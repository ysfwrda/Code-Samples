import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RealNumberTest {
	ComplexNumber r1;
	ComplexNumber r2;
	ComplexNumber r3;
	@BeforeEach
	void setUp() throws Exception {
		 r1 = new RealNumber(2.0);
		 r2 = new RealNumber(0.5);
		 r3 = new RealNumber(1);
	}

	@Test
	void testInverse() {
		assertEquals(r2,r1.inverse());
	}

	@Test
	void testMultiply() {
		assertEquals(r3,r1.inverse().multiply(r1));
	}

}
