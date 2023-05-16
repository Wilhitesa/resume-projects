package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

/**
 * The class that handles the frontend view of the checkerboard.
 *
 * @author samuelwilhite
 * @version 1.0
 */
public class CheckersTextConsole implements CheckersViewer {

  private final int vertLength;
  private final int horizLength;

  public CheckersTextConsole() {
    vertLength = 8;
    horizLength = 8;
  }

  /**
   * Returns string representation of the board in a CheckersGame. A 'o' will represent a piece
   * for player O, and an 'x' will represent a piece for player X. A '_' will represent an
   * unoccupied space. The axis will be labeled with numbers and letters as shown below, a
   * vertical bar will separate columns.
   *
   * <p>For example:
   * 8|_|o|_|o|_|o|_|o|
   * 7|o|_|o|_|o|_|o|_|
   * 6|_|o|_|o|_|o|_|o|
   * 5|_|_|_|_|_|_|_|_|
   * 4|_|_|_|_|_|_|_|_|
   * 3|x|_|x|_|x|_|x|_|
   * 2|_|x|_|x|_|x|_|x|
   * 1|x|_|x|_|x|_|x|_|
   * a b c d e f g h
   *
   * @param game Game to visualize.
   * @return String representation of board.
   */
  @Override
  public String printBoard(CheckersGame game) {
    String board = "";
    for (int i = vertLength - 1; i >= 0; i--) {
      board += (i + 1) + "|";
      for (int g = 0; g < horizLength; g++) {
        board += game.getSquare(i, g) + "|";
      }
      board += "\n";
    }
    board += "";
    for (int i = 1; i <= horizLength; i++) {
      board += (char) (i + 96) + " ";
    }
    return board;
  }
}