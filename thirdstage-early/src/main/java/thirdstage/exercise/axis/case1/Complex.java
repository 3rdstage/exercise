
package thirdstage.exercise.axis.case1;

/**
 * The instance of this class is immutable
 *
 * @author 3rdstage
 * @version 1.0, 2006년 7월 20일 (목), 3rdstage
 * @since 2006년 7월 20일 (목)
 */
public class Complex {
	
	private double real = 0.0d;
	private double imaginary = 0.0d;
	
	/** Creates a new instance of Complex */
	public Complex(double real, double img) {
		this.real = real;
		this.imaginary = img;
	}
	
	public double getReal(){ return this.real; }
	//public void setR(double r){ this.real = r; }
	
	public double getImaginary(){ return this.imaginary; }
	//public void setI(double i){ return this.img; }
	
	public Complex add(Complex c){
		return new Complex(this.real + c.getReal(), this.imaginary + c.getImaginary());
	}
	
	public boolean equals(Object obj){
		if((obj == null) || !(obj instanceof Complex)) return false;
		
		Complex c = (Complex)obj;
		if(c.getReal() == this.real && c.getImaginary() == this.imaginary) return true;
		else return false;
	}
	
}
