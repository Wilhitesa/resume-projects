package edu.ser216.checkers.core;

import java.util.Random;

/**
 * The class that handles a computer player for the checkers game.
 *
 * @author samuelwilhite
 * @version 1.0
 */
public class CheckersComputerPlayer {

  private final Random randomVar;
  private final CheckersGameLogic game;
  private Checker[] computerPieces;

  /**
   * Creates an object of the checkers computer player class.
   *
   * @param game the game the checkers computer player will access.
   */
  public CheckersComputerPlayer(CheckersGameLogic game) {
    this.game = game;
    randomVar = new Random();
    computerPieces = game.getComputerPieces();
  }

  /**
   * makes a move based on the location of its pieces on the board. Prioritizes piece jumping.
   */
  public void generateMove() {
    updatePieces();
    shuffle(computerPieces);
    boolean jumpedPiece = false;
    //jumper loop: make sure there are no pieces that can jump
    for (Checker piece : computerPieces) {
      if (game.canMove(piece)) {
        String piecePos = piece.toString();
        int currentRow = convertRow(piecePos.charAt(0));
        int currentCol = convertColumn(piecePos.charAt(1));
        if (game.isValidMove(piecePos + "-"
                + convertRow(currentRow + 2) + convertColumn(currentCol + 2))) {
          game.makeTurn(piecePos + "-" + convertRow(currentRow + 2)
                  + convertColumn(currentCol + 2));
          jumpedPiece = true;
          break;
        } else if (game.isValidMove(piecePos + "-"
                + convertRow(currentRow + 2) + convertColumn(currentCol - 2))) {
          game.makeTurn(piecePos + "-"
                  + convertRow(currentRow + 2) + convertColumn(currentCol - 2));
          jumpedPiece = true;
          break;
        }
      }
    }
    if (!jumpedPiece) {
      for (Checker piece : computerPieces) {
        if (game.canMove(piece)) {
          //implement checking for various moves and play them if possible
          String piecePos = piece.toString();
          int currentRow = convertRow(piecePos.charAt(0));
          int currentCol = convertColumn(piecePos.charAt(1));
          if (game.isValidMove(piecePos + "-"
                  + convertRow(currentRow + 1) + convertColumn(currentCol + 1))) {
            game.makeTurn(String.valueOf(convertRow(currentRow)) + convertColumn(currentCol)
                    + "-" + convertRow(currentRow + 1) + convertColumn(currentCol + 1));
          } else if (game.isValidMove(piecePos + "-"
                  + convertRow(currentRow + 1) + convertColumn(currentCol - 1))) {
            game.makeTurn(piecePos + "-"
                    + convertRow(currentRow + 1) + convertColumn(currentCol - 1));
          } else {
            throw new RuntimeException("Computer could find a possible move however not make it.");
          }

          break;
        }
      }
    }
    game.nextTurn();
  }

  /**
   * Internal shuffle method to shuffle the checker pieces given to the
   * move generator to guarantee moves are random.
   *
   * @param a The starting list of checker pieces.
   */
  private void shuffle(Checker[] a) {
    Checker[] newA = mergeShuffle(a, randomVar);
    System.arraycopy(newA, 0, a, 0, newA.length);
  }

  /**
   * Internal helper method for shuffling.
   * Breaks down the given piece of array recursively, then reassembles in a random order.
   *
   * @param a          The given piece of the array to shuffle
   * @param randomBool Ensures the random boolean is constantly used throughout the recursion.
   * @return The shuffled piece of the array given by param a.
   */
  private Checker[] mergeShuffle(Checker[] a, Random randomBool) {
    if (a.length <= 1) {
      return a;
    }

    Checker[] b = mergeShuffle(splitArray(a, 0, a.length / 2), randomBool);
    Checker[] c = mergeShuffle(splitArray(a, a.length / 2, a.length), randomBool);
    Checker[] d = shuffleMerge(b, c, randomBool);
    return d;
  }

