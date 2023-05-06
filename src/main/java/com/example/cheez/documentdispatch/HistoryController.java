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
    public class Item {
        private LocalDate date;
        private String name;
        private int id;

        public Item(LocalDate date, String name, int id) {
            this.date = date;
            this.name = name;
            this.id = id;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }


    List<Item> itemList = new ArrayList<>();
    itemList.add(new Item(LocalDate.of(2023, 4, 30), "Umar", 1));
    itemList.add(new Item(LocalDate.of(2023, 5, 1), "Abdullah", 2));
    itemList.add(new Item(LocalDate.of(2023, 5, 2), "Aleena", 3));

    @FXML
    void handleSearchButton(ActionEvent event) {

        String searchDate = SearchFromDate.getText();
        String searchName = SearchTitle.getText();
        String searchId = IDSearch.getText();

        List<Item> filteredList = itemList.stream()
                .filter(item -> searchDate.isEmpty() || item.getDate().toString().contains(searchDate))
                .filter(item -> searchName.isEmpty() || item.getName().contains(searchName))
                .filter(item -> searchId.isEmpty() || String.valueOf(item.getId()).contains(searchId))
                .collect(Collectors.toList());
        ObservableList<Item> observableList = FXCollections.observableArrayList(filteredList);
        historyTable.setItems(observableList);

        VBox vbox = new VBox(historyTable);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
    }



}
