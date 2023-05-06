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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class DetailsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button done_btn;
    @FXML
    private ListView<String> details_list;

    private DocumentHolder documentHolder;
    private DocumentsDB documentsDB;

    @FXML
    private Text attachTxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        documentHolder = DocumentHolder.getInstance();
        String date = documentHolder.document.date;
        String route = "";
        for (String r : documentHolder.document.route){
            route += ("\n" + r);
        }
        String senderName = documentHolder.document.senderName;
        String title = documentHolder.document.title;
        String id = documentHolder.document.senderID;
        String desc = documentHolder.document.description;

        String[] details = {"Sent on: " + date, "Route Followed:" + route, "Sender Name: " + senderName, "Title: " + title, "Sender ID: " + id, "Description: " + desc };
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

        attachTxt.setText("Attachments: " + documentHolder.document.fileCount + " + " + documentHolder.document.supportCount);

    }

    @FXML
    void done(ActionEvent event) {
        // navigate to next page
        documentsDB = DocumentsDB.getInstance();

        Record record = new Record(documentHolder.document.title, documentHolder.document.senderID, documentHolder.document.senderName, documentHolder.document.route.get(documentHolder.document.route.size() - 1), documentHolder.document.date);
        documentsDB.historyRecords.add(record);

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
