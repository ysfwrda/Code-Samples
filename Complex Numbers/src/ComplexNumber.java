
public class ComplexNumber {
final double real;
final double imaginary;

	public ComplexNumber(double real, double imaginary) {
	this.real = real;
	this.imaginary = imaginary;
}

	public ComplexNumber(double real) {
		this.real = real;
		this.imaginary = 0;
	}
	/**
	 * @return the real
	 */
	public double getReal() {
		return real;
	}

	/**
	 * @return the imaginary
	 */
	public double getImaginary() {
		return imaginary;
	}
	
	public String toString()
	{
		String string = "("+real +"," +imaginary+")";
		return string;
		
	}
	
	//Multiplication inverse
	public ComplexNumber inverse() {
		ComplexNumber inverse;
		double denomerator =(getReal()*getReal() +getImaginary() *getImaginary());
		double inverseReal =getReal()/denomerator;
		double inverseImaginary = (-1.0 * getImaginary())/(getReal()*getReal() +getImaginary() *getImaginary());
		inverse =new ComplexNumber(inverseReal,inverseImaginary);
		return inverse ;
	}
	
	//returns the result of multiplication by another complex number
	public ComplexNumber multiply (ComplexNumber z)
	{
		if(z.real == 0.0)
	        return new ComplexNumber(-this.imaginary*z.imaginary,this.real*z.imaginary);
	        else if (z.imaginary == 0.0)
	        return new ComplexNumber(this.real*z.real,this.imaginary*z.imaginary);
	        else
	        	return new ComplexNumber(this.real*z.real-this.imaginary*z.imaginary,this.real*z.imaginary+this.imaginary*z.real);
		//double resultReal = getReal() * z.getReal() - getImaginary() * z.getImaginary();
		//double resultImaginary = getReal() *z.getImaginary() +getImaginary() * z.getReal();
		//ComplexNumber result = new ComplexNumber(resultReal,resultImaginary);
		//return result;
	}
	
	@Override
	public boolean equals(Object c)
	{
		if(c instanceof ComplexNumber){
			ComplexNumber complex = (ComplexNumber) c; //type cast
			return (getReal() == complex.getReal()) && (getImaginary() == complex.getImaginary()) ;
		}
		return false;
	}
}
