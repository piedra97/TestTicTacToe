package Model;

public class Square {
    private Symbol symbol;

    public Square(Symbol symbol) {
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
