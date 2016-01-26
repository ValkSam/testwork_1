package valksam.trainwork.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import valksam.trainwork.Main;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.service.XlsService;

import java.io.File;
import java.util.stream.Collectors;

/**
 * Created by Valk on 25.01.16.
 */
public class EditFieldFormController {
    @FXML //  fx:id="editField"
    private TextField editField;

    @FXML //  fx:id="okButton"
    private Button okButton;

    @FXML //  fx:id="cancelButton"
    private Button cancelButton;

    @FXML //  fx:id="messageLabel"
    private Label messageLabel;

    private Stage stage;

    public EditFieldFormController() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onOk() {
        String newValue = editField.textProperty().get();
        if (! validateValue(newValue)){
            messageLabel.textProperty().set("Неверно введено имя");
            return;
        }
        DataStorage.correspondence.setColumnInDataTable(newValue);
        stage.close();
    }

    private boolean validateValue(String value){
        return value.matches("[a-zA-Z]{3,}");
    }

    @FXML
    private void onCancel() {
        DataStorage.correspondence.setColumnInDataTable("");
        stage.close();
    }

    public void onStageShown(){
        messageLabel.textProperty().set("");
        editField.textProperty().set(DataStorage.correspondence.getColumnInDataTable().get());
    }


}
