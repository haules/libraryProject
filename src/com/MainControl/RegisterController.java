package com.MainControl;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

public class RegisterController {

    private static String name, email, password;
    private static Statement statement;
    private static Connection connection;
    private static Stage window = new Stage();


    public static void confirm() {
        name = RegisterScene.getInsertNameTxt().getText();
        email = RegisterScene.getInsertEmail().getText();
        password = RegisterScene.getInsertPassword().getText();
        connection = ConnectionDB.getConnection();

        try {
            statement = connection.createStatement();

            int status = statement.executeUpdate("INSERT INTO users(name, email, password) " +
                    "VALUES(" + "'" + name + "', '" + email + "', '" + password + "');");
            if (status > 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Successful");
                alert.setTitle("New User Created");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerButton() {
        LoginScene.getRegisterButton().setOnAction(actionEvent -> {
            AssembleProject.showRegisterPage();
        });
    }
}