  /**
   * Splits the array by the given low and high indexes.
   *
   * @param a    the given array to split
   * @param low  The lowest index included in the array.
   * @param high The index the new array will reach.
   * @return the shortened array.
   */
  private Checker[] splitArray(Checker[] a, int low, int high) {
    assert low < high;
    assert low >= 0;
    assert high <= a.length;

    Checker[] result = new Checker[high - low];
    int resultInc = 0;
    for (int i = low; i < high; i++) {
      result[resultInc] = a[i];
      resultInc++;
    }
    return result;
  }

  /**
   * Merges the two given arrays into a single array. Merging is determined randomly.
   *
   * @param a          The first array to be merged.
   * @param b          The second array to be merged.
   * @param randomBool The random boolean to randomly merge by.
   * @return The merged array.
   */
  private Checker[] shuffleMerge(Checker[] a, Checker[] b, Random randomBool) {
    Checker[] merged = new Checker[a.length + b.length];
    int incrA = 0;
    int incrB = 0;
    for (int i = 0; i < merged.length; i++) {
      if (incrA >= (a.length)) {
        merged[i] = b[incrB];
        incrB++;
      } else if (incrB >= (b.length)) {
        merged[i] = a[incrA];
        incrA++;
      } else if (randomBool.nextBoolean()) {
        merged[i] = b[incrB];
        incrB++;
      } else if (randomBool.nextBoolean()) {
        merged[i] = a[incrA];
        incrA++;
      } else {
        merged[i] = a[incrA];
        incrA++;
      }
    }
    return merged;
  }

  /**
   * Takes the latest entry of playable pieces in the game and stores it in the class.
   */
  private void updatePieces() {
    computerPieces = game.getComputerPieces();
  }

  /**
   * converts the column from its array column number to the board column coordinate.
   * Helper method imported from CheckersGameLogic.
   *
   * @param letter the board column coordinate.
   * @return the associating array column number.
   */
  private int convertColumn(char letter) {
    switch (letter) {
      case 'a':
        return 0;
      case 'b':
        return 1;
      case 'c':
        return 2;
      case 'd':
        return 3;
      case 'e':
        return 4;
      case 'f':
        return 5;
      case 'g':
        return 6;
      case 'h':
        return 7;
      default:
        return -1;
    }
  }

  /**
   * converts the column from its array column number to the board column coordinate.
   * Helper method imported from CheckersGameLogic.
   *
   * @param coord the array column number.
   * @return the associating board column coordinate.
   */
  private char convertColumn(int coord) {
    switch (coord) {
      case 0:
        return 'a';
      case 1:
        return 'b';
      case 2:
        return 'c';
      case 3:
        return 'd';
      case 4:
        return 'e';
      case 5:
        return 'f';
      case 6:
        return 'g';
      case 7:
        return 'h';
      default:
        return '_';
    }
  }

  /**
   * Converts the row from an array to a coordinate number as it would appear on the board.
   * Helper method imported from CheckersGameLogic.
   *
   * @param arrayRow the row number from the board array.
   * @return the associating coordinate number for the board, in character form.
   */
  private char convertRow(int arrayRow) {
    switch (arrayRow) {
      case 0:
        return '8';
      case 1:
        return '7';
      case 2:
        return '6';
      case 3:
        return '5';
      case 4:
        return '4';
      case 5:
        return '3';
      case 6:
        return '2';
      case 7:
        return '1';
      default:
        return '_';
    }
  }

  /**
   * Converts the coordinate number as it would appear on the board to an array row.
   * Helper method imported from CheckersGameLogic.
   *
   * @param boardCoordinate the coordinate number for the board, in character form.
   * @return the associating row number from the board array.
   */
  private int convertRow(char boardCoordinate) {
    switch (boardCoordinate) {
      case '1':
        return 7;
      case '2':
        return 6;
      case '3':
        return 5;
      case '4':
        return 4;
      case '5':
        return 3;
      case '6':
        return 2;
      case '7':
        return 1;
      case '8':
        return 0;
      default:
        return '_';
    }
  }

}
