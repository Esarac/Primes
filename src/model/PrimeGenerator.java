package model;

import java.util.Arrays;

import exception.InvalidNumberException;

public class PrimeGenerator {
	
	public PrimeGenerator(){
		
	}
	
	public boolean[][] generatePrimesMatrix1(int maxValue) {
		//Matrix
		boolean[][] primesMatrix=generateMatrix(maxValue);
		
		//Number
		for(int i=1; i<=maxValue; i++){
			
			//Verify
			boolean isPrime=true;
			for(int j=2; (j<i) && isPrime;j++){
				if(i%j==0){
					isPrime=false;
				}
			}
			
			if(isPrime){
				
				int row=(i-1)/primesMatrix.length;
				int column=i-((row)*primesMatrix.length)-1;
				primesMatrix[row][column]=true;
			}
			
		}
		
		
		return primesMatrix;
	}
	
	public boolean[][] generatePrimesMatrix2(int maxValue) {
		//Matrix
		boolean[][] primesMatrix=generateMatrix(maxValue);
		for(boolean[] primesRow : primesMatrix){
			Arrays.fill(primesRow, Boolean.TRUE);
		}
		
		int i=2;
		while((i+i)<=maxValue){
			System.out.println("Prime:"+i);
			for(int j=i+i; j<=maxValue; j+=i){
				int row=(j-1)/primesMatrix.length;
				int column=j-(row*primesMatrix.length)-1;
				primesMatrix[row][column]=false;
				System.out.println("Not Prime:"+j);
			}
			
			boolean found=false;
			for(int j=i+1; (j<=maxValue) && (!found); j++){
				int row=(j-1)/primesMatrix.length;
				int column=j-(row*primesMatrix.length)-1;
				
				if(primesMatrix[row][column]){
					found=true;
					i=j;
				}
			}
			
		}
		
		return primesMatrix;
	}
	
	public boolean[][] generatePrimesMatrix3(int maxValue) {
		boolean[][] primesMatrix = generateMatrix(maxValue);
		
		if (maxValue>=2) {
			primesMatrix[0][1] = true;
		}
		
		for (int i = 1; i <= maxValue; i += 2) {
			
			boolean isPrime = true;
			
			for (int j = 2; (j < i) && isPrime; j++) {
				
				if (i % j == 0) {
					isPrime = false;
				}
				
			}
			
			if (isPrime) {
				int row = (i - 1) / primesMatrix.length;
				int column = i - (row * primesMatrix.length) - 1;
				
				primesMatrix[row][column] = true;
			}
			
			if( (i != 3) && (i % 10 == 3) ){
				i += 2;
			}
			
		}
		
		return primesMatrix;
	}
	
	public boolean[][] generateMatrix(int maxValue){
		boolean[][] primesMatrix;
		
		if(maxValue>=1){
			int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
			primesMatrix=new boolean[rowAndColumns][rowAndColumns];
		}
		else{
			throw new InvalidNumberException();
		}
		
		return primesMatrix;
	}
	
	public int[][] generateNumberMatrix(int maxValue){
		
		int[][] primesMatrix;
		
		if(maxValue>=1){
			int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
			primesMatrix=new int[rowAndColumns][rowAndColumns];
			
			for(int i = 1; i <= maxValue; i++){
				
				int row = (i-1) / primesMatrix.length;
				int column = i - (row * primesMatrix.length) - 1;
				
				primesMatrix[row][column] = i;
				
			}
		}
		else{
			throw new InvalidNumberException();
		}
		
		return primesMatrix;
		
	}
	
}
