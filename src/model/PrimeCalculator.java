package model;

public class PrimeCalculator {
	
	public PrimeCalculator(){
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
		int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
		boolean[][] primesMatrix=new boolean[rowAndColumns][rowAndColumns];
		
		return primesMatrix;
	}
	
	public boolean[][] generatePrimesMatrix3(int maxValue) {
		return null;
	}
	
	public boolean[][] generateMatrix(int maxValue){
		int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
		boolean[][] primesMatrix=new boolean[rowAndColumns][rowAndColumns];
		return primesMatrix;
	}
	
	public int[][] generateNumberMatrix(int maxValue){
		int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
		int[][] primesMatrix=new int[rowAndColumns][rowAndColumns];
		
		for(int i=1; i<=maxValue; i++){
			int row=(i-1)/primesMatrix.length;
			int column=i-((row)*primesMatrix.length)-1;
			primesMatrix[row][column]=i;
		}
		
		return primesMatrix;
	}
	
}
