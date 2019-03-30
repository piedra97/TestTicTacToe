import Model.Square;
import Model.Symbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {
    @Test
    public void whenClassSquareSymbolXIsCreatedCantSet(){
        //Arrange
            Square sq1 = new Square(Symbol.X);
        //Act
            sq1.setSymbol(Symbol.O);
        //Assertion
            Assertions.assertEquals(sq1.getSymbol(), Symbol.X);
    }

    @Test
    public void whenClassSquareSymbolOIsCreatedCantSet(){
        //Arrange
        Square sq1 = new Square(Symbol.O);
        //Act
        sq1.setSymbol(Symbol.X);
        //Assertion
        Assertions.assertEquals(sq1.getSymbol(), Symbol.O);
    }

    @Test
    public void whenClassSquareSymbolEIsCreatedCanSet(){
        //Arrange
        Square sq1 = new Square(Symbol.E);
        //Act
        sq1.setSymbol(Symbol.X);
        //Assertion
        Assertions.assertEquals(sq1.getSymbol(), Symbol.X);
    }
}

