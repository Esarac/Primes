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
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import model.PrimeGenerator;
import thread.ColoringThread;

public class ControlMenu implements Initializable {
	
	private PrimeGenerator generator;
	
	@FXML private Pane pane;
	@FXML private TextField n;
	@FXML private ChoiceBox<String> choiceBox;
	private GridPane matrix;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
		
		int size=Integer.parseInt(n.getText());
		
		//GenerateMatrix
		int[][] numberMatrix=generator.generateNumberMatrix(size);
		matrix=new GridPane();
		pane.getChildren().add(matrix);
		
		for(int x=0; x<numberMatrix.length; x++){
			RowConstraints row=new RowConstraints();
			row.setVgrow(Priority.ALWAYS);
			matrix.getRowConstraints().add(row);
		}
		for(int y=0; y<numberMatrix[0].length; y++){
			ColumnConstraints column=new ColumnConstraints();
			column.setHgrow(Priority.ALWAYS);
			matrix.getColumnConstraints().add(column);
		}
		

		for(int x=0; x<numberMatrix.length; x++){
			for(int y=0; y<numberMatrix[0].length; y++){
				
				Label number=new Label();
				number.setMaxWidth(Double.MAX_VALUE);
				number.setMaxHeight(Double.MAX_VALUE);
				
				matrix.add(number, y, x);
				
			}
		}
		
		//Primes
		if(choiceBox.getValue().equals("a")){
			new ColoringThread(this, generator.generatePrimesMatrix1(size), "a");
		}
		
	}
	
	public void colorNumber(int x, int y, boolean color){
		
	}
	
}
