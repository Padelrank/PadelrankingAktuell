package com.Padel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Loginpage extends Application {

    PasswordField pw;
    TextField user;




    private final Image img = new Image("com/Padel/LoginPadelV2.jpg");
    //gör bakgrundsbilden transparent.

    @Override
    public void start(Stage stage) {


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
            Alert error = new Alert(Alert.AlertType.ERROR);



            if ((user.getText().equals("1")) && (pw.getText().equals("1"))) {
                profilsida pf = new profilsida();
                pf.showProfilePage(stage);
            } else {
                error.setTitle("Misslyckad inloggning");
                error.setHeaderText("Fel lösenord");
                error.show();
            }

        });


        Button register = new Button();
        register.setText("Registrera");
        register.setOnMouseClicked(event -> {
            RegisterPage rp = new RegisterPage();
            rp.display(stage);

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

        pw = new PasswordField();
        user = new TextField();


        usernamePassword.getChildren().addAll(username, user, password, pw);
        gp.add(usernamePassword, 0, 0);

        gp.add(btns, 0, 2);
        gp.add(frgtPassword, 0, 6);


        Scene sc = new Scene(gp, 640, 426);

        stage.setResizable(false);
        gp.setGridLinesVisible(false);

        stage.getIcons().add(new Image("com/Padel/RacketStartPage.png"));
        stage.setTitle("Padelrank");
        stage.setScene(sc);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
