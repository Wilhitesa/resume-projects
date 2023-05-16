package edu.ser216.checkers.core;

import java.util.Scanner;

/**
 * The class that handles the checkers game logic.
 *
 * @author samuelwilhite
 * @version 1.0
 */
public class CheckersGameLogic implements CheckersGame {
  private Scanner input;

  /**
   * returns the current state of the board.
   *
   * @return the current checkers board.
   */
  public char[][] getBoard() {
    return board;
  }

  private char[][] board;
  private Checker[] xpieces;
  private Checker[] opieces;

  public boolean isTurnPlayerX() {
    return isTurnPlayerX;
  }

  private boolean isTurnPlayerX;
  private boolean isFirstTurn;
  private boolean isTwoMoves;

  /**
   * Creates an object that handles the backend logic of the checkers game.
   *
   * @param scan serves as input for the backend.
   */
  public CheckersGameLogic(Scanner scan) {
    input = scan;
    board = new char[][]{
            {'_', 'o', '_', 'o', '_', 'o', '_', 'o'},
            {'o', '_', 'o', '_', 'o', '_', 'o', '_'},
            {'_', 'o', '_', 'o', '_', 'o', '_', 'o'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'x', '_', 'x', '_', 'x', '_', 'x', '_'},
            {'_', 'x', '_', 'x', '_', 'x', '_', 'x'},
            {'x', '_', 'x', '_', 'x', '_', 'x', '_'}
    };
    xpieces = new Checker[12];
    opieces = new Checker[12];
    int xincrement = 0;
    int oincrement = 0;
    for (int i = 0; i < board.length; i++) {
      for (int g = 0; g < board[0].length; g++) {
        if (board[i][g] == 'x') {
          char gletter;
          switch (g) {
            case 0:
              gletter = 'a';
              break;
            case 1:
              gletter = 'b';
              break;
            case 2:
              gletter = 'c';
              break;
            case 3:
              gletter = 'd';
              break;
            case 4:
              gletter = 'e';
              break;
            case 5:
              gletter = 'f';
              break;
            case 6:
              gletter = 'g';
              break;
            case 7:
              gletter = 'h';
              break;
            default:
              gletter = '?';
              break;
          }
          xpieces[xincrement] = new Checker((String.valueOf(8 - i)) + gletter, 'x');
          xincrement++;
        } else if (board[i][g] == 'o') {
          char gletter;
          switch (g) {
            case 0:
              gletter = 'a';
              break;
            case 1:
              gletter = 'b';
              break;
            case 2:
              gletter = 'c';
              break;
            case 3:
              gletter = 'd';
              break;
            case 4:
              gletter = 'e';
              break;
            case 5:
              gletter = 'f';
              break;
            case 6:
              gletter = 'g';
              break;
            case 7:
              gletter = 'h';
              break;
            default:
              gletter = '?';
              break;
          }
          opieces[oincrement] = new Checker((String.valueOf(8 - i)) + gletter, 'o');
          oincrement++;
        }
      }
    }
    isTurnPlayerX = true;
    isFirstTurn = true;
  }

  /** Generates a checkers game without the scanner.
   *
   */
  public CheckersGameLogic() {
    board = new char[][]{
            {'_', 'o', '_', 'o', '_', 'o', '_', 'o'},
            {'o', '_', 'o', '_', 'o', '_', 'o', '_'},
            {'_', 'o', '_', 'o', '_', 'o', '_', 'o'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'x', '_', 'x', '_', 'x', '_', 'x', '_'},
            {'_', 'x', '_', 'x', '_', 'x', '_', 'x'},
            {'x', '_', 'x', '_', 'x', '_', 'x', '_'}
    };
    xpieces = new Checker[12];
    opieces = new Checker[12];
    int xincrement = 0;
    int oincrement = 0;
    for (int i = 0; i < board.length; i++) {
      for (int g = 0; g < board[0].length; g++) {
        if (board[i][g] == 'x') {
          char gletter;
          switch (g) {
            case 0:
              gletter = 'a';
              break;
            case 1:
              gletter = 'b';
              break;
            case 2:
              gletter = 'c';
              break;
            case 3:
              gletter = 'd';
              break;
            case 4:
              gletter = 'e';
              break;
            case 5:
              gletter = 'f';
              break;
            case 6:
              gletter = 'g';
              break;
            case 7:
              gletter = 'h';
              break;
            default:
              gletter = '?';
              break;
          }
          xpieces[xincrement] = new Checker((String.valueOf(8 - i)) + gletter, 'x');
          xincrement++;
        } else if (board[i][g] == 'o') {
          char gletter;
          switch (g) {
            case 0:
              gletter = 'a';
              break;
            case 1:
              gletter = 'b';
              break;
            case 2:
              gletter = 'c';
              break;
            case 3:
              gletter = 'd';
              break;
            case 4:
              gletter = 'e';
              break;
            case 5:
              gletter = 'f';
              break;
            case 6:
              gletter = 'g';
              break;
            case 7:
              gletter = 'h';
              break;
            default:
              gletter = '?';
              break;
          }
          opieces[oincrement] = new Checker((String.valueOf(8 - i)) + gletter, 'o');
          oincrement++;
        }
      }
    }
    isTurnPlayerX = true;
    isFirstTurn = true;
  }

