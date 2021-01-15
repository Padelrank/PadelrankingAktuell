package com.Padel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class ScoreResult {

    public static void main(String[] args) {


    }

    ScoreResult(){

    }

    Scene scene;
    Alert alert;
    Button returnToMainPage;
    DialogPane dp;

    @SuppressWarnings({"unchecked", "unchecked", "unchecked"})

   public void showScoreResult(Stage stage) {


        dp = new DialogPane();



        // Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Defining the Name text field
        final TextField player1 = new TextField();
        player1.setFocusTraversable(false);
        player1.setPromptText("Player1");
        player1.setPrefColumnCount(10);

        player1.setMaxWidth(180);
        player1.getText();
        GridPane.setConstraints(player1, 0, 0);
        grid.getChildren().add(player1);

        // Defining the Last Name text field
        final TextField result1 = new TextField();
        result1.setFocusTraversable(false);
        result1.setMaxWidth(180);
        result1.setPromptText("Player1 result");
        GridPane.setConstraints(result1, 0, 1);
        grid.getChildren().add(result1);

        // Defining the Comment text field
        final TextField comment1 = new TextField();
        comment1.setFocusTraversable(false);
        comment1.setMaxWidth(180);
        comment1.setPrefColumnCount(15);
        comment1.setPromptText("Enter a comment.");
        GridPane.setConstraints(comment1, 0, 2);
        grid.getChildren().add(comment1);

        // Defining the Name text field
        final TextField player2 = new TextField();
        player2.setFocusTraversable(false);
        player2.setMaxWidth(180);
        player2.setPromptText("Player2");
        player2.setPrefColumnCount(10);
        player2.getText();
        GridPane.setConstraints(player2, 1, 0);
        grid.getChildren().add(player2);

        // Defining the Last Name text field
        final TextField result2 = new TextField();
        result2.setFocusTraversable(false);
        result2.setMaxWidth(180);
        result2.setPromptText("Player2 result");
        GridPane.setConstraints(result2, 1, 1);
        grid.getChildren().add(result2);

        // Defining the Comment text field
        final TextField comment2 = new TextField();
        comment2.setFocusTraversable(false);
        comment2.setMaxWidth(180);
        comment2.setPrefColumnCount(15);
        comment2.setPromptText("Enter a comment.");
        GridPane.setConstraints(comment2, 1, 2);
        grid.getChildren().add(comment2);

        // Defining the Submit button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 3, 0);
        grid.getChildren().add(submit);


        // Defining the Clear button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 3, 1);
        grid.getChildren().add(clear);

        // Adding a Label
        final Label label = new Label();
        label.setFont(new Font("Arial", 24));
        label.setTextFill(Color.web("#ff0000", 0.8));
        label.setAlignment(Pos.CENTER_LEFT);
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);
/*
        //Setting an action for the Submit button
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                if (player1.getText() != null && result1.getText() != null && player2.getText()
                        != null && result2.getText() != null && isPositiveInteger(result1.getText()) && isPositiveInteger(result2.getText())) {
                    alert.setHeaderText(player1.getText() + "      " + result1.getText() + "  :  " + result2.getText() + "      " + player2.getText() +
                            "\n" + comment1.getText() + "                           " + comment2.getText());
                    alert.show();

                } else {
                    alert.setHeaderText("You have to insert a valid values .");
                    alert.show();
                }

            }


        });

 */
        submit.setOnMouseClicked(event -> {
            alert = new Alert(Alert.AlertType.INFORMATION);
            if (player1.getText() != null && result1.getText() != null && player2.getText()
                    != null && result2.getText() != null && isPositiveInteger(result1.getText()) && isPositiveInteger(result2.getText())) {
                alert.setHeaderText(player1.getText() + "      " + result1.getText() + "  :  " + result2.getText() + "      " + player2.getText() +
                        "\n" + comment1.getText() + "                           " + comment2.getText());
                alert.show();
                profilsida ps = new profilsida();
                ps.showProfilePage(stage);

            } else {
                alert.setHeaderText("Du måste ange information!");
                alert.show();
            }


        });

        //Setting an action for the Clear button
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                player1.clear();
                result1.clear();
                comment1.clear();

                player2.clear();
                result2.clear();
                comment2.clear();
                label.setText(null);
            }
        });

        scene = new Scene(grid, 800, 250);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private String POSITIVE_INTEGER_REGEX = "[0-9]+";
    private Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile(POSITIVE_INTEGER_REGEX);

    public boolean isPositiveInteger(String s) {
        return POSITIVE_INTEGER_PATTERN.matcher(s).matches();
    }

}
