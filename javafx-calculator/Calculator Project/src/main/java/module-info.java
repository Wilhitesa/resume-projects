module edu.ser216.calculator.calculatorproject {
  requires javafx.controls;
  requires javafx.fxml;


  opens edu.ser216.calculator.calculatorproject to javafx.fxml;
  exports edu.ser216.calculator.calculatorproject;
}