package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.PrimeGenerator;

class TestPrimeGenerator {
	
	//Tested Class
	private PrimeGenerator calculator;
	
	//Scene
	private void setUpScenePrimeCalculator(){
		calculator=new PrimeGenerator();
	}

	//Test
	@Test
	void testGeneratePrimesMatrix1() {
		setUpScenePrimeCalculator();
		boolean[][] matrix=calculator.generatePrimesMatrix1(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[0][2]);
		assertTrue(matrix[1][1]);
		assertTrue(matrix[2][0]);
		assertFalse(matrix[2][2]);
	}
	
	@Test
	void testGeneratePrimesMatrix3() {
		setUpScenePrimeCalculator();
		boolean[][] matrix=calculator.generatePrimesMatrix3(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[0][2]);
		assertTrue(matrix[1][1]);
		assertTrue(matrix[2][0]);
		assertFalse(matrix[2][2]);
	}
	
	@Test
	void testGenerateNumberMatrix() {
		setUpScenePrimeCalculator();
		int[][] matrix=calculator.generateNumberMatrix(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertEquals(matrix[0][0],1);
		assertEquals(matrix[0][1],2);
		assertEquals(matrix[0][2],3);
		
		assertEquals(matrix[1][0],4);
		assertEquals(matrix[1][1],5);
		assertEquals(matrix[1][2],6);
		
		assertEquals(matrix[2][0],7);
		assertEquals(matrix[2][1],8);
		assertEquals(matrix[2][2],0);
	}
	
}