package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button user_btn;

    @FXML
    private Button doc_btn;

    @FXML
    private Button hist_btn;
    @FXML
    void addUser(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("signup.fxml"));
            stage = (Stage) user_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void document_add(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("formstuff.fxml"));
            stage = (Stage) doc_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewHistory(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("log_history.fxml"));
            stage = (Stage) hist_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
