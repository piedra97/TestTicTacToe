import Model.Square;
import Model.Symbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {
    @Test
    public void havingSquareWithSymbolXThrowsAnIllegalArgumentException(){
        //Arrange
            Symbol symbol = Symbol.X;
            try {
                //Act
                Square square = new Square(symbol);
                //Assertion
                Assertions.fail("Symbol X doesn't throw a exception.");
            }catch(IllegalArgumentException ignored) {}
    }

    @Test
    public void havingSquareWithSymbolOThrowsAnIllegalArgumentException(){
        //Arrange
        Symbol symbol = Symbol.O;
        try {
            //Act
            Square square = new Square(symbol);
            //Assertion
            Assertions.fail("Symbol O doesn't throw a exception.");
        }catch(IllegalArgumentException ignored) {}
    }

    @Test
    public void ifSymbolInSetSymbolIsXThenTheSquareSymbolIsX(){
        //Arrange
        Square sq1 = new Square(Symbol.E);
        //Act
        sq1.setSymbol(Symbol.X);
        //Assertion
        Assertions.assertEquals(sq1.getSymbol(), Symbol.X);
    }

    @Test
    public void ifSymbolInSetSymbolIsOThenTheSquareSymbolIsX(){
        //Arrange
        Square sq1 = new Square(Symbol.E);
        //Act
        sq1.setSymbol(Symbol.O);
        //Assertion
        Assertions.assertEquals(sq1.getSymbol(), Symbol.O);
    }

}