  /**
   * Returns the square at a specific location on the game board.
   *
   * <p>For example, given the following board:
   * 8|_|o|_|o|_|o|_|o|
   * 7|o|_|o|_|o|_|o|_|
   * 6|_|o|_|o|_|o|_|o|
   * 5|_|_|_|_|_|_|_|_|
   * 4|_|_|_|_|_|_|_|_|
   * 3|x|_|x|_|x|_|x|_|
   * 2|_|x|_|x|_|x|_|x|
   * 1|x|_|x|_|x|_|x|_|
   * a b c d e f g h
   * getSquare(0,0) would return 'x'.
   *
   * @param row    Row.
   * @param column Column.
   * @return Contents of game board at position.
   */
  @Override
  public char getSquare(int row, int column) {
    return board[7 - row][column];
  }

  /**
   * Sets the contents ('x', 'o', or '_') of the game board.
   *
   * @param row     Row.
   * @param column  Column.
   * @param content Contents.
   */
  @Override
  public void setSquare(int row, int column, char content) {
    int arrayColumn = column;
    int arrayRow = 7 - row;
    if (withinCoordinateBounds(arrayColumn) && withinCoordinateBounds(arrayRow)) {
      char boardColumn = convertColumn(arrayColumn);
      char boardRow = convertRow(arrayRow);
      String boardPos = String.valueOf(boardRow) + boardColumn;
      if (content == '_') { //if a piece is trying to be removed
        //check if the former space was an 'x' or 'o', then delete the corresponding piece.
        if (getProperSquare(arrayRow, arrayColumn) == 'x') {
          removePiece(boardPos, 'x');
          board[arrayRow][arrayColumn] = content;
        } else if (getProperSquare(arrayRow, arrayColumn) == 'o') {
          removePiece(boardPos, 'o');
          board[arrayRow][arrayColumn] = content;
        } else {
          board[arrayRow][arrayColumn] = content;
        }
      } else if (content == 'x') { //else if an x piece is trying to be added
        //check if the former space was an '_' or 'o'. if 'o', delete before adding.
        if (getProperSquare(arrayRow, arrayColumn) == '_') {
          addPiece(boardPos, 'x');
          board[arrayRow][arrayColumn] = content;
        } else if (getProperSquare(arrayRow, arrayColumn) == 'o') {
          removePiece(boardPos, 'o');
          addPiece(boardPos, 'x');
          board[arrayRow][arrayColumn] = content;
        } else {
          board[arrayRow][arrayColumn] = content;
        }
      } else if (content == 'o') { //else if an o piece is trying to be added
        //check if the former space was an '_' or 'x'. if 'x', delete before adding.
        if (getProperSquare(arrayRow, arrayColumn) == '_') {
          addPiece(boardPos, 'o');
          board[arrayRow][arrayColumn] = content;
        } else if (getProperSquare(arrayRow, arrayColumn) == 'x') {
          removePiece(boardPos, 'x');
          addPiece(boardPos, 'o');
          board[arrayRow][arrayColumn] = content;
        } else {
          board[arrayRow][arrayColumn] = content;
        }
      }
    }
  }

