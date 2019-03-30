package Model;

public class Square {
    private Symbol symbol;

    public Square(Symbol symbol) {
        if (symbol != Symbol.E) throw new IllegalArgumentException("The symbol cannot be different than E in the constructor");
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        if (this.symbol == Symbol.E && symbol != Symbol.E)
            this.symbol = symbol;
    }
}
