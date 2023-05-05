package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DetailsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button done_btn;
    @FXML
    private ListView<String> details_list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] details = {"Sent on: 25/03/2023    23:07:32 PM", "Route Followed:\nSource\nAccounts\nDirector", "Sender Name: Amir Rehman", "Title: Document Title", "Sender ID: 11101-55555-1", "Description: Sample Description" };
        details_list.setCellFactory(cell -> {
            return new ListCell<String>(){
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setWrapText(true);
                        setFont(Font.font("Georgia", 16));
                    }
                }
            };

        });
        details_list.getItems().addAll(details);
    }

    @FXML
    void done(ActionEvent event) {
        // navigate to next page
        try {
            root = FXMLLoader.load(getClass().getResource("trackingPage.fxml"));
            stage = (Stage) done_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
