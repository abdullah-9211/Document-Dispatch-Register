package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AttachmentsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button ScanButton;

    @FXML
    private Button UploadButton;

    @FXML
    void uploadAttachments(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("set_route.fxml"));
            stage = (Stage) UploadButton.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
