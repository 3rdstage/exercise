
package thirdstage.math;

/**
 * This class is immutable.
 *
 * @author 3rdstage
 * @version 0.1, 2007-04-05, 3rdstage
 * @since 2007-04-5
 */
public class SquareMatrix extends Matrix {
	
	protected Double determinant = null;
	protected Double norm = null;
	
	/** Creates a new instance of SquareMatrix */
	public SquareMatrix() {
	}

	public SquareMatrix(double[][] a){
		this.elements = a;
		
		//@to-do
		this.determinant = new Double(0.0);
		this.norm = new Double(0.0);
	}

	public static SquareMatrix getIdentityMatrix(int dimension){
		
		double[][] a = new double[dimension][dimension];
		
		for(int i = 0; i < dimension; i++){
			for(int j = 0; j < dimension; j++){
				a[i][j] = (i == j) ? 1.0 : 0.0;
			}
		}
		
		return new SquareMatrix(a);
	}
	
	public double getDeterminant(){
		return this.determinant.doubleValue();
	}
	
	public double getNorm(){
		return this.norm.doubleValue();
	}
	
	public SquareMatrix getInverse(){
		//@to-do
		return null;
	}
	
}
