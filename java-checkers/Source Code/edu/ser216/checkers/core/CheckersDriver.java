package edu.ser216.checkers.core;

import edu.ser216.checkers.ui.CheckersGUI;
import edu.ser216.checkers.ui.CheckersTextConsole;
import edu.ser216.checkers.ui.CheckersViewer;
import java.util.Scanner;

/**
 * This class provides the entry to run the checkers game. It also provides the main game play loop
 * that calls methods from the two user-created classes (CheckersGameLogic and CheckersTextConsole).
 * <p>
 * The contents of this file should not be changed.
 *
 * @author Wilhite, Acuna, Baron
 * @version 2.0
 */
public class CheckersDriver {
  public static void main(String[] args) {
    //initialize game components, computer player
    Scanner scan = new Scanner(System.in);
    CheckersGame game = new CheckersGameLogic(scan);
    CheckersViewer console = new CheckersTextConsole();
    CheckersComputerPlayer checkersComputerPlayer = new CheckersComputerPlayer((CheckersGameLogic) game);

    //determine if the player wants to play with a computer
    boolean modeChosen = false;
    boolean computerChosen = false;
    while (!modeChosen) {
      System.out.println("Begin Game. Enter ‘P’ if you want to play against another player; enter ‘C’ to play against computer.");
      String choice = scan.nextLine();
      if (choice.equalsIgnoreCase("P")) {
        modeChosen = true;
        computerChosen = false;
      } else if (choice.equalsIgnoreCase("C")) {
        modeChosen = true;
        computerChosen = true;
        System.out.println("Start game against computer. You are Player X and Computer is Player O.");
      }
    }

    //determine if the player wants to play with the GUI.
    modeChosen = false;
    boolean GUIChosen = false;
    while (!modeChosen) {
      System.out.println("Would you like to play with the GUI? (Y/N)");
      String choice = scan.nextLine();
      if (choice.equalsIgnoreCase("Y")) {
        modeChosen = true;
        CheckersGUI.go(args, computerChosen);
      } else if (choice.equalsIgnoreCase("N")) {
        while (game.getWinningPlayer() == '_') {
          System.out.println(console.printBoard(game));
          game.doTurn();
          game.nextTurn();
          if (computerChosen) {
            try {
              checkersComputerPlayer.generateMove();
            } catch (RuntimeException e) {
              System.out.println("Computer was unable to find a move.");
            }
          }
        }
        game.onEnd();
      }
    }
  }
}
