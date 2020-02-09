package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.InvalidNumberException;
import model.PrimeGenerator;

class TestPrimeCalculator {
	
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
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			calculator.generatePrimesMatrix1(-1);
		});
		
		//1
		boolean[][] matrix=calculator.generatePrimesMatrix1(1);
		
		assertEquals(matrix.length, 1);
		assertEquals(matrix[0].length, 1);
		
		assertTrue(matrix[0][0]);
		
		//4
		matrix=calculator.generatePrimesMatrix1(4);
		
		assertEquals(matrix.length, 2);
		assertEquals(matrix[0].length, 2);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[1][0]);
		assertFalse(matrix[1][1]);
		
		//8
		matrix=calculator.generatePrimesMatrix1(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[0][2]);
		assertFalse(matrix[1][0]);
		assertTrue(matrix[1][1]);
		assertFalse(matrix[1][2]);
		assertTrue(matrix[2][0]);
		assertFalse(matrix[2][1]);
		assertFalse(matrix[2][2]);
	}
	
	@Test
	void testGeneratePrimesMatrix2() {
		
		setUpScenePrimeCalculator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			calculator.generatePrimesMatrix2(-1);
		});
		
		//1
		boolean[][] matrix=calculator.generatePrimesMatrix2(1);
		
		assertEquals(matrix.length, 1);
		assertEquals(matrix[0].length, 1);
		
		assertTrue(matrix[0][0]);
		
		//4
		matrix=calculator.generatePrimesMatrix2(4);
		
		assertEquals(matrix.length, 2);
		assertEquals(matrix[0].length, 2);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[1][0]);
		assertFalse(matrix[1][1]);
		
		//8
		matrix=calculator.generatePrimesMatrix2(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[0][2]);
		assertFalse(matrix[1][0]);
		assertTrue(matrix[1][1]);
		assertFalse(matrix[1][2]);
		assertTrue(matrix[2][0]);
		assertFalse(matrix[2][1]);
		assertTrue(matrix[2][2]);
		
	}
	
	@Test
	void testGeneratePrimesMatrix3() {
		
		setUpScenePrimeCalculator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			calculator.generatePrimesMatrix3(-1);
		});
		
		//1
		boolean[][] matrix=calculator.generatePrimesMatrix3(1);
		
		assertEquals(matrix.length, 1);
		assertEquals(matrix[0].length, 1);
		
		assertTrue(matrix[0][0]);
		
		//4
		matrix=calculator.generatePrimesMatrix3(4);
		
		assertEquals(matrix.length, 2);
		assertEquals(matrix[0].length, 2);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[1][0]);
		assertFalse(matrix[1][1]);
		
		//8
		matrix=calculator.generatePrimesMatrix3(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[0][2]);
		assertFalse(matrix[1][0]);
		assertTrue(matrix[1][1]);
		assertFalse(matrix[1][2]);
		assertTrue(matrix[2][0]);
		assertFalse(matrix[2][1]);
		assertFalse(matrix[2][2]);
	}
	
	@Test
	void testGenerateNumberMatrix() {
		setUpScenePrimeCalculator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			calculator.generateNumberMatrix(-1);
		});
		
		//8
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
