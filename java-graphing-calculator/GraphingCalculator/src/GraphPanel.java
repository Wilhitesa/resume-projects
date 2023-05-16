import javax.swing.JPanel;
import java.awt.*;

public class GraphPanel extends JPanel {
	
		public void drawGrid() {
			for (int i = 20; i < 500; i+=20) {
				this.getGraphics().drawLine(0, i, 500, i);
				this.getGraphics().drawLine(i, 0, i, 500);
			}
		}
		
		public void drawLine(int i) {
			this.getGraphics().drawLine(0, 500 - (i * 20), 500, 500);
		}
		
		public void drawLine() {
			this.getGraphics().drawLine(0, 500 - (0 * 20), 500, 500);
		}
		
		public void graph(ParsedPolynomial polynomial) {
			Graphics graphics = this.getGraphics();
			graphics.setColor(Color.red);
			for (int i = 0; i < 25; i += 1) {
				System.out.println("polynomial calculated with " + i + ": " + polynomial.calculate(i));
				System.out.println("-----------");
				System.out.println("First X: " + (i * 20));
				System.out.println("First Y: " + (500 + (polynomial.calculate(i) * 20)));
				System.out.println("First X: " + ((i + 1) * 20));
				System.out.println("First Y: " + (500 + (polynomial.calculate(i + 1) * 20)));
				System.out.println("-----------");
				graphics.drawLine(i * 20, 500 - (polynomial.calculate(i) * 20), (i + 1) * 20, 500 - (polynomial.calculate(i + 1) * 20));
			}
			graphics.setColor(Color.blue);
			ParsedPolynomial newPolynomial = new ParsedPolynomial(polynomial.derivativeToString());
			System.out.println("new polynomial: " + newPolynomial.toString());
			for (int i = 0; i < 25; i += 1) {
				graphics.drawLine(i * 20, 500 - (newPolynomial.calculate(i) * 20), (i + 1) * 20, 500 - (newPolynomial.calculate(i + 1) * 20));
			}
		}
}
