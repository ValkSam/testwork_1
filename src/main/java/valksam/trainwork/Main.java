package valksam.trainwork;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import valksam.trainwork.controller.DataStorage;
import valksam.trainwork.controller.EditFieldFormController;
import valksam.trainwork.controller.RootController;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.service.XlsService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Valk on 25.01.16.
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Stage formStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("ValkSam test work");
        rootLayout = initAndShowRootLayout(primaryStage, "/view/root.fxml");
        AnchorPane body = initAndShowNestedBody(rootLayout, "/view/body.fxml");
        formStage = initEditForm(primaryStage, "/view/editTblColName.fxml");
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Stage getFormStage() {
        return formStage;
    }

    public BorderPane initAndShowRootLayout(Stage stage, String fxmlName) {
        BorderPane layout = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(fxmlName));
            layout = loader.load();
            //
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            //
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    public AnchorPane initAndShowNestedBody(BorderPane root, String fxmlName) {
        AnchorPane body = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(fxmlName));
            body = (AnchorPane) loader.load();
            //
            root.setCenter(body);
            //
            RootController controller = loader.getController();
            controller.setMainApp(this);
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public Stage initEditForm(Stage rootStage, String fxmlName) {
        Stage formStage = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(fxmlName));
            AnchorPane form = (AnchorPane) loader.load();
            Scene scene = new Scene(form);
            //
            formStage = new Stage();
            formStage.setTitle("Редактирование поля таблицы");
            formStage.initModality(Modality.WINDOW_MODAL);
            formStage.initOwner(rootStage);
            formStage.setScene(scene);
            //
            EditFieldFormController controller = loader.getController();
            controller.setStage(formStage);
            formStage.setOnShown(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    controller.onStageShown();
                }
            });
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
