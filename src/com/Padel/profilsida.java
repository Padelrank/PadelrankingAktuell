package com.Padel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class profilsida {


    Text firstNameLastName;
    Text rubrik;
    Text personalDescription;
    Text score;
    VBox personalData;
    VBox pointsAndRank;


    TextField beskrivning;
    TextFlow descFlow;

    Text rankScore;

    BorderPane mainLayout;
    BorderPane middleLayout;

    double prefWidth = 250;
    double prefHeight = 250;

    Button redigera;
    Button calendar;

    HBox rankPanel;
    HBox panel;

    ComboBox<String> meny;


    profilsida(){
    }


    ProgressBar rank;
    public void showProfilePage(Stage stage){



        middleLayout = new BorderPane();
        middleLayout.setPadding(new Insets(100,50,100,50));
        middleLayout.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(5, 15, 5, 15))));

        /*
        personalDescription = new Text();
        personalDescription.setText("Jag heter jan borg och har spelat padel i snart 6 år.\n" +
                "När jag spelar föredrar jag att spela backhand\n" +
                "men kan även spela forehand.\nSpelar helst med och mot någon med mer än 1500poäng");
        personalDescription.setFont(Font.font("Verdana", 20));


         */

        VBox pane = new VBox();
        pane.setPrefSize(200,200);
        pane.setMinHeight(200);
        pane.setMaxSize(200,200);
        VBox mitten = new VBox();
        TextArea besk = new TextArea();
        besk.setWrapText(true);



        String valfri = new String("Jag heter jan borg och har spelat padel i snart 6 år. när jag spelar föredrar jag att spela backhand men kan även spela forehand. spelar helst med och mot någon med mer än 1500poäng");
        besk.setPrefWidth(prefWidth);
        besk.setPrefHeight(prefHeight);
        besk.setPrefColumnCount(100);
        besk.setPrefRowCount(100);
        besk.setText(valfri);
        besk.setEditable(false);
        HBox knapp = new HBox();
        knapp.setPadding(new Insets(0,5,5,58));
        knapp.setSpacing(0.5f);
        Button edit = new Button("Edit");
        Button save = new Button("Save");
        edit.setOnMouseClicked(e ->{
            besk.setEditable(true);
        });
        save.setOnMouseClicked(e ->{
            besk.setEditable(false);
        });
        mitten.getChildren().add(besk);
        knapp.getChildren().addAll(edit, save);

        pane.getChildren().addAll(mitten, knapp);


        panel = new HBox();
        panel.setSpacing(350);

        panel.setAlignment(Pos.CENTER);
        panel.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, CornerRadii.EMPTY, new Insets(5, 15, 15, 15))));
// änra röda panelen till något snyggare, såg bättre ut i paint :P
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
        middleLayout.setCenter(pane);
        middleLayout.setRight(pointsAndRank);
        middleLayout.setBottom(rankPanel);

        redigera = new Button("Redigera profil");
        redigera.setOnMouseClicked(event -> {

        });

        meny = new ComboBox();

        meny.setMaxWidth(80);
        meny.setPromptText("Meny");
        meny.getItems().add("Startsida");
        meny.getItems().add("Min profil");
        meny.getItems().add("Ranking");
        meny.getItems().add("Kalender");
        meny.getItems().add("Rankingsida");
        meny.setPrefSize(80, 20);


        Circle bild = new Circle(300, 250, 70);

        beskrivning = new TextField();

        calendar = new Button();
        calendar.setText("Kalender");
        calendar.setOnMouseClicked(event -> {
            Calendar c = new Calendar(stage);
        });


        rankScore = new Text();
        rankScore.setText("1575 Poäng");
        rankScore.setFont(Font.font("Verdana", 40));

        pointsAndRank.getChildren().addAll(rankScore, calendar);

        rankPanel.getChildren().addAll(score, rank);

        panel.getChildren().addAll(meny, rubrik, redigera);
        mainLayout = new BorderPane();
        mainLayout.setTop(panel);
        mainLayout.setCenter(middleLayout);
        //mainLayout.setRight(pointsAndRank);

        //BorderPane.setAlignment(pane, Pos.CENTER);


        BorderPane.setAlignment(rank, Pos.CENTER);
        stage.getIcons().add(new Image("com/Padel/RacketStartPage.png"));
        Scene profil = new Scene(mainLayout, 1500, 800);
        stage.setScene(profil);
        stage.show();
    }


}