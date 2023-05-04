package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SetRouteController implements Initializable {
    @FXML
    private Button done_btn;
    @FXML
    private Button add_btn;
    @FXML
    private ListView<String> route_list;
    @FXML
    private ListView<String> route_list2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // populate route_list
        String[] routes = {"Finance", "Admin", "Accounts", "OneStop", "Director"};
        route_list.getItems().addAll(routes);
        // populate route_list2
    }

    @FXML
    void add(ActionEvent event) {
        List<String> selected = route_list.getSelectionModel().getSelectedItems();
        route_list2.getItems().addAll(selected);
        // remove selected from route_list
        route_list.getItems().removeAll(selected);
    }

    @FXML
    void done(ActionEvent event) {
        // navigate to next page
    }
}
