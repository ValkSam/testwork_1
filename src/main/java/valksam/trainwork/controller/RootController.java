package valksam.trainwork.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import valksam.trainwork.Main;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.service.XlsService;

import javax.swing.table.DefaultTableColumnModel;
import java.io.File;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Valk on 25.01.16.
 */
public class RootController {

    @FXML //  fx:id="tableNameCombo"
    private ComboBox<String> tableNameCombo;

    @FXML //  fx:id="selectedTableName"
    private Label selectedTableName;

    @FXML //  fx:id="fileOpenButton"
    private Button fileOpenButton;

    @FXML //  fx:id="selectedFileName"
    private Label selectedFileName;

    @FXML //  fx:id="getColumnsButton"
    private Button getColumnsButton;

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

    @FXML
    private void initialize() {
        tableNameCombo.getItems().add("Таблица 1");
        tableNameCombo.getItems().add("Таблица 2");
        tableNameCombo.getItems().add("Таблица 3");
        //
        selectedTableName.textProperty().bind(tableNameCombo.getSelectionModel().selectedItemProperty());
        selectedFileName.textProperty().set(FILE_NOT_SELECTED);
        getColumnsButton.disableProperty().bind(
                (selectedFileName.textProperty().isEqualTo(FILE_NOT_SELECTED)
                        .or(selectedFileName.textProperty().isEmpty())
                        .or(selectedTableName.textProperty().isEmpty())));

        /*DataStorage.correspondencesTable.add(new Correspondence("1"));
        DataStorage.correspondencesTable.add(new Correspondence("2"));*/
        /*columnsTable.setEditable(true);
        dataTableColumnName.setEditable(true);*/

        /*так не обновляется таблица после редактирования
        fileColumnName.setCellValueFactory(new PropertyValueFactory<>("columnInFile"));
        dataTableColumnName.setCellValueFactory(new PropertyValueFactory<>("columnInDataTable"));*/
        fileColumnName.setCellValueFactory(data->data.getValue().getColumnInFile());
        dataTableColumnName.setCellValueFactory(data->data.getValue().getColumnInDataTable());
        columnsTable.setItems(DataStorage.correspondencesTable);
    }

    @FXML
    private void onFileOpenButtonAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file != null) {
            selectedFileName.textProperty().set(file.getAbsolutePath());
        }
    }

    @FXML
    private void onGetColumnsButtonAction() {
        DataStorage.correspondencesTable.clear();
        DataStorage.columnsMap.putAll(XlsService.getColumnNames(selectedFileName.textProperty().get()));
        DataStorage.correspondencesTable.addAll(
                DataStorage.columnsMap.values()
                        .stream()
                        .map(r -> new Correspondence(r))
                        .collect(Collectors.toList()));
    }

    @FXML
    private void onEditTableColumnNameAction(TableColumn.CellEditEvent<Correspondence, String> t) {
        //((TextField)mainApp.getFormStage().getScene().getRoot().lookup("#editField")).textProperty().set(t.getOldValue());
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
