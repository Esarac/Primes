package thread;

import controller.ControlMenu;
import javafx.application.Platform;

public class ColoringThread extends Thread{
	
	//Constants
	public final static String METHOD1="a";
	public final static String METHOD2="b";
	public final static String METHOD3="c";
	
	//Attributes
	public ControlMenu controller;
	public boolean[][] colorMatrix;
	public String method;
	
	//Constructor
	public ColoringThread(ControlMenu controller,boolean[][] colorMatrix, String method){
		
		this.controller=controller;
		this.colorMatrix=colorMatrix;
		this.method=method;
		
	}
	
	//Run
	public void run() {
		if(METHOD1.equals(method)){
			a();
		}
		else if(METHOD2.equals(method)){
			
		}
		else if(METHOD3.equals(method)){
			
		}
		else{
			
		}
	}
	
	//Methods
	public void a() {
		
		for(int i=1; i<colorMatrix.length; i++){
			
			int x=(i-1)/colorMatrix.length;
			int y=i-((x)*colorMatrix.length)-1;
			
			Runnable color=new Runnable() {
				public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
			};
			Platform.runLater(color);
			
			try {sleep(100);} catch (InterruptedException e)
			{e.printStackTrace();}
			
		}
	}
	
}
