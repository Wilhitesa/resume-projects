public abstract class PolynomialPiece {

	protected boolean isVariable;
	
	protected PolynomialPiece(boolean isVariable) {
		this.isVariable = isVariable;
	}
	
	/**
	 * finds the derivative and returns it 
	 * @return returns a derivative of the original variable in the form of its class
	 */
	public abstract PolynomialPiece getDerivative();
	
	/**
	 * @return returns the string form of the variable
	 */
	public abstract String toString();
	
	public abstract int returnConstant();
	
	public boolean isVariable() {
		return isVariable;
	}
	
	public abstract int calculate(int g);
}
