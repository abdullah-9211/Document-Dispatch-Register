package com.example.cheez.documentdispatch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HistoryController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void initialize() {
        final ObservableList<Record> historyRecords = FXCollections.observableArrayList(Arrays.asList(new Record("Doc 1", "123-3445-323", "Amir Qayyum", "Director", "Computer Science"), new Record("Doc 2", "3839-8392-193", "Gohar Rasheed", "Director", "Software Engineering"), new Record("Doc 3", "381-3892-3093", "Tahir Baig", "Finance Dept.", "Computer Science"), new Record("Doc 4", "1235-8493-849", "Javeria Arshad", "One Stop", "Management Sciences")));

        title.setCellValueFactory(new PropertyValueFactory<Record, String>("title"));
        senderID.setCellValueFactory(new PropertyValueFactory<Record, String>("senderID"));
        senderName.setCellValueFactory(new PropertyValueFactory<Record, String>("senderName"));
        reciever.setCellValueFactory(new PropertyValueFactory<Record, String>("reciever"));
        dept.setCellValueFactory(new PropertyValueFactory<Record, String>("dept"));

        historyTable.setItems(historyRecords);
    }
    @FXML
    private TextField IDSearch;
    @FXML
    private TextField SearchTitle;

    @FXML
    private TextField SearchFromDate;

    @FXML
    private TextField SearchToDate;

    @FXML
    private Button SearchButton;

    @FXML
    private TableColumn<Record, String> dept;

    @FXML
    private TableColumn<Record, String> reciever;

    @FXML
    private TableColumn<Record, String> senderID;

    @FXML
    private TableColumn<Record, String> senderName;

    @FXML
    private TableColumn<Record, String> title;

    @FXML
    private TableView<Record> historyTable;

    @FXML
    private Button backbtn;

    @FXML
    void goBack(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
            stage = (Stage) backbtn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    datalist.addAll(//add objects that are created)
//    @FXML
//    FilteredList<Record> filteredData = new FilteredList<>(datalist, b => true);
//    if (newValue ==null || newValue.isEmpty()){
//        return true;
//    }
//    String lowerCaseFilter = newValue.toLowerCase();
    //if cases to find stuff out if present or stuff




}
