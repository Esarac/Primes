package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.PrimeGenerator;
import thread.ColoringThread;

public class ControlMenu implements Initializable {
	
	private PrimeGenerator generator;
	
	@FXML private TextField n;
	@FXML private ChoiceBox<String> choiceBox;
	@FXML private VBox matrix;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		generator=new PrimeGenerator();
		choiceBox.getItems().addAll("a","c");
		choiceBox.getSelectionModel().selectFirst();
		
		n.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				
				String character = event.getCharacter();
				
				try {
		    		Integer.parseInt(character);
		    	}
		    	catch(NumberFormatException e) {
		    		event.consume();
		    	}
				
		    }});
		
	}
	
	public void generateMatrix(){
		
		matrix.getChildren().clear();
		int size=Integer.parseInt(n.getText());
		
		//GenerateMatrix
		int[][] numberMatrix=generator.generateNumberMatrix(size);
		
		for(int x=0; x<numberMatrix.length; x++){
			HBox row=new HBox();
			matrix.getChildren().add(row);
		}
		

		for(int x=0; x<numberMatrix.length; x++){
			for(int y=0; y<numberMatrix[0].length; y++){
				
				String textNumber="";
				if(numberMatrix[x][y]!=0){
					textNumber+=numberMatrix[x][y];
				}
				
				Label number=new Label(textNumber);
				number.setMaxWidth(Double.MAX_VALUE);
				number.setMaxHeight(Double.MAX_VALUE);
				
				HBox row=(HBox)matrix.getChildren().get(x);
				row.getChildren().add(number);
				
			}
		}
		
		//Primes
		if(choiceBox.getValue().equals("a")){
			new ColoringThread(this, generator.generatePrimesMatrix1(size), "a").start();
		}
		else if(choiceBox.getValue().equals("c")){
			new ColoringThread(this, generator.generatePrimesMatrix3(size), "c").start();
		}
		
	}
	
	public void colorNumber(int x, int y, boolean color){
		HBox row=(HBox)matrix.getChildren().get(x);
		Label number=(Label)row.getChildren().get(y);
		if(color){
			number.setTextFill(Color.GREEN);
		}
		else {
			number.setTextFill(Color.RED);
		}
	}
	
}
