package com.MainControl;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static Connection connection;
    private static String sqlQuery;
    private static String username, password;



    public static void checkCredentials() {
        username = LoginScene.getUsernameTxt().getText();
        password = LoginScene.getPasswordTxt().getText();
        sqlQuery = "SELECT * FROM users WHERE name = ? AND password = ?";
        Alert alertType = new Alert(Alert.AlertType.CONFIRMATION);

        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (username.isEmpty() && password.isEmpty()) {
               alert(alertType, "Error", "Try Again", "Fill the fields with your credentials");

            } else if (!resultSet.next()) {
                alert(alertType, "Error", "Try again", "Username or password are incorrect");

            } else {
                AssembleProject.showMenu();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't check credentials, ERROR!");
        }
    }

    public static void loginButton(){
        LoginScene.getLoginButton().setOnAction(actionEvent -> {
            LoginController.checkCredentials();
        });
    }

    public static Alert alert(Alert alert, String title, String header, String content){
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        LoginScene.getUsernameTxt().clear();
        LoginScene.getPasswordTxt().clear();

        return alert;
    }
}
