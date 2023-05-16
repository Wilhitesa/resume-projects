package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGameLogic;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/** Creates a grid of buttons that act as checker squares.
 *  Squares are able to update according to the game.
 *
 */
public class PieceGrid extends GridPane {

  ArrayList<PieceButton> pieceButtons;
  CheckersGameLogic game;


  /** Creates a grid of pieces that are able to update.
   *
   * @param game The game the grid of pieces will reference from.
   * @param gui The gui the program will call game processing from.
   */
  public PieceGrid(CheckersGameLogic game, CheckersGUI gui) {
    super();
    setMinSize(100, 100);
    setPadding(new Insets(10, 10, 10, 10));
    setAlignment(Pos.CENTER);
    pieceButtons = new ArrayList<PieceButton>();
    this.game = game;
    //creates the event handler for all piece buttons.
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        PieceButton source = (PieceButton) e.getSource();
        //System.out.println(source.getPosition());
        gui.giveGUIPosition(source.getPosition());
      }
    };

    for (int i = 0; i < 8; i++) {
      for (int g = 0; g < 8; g++) {
        PieceButton newButton =
                new PieceButton(String.valueOf((char) ('8' - i)) + (char) ('a' + g), "-");
        pieceButtons.add(newButton);
        add(newButton, g, i);
        newButton.setOnAction(event);
      }
    }
    updateGrid();
  }

  /** Updates every label on the board to display current piece positions.
   *
   */
  public void updateGrid() {
    char[][] board = game.getBoard();
    for (int i = 0; i < 8; i++) {
      for (int g = 0; g < 8; g++) {
        pieceButtons.get((i * 8) + g).setText(String.valueOf(board[i][g]));
      }
    }
  }
}
