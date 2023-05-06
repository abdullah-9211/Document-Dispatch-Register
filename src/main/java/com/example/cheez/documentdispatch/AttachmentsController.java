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

public class AttachmentsController implements Initializable {

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

    public List<String> attachment_fileNames;
    public List<String> attachment_filePaths;

    public String filename;

    public int fileCount = 0;



    @Override
    public void initialize(java.net.URL arg0, java.util.ResourceBundle arg1) {
        file_name.setText("No file selected");
        attachment_fileNames = new java.util.ArrayList<>();
        attachment_filePaths = new java.util.ArrayList<>();
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
        attachment_fileNames.add(file.getName());
        attachment_filePaths.add(file.getAbsolutePath());
        fileCount++;

        // set text of label to name of file
        if (fileCount == 1)
            file_name.setText(file.getName() + " Successfully uploaded");
        else{
            file_name.setText(attachment_fileNames.size() + " files successfully uploaded");
        }

    }

    public void scanFile(){
        // woo file scan hogayi
    }

    public void done(){
        // navigate to next page
    }

    @FXML
    void uploadAttachments(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("set_route.fxml"));
            stage = (Stage) UploadButton.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
