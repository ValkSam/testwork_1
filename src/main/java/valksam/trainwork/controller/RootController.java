package valksam.trainwork.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import valksam.trainwork.Main;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.service.XlsService;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Valk on 25.01.16.
 */
public class RootController {

    @FXML //  fx:id="tableNameEdit"
    private TextField tableNameEdit;

    @FXML //  fx:id="fileOpenButton"
    private Button fileOpenButton;

    @FXML //  fx:id="selectedFileName"
    private Label selectedFileName;

    @FXML //  fx:id="procFileButton"
    private Button procFileButton;

    @FXML //  fx:id="dataTableColumnName"
    private TableColumn<Correspondence, String> dataTableColumnName;

    @FXML //  fx:id="fileColumnName"
    private TableColumn<Correspondence, String> fileColumnName;

    @FXML //  fx:id="columnsTable"
    private TableView<Correspondence> columnsTable;

    private Main mainApp;

    public RootController() {
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private final String FILE_NOT_SELECTED = "Файл не выбран";

    File xlsFile;

    @FXML
    private void initialize() {
        selectedFileName.textProperty().set(FILE_NOT_SELECTED);
        procFileButton.disableProperty().bind(
                selectedFileName.textProperty().isEqualTo(FILE_NOT_SELECTED)
                        .or(selectedFileName.textProperty().isEmpty())
                        .or(tableNameEdit.textProperty().isEmpty()));
        tableNameEdit.disableProperty().bind(selectedFileName.textProperty().isEqualTo(FILE_NOT_SELECTED)
                .or(selectedFileName.textProperty().isEmpty()));
        //
        fileColumnName.setCellValueFactory(data -> data.getValue().getColumnInFile());
        dataTableColumnName.setCellValueFactory(data -> data.getValue().getColumnInDataTable());
        columnsTable.setItems(DataStorage.correspondencesTable);
    }

    @FXML
    private void onFileOpenButtonAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls");
        fileChooser.getExtensionFilters().add(extFilter);
        selectedFileName.textProperty().set("");
        xlsFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (xlsFile != null) {
            selectedFileName.textProperty().set(xlsFile.getAbsolutePath());
            fillColumnsTable();
        }
    }

    private void fillColumnsTable() {
        assert (xlsFile != null);
        DataStorage.correspondencesTable.clear();
        DataStorage.columnsMap.putAll(XlsService.getColumnNames(xlsFile));
        DataStorage.correspondencesTable.addAll(
                DataStorage.columnsMap.values()
                        .stream()
                        .map(r -> new Correspondence(r))
                        .collect(Collectors.toList()));
    }

    private boolean validateValue(String value) {
        return value.matches("^[a-zA-Z]+\\w+");
    }

    private boolean validateColumnNames() {
        Set<Correspondence> set = new HashSet<>();
        set.addAll((Collection) DataStorage.correspondencesTable);
        return set.size()==DataStorage.correspondencesTable.size()&&
                DataStorage.correspondencesTable
                .stream()
                .map(e -> e.getColumnInDataTable().get())
                .collect(Collectors.toList())
                .stream()
                        .allMatch(e -> e.matches("^[a-zA-Z]+\\w+"));
    }

    @FXML
    private void onProcFileButtonAction() {
        if (!validateValue(tableNameEdit.textProperty().get())) {
            mainApp.getMessStage("Не верно введено имя таблицы !").showAndWait();
            return;
        }
        if (!validateColumnNames()) {
            mainApp.getMessStage("Среди столбцов есть столбец с не корректным именем !").showAndWait();
            return;
        }
        boolean scvResult = XlsService.createDbTable(xlsFile, tableNameEdit.textProperty().get(), DataStorage.columnsMap);
        String jsonFileName = xlsFile.getName();
        int index = jsonFileName.lastIndexOf('.');
        if(index > 0) jsonFileName = jsonFileName.substring(0, index);
        jsonFileName =  jsonFileName +"-"+ Math.abs(new Random().nextInt()) + ".json";
        String gsonResult = XlsService.saveGSONSchema(jsonFileName, tableNameEdit.textProperty().get(), DataStorage.correspondencesTable);
        if (scvResult){
            mainApp.getMessStage("Операция прошла успешно !").showAndWait();
        } else {
            mainApp.getMessStage("Данные не были сохранены в БД !").showAndWait();
        }
        if (gsonResult.isEmpty()){
            mainApp.getMessStage("JSON данные не были сохранены на диск !").showAndWait();
        } else {
            mainApp.getMessStage("JSON сохранен в " + gsonResult).showAndWait();
        }
    }


    @FXML
    private void onEditTableColumnNameAction(TableColumn.CellEditEvent<Correspondence, String> t) {
        DataStorage.correspondence.setColumnInDataTable(t.getOldValue());
        mainApp.getFormStage().showAndWait();
        String newValue = DataStorage.correspondence.getColumnInDataTable().get();
        if (!"".equals(newValue)) {
            t.getRowValue().setColumnInDataTable(newValue);
        }
        columnsTable.getItems().contains(newValue);
    }

    @FXML
    private void onEditCommitTableColumnNameAction() {
    }
}
