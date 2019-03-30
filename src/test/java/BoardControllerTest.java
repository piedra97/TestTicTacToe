import Controller.BoardController;
import Model.Board;
import Model.Player;
import Model.Square;
import Model.Symbol;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardControllerTest {
    @Test
    public void whenNextTurnIsCalledTurnIsChanged(){
        //Arrange
        Square[][] squares = new Square[3][3];
        Board board = mock(Board.class);
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                squares[i][j] = mock(Square.class);
                when(squares[i][j].getSymbol()).thenReturn(Symbol.X);
            }
        }

        when(board.getSquares()).thenReturn(squares);
        when(player1.getSymbol()).thenReturn(Symbol.X);
        when(player2.getSymbol()).thenReturn(Symbol.O);

        BoardController boardController = new BoardController(board, new Player[] {player1, player2});
        int turn = boardController.turn;

        //Act
        boardController.nextTurn();

        //Assert
        Assert.assertNotEquals(turn, boardController.turn);
    }

    @Test
    public void whenNextTurnIsCalledPlayerPosIsChanged(){
        //Arrange
        Square[][] squares = new Square[3][3];
        Board board = mock(Board.class);
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                squares[i][j] = mock(Square.class);
                when(squares[i][j].getSymbol()).thenReturn(Symbol.X);
            }
        }

        when(board.getSquares()).thenReturn(squares);
        when(player1.getSymbol()).thenReturn(Symbol.X);
        when(player2.getSymbol()).thenReturn(Symbol.O);

        BoardController boardController = new BoardController(board, new Player[] {player1, player2});
        int playerPos = boardController.playerPos;

        //Act
        boardController.nextTurn();

        //Assert
        Assert.assertNotEquals(playerPos, boardController.playerPos);
    }
}
