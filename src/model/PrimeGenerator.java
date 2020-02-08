package model;

import java.util.Arrays;

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
		Arrays.fill(primesMatrix, Boolean.TRUE);
		
		
		
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
		
		int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
		boolean[][] primesMatrix=new boolean[rowAndColumns][rowAndColumns];
		
		return primesMatrix;
	}
	
	public int[][] generateNumberMatrix(int maxValue){
		
		int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
		int[][] primesMatrix=new int[rowAndColumns][rowAndColumns];
		
		for(int i = 1; i <= maxValue; i++){
			
			int row = (i-1) / primesMatrix.length;
			int column = i - (row * primesMatrix.length) - 1;
			
			primesMatrix[row][column] = i;
			
		}
		
		return primesMatrix;
		
	}
	
}