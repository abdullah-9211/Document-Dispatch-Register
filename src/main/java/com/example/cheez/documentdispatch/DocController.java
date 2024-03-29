package com.example.cheez.documentdispatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


import java.io.File;
import java.util.List;

public class DocController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button ScanButton;

    @FXML
    private Button ScanButton1;

    @FXML
    private Button cloud_upload_btn;

    @FXML
    private Text file_name;

    @FXML
    private ImageView image;

    public DocumentHolder documentHolder;

    public List<String> fileNames;
    public List<String> filePaths;

    public String filename;

    public int fileCount = 0;

    @FXML
    private Button done_btn;


    @Override
    public void initialize(java.net.URL arg0, java.util.ResourceBundle arg1) {
        documentHolder = DocumentHolder.getInstance();
        file_name.setText("No file selected");
        fileNames = new java.util.ArrayList<>();
        filePaths = new java.util.ArrayList<>();
    }

    public void uploadFile(){
        FileChooser fileChooser = new FileChooser();
        // set initial directory to user directory
        fileChooser.setInitialDirectory(new java.io.File(System.getProperty("user.home")));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            filename = file.getAbsolutePath();
            System.out.println(filename);
        }
        fileNames.add(file.getName());
        fileCount++;

        // set text of label to name of file
        if (fileCount == 1)
            file_name.setText(file.getName() + " Successfully uploaded");
        else{
            file_name.setText(fileNames.size() + " files successfully uploaded");
        }

    }

    public void scanFile(){
        // woo file scan hogayi
    }

    public void done(){
        // navigate to next page
        documentHolder.document.files = fileNames;
        documentHolder.document.fileCount = fileCount;

        try {
            root = FXMLLoader.load(getClass().getResource("UploadAttatchments.fxml"));
            stage = (Stage) done_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
