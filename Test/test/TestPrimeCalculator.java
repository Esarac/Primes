package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.PrimeCalculator;

class TestPrimeCalculator {
	
	//Tested Class
	private PrimeCalculator calculator;
	
	//Scene
	private void setUpScenePrimeCalculator(){
		calculator=new PrimeCalculator();
	}

	//Test
	@Test
	void testGeneratePrimesMatrix1() {
		setUpScenePrimeCalculator();
		boolean[][] matrix=calculator.generatePrimesMatrix1(9);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[0][2]);
		assertTrue(matrix[1][1]);
		assertTrue(matrix[2][0]);
		assertFalse(matrix[2][2]);
	}
}
