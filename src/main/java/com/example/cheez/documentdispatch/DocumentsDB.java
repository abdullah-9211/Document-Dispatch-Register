package com.example.cheez.documentdispatch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Arrays;

public final class DocumentsDB {

    final ObservableList<Record> historyRecords = FXCollections.observableArrayList(Arrays.asList(new Record("Doc 1", "123-3445-323", "Amir Qayyum", "Director", LocalDate.of(2023, 4, 30)), new Record("Doc 2", "3839-8392-193", "Gohar Rasheed", "Director", LocalDate.of(2023, 6, 24)), new Record("Doc 3", "381-3892-3093", "Tahir Baig", "Finance Dept.", LocalDate.of(2023, 1, 15)), new Record("Doc 4", "1235-8493-849", "Javeria Arshad", "One Stop", LocalDate.of(2023, 2, 11))));

    private final static DocumentsDB INSTANCE = new DocumentsDB();

    private DocumentsDB() {}

    public static DocumentsDB getInstance(){
        return INSTANCE;
    }

    public ObservableList<Record> getDocs(){
        return this.historyRecords;
    }


}
