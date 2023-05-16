package edu.ser216.calculator.calculatorproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

  private TextField textField;
  private GridPane buttonGrid;
  private Button[] calcButtons;
  private int result = 0;
  private String previousOperator = " ";
  private String inputString = "0";
  boolean numberStored = false;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    //Initializing all JavaFX nodes
    buttonGrid = new GridPane();
    buttonGrid.setAlignment(Pos.CENTER);
    buttonGrid.setPadding(new Insets(15, 5, 5, 5));
    BorderPane mainPane = new BorderPane();
    textField = new TextField();
    textField.setEditable(false);
    calcButtons = new Button[16];
    //textField.setPadding(new Insets(30, 30, 30, 30));

    String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "C", "0", "=", "/",
    };

    for (int i = 0; i < 16; i++) {
      calcButtons[i] = createAndSetButton(buttonLabels[i], i % 4, i / 4);
    }


    //Placing nodes
    Scene mainScene = new Scene(mainPane);
    stage.setScene(mainScene);
    stage.setTitle("Calculator");
    mainPane.setCenter(buttonGrid);
    mainPane.setTop(textField);

    stage.show();
  }

  private Button createAndSetButton(String label, int x, int y) {
    Button newButton = new Button(label);
    buttonGrid.add(newButton, x, y);
    newButton.setOnAction(new CalculatorButtonsHandler());
    //newButton.setPadding(new Insets(5, 5, 5, 5));
    return newButton;
  }

  private void compute(String input) {
    int inputNum;
    boolean hasNumber = false;
    try {
      inputNum = Integer.parseInt(input);
      //System.out.println("Is a number.");
      if(numberStored) {
        textField.setText(input);
        numberStored = false;
      } else if (textField.getText().equals("0")) {
        textField.setText(input);
      } else if (textField.getText().equals("ERR")) {

      } else {
        textField.setText(textField.getText() + input);
      }
    } catch (NumberFormatException e) {
      try {
        //System.out.println("Not a number.");
        if (input.equals("=")) {
          if (previousOperator.equals("+")) {
            result += Integer.parseInt(textField.getText());
          } else if (previousOperator.equals("-")) {
            result -= Integer.parseInt(textField.getText());
          } else if (previousOperator.equals("x")) {
            result *= Integer.parseInt(textField.getText());
          } else if (previousOperator.equals("/")) {
            result /= Integer.parseInt(textField.getText());
          } else {
            result = Integer.parseInt(textField.getText());
          }
          textField.setText(String.valueOf(result));
          numberStored = true;
          previousOperator = " ";
        } else if (input.equals("C")) {
          result = 0;
          inputString = "0";
          previousOperator = " ";
          textField.setText("0");
          numberStored = false;
        } else {
          if (previousOperator.equals("+")) {
            result += Integer.parseInt(textField.getText());
          } else if (previousOperator.equals("-")) {
            result -= Integer.parseInt(textField.getText());
          } else if (previousOperator.equals("x")) {
            result *= Integer.parseInt(textField.getText());
          } else if (previousOperator.equals("/")) {
            result /= Integer.parseInt(textField.getText());
          } else {
            result = Integer.parseInt(textField.getText());
          }
          previousOperator = input;
          numberStored = true;
        }
      } catch (ArithmeticException error) {
        textField.setText("ERR");
      } catch (NumberFormatException numberFormatException) {

      }
    } catch (ArithmeticException arithmeticException) {
      textField.setText("UNKNOWN ERR");
    }
  }

  class CalculatorButtonsHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
      Button buttonClicked = (Button) actionEvent.getSource();
      compute(buttonClicked.getText());
    }
  }
}
