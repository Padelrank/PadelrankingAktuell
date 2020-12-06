package com.Padel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class profilsida extends Application {


    Text firstNameLastName;
    Text rubrik;
    Text personalDescription;
    Text score;
    VBox personalData;
    VBox pointsAndRank;

    TextField beskrivning;
    TextFlow descFlow;

    BorderPane mainLayout;
    BorderPane middleLayout;


    Button redigera;

    HBox rankPanel;
    HBox panel;

    ComboBox meny;


    ProgressBar rank;


    @Override
    public void start(Stage primaryStage) {
        mainLayout = new BorderPane();



        middleLayout = new BorderPane();
        middleLayout.setPadding(new Insets(100,100,100,100));
        middleLayout.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(5, 15, 5, 15))));


        personalDescription = new Text();
        personalDescription.setText("Jag heter jan borg och har spelat padel i snart 6 år.\n" +
                "när jag spelar föredrar jag att spela backhand\n" +
                "men kan även spela forehand.\nspelar helst med och mot någon med mer än 1500poäng");
        personalDescription.setFont(Font.font("Verdana", 20));




        panel = new HBox();
        panel.setSpacing(350);

        panel.setAlignment(Pos.CENTER);
        panel.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, CornerRadii.EMPTY, new Insets(5, 15, 15, 15))));

        rubrik = new Text(500, 85, "Padelrank");
        rubrik.setFont(Font.font("Verdana", 100));
        rubrik.setFill(Color.BLACK);

        firstNameLastName = new Text();
        firstNameLastName.setFont(Font.font("Verdana", 40));
        firstNameLastName.setText("Jan Borg");


        pointsAndRank = new VBox();
        //pointsAndRank.getChildren().add();

        rank = new ProgressBar();
        rank.setPrefWidth(200f);
        rank.setProgress(0.5f);



        rankPanel = new HBox();
        rankPanel.setAlignment(Pos.CENTER);
        score = new Text("Score: ");

        score.setFont(Font.font("Verdana", 20));

        personalData = new VBox();
        personalData.getChildren().add(firstNameLastName);
        middleLayout.setLeft(personalData);
        middleLayout.setCenter(personalDescription);
        middleLayout.setRight(pointsAndRank);
        middleLayout.setBottom(rankPanel);

        redigera = new Button("Redigera profil");
        redigera.setOnMouseClicked(event -> {

        });

        meny = new ComboBox();
        meny.setMaxWidth(80f);
        meny.getItems().add("Startsida");
        meny.getItems().add("Min profil");
        meny.getItems().add("Ranking");
        meny.setPromptText("Meny");
        meny.setPrefSize(80, 20);


        Circle bild = new Circle(300, 250, 70);

        beskrivning = new TextField();



        rankPanel.getChildren().addAll(score, rank);

        panel.getChildren().addAll(meny, rubrik, redigera);
        mainLayout.setTop(panel);
        mainLayout.setCenter(middleLayout);


        BorderPane.setAlignment(rank, Pos.CENTER);

        Scene profil = new Scene(mainLayout, 1500, 800);
        primaryStage.setScene(profil);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}