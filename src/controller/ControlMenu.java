package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
	@FXML private ScrollPane scroll;
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
	
	public <T extends Dialog<?>> void setCss(T dialog) {
		
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("/view/view.css").toExternalForm());
		dialogPane.getStyleClass().add("dialog");
		Stage stage = (Stage) dialogPane.getScene().getWindow();
		stage.getIcons().add(new Image("file:med/Logo.png"));
	}
	
	public void generateMatrix() {
		
		int size = 0;
		
		if(!n.getText().equals("")) {
			
			size = Integer.parseInt(n.getText());
			
			if(size > 0) {
				
				GridPane matrix = new GridPane();
				scroll.setContent(matrix);
				scroll.setId("scroll");
				matrix.setId("grid");
				
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
						
						
						if(numberMatrix[x][y]!=0){

							String textNumber = numberMatrix[x][y] + "";
							Label number = new Label(textNumber);
							number.getStyleClass().add("outline");
							number.setId("default");
							number.setMinHeight(70);
							number.setMinWidth(70);
							number.setMaxWidth(Double.MAX_VALUE);
							number.setMaxHeight(Double.MAX_VALUE);
							number.setAlignment(Pos.CENTER);
							
							this.matrix[x][y]=number;
							matrix.add(number, y, x);
						}
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
		else {
			
			ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
			
			//Shows an alert if the max value is 0.
			Alert alert = new Alert(AlertType.NONE, "Please enter a number greater than zero!", ok);
			alert.setHeaderText(null);
			alert.setTitle(null);
			setCss(alert);
			alert.show();
			n.clear();
		}
			}
		else {
			
			ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
			
			//Shows an alert if the text field is empty.
			Alert alert = new Alert(AlertType.NONE, "Please enter a number!", ok);
			alert.setHeaderText(null);
			alert.setTitle(null);
			setCss(alert);
			alert.show();
		}
	}
	
	public void colorNumber(int x, int y, boolean color) {
		try{
			if(color){
				
				matrix[x][y].setId("prime");
			}
			else {
				
				matrix[x][y].setId("composite");
			}
		}
		catch(NullPointerException e){
		}
	}
}
