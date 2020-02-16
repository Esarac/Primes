package thread;

import controller.ControlMenu;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class ColoringThread extends Thread{
	
	//Constants
	public final static int SLEEP=75;
	
	//Attributes
	private ControlMenu controller;
	private boolean[][] colorMatrix;
	private String method;
	private Button generate;
	
	//Constructor
	public ColoringThread(ControlMenu controller,boolean[][] colorMatrix, String method, Button generate){
		
		this.controller = controller;
		this.colorMatrix = colorMatrix;
		this.method = method;
		this.generate = generate;
		
	}
	
	//Run
	public void run() {
		try {sleep(SLEEP);}
		catch (InterruptedException e){e.printStackTrace();}
		
		if(ControlMenu.METHOD1.equals(method)){
			method1(generate);
			generate.setDisable(false);
		}
		else if(ControlMenu.METHOD2.equals(method)){
			method2(generate);
			generate.setDisable(false);
		}
		else if(ControlMenu.METHOD3.equals(method)){
			method3(generate);
			generate.setDisable(false);
		}
		else{
			method1(generate);
			generate.setDisable(false);
		}
	}
	
	//Methods
	public void method1(Button generate) {
		
		for(int i = 1; i <= (colorMatrix.length * colorMatrix.length); i++){
			
			int x = (i-1) / colorMatrix.length;
			int y = i-((x) * colorMatrix.length)-1;
			
			Runnable color=new Runnable() {
				public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
			};
			Platform.runLater(color);
			
			try {sleep(SLEEP);}
			catch (InterruptedException e){e.printStackTrace();}
			
		}
	}
	
	public void method2(Button generate){
		for(int i = 1; (i <= (colorMatrix.length*colorMatrix.length));){
			
			if(i > 1){
				for(int j = i; j<=(colorMatrix.length*colorMatrix.length); j += i){
					
					int x = (j-1) / colorMatrix.length;
					int y = j - ((x) * colorMatrix.length) - 1;
					Runnable color = new Runnable() {
						public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
					};
					Platform.runLater(color);
					
					try {sleep(SLEEP);}
					catch (InterruptedException e){e.printStackTrace();}
					
					if(j==i){
						j+=i*(i-2);
					}
					
				}
				boolean found = false;
				for(int j = i+1; (j <= (colorMatrix.length*colorMatrix.length)) && (!found); j++){
					int row = (j-1) / colorMatrix.length;
					int column=j-(row*colorMatrix.length)-1;
					
					if(colorMatrix[row][column]){
						found = true;
						i = j;
					}
				}
				
				if(!found){
					i = colorMatrix.length*colorMatrix.length+1;
				}
			}
			else{
				Runnable color = new Runnable() {
					public void run() {controller.colorNumber(0, 0, colorMatrix[0][0]);}
				};
				Platform.runLater(color);
				
				try {sleep(SLEEP);}
				catch (InterruptedException e){e.printStackTrace();}
				i++;
			}
		}
	}
	
	public void method3(Button generate) {
		
		for(int i = 1; i <= (colorMatrix.length*colorMatrix.length); i++){
			
			int x = (i-1) / colorMatrix.length;
			int y = i-((x) * colorMatrix.length) - 1;
			
			Runnable color=new Runnable() {
				public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
			};
			Platform.runLater(color);
			
			if( (i % 2 != 0) && (i % 10 != 5) ) {
				try {sleep(SLEEP);}
				catch (InterruptedException e){e.printStackTrace();}
			}
		}	
	}	
}
