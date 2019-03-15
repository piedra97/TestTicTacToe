package Model;

public class Board {

    private Square[][] squares;

    public Board (Square[][] squares){
        this.squares = squares;
    }

    public Square getSquare(Position position){
        return squares[position.getX()][position.getY()];
    }

    public void setSquareSymbol(Position position, Symbol symbol){
        squares[position.getX()][position.getY()].setSymbol(symbol);
    }

    public boolean isFull(){

        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                if (squares[x][y].getSymbol() == Symbol.E){
                    return false;
                }
            }
        }
        return true;
    }
}