  /**
   * Alternative param function to add a piece.
   * adds a checker piece to its corresponding type array.
   *
   * @param piecePos position of the piece to be added.
   * @param type     the piece to be added to the array.
   */
  private void addPiece(String piecePos, char type) {
    Checker piece = new Checker(piecePos, type);
    addPiece(piece);
  }

  /**
   * adds a checker piece to its corresponding type array.
   *
   * @param piece the piece to be added to the piece array.
   */
  private void addPiece(Checker piece) {
    //determines array to use based on piece type
    int newLength;
    Checker[] oldpieces;
    if (piece.pieceType() == 'x') {
      newLength = xpieces.length + 1;
      oldpieces = xpieces;
    } else {
      newLength = opieces.length + 1;
      oldpieces = opieces;
    }
    Checker[] newpieces = new Checker[newLength];
    int incementer = 0;
    for (Checker oldpiece : oldpieces) {
      newpieces[incementer] = oldpiece;
      incementer++;
    }
    newpieces[incementer] = piece;
    if (piece.pieceType() == 'x') {
      xpieces = newpieces;
    } else {
      opieces = newpieces;
    }
  }

  private void removePiece(String piecePos, char type) {
    Checker piece = new Checker(piecePos, type);
    removePiece(piece);
  }

  private void removePiece(Checker piece) {
    //determines array to use based on piece type
    int newLength;
    Checker[] oldpieces;
    if (piece.pieceType() == 'x') {
      newLength = xpieces.length - 1;
      oldpieces = xpieces;
    } else {
      newLength = opieces.length - 1;
      oldpieces = opieces;
    }
    Checker[] newpieces = new Checker[newLength];
    int incementer = 0;
    for (Checker oldpiece : oldpieces) {
      if (!(oldpiece.getStringPos().equals(piece.getStringPos()))) {
        newpieces[incementer] = oldpiece;
        incementer++;
      }
    }
    if (piece.pieceType() == 'x') {
      xpieces = newpieces;
    } else {
      opieces = newpieces;
    }
  }

  /**
   * Returns the square at a specific location on the game board. Used internally.
   *
   * <p>For example, given the following board:
   * 8|_|o|_|o|_|o|_|o|
   * 7|o|_|o|_|o|_|o|_|
   * 6|_|o|_|o|_|o|_|o|
   * 5|_|_|_|_|_|_|_|_|
   * 4|_|_|_|_|_|_|_|_|
   * 3|x|_|x|_|x|_|x|_|
   * 2|_|x|_|x|_|x|_|x|
   * 1|x|_|x|_|x|_|x|_|
   * a b c d e f g h
   * getSquare(0,0) would return 'x'.
   *
   * @param row    Row.
   * @param column Column.
   * @return Contents of game board at position.
   */
  private char getProperSquare(int row, int column) {
    return board[row][column];
  }

  /**
   * Sets the contents ('x', 'o', or '_') of the game board. Used internally.
   *
   * @param row     Row.
   * @param column  Column.
   * @param content Contents.
   */
  public void setProperSquare(int row, int column, char content) {
    board[row][column] = content;
  }

  /**
   * Returns 'x' if player X  has won, 'o' if player O has won, and '_' otherwise. May be called
   * at any time.
   *
   * @return A character representing the winner.
   */
  @Override
  public char getWinningPlayer() {
    //check if any x pieces are still on the board
    int piecesAvailable = 0;
    for (Checker piece : xpieces) {
      if (piece.isEnabled() || !piece.getStringPos().equals("--")) {
        piecesAvailable++;
      }
    }
    if (piecesAvailable == 0) {
      return 'o';
    }

    piecesAvailable = 0;
    for (Checker piece : opieces) {
      if (piece.isEnabled() || !piece.getStringPos().equals("--")) {
        piecesAvailable++;
      }
    }
    if (piecesAvailable == 0) {
      return 'x';
    }

    piecesAvailable = 0;
    for (Checker piece : xpieces) {
      if (canMove(piece) && (piece.isEnabled() || !piece.getStringPos().equals("--"))) {
        piecesAvailable++;
      }
    }
    if (piecesAvailable == 0) {
      return 'o';
    }

    piecesAvailable = 0;
    for (Checker piece : opieces) {
      if (canMove(piece) && (piece.isEnabled() || !piece.getStringPos().equals("--"))) {
        piecesAvailable++;
      }
    }
    if (piecesAvailable == 0) {
      return 'x';
    }

    return '_';
  }

