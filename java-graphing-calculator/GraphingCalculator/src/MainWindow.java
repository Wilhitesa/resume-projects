/**
 * @author samuelwilhite
 * 
 * possible graph redraw idea:
 * - Make a jpanel and clear jpanel when new graph is created
 * -- figure out how the heck to clear a jpanel
 * -remember to put derivative label in bottom thingy
 * -it is 6:30am good freaking night
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener {
	
	private GraphPanel graph;
	private ParsedPolynomial polynomial;
	private JTextField graphField;
	private JLabel dLabel;
	
	public MainWindow() {
		super("Graph");
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		JPanel buttonPanel = new JPanel();
		graph = new GraphPanel();
		add(graph, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(2,3));
		add(buttonPanel, BorderLayout.SOUTH);
		JLabel graphLabel = new JLabel("Graph Equation: ");
		buttonPanel.add(graphLabel);
		graphField = new JTextField();
		buttonPanel.add(graphField);
		JButton graphButton = new JButton("Graph!");
		buttonPanel.add(graphButton);
		graphButton.addActionListener(this);
		dLabel = new JLabel("Derivative: ");
		buttonPanel.add(dLabel);
		
	}
	
	public static void main(String[] args) {
		MainWindow graph = new MainWindow();
		graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graph.setSize(500, 600);
		graph.setResizable(false);
		graph.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		graph.getGraphics().clearRect(0, 0, 1000, 1000);
		polynomial = new ParsedPolynomial(graphField.getText());
		graph.drawGrid();
		graph.graph(polynomial);
		graph.drawLine();
		System.out.println("Intended Polynomial: " + graphField.getText());
		dLabel.setText("Derivative: " + polynomial.derivativeToString());
	}
	
}
