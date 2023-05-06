package com.example.cheez.documentdispatch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoryController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    final ObservableList<Record> historyRecords = FXCollections.observableArrayList(Arrays.asList(new Record("Doc 1", "123-3445-323", "Amir Qayyum", "Director", LocalDate.of(2023, 4, 30)), new Record("Doc 2", "3839-8392-193", "Gohar Rasheed", "Director", LocalDate.of(2023, 6, 24)), new Record("Doc 3", "381-3892-3093", "Tahir Baig", "Finance Dept.", LocalDate.of(2023, 1, 15)), new Record("Doc 4", "1235-8493-849", "Javeria Arshad", "One Stop", LocalDate.of(2023, 2, 11))));


    @FXML
    public void initialize() {

        title.setCellValueFactory(new PropertyValueFactory<Record, String>("title"));
        senderID.setCellValueFactory(new PropertyValueFactory<Record, String>("senderID"));
        senderName.setCellValueFactory(new PropertyValueFactory<Record, String>("senderName"));
        reciever.setCellValueFactory(new PropertyValueFactory<Record, String>("reciever"));
        date.setCellValueFactory(new PropertyValueFactory<Record, String>("date"));

        historyTable.setItems(historyRecords);
    }
    @FXML
    private TextField SearchID;
    @FXML
    private TextField SearchTitle;

    @FXML
    private TextField SearchFromDate;

    @FXML
    private TextField SearchToDate;

    @FXML
    private Button SearchButton;

    @FXML
    private TableColumn<Record, String> date;

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

    private boolean searchFindsRecord(Record record, String searchText1, String searchText2, String searchText3){
        return (record.getTitle().contains(searchText1.toLowerCase())) ||
                (record.getSenderID().toLowerCase().contains(searchText2.toLowerCase())) ||
                (record.getDate().toString().toLowerCase().contains(searchText3.toLowerCase()));
    }

    private ObservableList<Record> filterList(ObservableList<Record> list, String searchText1, String searchText2, String searchText3){
        List<Record> filteredList = new ArrayList<>();
        for (Record record : list){
            if(searchFindsRecord(record, searchText1, searchText2, searchText3)) filteredList.add(record);
        }
        return FXCollections.observableList(filteredList);
    }

    @FXML
    void handleSearchButton() {

        String searchDate;
        String searchName;
        String searchId;

        if (SearchID.getText() == null || SearchID.getText().trim().isEmpty()){
            searchId = "3827482374123981231294890384921839012849783278473284739274287489";
        }
        else {
            searchId = SearchID.getText();
        }

        if (SearchTitle.getText() == null || SearchTitle.getText().trim().isEmpty()){
            searchName = "3827482374123981231294890384921839012849783278473284739274287489";
        }
        else {
            searchName = SearchTitle.getText();
        }

        if (SearchFromDate.getText() == null || SearchFromDate.getText().trim().isEmpty()){
            searchDate = "3827482374123981231294890384921839012849783278473284739274287489";
        }
        else {
            searchDate = SearchFromDate.getText();
        }

        historyTable.setItems(filterList(historyRecords, searchName, searchId, searchDate));
    }


}
