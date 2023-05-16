package edu.ser216.checkers.test;

import edu.ser216.checkers.core.CheckersComputerPlayer;
import edu.ser216.checkers.core.CheckersGameLogic;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CheckersComputerPlayerTest {

  CheckersComputerPlayer testComputer;
  CheckersGameLogic testGameLogic;
  String[] testPlayerMoves = {"3a-4b", "3c-4d", "3e-4f", "3g-4h", "4b-5a", "4d-5c", "4f-5e", "4h-5g"};

  @BeforeEach
  void setUp() {
    testGameLogic = new CheckersGameLogic();
    testComputer = new CheckersComputerPlayer(testGameLogic);
  }

  @RepeatedTest(5)
  @DisplayName("Generating moves based on player moves.")
  void generateMoveTest() {
    assertTrue(testGameLogic.isTurnPlayerX(), "Ensures game starts with player X's turn");
    assertEquals(testGameLogic.getWinningPlayer(), '_', "Game must start with no winning player");
    for(String move: testPlayerMoves) {
      if(testGameLogic.isValidMove(move)) {
        testGameLogic.makeTurn(move);
        testGameLogic.nextTurn();
        assertFalse(testGameLogic.isTurnPlayerX(), "Player must make a valid move then change turn");
        testComputer.generateMove();
        assertTrue(testGameLogic.isTurnPlayerX(), "Computer must make a valid move then change turn");
      }
    }
  }
}