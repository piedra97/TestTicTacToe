import Controller.BoardController;
import Model.Board;
import Model.Player;
import Model.Square;
import Model.Symbol;

public class Main {

    public static void main(String[] args) {
        Square[][] squares = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = new Square(Symbol.E);
                squares[i][j] = square;
            }

        }
        Player playerX = new Player(Symbol.X);
        Player playerO = new Player(Symbol.O);
        Player[] players = new Player[2];
        players[0] = playerX;
        players[1] = playerO;
        Board boardModel = new Board(squares);
        new BoardController(boardModel, players);
    }
}
