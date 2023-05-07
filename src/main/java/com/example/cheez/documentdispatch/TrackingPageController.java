package com.example.cheez.documentdispatch;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TrackingPageController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button done_btn;
    @FXML
    private Text firstID;
    @FXML
    private Text secondID;
    @FXML
    private Text thirdID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DocumentHolder docHolder = DocumentHolder.getInstance();
        List<String> routes = docHolder.document.route;
        firstID.setText(" " + routes.get(0));
        secondID.setText(" " + routes.get(1));
        thirdID.setText(" " + routes.get(2));
    }


    @FXML
    void donetracking(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
            stage = (Stage) done_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}