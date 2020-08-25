import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComplexNumberTest {
	private ComplexNumber c1;
	private ComplexNumber c2;
	@BeforeEach
	void setUp() throws Exception {
		 c1 = new ComplexNumber(1.0); // imag part = 0
		 c2 = new ComplexNumber(-1.5, -2.5); // real part, imag part
	}

	@Test
	void testComplexNumberDoubleDouble() {
		assertEquals(-1.5,c2.getReal());
		assertEquals(-2.5,c2.getImaginary());
	}

	@Test
	void testComplexNumberDouble() {
		assertEquals(1.0,c1.getReal());
	}
	
	@Test
	void testToString() {
	assertEquals("(" +c1.getReal()+","+c1.getImaginary()+")",c1.toString());
	assertEquals("(" +c2.getReal()+","+c2.getImaginary()+")",c2.toString());
		
		
		
	}
	
	@Test
	void testMultiply(){
		assertEquals("(-4.0,7.5)",c1.multiply(c2).multiply(c2).toString());
	}
	
	@Test
	void testInverse() {
		assertEquals(c1,c2.inverse().multiply(c2));
	}
	}
	//Helper method
	/*  private double assertEquals(ComplexNumber c1 , ComplexNumber c2)
	{
		boolean equals =false;
		if(c1.getReal() == c2.getReal() && c1.getImaginary() == c2.getImaginary())
			return true;
		else
		return false;
	} */
