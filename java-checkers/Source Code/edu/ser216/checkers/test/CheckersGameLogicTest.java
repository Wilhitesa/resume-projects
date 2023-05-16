package edu.ser216.checkers.test;

import edu.ser216.checkers.core.CheckersGameLogic;
import edu.ser216.checkers.core.Checker;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Executable;
import java.util.Scanner;

class CheckersGameLogicTest {

  Scanner inputTest;
  CheckersGameLogic testGame;

  @BeforeEach
  void startup() {
    try {
      //IMPORTANT: Replace file path with current location of testInputs.txt
      inputTest = new Scanner(new File("/Users/samuelwilhite/IdeaProjects/Deliverable4/src/test/java/edu/ser216/checkers/test/testInputs"));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e + "\nFile location for the move testing text file was likely not replaced. Please change it to the current location of testInputs.txt.");
    }
    testGame = new CheckersGameLogic(inputTest);
  }

  @Test
  void getBoard() {
    char[][] correctBoard = new char[][]{
            {'_', 'o', '_', 'o', '_', 'o', '_', 'o'},
            {'o', '_', 'o', '_', 'o', '_', 'o', '_'},
            {'_', 'o', '_', 'o', '_', 'o', '_', 'o'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_', '_', '_', '_'},
            {'x', '_', 'x', '_', 'x', '_', 'x', '_'},
            {'_', 'x', '_', 'x', '_', 'x', '_', 'x'},
            {'x', '_', 'x', '_', 'x', '_', 'x', '_'}
    };
    assertArrayEquals(correctBoard, testGame.getBoard(), "Starting game board should be the same as variable correctBoard");
  }

  @Test
  void isTurnPlayerX() {
    assertTrue(testGame.isTurnPlayerX(), "Game should initialize with player X turn");
    testGame.nextTurn();
    assertFalse(testGame.isTurnPlayerX(), "Game should be able to recognize player O turn after nextTurn() was called");
  }

  @Test
  void getSquare() {
    char correctSquare = testGame.getBoard()[7][0];
    char foundSquare = testGame.getSquare(0, 0);
    assertEquals(correctSquare, foundSquare, "getSquare() should find the correct piece on the game board.");
  }

  @Test
  void setSquare() {
    Random random = new Random();
    //changes a square from x to _
    int randomRow = random.nextInt(0, 8);
    int randomCol = random.nextInt(0, 8);
    while(testGame.getSquare(randomRow, randomCol) != 'x') {
      randomRow = random.nextInt(0, 8);
      randomCol = random.nextInt(0, 8);
    }
    char oldSquare = testGame.getSquare(randomRow, randomCol);
    testGame.setSquare(randomRow, randomCol, '_');
    char newSquare = testGame.getSquare(randomRow, randomCol);
    assertEquals(newSquare, '_', "square must change from 'x' to '_'");
    assertNotEquals(oldSquare, newSquare, "ensures the old square does not resemble the new square");
    //changes a square from _ to x
    randomRow = random.nextInt(0, 8);
    randomCol = random.nextInt(0, 8);
    while(testGame.getSquare(randomRow, randomCol) != '_') {
      randomRow = random.nextInt(0, 8);
      randomCol = random.nextInt(0, 8);
    }
    oldSquare = testGame.getSquare(randomRow, randomCol);
    testGame.setSquare(randomRow, randomCol, 'x');
    newSquare = testGame.getSquare(randomRow, randomCol);
    assertEquals(newSquare, 'x', "square must change from '_' to 'x'");
    assertNotEquals(oldSquare, newSquare, "ensures the old square does not resemble the new square");
    //changes a square from o to _
    randomRow = random.nextInt(0, 8);
    randomCol = random.nextInt(0, 8);
    while(testGame.getSquare(randomRow, randomCol) != 'o') {
      randomRow = random.nextInt(0, 8);
      randomCol = random.nextInt(0, 8);
    }
    oldSquare = testGame.getSquare(randomRow, randomCol);
    testGame.setSquare(randomRow, randomCol, '_');
    newSquare = testGame.getSquare(randomRow, randomCol);
    assertEquals(newSquare, '_', "square must change from 'o' to '_'");
    assertNotEquals(oldSquare, newSquare, "ensures the old square does not resemble the new square");
    //changes a square from _ to o
    randomRow = random.nextInt(0, 8);
    randomCol = random.nextInt(0, 8);
    while(testGame.getSquare(randomRow, randomCol) != '_') {
      randomRow = random.nextInt(0, 8);
      randomCol = random.nextInt(0, 8);
    }
    oldSquare = testGame.getSquare(randomRow, randomCol);
    testGame.setSquare(randomRow, randomCol, 'o');
    newSquare = testGame.getSquare(randomRow, randomCol);
    assertEquals(newSquare, 'o', "square must change from '_' to 'o'");
    assertNotEquals(oldSquare, newSquare, "ensures the old square does not resemble the new square");
    //changes a square from o to x
    randomRow = random.nextInt(0, 8);
    randomCol = random.nextInt(0, 8);
    while(testGame.getSquare(randomRow, randomCol) != 'o') {
      randomRow = random.nextInt(0, 8);
      randomCol = random.nextInt(0, 8);
    }
    oldSquare = testGame.getSquare(randomRow, randomCol);
    testGame.setSquare(randomRow, randomCol, 'x');
    newSquare = testGame.getSquare(randomRow, randomCol);
    assertEquals(newSquare, 'x', "square must change from 'o' to '_'");
    assertNotEquals(oldSquare, newSquare, "ensures the old square does not resemble the new square");
    //changes a square from x to o
    randomRow = random.nextInt(0, 8);
    randomCol = random.nextInt(0, 8);
    while(testGame.getSquare(randomRow, randomCol) != 'x') {
      randomRow = random.nextInt(0, 8);
      randomCol = random.nextInt(0, 8);
    }
    oldSquare = testGame.getSquare(randomRow, randomCol);
    testGame.setSquare(randomRow, randomCol, 'o');
    newSquare = testGame.getSquare(randomRow, randomCol);
    assertEquals(newSquare, 'o', "square must change from '_' to 'o'");
    assertNotEquals(oldSquare, newSquare, "ensures the old square does not resemble the new square");
  }

  @Test
  void setProperSquare() {
  }

  @Test
  void getWinningPlayer() {
    assertEquals(testGame.getWinningPlayer(), '_', "game startup should not automatically have a winning player");
  }

  @Test
  void nextTurn() {
    boolean originalTurn = testGame.isTurnPlayerX();
    testGame.nextTurn();
    assertNotEquals(testGame.isTurnPlayerX(), originalTurn, "nextTurn() must change the player turn");
  }

  @Test
  void doTurn() {
    while(inputTest.hasNextLine()) {
      testGame.doTurn();
      testGame.nextTurn();
    }
  }

  @Test
  void makeTurn() {
    while(inputTest.hasNextLine()) {
      testGame.makeTurn(inputTest.nextLine());
      testGame.nextTurn();
    }
  }

  @Test
  void isValidMove() {
    while(inputTest.hasNextLine()) {
      String nextMove = inputTest.nextLine();
      assertTrue(testGame.isValidMove(nextMove), "Moves given from text file must be correct");
      testGame.makeTurn(nextMove);
      testGame.nextTurn();
    }
  }

  @Test
  void canMove() {
    testGame.nextTurn();
    for(Checker piece: testGame.getComputerPieces()) {
      testGame.canMove(piece);
    }
  }

  @Test
  void onEnd() {
    testGame.onEnd();
  }

  @Test
  void getComputerPieces() {
    for(Checker piece: testGame.getComputerPieces()) {
      assertNotNull(piece, "Computer piece should exist.");
    }
  }
}