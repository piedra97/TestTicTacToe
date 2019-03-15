package Model;

public class Square {
    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        if (this.symbol == Symbol.E)
            this.symbol = symbol;
    }
}
