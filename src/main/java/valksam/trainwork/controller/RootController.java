package valksam.trainwork.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import valksam.trainwork.Main;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.model.Tables;
import valksam.trainwork.service.XlsService;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Valk on 25.01.16.
 */
public class RootController {

    @FXML //  fx:id="tableNameCombo"
    private ComboBox tableNameCombo;

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
                        .or(tableNameCombo.getSelectionModel().selectedItemProperty().isNull()));
        tableNameCombo.disableProperty().bind(selectedFileName.textProperty().isEqualTo(FILE_NOT_SELECTED)
                .or(selectedFileName.textProperty().isEmpty()));
        //
        fileColumnName.setCellValueFactory(data -> data.getValue().getColumnInFile());
        dataTableColumnName.setCellValueFactory(data -> data.getValue().getColumnInDataTable());
        columnsTable.setItems(DataStorage.correspondencesTable);
        //
        tableNameCombo.getItems().addAll(XlsService.getTablesList());
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
        List<String> mappedFields = DataStorage.correspondencesTable
                .stream()
                .map(e -> e.getColumnInDataTable().get())
                .filter(e -> !"".equals(e))
                .collect(Collectors.toList());
        return mappedFields.size() == DataStorage.currTableFieldNameList.size();
    }

    private boolean makeMappingColumnsAndFields(String tableName) {
        boolean result = false;
        try {
            for (Correspondence correspondence:DataStorage.correspondencesTable){
                correspondence.setColumnInDataTable("");
            }
            Class clazz = Class.forName(Tables.valueOf(tableNameCombo.getValue().toString()).getClassName());
            List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
            for (Field field : fields) {
                for (Correspondence correspondence : DataStorage.correspondencesTable) {
                    if (correspondence.getColumnInFile().get().toUpperCase().equals(
                            field.getName().toUpperCase()
                    )) {
                        correspondence.setColumnInDataTable(field.getName());
                        break;
                    }
                }
            }
            DataStorage.currTableFieldNameList.clear();
            DataStorage.currTableFieldNameList.addAll((Collection) fields.stream().map(m -> m.getName()).collect(Collectors.toList()));
            result = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;

    }

    @FXML
    private void onTableNameChanged() {
        String tableName = tableNameCombo.getValue().toString();
        if (!makeMappingColumnsAndFields(tableName)) {
            mainApp.getMessStage("Таблица " + tableName + " не найдена !").showAndWait();
            return;
        }
    }

    @FXML
    private void onProcFileButtonAction() {
        String tableName = tableNameCombo.getValue().toString();
        if (!validateValue(tableName)) {
            mainApp.getMessStage("Не верно введено имя таблицы !").showAndWait();
            return;
        }
        if (!validateColumnNames()) {
            mainApp.getMessStage("Не все столбцы таблицы закреплены за столбцами xls файла !").showAndWait();
            return;
        }
        //
        //делаем версию DataStorage.columnsMap без незакрепленных столбцов
        Map<Integer, String> finalColumnsMap = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : DataStorage.columnsMap.entrySet()) {
            if (!"".equals(DataStorage.correspondencesTable
                    .stream()
                    .filter(m -> m.getColumnInFile().get().toUpperCase().equals(entry.getValue().toUpperCase()))
                    .findFirst().get().getColumnInDataTable().get())) {
                finalColumnsMap.put(entry.getKey(), entry.getValue());
            }
        }
        //
        boolean scvResult = XlsService.createDbTable(xlsFile, tableName, finalColumnsMap);
        String jsonFileName = xlsFile.getName();
        int index = jsonFileName.lastIndexOf('.');
        if (index > 0) jsonFileName = jsonFileName.substring(0, index);
        jsonFileName = jsonFileName + "-" + Math.abs(new Random().nextInt()) + ".json";
        String gsonResult = XlsService.saveGSONSchema(xlsFile.getAbsolutePath(), jsonFileName, tableName, DataStorage.correspondencesTable);

        if (scvResult) {
            mainApp.getMessStage("Операция прошла успешно !").showAndWait();
        } else {
            mainApp.getMessStage("Данные не были сохранены в БД !").showAndWait();
        }
        if ("".equals(gsonResult)) {
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
