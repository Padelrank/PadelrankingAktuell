package com.Padel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Loginpage extends Application {

    private final Image img = new Image("com/Padel/LoginPadelV2.jpg");
    //gör bakgrundsbilden transparent.

    @Override
    public void start(Stage primaryStage) {


        GridPane gp = new GridPane();
        gp.setAlignment(Pos.TOP_CENTER);
        gp.setVgap(5);
        gp.setHgap(5);
        gp.setPadding(new Insets(25, 25, 25, 25));


        gp.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT
                , BackgroundSize.DEFAULT)));

        Text username = new Text();
        username.setText("Användarnamn:");
        username.setFont(Font.font("Verdana", 13));
        username.setFill(Color.WHITESMOKE);


        Text password = new Text();
        password.setText("Lösenord: ");
        password.setFont(Font.font("Verdana", 13));
        password.setFill(Color.WHITESMOKE);


        HBox btns = new HBox();
        Button login = new Button();
        login.setText("Logga In");
        login.setOnMouseClicked(event -> {
            profilsida.launch();
        });


        Button register = new Button();
        register.setText("Registrera");
        register.setOnMouseClicked(event -> {
            RegisterPage rp = new RegisterPage();
            rp.display(primaryStage);

        });

        Button frgtPassword = new Button();
        frgtPassword.setText("Glömt lösenord");

        btns.getChildren().addAll(login, register);
        btns.setAlignment(Pos.CENTER);
        btns.setSpacing(10);
        btns.setMaxWidth(200);


        VBox usernamePassword = new VBox();
        usernamePassword.setMaxWidth(200);
        usernamePassword.setSpacing(5);

        PasswordField pw = new PasswordField();
        TextField user = new TextField();


        usernamePassword.getChildren().addAll(username, user, password, pw);
        gp.add(usernamePassword, 0, 0);

        gp.add(btns, 0, 2);
        gp.add(frgtPassword, 0, 6);


        Scene sc = new Scene(gp, 640, 426);

        primaryStage.setResizable(false);
        gp.setGridLinesVisible(false);

        primaryStage.getIcons().add(new Image("com/Padel/RacketStartPage.png"));
        primaryStage.setTitle("Padelrank");
        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
