import Model.Board;
import Model.Square;
import Model.Symbol;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

    @Test
    public void returnTrueIfArrayOfSquaresIsFull() {
        //Arrange
        Board b1;
        Square[][] squares = new Square[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                squares[i][j] = mock(Square.class);
                when(squares[i][j].getSymbol()).thenReturn(Symbol.X);
            }
        }

        //when(b1.getSquares()).thenReturn(squares);

        //Act
        b1 = new Board(squares);
        boolean value = b1.isFull();

        //Asserts
        Assert.assertTrue(value);
    }

    @Test
    public void returnFalseIfArrayOfSquaresIsPartlyFull() {
        //Arrange
        Board b1;
        Square[][] squares = new Square[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                squares[i][j] = mock(Square.class);
            }
        }

        when(squares[1][2].getSymbol()).thenReturn(Symbol.E);

        //Act
        b1 = new Board(squares);
        boolean value = b1.isFull();

        //Asserts
        Assert.assertFalse(value);
    }

    @Test
    public void returnFalseIfArrayOfSquaresIsEmpty() {

        //Arrange
        Board b1;
        Square[][] squares = new Square[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                squares[i][j] = mock(Square.class);
                when(squares[i][j].getSymbol()).thenReturn(Symbol.E);
            }
        }

        //Act
        b1 = new Board(squares);
        boolean value = b1.isFull();

        //Asserts
        Assert.assertFalse(value);
    }


}
