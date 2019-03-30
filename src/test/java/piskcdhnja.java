
import Model.Player;
import Model.Square;
import Model.Symbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class piskcdhnja {
    @Test
    public void testCommutativeProperty() {
        Square sq1 = new Square(Symbol.E);

        Symbol symbol = sq1.getSymbol();

        Assertions.assertEquals(symbol, Symbol.E);
    }

}
