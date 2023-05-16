/**
 * @author samuelwilhite
 * created for MAT265 Honors Contract Project
 * 
 * Need to do:
 *  - Create an array for equation signs
 *  - figure out how to implement signs and polypiece arrays into one another
 *  - Place visual elements and listeners into MainWindow
 */

import java.util.ArrayList;
import java.util.Collections;

public class ParsedPolynomial {

	private String equation;
	private ArrayList exponents;
	private String[] splitExponents;
	//probably change exponent sign
	private final static String EXPONENT_SIGN = "\\^";
	//where PolynomialPiece vars and consts will go
	public PolynomialPiece[] polynomialParts;
	private String[] signs;
	
	public ParsedPolynomial(String polynomialToParse) {
		//split the equation by spacing
		equation = polynomialToParse;
		splitExponents = polynomialToParse.split(" ");
		for(String exponent : splitExponents) {
			System.out.println(exponent);
		}
		System.out.println("---------------------------");
		//create an array based off num of polynomial components
		int exponentLen = (int)Math.round(splitExponents.length / 2.0);
		System.out.println("num polynomial pieces: " + exponentLen);
		polynomialParts = new PolynomialPiece[exponentLen];
		int polyPartIndex = 0;
		System.out.println("---------------------------");
		//create variable or constant instances then input into array
		for(int i = 0; i < splitExponents.length; i += 2) {
			String variable = splitExponents[i];
			if(variable.contains("^")) {
				String firstPart = variable.substring(0, variable.indexOf("^"));
				String secondPart = variable.substring(variable.indexOf("^"));
				variable = firstPart + "\\" + secondPart;
			}
			String[] varPieces = variable.split(EXPONENT_SIGN);
			for(String str : varPieces) {
				System.out.println(str);
			}
			int coeffecient;
			int exponent;
			//if there is an exponent
			if(varPieces.length > 1) {
				if(varPieces[0].indexOf("x") > 0) {
					coeffecient = Integer.parseInt(varPieces[0].substring(0, varPieces[0].length() - 2));
					exponent = Integer.parseInt(varPieces[1]);
					polynomialParts[polyPartIndex] = new Variable("x", coeffecient, exponent);
				} else { //if there is no coeffecient
					exponent = Integer.parseInt(varPieces[1]);
					polynomialParts[polyPartIndex] = new Variable("x", 1, exponent);
				}
			} else if(varPieces[0].contains("x") && varPieces[0].length() > 2) { //if there is an x and a coefficient
				String[] fixer = varPieces[0].split("x");
				coeffecient = Integer.parseInt(fixer[0]);
				polynomialParts[polyPartIndex] = new Variable("x", coeffecient, 1);
			} else if(varPieces[0].contains("x")) { // else if there is only an x
				polynomialParts[polyPartIndex] = new Variable("x", 1, 1);
			}
			else { //else -- must be a coefficient
				coeffecient = Integer.parseInt(varPieces[0]);
				polynomialParts[polyPartIndex] = new Constant(coeffecient);
			}
			polyPartIndex++;
		}
		for(PolynomialPiece part : polynomialParts) {
			System.out.print(part.getDerivative().toString() + " ");
		}
		signs = new String[splitExponents.length - exponentLen];
		int signIndex = 0;
		for(int i = 1; i < splitExponents.length; i += 2) {
			signs[signIndex] = splitExponents[i];
			signIndex++;
		}
	}
	
	public String derivativeToString() {
		String finalString = "";
		int varIndex = 0;
		int sIndex = 0;
		for(int i = 0; i < splitExponents.length; i++) {
			if(i % 2 == 0) {
				finalString += polynomialParts[varIndex].getDerivative();
				varIndex++;
			} else {
				finalString += " " + signs[sIndex] + " ";
				sIndex++;
			}
		}
		return finalString;
	}
	
	
	/**
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String equationToParse = "3x" + EXPONENT_SIGN + "3 + x" + EXPONENT_SIGN + "2 + x + 3";
		ParsedPolynomial test = new ParsedPolynomial(equationToParse);
	}
	*/
	
	//useless code (may delete later)
	public int getHighestExponent() {
		return (int)exponents.get(exponents.size() - 1);
	}
	
	public int getConstant() {
		if(!polynomialParts[polynomialParts.length - 1].isVariable) {
			if(signs[signs.length - 1].equals(" + ")) {
				System.out.println("Constant: "+  polynomialParts[polynomialParts.length - 1].returnConstant());
				return(polynomialParts[polynomialParts.length - 1].returnConstant());
			} else {
				System.out.println("Constant: "+  polynomialParts[polynomialParts.length - 1].returnConstant());
				return(polynomialParts[polynomialParts.length - 1].returnConstant() * -1);
			}
			
		} else {
			return 0;
		}
		
		
	}
	
	public int calculate(int i) {
		int total = 0;
		for(int g = 0; g < polynomialParts.length; g++) {
			if(g != 0 && signs[g - 1].equals("-")) {
				//System.out.println(polynomialParts[g].calculate(g));
				total -= polynomialParts[g].calculate(i);
			} else {
				//System.out.println(polynomialParts[g].calculate(g));
				total += polynomialParts[g].calculate(i);
			}
		}
		//System.out.println("parsedPolynomial input: " + i + ". parsedPolynomial total: " + total);
		return total;
	}

	//don't worry about this
	protected String secretYoMamaCode() {
		return("yo mama");
	}
}
