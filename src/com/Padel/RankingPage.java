package com.Padel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class RankingPage extends Application {

    public TableView<Person> table = new TableView<Person>();
    public final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(110001, "Fernando Belasteguin", 1705),
                    new Person(110002, "Pablo Lima", 1445),
                    new Person(110003, "Javi Rico", 1335),
                    new Person(110004, "Coki Nieto", 1475),
                    new Person(110005, "Sanyo Gutierrez", 1570),
                    new Person(110006, "Franco Stupaczuk", 1530),
                    new Person(110007, "Augustin Tapia", 1440),
                    new Person(110008, "Paquito Navarro", 1535),
                    new Person(110009, "Juan Martin Diaz", 1275),
                    new Person(110010, "Maxi Sanchez", 1470),
                    new Person(110011, "Mati Diaz", 1230),
                    new Person(110012, "Martin Dinenno", 1140)
            );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Rubrik
        Text text1 = new Text("Rankinglista");
        text1.setFill(Color.BLACK);
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        TextFlow flow = new TextFlow(text1);
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));


        HBox overdel = new HBox(flow);
        overdel.setAlignment(Pos.CENTER);
        overdel.setPadding(new Insets(5, 5, 5,5));
        pane.setTop(overdel);

        HBox cLista = new HBox();
        cLista.setMaxSize(320,220);
        cLista.setSpacing(5);
        cLista.setPadding(new Insets(5));
        cLista.setAlignment(Pos.CENTER);

        pane.setCenter(cLista);

        TableView table = new TableView();

        table.setMaxSize(300,320);

        TableColumn playerID = new TableColumn("PlayerID");
        playerID.setPrefWidth(60);
        TableColumn playerName = new TableColumn("Name");
        playerName.setPrefWidth(170);
        TableColumn rankingPoints = new TableColumn("Points");
        rankingPoints.setPrefWidth(50);


        table.getColumns().addAll(playerID, playerName, rankingPoints);
        pane.setCenter(table);
        System.out.println(table);


        playerID.setCellValueFactory(
                new PropertyValueFactory<Person, String>("playerID"));
        playerName.setCellValueFactory(
                new PropertyValueFactory<Person, String>("playerName"));
        rankingPoints.setCellValueFactory(
                new PropertyValueFactory<Person, String>("rankingPoints"));
        table.setItems(data);

        HBox hinfo = new HBox();
        cLista.setMaxSize(60,120);
        cLista.setSpacing(5);
        cLista.setPadding(new Insets(5, 5, 5,5));
        cLista.setAlignment(Pos.CENTER_LEFT);
/*
        pane.setLeft(hinfo);
        ImageView bild1 = new ImageView(new Image("com/Padel/RacketStartPage.png"));
        bild1.setFitWidth(60);
        bild1.setPreserveRatio(true);
        hinfo.getChildren().add(bild1);


 */
        HBox vinfo = new HBox();
        cLista.setMaxSize(60,120);
        cLista.setSpacing(5);
        cLista.setPadding(new Insets(5));
        cLista.setAlignment(Pos.CENTER_RIGHT);
        pane.setRight(vinfo);


/*
        VBox beskrivning = new VBox();
        beskrivning.setSpacing(10);
        beskrivning.setPadding(new Insets(10));
        beskrivning.getChildren().addAll();

 */

        Scene scene = new Scene(pane, 640, 426);
        primaryStage.setTitle("Rankinglista");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

