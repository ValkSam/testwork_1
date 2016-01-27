package valksam.trainwork.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        if (!validateValue(newValue)) {
            messageLabel.textProperty().set("Неверно введено имя");
            return;
        }
        DataStorage.correspondence.setColumnInDataTable(newValue);
        stage.close();
    }

    private boolean validateValue(String value) {
        return value.matches("^[a-zA-Z]+\\w+") &&
                !DataStorage.correspondencesTable
                        .stream()
                        .map(e -> e.getColumnInDataTable().get())
                        .collect(Collectors.toList())
                        .contains(value);
    }

    @FXML
    private void onCancel() {
        DataStorage.correspondence.setColumnInDataTable("");
        stage.close();
    }

    public void onStageShown() {
        if (messageLabel != null) messageLabel.textProperty().set("");
        if (editField != null) editField.textProperty().set(DataStorage.correspondence.getColumnInDataTable().get());
    }


}