  /**
   * Indicates to the game that it is the next player's turn.
   */
  @Override
  public void nextTurn() {
    isTurnPlayerX = !isTurnPlayerX;
  }

  /**
   * Indicates to the game that a players turn should occur (i.e., read a move and act upon it).
   * To read input from the keyboard, this method must make use of the Scanner object passed
   * into the constructor of this CheckersGame. Valid inputs must look like "3a-4b".
   */
  @Override
  public void doTurn() {
    if (isFirstTurn) {
      System.out.print("Begin Game. ");
      isFirstTurn = false;
    }
    boolean moveValidated = false;
    while (!moveValidated) {
      stringTurn();
      String move = input.nextLine();
      if (isValidMove(move)) {
        makeTurn(move);
        moveValidated = true;
      }
    }
  }

  /**
   * Performs the turn and moves pieces accordingly.
   * Assumes move is valid.
   *
   * @param move the move to be made.
   */
  public void makeTurn(String move) {
    //System.out.println("Valid move!");
    String originalPos = move.substring(0, 2);
    String newPos = move.substring(3);
    Checker mover = findPiece(originalPos, isTurnPlayerX);
    char pieceChar = '_';
    if (isTurnPlayerX) {
      pieceChar = 'x';
    } else {
      pieceChar = 'o';
    }
    if (!isTwoMoves) {
      setProperSquare(convertRow(originalPos.charAt(0)),
              convertColumn(originalPos.charAt(1)), '_');
      mover.move(newPos);
      setProperSquare(convertRow(newPos.charAt(0)),
              convertColumn(newPos.charAt(1)), pieceChar);
    } else {
      //delete the piece's original position
      setProperSquare(convertRow(originalPos.charAt(0)),
              convertColumn(originalPos.charAt(1)), '_');
      //find the piece to be jumped over
      int enemyArrayColumn = (convertColumn(originalPos.charAt(1))
              + convertColumn(newPos.charAt(1))) / 2;
      int enemyArrayRow = (convertRow(originalPos.charAt(0))
              + convertRow(newPos.charAt(0))) / 2;
      char enemyColumn = convertColumn(enemyArrayColumn);
      char enemyRow = convertRow(enemyArrayRow);
      String enemyCoords = String.valueOf(enemyRow) + enemyColumn;
      Checker jumpedEnemy = findPiece(enemyCoords, !isTurnPlayerX);
      //jump the opposite piece, remove it, move the piece
      if (jumpedEnemy != null) {
        jumpedEnemy.jumped();
      }
      setProperSquare(enemyArrayRow, enemyArrayColumn, '_');
      mover.move(newPos);
      setProperSquare(convertRow(newPos.charAt(0)), convertColumn(newPos.charAt(1)), pieceChar);
    }
  }

  /**
   * Determines if the move given is a valid move to be taken, based on positioning.
   *
   * @param move the move to be checked, in "4a-5b" form.
   * @return If the move is valid.
   */
  public boolean isValidMove(String move) {
    boolean validMove = false;
    try {
      validMove = isValidInput(move);
    } catch (Exception e) {
      System.out.println("Invalid input.");
      return false;
    }
    if (validMove) {
      String originalPosition = move.substring(0, 2);
      String newPosition = move.substring(3);

      Checker pieceValidating = findPiece(originalPosition, isTurnPlayerX);

      //find the piece using the original position to prove it exists
      if (pieceValidating == null) {
        return false;
      }

      //ensures the piece is not moving more than 2 spaces, as it would not be a legal move
      if (Math.abs(convertRow(newPosition.charAt(0)) - convertRow(originalPosition.charAt(0))) > 2
              || Math.abs(convertColumn(newPosition.charAt(1))
              - convertColumn(originalPosition.charAt(1))) > 2) {
        return false;
      }

      return canMove(originalPosition, newPosition);
    }
    return false;
  }

  /**
   * Returns if the number is within bounds of the coordinate.
   *
   * @param number the number to be used
   * @return if the number given is within coordinate bounds, and is a valid number
   */
  private boolean withinCoordinateBounds(int number) {
    return number >= 0 && number <= 7;
  }

