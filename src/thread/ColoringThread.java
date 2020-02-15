package thread;

import controller.ControlMenu;
import javafx.application.Platform;

public class ColoringThread extends Thread{
	
	//Constants
	public final static String METHOD1="a";
	public final static String METHOD2="b";
	public final static String METHOD3="c";
	public final static int SLEEP=75;
	
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
			b();
		}
		else if(METHOD3.equals(method)){
			c();
		}
		else{
			
		}
	}
	
	//Methods
	public void a() {
		
		for(int i=1; i<=(colorMatrix.length*colorMatrix.length); i++){
			
			int x=(i-1)/colorMatrix.length;
			int y=i-((x)*colorMatrix.length)-1;
			
			Runnable color=new Runnable() {
				public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
			};
			Platform.runLater(color);
			
			try {sleep(SLEEP);} catch (InterruptedException e)
			{e.printStackTrace();}
			
		}
	}
	
	public void b(){
		for(int i=1; (i<=(colorMatrix.length*colorMatrix.length));){
			
			if(i>1){
				for(int j=i; j<=(colorMatrix.length*colorMatrix.length); j+=i){
					
					int x=(j-1)/colorMatrix.length;
					int y=j-((x)*colorMatrix.length)-1;
					Runnable color=new Runnable() {
						public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
					};
					Platform.runLater(color);
					
					try {sleep(SLEEP);} catch (InterruptedException e)
					{e.printStackTrace();}
				}
				
				boolean found=false;
				for(int j=i+1; (j<=(colorMatrix.length*colorMatrix.length)) && (!found); j++){
					int row=(j-1)/colorMatrix.length;
					int column=j-(row*colorMatrix.length)-1;
					
					System.out.println("j:"+j+" x:"+row+" y:"+column+" size:"+colorMatrix.length);
					if(colorMatrix[row][column]){
						found=true;
						i=j;
					}
				}
				
				if(!found){
					i=colorMatrix.length*colorMatrix.length+1;
				}
			}
			else{
				Runnable color=new Runnable() {
					public void run() {controller.colorNumber(0, 0, colorMatrix[0][0]);}
				};
				Platform.runLater(color);
				
				try {sleep(SLEEP);} catch (InterruptedException e)
				{e.printStackTrace();}
				i++;
			}
			
		}
		
	}
	
	public void c() {
		
		for(int i=1; i<=(colorMatrix.length*colorMatrix.length); i++){
			
			int x=(i-1)/colorMatrix.length;
			int y=i-((x)*colorMatrix.length)-1;
			
			Runnable color=new Runnable() {
				public void run() {controller.colorNumber(x, y, colorMatrix[x][y]);}
			};
			Platform.runLater(color);
			
			if( (i % 2 != 0) && (i % 10 != 5) ) {
				try {sleep(SLEEP);} catch (InterruptedException e)
				{e.printStackTrace();}
			}
			
		}
		
	}
	
}
