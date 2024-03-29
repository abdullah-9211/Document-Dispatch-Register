package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Signup {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button addUser;

    @FXML
    private TextField email;

    @FXML
    private TextField pass;

    @FXML
    private TextField permissions;

    @FXML
    private TextField userType;

    @FXML
    private TextField username;

    @FXML
    private Text haveAccount;

    @FXML
    void addUser(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
            stage = (Stage) addUser.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void moveToLogin(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage) haveAccount.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
