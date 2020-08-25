
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumber c1 = new ComplexNumber(1.0); // imag part = 0
		ComplexNumber c2 = new ComplexNumber(-1.5, -2.5); // real part, imag part
		System.out.println(c1.multiply(c2).multiply(c2).toString());
		System.out.println(c2.inverse().multiply(c2));
		
	}

}
