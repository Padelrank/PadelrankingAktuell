package com.Padel;

import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Calendar {

    Calendar(){

    }
    void displayCalendar(Stage stage){
        VBox vbox = new VBox(20);
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

        vbox.getChildren().add(startDatePicker);

        vbox.getChildren().add(endDatePicker);
        stage.show();
    }

}
