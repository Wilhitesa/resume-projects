package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersComputerPlayer;
import edu.ser216.checkers.core.CheckersGameLogic;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The class for the Checkers game UI.
 *
 * @author samuelwilhite
 * @version 1.0
 */
public class CheckersGUI extends Application {

  static CheckersGameLogic gameLogic = new CheckersGameLogic();
  static PieceGrid boardGrid;
  static boolean hasOne = false;
  static String firstCoord = "";
  static String secondCoord = "";
  static CheckersComputerPlayer guiComputer = new CheckersComputerPlayer(gameLogic);
  private static boolean hasComputerPlayer = false;
  private static boolean alreadyLabeled = true;
  static Label statusLabel;

  /**
   * Simplified function call to create a JavaFX window.
   *
   * @param args        args to be taken from main.
   * @param hasComputer indicates whether the player requests a computer opponent.
   */
  public static void go(String[] args, boolean hasComputer) {
    hasComputerPlayer = hasComputer;
    launch(args);
  }


  /**
   * The starting function for the JavaFX gui to be built.
   *
   * @param stage The window to place all JavaFX components on.
   */
  @Override
  public void start(Stage stage) {
    GridPane mainGrid = new GridPane();
    mainGrid.setAlignment(Pos.CENTER);
    statusLabel = new Label("Player X, start game.");
    statusLabel.setAlignment(Pos.CENTER);
    GridPane numberGrid = new GridPane();
    numberGrid.setAlignment(Pos.CENTER);
    for (int i = 0; i < 8; i++) {
      numberGrid.add(new Label((8 - i) + "\n"), 0, i);
    }
    GridPane letterGrid = new GridPane();
    letterGrid.setAlignment(Pos.CENTER);
    for (int i = 0; i < 8; i++) {
      letterGrid.add(new Label((char) (i + 'a') + "    "), i, 0);
    }
    boardGrid = new PieceGrid(gameLogic, this);
    mainGrid.add(statusLabel, 1, 0);
    mainGrid.add(boardGrid, 1, 1);
    mainGrid.add(numberGrid, 0, 1);
    mainGrid.add(letterGrid, 1, 2);
    Scene mainScene = new Scene(mainGrid);
    stage.setScene(mainScene);
    stage.setTitle("Checkers");
    stage.show();
  }

  /** Inputs a position on the checkerboard and handles it as a move in the game.
   *
   * @param position a position on the checkerboard, such as "4a" or "3b"
   */
  public void giveGUIPosition(String position) {
    //TODO: move win functionality to the bottom, create and manage a label for the current position
    if (gameLogic.getWinningPlayer() == '_') {
      if (!hasOne) {
        firstCoord = position;
        hasOne = true;
        statusLabel.setText(statusLabel.getText() + "    (" + position + "- )");
      } else {
        secondCoord = position;
        String move = firstCoord + "-" + secondCoord;
        if (gameLogic.isValidMove(move)) {
          gameLogic.makeTurn(move);
          if (!hasComputerPlayer) {
            gameLogic.nextTurn();
          } else {
            gameLogic.nextTurn();
            guiComputer.generateMove();
          }
          alreadyLabeled = false;
        } else {
          if (gameLogic.isTurnPlayerX()) {
            statusLabel.setText("Player X, try again.");
          } else {
            statusLabel.setText("Player O, try again.");
          }
        }
        boardGrid.updateGrid();
        hasOne = false;
      }
      if (gameLogic.isTurnPlayerX() && !alreadyLabeled) {
        statusLabel.setText("Player X, your turn.");
        alreadyLabeled = true;
      } else if (!gameLogic.isTurnPlayerX() && !alreadyLabeled) {
        statusLabel.setText("Player O, your turn.");
        alreadyLabeled = true;
      }
    }
    winCheck();
  }

  private void winCheck() {
    if (gameLogic.getWinningPlayer() == 'x') {
      statusLabel.setText("Player X has won the game!");
    } else if (gameLogic.getWinningPlayer() == 'o') {
      statusLabel.setText("Player O has won the game!");
    } else if (gameLogic.getWinningPlayer() != '_') {
      statusLabel.setText("Game was a tie!");
    }
  }

}
