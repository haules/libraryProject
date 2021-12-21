package com.MainControl;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class RegisterScene {

    private static Scene scene;
    private static VBox vBoxLbl, vBoxTxt;
    private static Button confirmButton, backButton;
    private static Label title, nameLbl, emailLbl, passwordLbl;
    private static Pane pane;
    private static TextField insertNameTxt, insertEmail, insertPassword;
    private static Stage window;

    public static void initialize() {
        Font font = new Font("Times New Roman", 17);

        title = new Label("Registration page");
        title.setFont(new Font("Verdana", 30));
        title.relocate(240, 10);
        title.setId("titleLabel");

        nameLbl = new Label("Name");
        nameLbl.setPrefSize(100, 70);
        nameLbl.setFont(font);
        nameLbl.setId("labels");

        emailLbl = new Label("Email");
        emailLbl.setPrefSize(100, 70);
        emailLbl.setFont(font);
        emailLbl.setId("labels");

        passwordLbl = new Label("Password");
        passwordLbl.setPrefSize(100, 70);
        passwordLbl.setFont(font);
        passwordLbl.setId("labels");

        insertNameTxt = new TextField();
        insertEmail = new TextField();
        insertPassword = new TextField();

        confirmButton = new Button("Confirm");
        confirmButton.setMinWidth(100);
        confirmButton.relocate(400, 300);

        backButton = new Button("Back");
        backButton.setMinWidth(100);
        backButton.relocate(200, 300);

        vBoxLbl = new VBox(30);
        vBoxLbl.setPrefSize(150, 100);
        vBoxLbl.relocate(150, 100);
        vBoxLbl.getChildren().addAll(nameLbl,emailLbl, passwordLbl);

        vBoxTxt = new VBox(23);
        vBoxTxt.relocate(350, 100);
        vBoxTxt.getChildren().addAll(insertNameTxt, insertEmail, insertPassword);

        pane = new Pane();
        pane.getChildren().addAll(title, confirmButton, backButton,vBoxLbl, vBoxTxt);

        scene = new Scene(pane, 700, 500);
        scene.getStylesheets().add("style.css");

    }


    public static Stage getWindow() {
        return window;
    }

    public static Label getNameLbl() {
        return nameLbl;
    }

    public static Label getEmailLbl() {
        return emailLbl;
    }

    public static Label getPasswordLbl() {
        return passwordLbl;
    }

    public static Pane getPane() {
        return pane;
    }

    public static TextField getInsertNameTxt() {
        return insertNameTxt;
    }

    public static TextField getInsertEmail() {
        return insertEmail;
    }

    public static TextField getInsertPassword() {
        return insertPassword;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void backToLogin(){
        backButton.setOnAction(actionEvent -> {
            AssembleProject.showLoginScene();
            AssembleProject.stage(LoginScene.getScene());
        });
    }
}
