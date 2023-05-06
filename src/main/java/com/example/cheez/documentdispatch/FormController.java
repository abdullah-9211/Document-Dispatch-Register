package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FormController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField EnterAttatchments;

    @FXML
    private TextField EnterDepartment;

    @FXML
    private TextArea EnterDescription;

    @FXML
    private TextField EnterFinalReceiver;

    @FXML
    private TextField EnterSenderId;

    @FXML
    private TextField EnterSenderName;

    @FXML
    private TextField EnterTitle;

    @FXML
    private Button scan_btn;

    @FXML
    void scanDoc(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("UploadDoc.fxml"));
            stage = (Stage) scan_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
