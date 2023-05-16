package edu.ser216.checkers.ui;

import javafx.scene.control.Button;

/** The PieceButton class extends all abilities of a JavaFX button
 *  and adds functionality to store a position on initialization.
 *
 */
public class PieceButton extends Button {
  private final String position;

  public PieceButton(String position, String s) {
    super(s);
    this.position = position;
  }

  /** gives the position of the button relative to the game board's coordinates.
   *
   * @return the given checker position of the button.
   */
  public String getPosition() {
    return position;
  }
}
