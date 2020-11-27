package com.Padel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.SQLException;

public class RegisterPage {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    SQLConnector connector = new SQLConnector();


    RegisterPage() {


    }

    void display(Stage stage) {
        GridPane info = new GridPane();
        info.setGridLinesVisible(false);
        Button insertPic = new Button("Lägg till profilbild");
        Button createAccount = new Button("Skapa konto");

        info.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, new Insets(5, 5, 5, 5))));

        info.setVgap(10);
        info.setHgap(10);

        info.setPadding(new Insets(50, 40, 50, 40));

        VBox regInfo = new VBox();
        regInfo.setSpacing(15);
        Text fName = new Text("Förnamn: ");
        fName.setFont(Font.font("Verdana", 12));

        Text eName = new Text("Efternamn: ");
        eName.setFont(Font.font("Verdana", 12));

        Text eMail = new Text("Mailadress: ");
        eMail.setFont(Font.font("Verdana", 12));

        Text username = new Text("Användarnamn: ");
        username.setFont(Font.font("Verdana", 12));

        Text losen = new Text("Lösenord: ");
        losen.setFont(Font.font("Verdana", 12));

        regInfo.getChildren().addAll(fName, eName, eMail, username, losen);

        VBox regData = new VBox();
        regData.setSpacing(5);
        TextField fNamn = new TextField();
        TextField eNamn = new TextField();
        TextField userLogin = new TextField();
        TextField email = new TextField();

        PasswordField pw = new PasswordField();
        regData.getChildren().addAll(fNamn, eNamn, userLogin, email, pw);

        alert.setTitle("Padelrank");

        createAccount.setOnMouseClicked(event -> {
            String firstName = fNamn.getText();
            String lastName = eNamn.getText();
            String mailAdress = email.getText();

            String userID = userLogin.getText();
            String password = pw.getText();

            //boolean ok = controlInput(firstName, lastName, mailAdress, userID, password);
            if (controlInput(firstName, lastName, mailAdress, userID, password)) {
                registerUser(firstName, lastName, mailAdress, userID, password);
            } else {
                alert.show();
            }

        });
        insertPic.setOnMouseClicked(event -> {
            uploadProfilePic(stage);
        });

        info.add(regInfo, 0, 0);
        info.add(regData, 1, 0);
        info.add(insertPic, 1, 2);
        info.add(createAccount, 1, 3);

        info.setAlignment(Pos.BASELINE_CENTER);


        Scene regForm = new Scene(info, 400, 400);
        stage.setTitle("Registrera användare");
        stage.setScene(regForm);
        stage.show();
    }

    void uploadProfilePic(Stage st) {
        FileChooser fileChooser = new FileChooser();
        File pic = fileChooser.showOpenDialog(st);
    }

    void registerUser(String fName, String eName, String eMail, String userName, String password)  {
        new User(fName.toUpperCase(), eName.toUpperCase(), eMail, userName, password);
    }

    public boolean controlInput(String fName, String lastName, String eMail, String alias, String password) {
        if ((fName.length() != 0) && (lastName.length() != 0) && (eMail.length() != 0) && (alias.length() != 0)) {
            return kontroll(password);
        } else {
            alert.setHeaderText("Alla fält måste vara ifyllda.\n" +
                    "Var vänlig försök igen.");
        }
        return false;
    }

    public static boolean eligiblePassword(String losen) {

        return losen.length() >= 6;

    }
    public static boolean siffror(String password) {


        int antalSiffror = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                antalSiffror++;
            }
        }
        return antalSiffror >= 1;
    }
    public static boolean upperCase(String password) {

        int bokstaver = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                bokstaver++;
            }
        }
        return bokstaver >= 1;
    }

    public static boolean kontroll(String password) {

        return eligiblePassword(password) && upperCase(password) &&  siffror(password);
    }

}
