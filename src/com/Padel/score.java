package com.Padel;

import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text; 

public class score extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
	@Override
	public void start(Stage stage) throws Exception {

		Text score = new Text(); 
	       
	      //Setting font to the text 
	      //score.setFont(new Font(45)); 
	       
	      //setting the position of the text 
	      score.setX(250); 
	      score.setY(60);      
	      
	      //setting the font type and size
	      score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
	      
	      //Setting the color 
	      score.setFill(Color.BROWN); 
	       
	      //Setting the Stroke  
	      score.setStrokeWidth(2); 
	      
	      // Setting the stroke color
	      score.setStroke(Color.BLUE);        

	      
	      //Setting the text to be added. 
	      score.setText("Score Result"); 
	      
	      
	      Text firstPlayer = new Text(); 
          firstPlayer.setFont(new Font(25)); 
	      firstPlayer.setX(180); 
	      firstPlayer.setY(210);      
	      firstPlayer.setFill(Color.BROWN); 
	      firstPlayer.setText("First Player"); 
	      
	      Text firstResult = new Text(); 
          firstResult.setFont(new Font(25)); 
	      firstResult.setX(320); 
	      firstResult.setY(210);      
	      firstResult.setFill(Color.BROWN); 
	      firstResult.setText("4"); 
	      
	      Text firstDesc = new Text(); 
          firstDesc.setFont(new Font(20)); 
	      firstDesc.setX(200); 
	      firstDesc.setY(250);      
	      firstDesc.setFill(Color.BROWN); 
	      firstDesc.setText("Winner!"); 
	      
	      
	      Text col = new Text(); 
          col.setFont(new Font(25)); 
	      col.setX(360); 
	      col.setY(210);      
	      col.setFill(Color.BROWN); 
	      col.setText("-"); 
	      
	      
	      Text secondPlayer = new Text(); 
          secondPlayer.setFont(new Font(25)); 
	      secondPlayer.setX(450); 
	      secondPlayer.setY(210);      
	      secondPlayer.setFill(Color.BROWN); 
	      secondPlayer.setText("Second Player"); 
	      
	      
	      Text secondResult = new Text(); 
          secondResult.setFont(new Font(25)); 
	      secondResult.setX(410); 
	      secondResult.setY(210);      
	      secondResult.setFill(Color.BROWN); 
	      secondResult.setText("0"); 
	      
	      Text secondDesc = new Text(); 
          secondDesc.setFont(new Font(20)); 
	      secondDesc.setX(480); 
	      secondDesc.setY(250);      
	      secondDesc.setFill(Color.BROWN); 
	      secondDesc.setText("Loser!"); 
	      
	      //Creating a Group object  
	      Group root = new Group(); 
	       
	      //Retrieving the observable list object 
	      ObservableList list = root.getChildren(); 
	       
	      //Setting the text object as a node to the group object 
	      list.add(score);       
	      list.add(firstPlayer);
	      list.add(firstResult);
	      list.add(firstDesc);
	      list.add(col);
	      list.add(secondPlayer); 
	      list.add(secondResult);
	      list.add(secondDesc);
	      //Creating a scene object 
	      Scene scene = new Scene(root, 800, 500, Color.BEIGE); 
	       
	      //Setting title to the Stage 
	      stage.setTitle("Score"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	      
	      stage.setResizable(false);
	         
	      //Displaying the contents of the stage 
	      stage.show(); 
	}

}
