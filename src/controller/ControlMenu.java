package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import model.PrimeGenerator;
import thread.ColoringThread;

public class ControlMenu implements Initializable {
	//Constants
	public final static String METHOD1="Naive";
	public final static String METHOD2="Eratosthenes";
	public final static String METHOD3="Odd-5";
	
	//Attributes
	private PrimeGenerator generator;
	
	@FXML private BorderPane pane;
	@FXML private Button generate;
	@FXML private TextField n;
	@FXML private ChoiceBox<String> choiceBox;
	private Label[][] matrix;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		generator = new PrimeGenerator();
		choiceBox.getItems().addAll(METHOD1,METHOD2,METHOD3);
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
		
		int size = Integer.parseInt(n.getText());
		
		GridPane matrix = new GridPane();
		pane.setCenter(matrix);
		
		//GenerateMatrix
		int[][] numberMatrix = generator.generateNumberMatrix(size);
		this.matrix = new Label[numberMatrix.length][numberMatrix[0].length];
		
		for(int x = 0; x < numberMatrix.length; x++){
			RowConstraints row = new RowConstraints();
			row.setVgrow(Priority.ALWAYS);
			matrix.getRowConstraints().add(row);
		}
		for(int y = 0; y < numberMatrix[0].length; y++){
			ColumnConstraints column = new ColumnConstraints();
			column.setHgrow(Priority.ALWAYS);
			matrix.getColumnConstraints().add(column);
		}

		for(int x = 0; x < numberMatrix.length; x++){
			for(int y = 0; y < numberMatrix[0].length; y++){
				
				String textNumber = "";
				if(numberMatrix[x][y]!=0){
					textNumber += numberMatrix[x][y];
				}
				
				Label number = new Label(textNumber);
				number.setMaxWidth(Double.MAX_VALUE);
				number.setMaxHeight(Double.MAX_VALUE);
				
				this.matrix[x][y]=number;
				matrix.add(number, y, x);
				
			}
			
			generate.setDisable(true);
		}
		
		//Primes
		if(choiceBox.getValue().equals(METHOD1)){
			new ColoringThread(this, generator.generatePrimesMatrix1(size), METHOD1, generate).start();
		}
		else if(choiceBox.getValue().equals(METHOD2)){
			new ColoringThread(this, generator.generatePrimesMatrix2(size), METHOD2, generate).start();
		}
		else if(choiceBox.getValue().equals(METHOD3)){
			new ColoringThread(this, generator.generatePrimesMatrix3(size), METHOD3, generate).start();
		}
		
	}
	
	public void colorNumber(int x, int y, boolean color){
		
		Color red = Color.rgb(255, 0, 102);
		Color green = Color.rgb(0, 255, 153);
		
		if(color){
			
			matrix[x][y].setTextFill(green);
		}
		else {
			matrix[x][y].setTextFill(red);
		}
	}
}
