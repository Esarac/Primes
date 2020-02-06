package model;

public class PrimeCalculator {
	
	public PrimeCalculator(){
	}
	
	public boolean[][] generatePrimesMatrix1(int maxValue) {
		//Matrix
		int rowAndColumns=(int) Math.ceil(Math.sqrt(maxValue));
		boolean[][] primesMatrix=new boolean[rowAndColumns][rowAndColumns];
		
		//Number
		for(int i=1; i<=maxValue; i++){
			
			//Verify
			System.out.println("prime:"+i);
			boolean isPrime=true;
			for(int j=2; (j<i) && isPrime;j++){
				if(i%j==0){
					System.out.println("divisible por:"+j);
					isPrime=false;
				}
			}
			
			if(isPrime){
				
				int row=(i-1)/primesMatrix.length;
				int column=i-((row)*primesMatrix.length)-1;
				System.out.println((i-1)+"nb "+primesMatrix.length);
				System.out.println(row+" "+column);
				primesMatrix[row][column]=true;
			}
			
		}
		
		
		return primesMatrix;
	}
	
	public boolean[][] generatePrimesMatrix2(int maxValue) {
		return null;
	}
	
	public boolean[][] generatePrimesMatrix3(int maxValue) {
		return null;
	}
	
}
