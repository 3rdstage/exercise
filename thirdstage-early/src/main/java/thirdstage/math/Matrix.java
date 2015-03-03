package thirdstage.math;

/**
 * This class is immutable.
 *
 * @author 3rdstage
 * @version 0.1, 2007-04-05, 3rdstage
 * @since 2007-04-5
 */
public class Matrix {
	
	protected double[][] elements = null;
	
	/** Creates a new instance of Matrix */
	public Matrix() {
	}
	
	public Matrix(double[][] a){
		
	}
	
	public int getWidth(){
		return elements.length;
	}
	
	public int getHeight(){
		return elements[0].length;
	}
	
	public double[] getRow(int i){
		return null;
	}
	
	public double[] getColumn(int j){
		return null;
	}
	
	public double getElement(int i, int j){
		return elements[i][j];
	}
	
	
	
}
