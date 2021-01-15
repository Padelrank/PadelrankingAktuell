package com.Padel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.time.LocalDate;
import java.util.LinkedList;

public class profilsida {


    Text firstNameLastName;
    Text rubrik;
    Text personalDescription;
    Text score;
    Text location;
    VBox personalData;
    VBox pointsAndRank;


    TextField beskrivning;


    TextField comment1;
    TextField comment2;
    TextField result2;

    Text rankScore;

    BorderPane mainLayout;
    BorderPane middleLayout;

    double prefWidth = 250;
    double prefHeight = 250;

    Button redigera;
    Button calendar;
    Button insertResults;

    DialogPane dp;

    HBox rankPanel;
    HBox panel;

    VBox date;
    DatePicker startDatePicker;
    DatePicker endDatePicker;

    TextField player1;
    TextField result1;
    TextField player2;

    ButtonType submit;
    ButtonType clear;

    GridPane gpAddResults;

    Dialog<String> dialog;

    ComboBox<String> meny;

    public TableView<Person> table = new TableView<Person>();
    public final ObservableList<Person> data = FXCollections.observableArrayList();


    profilsida() {

    }


    ProgressBar rank;

    public void showProfilePage(Stage stage) {


        LinkedList<Person> personLinkedList = new LinkedList<>();


        String explanation;




        middleLayout = new BorderPane();
        middleLayout.setPadding(new Insets(100, 150, 100, 150));
        middleLayout.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(5, 15, 5, 15))));


        personalDescription = new Text();
        personalDescription.setText("Jag heter Dennis Öberg och har spelat padel i snart 6 år.\n" +
                "När jag spelar föredrar jag att spela backhand\n" +
                "men kan även spela forehand.\nSpelar helst med och mot någon med mer än 1500poäng");
        personalDescription.setFont(Font.font("Verdana", 20));


        insertResults = new Button("Registrera resultat");
        insertResults.setOnMouseClicked(event -> {
            dialog = new Dialog<>();
            dialog.setTitle("Registrera Matchresultat");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(800, 250);
            dialog.setGraphic(new ImageView("com/Padel/RacketStartPage.png"));

            dp = new DialogPane();
            gpAddResults = new GridPane();
            gpAddResults.setAlignment(Pos.TOP_CENTER);
            gpAddResults.setPadding(new Insets(10, 10, 10, 10));
            gpAddResults.setVgap(10);
            gpAddResults.setHgap(10);

            result1 = new TextField();
            result1.setFocusTraversable(false);
            result1.setMaxWidth(180);
            result1.setPromptText("Resultat spelare 1:");
            GridPane.setConstraints(result1, 0, 1);
            gpAddResults.getChildren().add(result1);

            // Defining the Comment text field
            comment1 = new TextField();
            comment1.setFocusTraversable(false);
            comment1.setMaxWidth(180);
            comment1.setPrefColumnCount(15);
            comment1.setPromptText("Ange en kommentar");
            GridPane.setConstraints(comment1, 0, 2);
            gpAddResults.getChildren().add(comment1);

            // Defining the Name text field
            player2 = new TextField();
            player2.setFocusTraversable(false);
            player2.setMaxWidth(180);
            player2.setPromptText("Spelare 2:");
            player2.setPrefColumnCount(10);
            player2.getText();
            GridPane.setConstraints(player2, 1, 0);
            gpAddResults.getChildren().add(player2);

            // Defining the Last Name text field
            result2 = new TextField();
            result2.setFocusTraversable(false);
            result2.setMaxWidth(180);
            result2.setPromptText("Resultat spelare 2:");
            GridPane.setConstraints(result2, 1, 1);
            gpAddResults.getChildren().add(result2);

            // Defining the Comment text field
            comment2 = new TextField();
            comment2.setFocusTraversable(false);
            comment2.setMaxWidth(180);
            comment2.setPrefColumnCount(15);
            comment2.setPromptText("Ange en kommentar");
            GridPane.setConstraints(comment2, 1, 2);
            gpAddResults.getChildren().add(comment2);

            // Defining the Submit button
            submit = new ButtonType("Klar", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(submit);


            player1 = new TextField();
            player1.setFocusTraversable(false);
            player1.setPromptText("Spelare 1:");
            player1.setPrefColumnCount(10);
            player1.setMaxWidth(180);
            player1.getText();
            GridPane.setConstraints(player1, 0, 0);
            gpAddResults.getChildren().add(player1);

            player2 = new TextField();
            player2.setFocusTraversable(false);
            player2.setPromptText("Spelare 1:");
            player2.setPrefColumnCount(10);
            player2.setMaxWidth(180);
            player2.getText();
            GridPane.setConstraints(player2, 0, 0);
            gpAddResults.getChildren().add(player2);
            dialog.getDialogPane().setContent(gpAddResults);

            dialog.showAndWait();


        });

        showTableView(data);

        Text text1 = new Text("Rankinglista");
        text1.setFill(Color.BLACK);
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        TextFlow flow = new TextFlow(text1);
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));


        HBox overdel = new HBox(flow);
        overdel.setAlignment(Pos.CENTER);
        overdel.setPadding(new Insets(5, 5, 5, 5));
        pane.setTop(overdel);

        HBox cLista = new HBox();
        cLista.setMaxSize(320, 220);
        cLista.setSpacing(5);
        cLista.setPadding(new Insets(5));
        cLista.setAlignment(Pos.CENTER);

        pane.setCenter(cLista);

        TableView table = new TableView();

        table.setMaxSize(420, 320);

        TableColumn playerRank = new TableColumn("Rank");
        playerRank.setPrefWidth(40);
        TableColumn playerID = new TableColumn("PlayerID");
        playerID.setPrefWidth(60);
        TableColumn playerName = new TableColumn("Name");
        playerName.setPrefWidth(155);
        TableColumn rankingPoints = new TableColumn("Points");
        rankingPoints.setPrefWidth(50);


        table.getColumns().addAll(playerRank, playerID, playerName, rankingPoints);
        pane.setCenter(table);
        System.out.println(table);

        playerRank.setCellValueFactory(
                new PropertyValueFactory<Person, String>("rank"));
        playerID.setCellValueFactory(
                new PropertyValueFactory<Person, String>("playerID"));
        playerName.setCellValueFactory(
                new PropertyValueFactory<Person, String>("playerName"));
        rankingPoints.setCellValueFactory(
                new PropertyValueFactory<Person, String>("rankingPoints"));
        table.setItems(data);

        HBox hinfo = new HBox();
        cLista.setMaxSize(60, 120);
        cLista.setSpacing(5);
        cLista.setPadding(new Insets(5, 5, 5, 5));
        cLista.setAlignment(Pos.CENTER_LEFT);

        HBox vinfo = new HBox();
        cLista.setMaxSize(60, 120);
        cLista.setSpacing(5);
        cLista.setPadding(new Insets(5));
        cLista.setAlignment(Pos.CENTER_RIGHT);
        pane.setRight(vinfo);


        VBox infoPane = new VBox();
        infoPane.setPrefSize(200, 200);
        infoPane.setMinHeight(200);
        infoPane.setMaxSize(200, 200);
        VBox mitten = new VBox();
        TextArea besk = new TextArea();
        besk.setWrapText(true);


        String valfri = "Jag heter Jan Borg och har spelat padel i snart 6 år. när jag spelar föredrar jag att spela backhand men kan även spela forehand. spelar helst med och mot någon med mer än 1500poäng";
        besk.setPrefWidth(prefWidth);
        besk.setPrefHeight(prefHeight);
        besk.setPrefColumnCount(100);
        besk.setPrefRowCount(100);
        besk.setText(valfri);
        besk.setEditable(false);
        HBox knapp = new HBox();
        knapp.setPadding(new Insets(0, 5, 5, 58));
        knapp.setSpacing(0.5f);
        Button edit = new Button("Edit");
        Button save = new Button("Save");
        edit.setOnMouseClicked(e -> {
            besk.setEditable(true);
        });
        save.setOnMouseClicked(e -> {
            besk.setEditable(false);
        });


        mitten.getChildren().add(besk);
        knapp.getChildren().addAll(edit, save);

        infoPane.getChildren().addAll(mitten);


        panel = new HBox();
        panel.setSpacing(250);

        panel.setAlignment(Pos.CENTER);
        panel.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, CornerRadii.EMPTY, new Insets(5, 15, 15, 15))));
        rubrik = new Text(500, 85, "Padelrank");
        rubrik.setFont(Font.font("Verdana", 100));
        rubrik.setFill(Color.BLACK);

        firstNameLastName = new Text();
        firstNameLastName.setFont(Font.font("Verdana", 40));

        firstNameLastName.setText("Jan Borg");

        pointsAndRank = new VBox();


        rank = new ProgressBar();
        rank.setPrefWidth(500f);
        rank.setProgress(0.5f);


        rankPanel = new HBox();
        rankPanel.setAlignment(Pos.CENTER);
        score = new Text("Score: ");

        score.setFont(Font.font("Verdana", 20));

        personalData = new VBox();
        location = new Text();
        location.setText("Växjö");
        location.setFont(Font.font("Verdana", 20));
        personalData.getChildren().addAll(firstNameLastName, location);
        middleLayout.setLeft(personalData);
        middleLayout.setCenter(infoPane);
        middleLayout.setRight(pointsAndRank);


        redigera = new Button("Redigera profil");
        redigera.setOnMouseClicked(event -> {

        });



        meny = new ComboBox();

        meny.setMaxWidth(150);
        meny.setPromptText("Meny");
        meny.getItems().add("Startsida");
        meny.getItems().add("Min profil");
        meny.getItems().add("Ranking");
        meny.getItems().add("Kalender");
        meny.getItems().add("Rankingsida");
        meny.setPrefSize(150, 20);


        beskrivning = new TextField();


        rankScore = new Text();
        rankScore.setText("1575 Poäng");
        rankScore.setFont(Font.font("Verdana", 40));

        pointsAndRank.getChildren().addAll(rankScore, pane);

        rankPanel.getChildren().addAll(score, rank);

        panel.getChildren().addAll(meny, rubrik, insertResults);
        mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10, 10, 10, 10));
        mainLayout.setTop(panel);
        mainLayout.setCenter(middleLayout);


        startDatePicker = new DatePicker();
        endDatePicker = new DatePicker();

        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

        date = new VBox();
        date.getChildren().add(startDatePicker);
        date.getChildren().add(endDatePicker);
        mainLayout.setBottom(rank);

        middleLayout.setBottom(date);
        BorderPane.setAlignment(date, Pos.CENTER_LEFT);

        BorderPane.setAlignment(rank, Pos.CENTER);
        stage.getIcons().add(new Image("com/Padel/RacketStartPage.png"));
        Scene profil = new Scene(mainLayout, 1500, 800);

        stage.setScene(profil);
        stage.show();



        Rectangle2D primScreenbounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenbounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenbounds.getHeight() - stage.getHeight()) / 2);


    }

    static void showTableView(ObservableList<Person> data) {
        data.setAll(new Person(1, 110001, "Fernando Belasteguin", 1705),
                new Person(2, 110002, "Pablo Lima", 1700),
                new Person(3, 110003, "Javi Rico", 1680),
                new Person(4, 110004, "Coki Nieto", 1640),
                new Person(5, 110011, "Jan Borg", 1575),
                new Person(6, 110005, "Sanyo Gutierrez", 1570),
                new Person(7, 110006, "Franco Stupaczuk", 1530),
                new Person(8, 110007, "Augustin Tapia", 1440),
                new Person(9, 110008, "Paquito Navarro", 1430),
                new Person(10, 110009, "Juan Martin Diaz", 1400),
                new Person(11, 110010, "Maxi Sanchez", 1390),
                new Person(12, 110011, "Mati Diaz", 1230),
                new Person(13, 110012, "Martin Dinenno", 1140));
    }

    static void showAvailablePlayers(ObservableList<Person> data){

    }
}