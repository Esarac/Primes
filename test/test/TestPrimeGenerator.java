package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.InvalidNumberException;
import model.PrimeGenerator;

class TestPrimeGenerator {
	
	//Tested Class
	private PrimeGenerator generator;
	
	//Scene
	private void setUpScenePrimeGenerator(){
		generator=new PrimeGenerator();
	}

	//Test
	@Test
	void testGeneratePrimesMatrix1() {
		
		setUpScenePrimeGenerator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			generator.generatePrimesMatrix1(-1);
		});
		
		//1
		boolean[][] matrix=generator.generatePrimesMatrix1(1);
		
		assertTrue(matrix[0][0]);
		
		//4
		matrix=generator.generatePrimesMatrix1(4);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[1][0]);
		assertFalse(matrix[1][1]);
		
		//8
		matrix=generator.generatePrimesMatrix1(8);
		
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
		
		setUpScenePrimeGenerator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			generator.generatePrimesMatrix2(-1);
		});
		
		//1
		boolean[][] matrix=generator.generatePrimesMatrix2(1);
		
		assertTrue(matrix[0][0]);
		
		//4
		matrix=generator.generatePrimesMatrix2(4);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[1][0]);
		assertFalse(matrix[1][1]);
		
		//8
		matrix=generator.generatePrimesMatrix2(8);
		
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
		
		setUpScenePrimeGenerator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			generator.generatePrimesMatrix3(-1);
		});
		
		//1
		boolean[][] matrix=generator.generatePrimesMatrix3(1);
		
		assertTrue(matrix[0][0]);
		
		//4
		matrix=generator.generatePrimesMatrix3(4);
		
		assertTrue(matrix[0][0]);
		assertTrue(matrix[0][1]);
		assertTrue(matrix[1][0]);
		assertFalse(matrix[1][1]);
		
		//8
		matrix=generator.generatePrimesMatrix3(8);
		
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
	void testGenerateMatrix() {
		setUpScenePrimeGenerator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			generator.generateMatrix(-1);
		});
		
		//1
		boolean[][] matrix=generator.generateMatrix(1);
		
		assertEquals(matrix.length, 1);
		assertEquals(matrix[0].length, 1);
		
		//4
		matrix=generator.generateMatrix(4);
		
		assertEquals(matrix.length, 2);
		assertEquals(matrix[0].length, 2);
		
		//8
		matrix=generator.generateMatrix(8);
		
		assertEquals(matrix.length, 3);
		assertEquals(matrix[0].length, 3);
		
	}
	
	@Test
	void testGenerateNumberMatrix() {
		setUpScenePrimeGenerator();
		
		//-1
		assertThrows(InvalidNumberException.class, ()->{
			generator.generateNumberMatrix(-1);
		});
		
		//1
		int[][] matrix=generator.generateNumberMatrix(1);
		
		assertEquals(matrix[0][0],1);
		
		//4
		matrix=generator.generateNumberMatrix(4);
		
		assertEquals(matrix[0][0],1);
		assertEquals(matrix[0][1],2);
		
		assertEquals(matrix[1][0],3);
		assertEquals(matrix[1][1],4);
		
		//8
		matrix=generator.generateNumberMatrix(8);
		
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