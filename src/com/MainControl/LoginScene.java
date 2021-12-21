package com.MainControl;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginScene {

    private static TextField usernameTxt;
    private static TextField passwordTxt;
    private static Label titleLabel, usernameLbl, passwordLbl, bottomTitle;
    private static Button loginButton, registerButton;
    private static VBox vBoxTxt, vBoxLbl;
    private static Scene scene;
    private static Pane pane;
    private static Stage window;

    public static void initialize(){

        usernameTxt = new TextField();
        usernameTxt.setMinSize(100, 10);

        passwordTxt = new TextField();
        passwordTxt.setMinSize(75, 10);

        titleLabel = new Label("Sign In");
        titleLabel.relocate(150, 30);
        titleLabel.setId("titleLabel");

        bottomTitle = new Label("Powered by Alex!");
        bottomTitle.setFont(new Font("Arial", 7));
        bottomTitle.relocate(180, 420);

        usernameLbl = new Label("Username");
        usernameLbl.setId("labels");
        passwordLbl = new Label("Password");
        passwordLbl.setId("labels");

        loginButton = new Button("Login");
        loginButton.setMinSize(100, 25);
        loginButton.relocate(170, 220);

        registerButton = new Button("Register");
        registerButton.setMinSize(100, 25);
        registerButton.relocate(170, 250);

        vBoxLbl = new VBox(30);
        vBoxLbl.getChildren().addAll(usernameLbl, passwordLbl);
        vBoxLbl.relocate(60, 130);

        vBoxTxt = new VBox(20);
        vBoxTxt.getChildren().addAll(usernameTxt, passwordTxt);
        vBoxTxt.relocate(150, 130);

        pane = new Pane();
        pane.getChildren().addAll(titleLabel, vBoxLbl, vBoxTxt, loginButton, registerButton, bottomTitle);

        scene = new Scene(pane, 400, 450);
        scene.getStylesheets().add("style.css");


    }

    public static Button getLoginButton() {
        return loginButton;
    }

    public static Button getRegisterButton() {
        return registerButton;
    }

    public static TextField getUsernameTxt() {
        return usernameTxt;
    }

    public static TextField getPasswordTxt() {
        return passwordTxt;
    }

    public static Scene getScene() {
        return scene;
    }

}
