
public class Constant extends PolynomialPiece{

	private int constant;
	
	public Constant(int constant) {
		super(false);
		this.constant = constant;
	}
	
	public int getConstant() {
		return constant;
	}

	@Override
	public Constant getDerivative() {
		// TODO Auto-generated method stub
		return new Constant(0);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return constant + "";
	}

	@Override
	public int returnConstant() {
		// TODO Auto-generated method stub
		return constant;
	}

	@Override
	public int calculate(int g) {
		// TODO Auto-generated method stub
		return constant;
	}
}
