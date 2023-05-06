package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SetRouteController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button done_btn;
    @FXML
    private Button add_btn;
    @FXML
    private ListView<String> route_list;
    @FXML
    private ListView<String> route_list2;

    private List<String> routes;
    public DocumentHolder documentHolder;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        routes = new ArrayList<>();
        documentHolder = DocumentHolder.getInstance();
        // populate route_list
        String[] routes = {"Finance", "Admin", "Accounts", "OneStop", "Director"};
        route_list.getItems().addAll(routes);
        // populate route_list2
    }

    @FXML
    void add(ActionEvent event) {
        List<String> selected = route_list.getSelectionModel().getSelectedItems();
        for (String s : selected){
            routes.add(s);
        }
        route_list2.getItems().addAll(selected);
        // remove selected from route_list
        route_list.getItems().removeAll(selected);
    }

    @FXML
    void done(ActionEvent event) {
        // navigate to next page
        documentHolder.document.route = routes;

        try {
            root = FXMLLoader.load(getClass().getResource("details.fxml"));
            stage = (Stage) done_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
