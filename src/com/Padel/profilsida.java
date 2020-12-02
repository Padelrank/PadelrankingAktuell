package com.Padel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class profilsida extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();



        GridPane gp = new GridPane();
        gp.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, new Insets(20, 20, 20, 20))));
        HBox panel = new HBox();

        panel.setAlignment(Pos.CENTER);
        panel.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, CornerRadii.EMPTY, new Insets(20, 20, 20, 20))));

        Text rubrik = new Text(500, 85, "Padelrank");
        rubrik.setFont(Font.font(100));
        rubrik.setFill(Color.BLACK);

        Circle bild = new Circle(300, 250, 70);

        TextField beskrivning = new TextField();

        panel.getChildren().add(rubrik);
        bp.setTop(panel);
        bp.setCenter(gp);
        Scene profil = new Scene(bp, 1500, 800);
        primaryStage.setScene(profil);
        primaryStage.show();
    }
}
