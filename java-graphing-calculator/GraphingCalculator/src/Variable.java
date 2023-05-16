public class Variable extends PolynomialPiece {

	private String variable;
	private int coeffecient;
	private int exponent;
	
	public Variable(String variable) {
		super(true);
		this.variable = variable;
		coeffecient = 1;
		exponent = 1;
	}
	
	public Variable(String variable, int coeffecient) {
		super(true);
		this.variable = variable;
		this.coeffecient = coeffecient;
		exponent = 1;
	}
	
	public Variable(String variable, int coeffecient, int exponent) {
		super(true);
		this.variable = variable;
		this.coeffecient = coeffecient;
		this.exponent = exponent;
	}
	
	public Variable getDerivative() {
		int newCoeffecient = coeffecient * exponent;
		int newExponent = exponent - 1;
		return(new Variable(variable, newCoeffecient, newExponent));
	}
	
	public int getExponent() {
		return exponent;
	}
	
	public int getCoeffecient() {
		return coeffecient;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public String toString() {
		return coeffecient + variable + "^" + exponent;
	}

	@Override
	public int returnConstant() {
		// TODO Auto-generated method stub
		return coeffecient;
	}
	
	public int calculate(int i) {
		int total = 0;
		total  = (int)Math.pow(i, exponent);
		total *= coeffecient;
		//System.out.println("input: " + i + ". variable: " + this.toString() + ". amount: " + total);
		return total;
	}
}
