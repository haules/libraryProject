package com.MainControl;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class AssembleProject {

    private static final Stage window = new Stage();

    public static void showLoginScene(){

        ConnectionDB.connect();
        LoginScene.initialize();

        LoginController.loginButton();
        RegisterController.registerButton();

        window.setScene(LoginScene.getScene());
        window.show();

        System.out.println("Initialized");
    }

    public static void showMenu(){
        MainMenuScene.initialize();

        stage(MainMenuScene.getScene());

        System.out.println("Menu Initialized");

        MainMenuScene.backToLoginPage();
    }

    public static void showRegisterPage(){
        RegisterScene.initialize();

        stage(RegisterScene.getScene());

        RegisterScene.backToLogin();

        System.out.println("Register page initialized");

    }

    public static void stage(Scene scene){
        window.setScene(scene);
        window.show();
        window.centerOnScreen();
    }
}
