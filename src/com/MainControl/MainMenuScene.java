package com.MainControl;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene {

    private static Scene scene;
    private static Pane pane;
    private static Stage window = new Stage();

    private static Label quoteLabel;
    private static Button departmentShowBooks, departmentRentalBooks, departmentLateBooks, backButton;

    private static VBox vBoxButtons;

    public static void initialize() {
        quoteLabel = new Label("Please select the library department that you want to access");
        quoteLabel.relocate(50, 50);
        quoteLabel.setId("quoteLabel");

        departmentShowBooks = new Button("Book Database");
        departmentShowBooks.setId("buttons");
        departmentShowBooks.setTooltip(new Tooltip("This department shows all of the books that are" +
                "stored in out database"));

        departmentRentalBooks = new Button("Rented Books");
        departmentRentalBooks.setId("buttons");
        departmentRentalBooks.setTooltip(new Tooltip("This department shows all the books that have been rented"));

        departmentLateBooks = new Button("Overdue Books");
        departmentLateBooks.setId("buttons");
        departmentLateBooks.setTooltip(new Tooltip("This department shows all books that are overdue"));

        backButton = new Button("Back");
        backButton.setId("buttons");
        backButton.relocate(450, 370);

        vBoxButtons = new VBox(20);
        vBoxButtons.getChildren().addAll(departmentShowBooks, departmentRentalBooks, departmentLateBooks);
        vBoxButtons.relocate(70, 150);

        pane = new Pane();
        pane.getChildren().addAll(quoteLabel, vBoxButtons, backButton);

        scene = new Scene(pane, 700, 500);
        scene.getStylesheets().add("style.css");

    }

    public static Scene getScene() {
        return scene;
    }

    public static void backToLoginPage(){
        backButton.setOnAction(actionEvent -> {
            AssembleProject.showLoginScene();
            AssembleProject.stage(LoginScene.getScene());
        });
    }
}

