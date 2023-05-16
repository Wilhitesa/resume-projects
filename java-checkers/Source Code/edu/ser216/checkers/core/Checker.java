package edu.ser216.checkers.core;

public class Checker {
  private String position; //full coordinate set
  private char positionX; //The letter coordinate
  private char positionY; //The number coordinate
  private int column; //proper column number for the piece
  private int row; //the proper row number for the piece
  private boolean enabled;
  private final char type;


  /**
   * Creates an object of class Checker.
   *
   * @param position the starting position of the checker piece.
   * @param type     whether the checker is an x or o.
   */
  public Checker(String position, char type) {
    this.position = position;
    positionX = this.position.charAt(1);
    switch (positionX) {
      case 'a':
        column = 0;
        break;
      case 'b':
        column = 1;
        break;
      case 'c':
        column = 2;
        break;
      case 'd':
        column = 3;
        break;
      case 'e':
        column = 4;
        break;
      case 'f':
        column = 5;
        break;
      case 'g':
        column = 6;
        break;
      case 'h':
        column = 7;
        break;
      default:
        column = -1;
        break;
    }
    positionY = this.position.charAt(0);
    switch (positionY) {
      case '1':
        row = 7;
        break;
      case '2':
        row = 6;
        break;
      case '3':
        row = 5;
        break;
      case '4':
        row = 4;
        break;
      case '5':
        row = 3;
        break;
      case '6':
        row = 2;
        break;
      case '7':
        row = 1;
        break;
      case '8':
        row = 0;
        break;
      default:
        column = -1;
        break;
    }
    enabled = true;
    this.type = type;
  }

  /**
   * Stores the new position of the piece.
   *
   * @param nextSpace the next position the piece will be in.
   */
  public void move(String nextSpace) {
    this.position = nextSpace;
    positionX = this.position.charAt(1);
    switch (positionX) {
      case 'a':
        row = 0;
        break;
      case 'b':
        row = 1;
        break;
      case 'c':
        row = 2;
        break;
      case 'd':
        row = 3;
        break;
      case 'e':
        row = 4;
        break;
      case 'f':
        row = 5;
        break;
      case 'g':
        row = 6;
        break;
      case 'h':
        row = 7;
        break;
      default:
        column = -1;
        break;
    }
    positionY = this.position.charAt(0);
    switch (positionY) {
      case '1':
        row = 7;
        break;
      case '2':
        row = 6;
        break;
      case '3':
        row = 5;
        break;
      case '4':
        row = 4;
        break;
      case '5':
        row = 3;
        break;
      case '6':
        row = 2;
        break;
      case '7':
        row = 1;
        break;
      case '8':
        row = 0;
        break;
      default:
        column = -1;
        break;
    }
  }

  /**
   * Indicates that the piece was jumped and disables it.
   */
  public void jumped() {
    enabled = false;
    position = "--";
  }

  /**
   * Returns the position of this piece.
   *
   * @return the coordinate position of the piece in relation to the board.
   */
  public String getStringPos() {
    return position;
  }

  /**
   * Returns the type of the Checker piece, whether is is an x or o.
   *
   * @return the type of checker piece
   */
  public char pieceType() {
    return type;
  }

  /**
   * returns the proper column value as it would be displayed in an array.
   *
   * @return the column value
   */
  public int getColumn() {
    return column;
  }

  /**
   * returns the proper row value as it would be displayed in an array.
   *
   * @return the row value
   */
  public int getRow() {
    return row;
  }

  /**
   * returns whether the piece is still on the board, or 'enabled'.
   *
   * @return if the piece is on the board.
   */
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public String toString() {
    return position;
  }
}