  /**
   * Determines if the piece has an available move that it could make.
   *
   * @param piece The piece whose possible moves will be checked.
   * @return Whether the given piece is able to be moved.
   */
  public boolean canMove(Checker piece) {
    int movements = 0;
    int currentArrayRow = convertRow(piece.getStringPos().charAt(0));
    int currentArrayColumn = convertColumn(piece.getStringPos().charAt(1));
    int nextArrayRow;
    int nextArrayColumn;
    if (piece.pieceType() == 'x') {
      if (currentArrayRow == 0) {
        return false;
      }
      nextArrayRow = currentArrayRow - 1;
      if (withinCoordinateBounds(nextArrayRow)) {
        nextArrayColumn = currentArrayColumn + 1;
        if (withinCoordinateBounds(nextArrayRow) && withinCoordinateBounds(nextArrayColumn)) {
          if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
            movements++;
          } else if (getProperSquare(nextArrayRow, nextArrayColumn) == 'o') {
            nextArrayRow--;
            nextArrayColumn++;
            if (withinCoordinateBounds(nextArrayRow) && withinCoordinateBounds(nextArrayColumn)) {
              if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
                movements++;
              }
            }
          }
        }
        nextArrayRow = currentArrayRow - 1;
        nextArrayColumn = currentArrayColumn - 1;
        if (withinCoordinateBounds(nextArrayRow) && withinCoordinateBounds(nextArrayColumn)) {
          if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
            movements++;
          } else if (getProperSquare(nextArrayRow, nextArrayColumn) == 'o') {
            nextArrayRow--;
            nextArrayColumn--;
            if (withinCoordinateBounds(nextArrayRow) && withinCoordinateBounds(nextArrayColumn)) {
              if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
                movements++;
              }
            }
          }
        }
      }
    } else {
      if (currentArrayRow == 7) {
        return false;
      }
      nextArrayRow = currentArrayRow + 1;
      if (withinCoordinateBounds(nextArrayRow)) {
        nextArrayColumn = currentArrayColumn + 1;
        if (withinCoordinateBounds(nextArrayColumn)) {
          if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
            movements++;
          } else if (getProperSquare(nextArrayRow, nextArrayColumn) == 'x') {
            nextArrayRow++;
            nextArrayColumn++;
            if (withinCoordinateBounds(nextArrayRow) && withinCoordinateBounds(nextArrayColumn)) {
              if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
                movements++;
              }
            }
          }
        }
        nextArrayRow = currentArrayRow + 1;
        nextArrayColumn = currentArrayColumn - 1;
        if (withinCoordinateBounds(nextArrayColumn)) {
          if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
            movements++;
          } else if (getProperSquare(nextArrayRow, nextArrayColumn) == 'x') {
            nextArrayRow++;
            nextArrayColumn--;
            if (withinCoordinateBounds(nextArrayRow) && withinCoordinateBounds(nextArrayColumn)) {
              if (getProperSquare(nextArrayRow, nextArrayColumn) == '_') {
                movements++;
              }
            }
          }
        }
      }
    }
    return movements > 0;
  }

  /**
   * Determines if the piece is able to move to the destination.
   *
   * @param move the movement string inputted by the player.
   * @return whether the piece can move to the specified destination.
   */
  private boolean canMove(String move) {
    String originalPosition = move.substring(0, 2);
    String newPosition = move.substring(3);
    return canMove(originalPosition, newPosition);
  }

  /**
   * Determines if the piece is able to move to the destination.
   *
   * @param startingPosition the piece's starting position.
   * @param endingPosition   the piece's destination.
   * @return if the piece is able to move to the destination.
   */
  private boolean canMove(String startingPosition, String endingPosition) {
    //checking if the destination space is empty
    if (getProperSquare(convertRow(endingPosition.charAt(0)),
            convertColumn(endingPosition.charAt(1))) != '_') {
      return false;
    }
    //checking whose turn it is
    if (isTurnPlayerX) {
      //return true if only one diagonal move
      if (Math.abs(convertColumn(endingPosition.charAt(1))
              - convertColumn(startingPosition.charAt(1))) == 1
              && convertRow(endingPosition.charAt(0))
              - convertRow(startingPosition.charAt(0)) == -1) {
        isTwoMoves = false;
        return true;
        //if the piece moves 2 spaces, continue checking
      } else if (Math.abs(convertColumn(endingPosition.charAt(1))
              - convertColumn(startingPosition.charAt(1))) == 2
              && convertRow(endingPosition.charAt(0))
              - convertRow(startingPosition.charAt(0)) == -2) {
        //if the piece in between is not an enemy piece, return false
        int intermediateRow = (convertRow(startingPosition.charAt(0))
                + convertRow(endingPosition.charAt(0))) / 2;
        int intermediateCol = (convertColumn(startingPosition.charAt(1))
                + convertColumn(endingPosition.charAt(1))) / 2;
        if (getProperSquare(intermediateRow, intermediateCol) != 'o') {
          return false;
        }
        isTwoMoves = true;
        return true;
      }
    } else {
      //return true if only one diagonal move
      if (Math.abs(convertColumn(endingPosition.charAt(1))
              - convertColumn(startingPosition.charAt(1))) == 1
              && convertRow(endingPosition.charAt(0))
              - convertRow(startingPosition.charAt(0)) == 1) {
        isTwoMoves = false;
        return true;
      } else if (Math.abs(convertColumn(endingPosition.charAt(1))
              - convertColumn(startingPosition.charAt(1))) == 2
              && convertRow(endingPosition.charAt(0))
              - convertRow(startingPosition.charAt(0)) == 2) {
        int intermediateRow = (convertRow(startingPosition.charAt(0))
                + convertRow(endingPosition.charAt(0))) / 2;
        int intermediateCol = (convertColumn(startingPosition.charAt(1))
                + convertColumn(endingPosition.charAt(1))) / 2;
        if (getProperSquare(intermediateRow, intermediateCol) != 'x') {
          return false;
        }
        isTwoMoves = true;
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if the input given by the player is valid to be read.
   *
   * @param move the input given by the player, typically in "3a-4b" format
   * @return if the given input is within board bounds
   */
  private boolean isValidInput(String move) throws Exception {
    boolean lengthValid = move.length() == 5;
    //making sure the length is 5
    if (lengthValid) {
      boolean originalRowValid = convertRow(move.charAt(0)) >= 0 && convertRow(move.charAt(0)) <= 7;
      boolean originalColumnValid = convertColumn(move.charAt(1)) >= 0
              && convertColumn(move.charAt(1)) <= 7;
      boolean hasDash = move.charAt(2) == '-';
      boolean newRowValid = convertRow(move.charAt(3)) >= 0 && convertRow(move.charAt(3)) <= 7;
      boolean newColumnValid = convertColumn(move.charAt(4)) >= 0
              && convertColumn(move.charAt(4)) <= 7;
      //returns if the
      return (originalRowValid && originalColumnValid && hasDash
              && newRowValid && newColumnValid);
    }
    throw new Exception("Invalid input.");
  }

  /**
   * Finds the piece expected at the given position and returns it.
   *
   * @param checkerPos expected position of the checker piece.
   * @param isPieceX   whether the piece is an x or o piece.
   * @return the piece that is found in that position. Returns null if no piece was found.
   */
  private Checker findPiece(String checkerPos, boolean isPieceX) {
    Checker checkerFound = null;
    //ensures the input given is a valid input
    if (checkerPos.length() != 2) {
      return null;
    }
    if (isPieceX) {
      for (Checker piece : xpieces) {
        if (piece.getStringPos().equals(checkerPos)) {
          checkerFound = piece;
        }
      }
    } else {
      for (Checker piece : opieces) {
        if (piece.getStringPos().equals(checkerPos)) {
          checkerFound = piece;
        }
      }
    }
    return checkerFound;
  }

  /**
   * converts the column from its array column number to the board column coordinate.
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

  /**
   * Handles the system output explaining whose turn it is.
   */
  private void stringTurn() {
    if (isTurnPlayerX) {
      System.out.println("Player X - your turn.");
    } else {
      System.out.println("Player O - your turn.");
    }
    System.out.println("Choose a cell position of piece to be"
            + " moved and the new position. e.g., 3a-4b");
  }

  /**
   * Indicates to the game that it is over. Used to do things like display the winner.
   */
  @Override
  public void onEnd() {
    char winner = this.getWinningPlayer();
    winner = (char) (winner - 32);
    System.out.println("Player " + winner + " Won the Game");
  }

  public Checker[] getComputerPieces() {
    return opieces;
  }
}