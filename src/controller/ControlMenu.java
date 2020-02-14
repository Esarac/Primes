package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ControlMenu implements Initializable {
	
	@FXML TextField n;

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
	
}
