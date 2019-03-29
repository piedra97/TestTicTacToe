package Controller;

import Model.*;
import View.BoardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController implements ActionListener {
    private Board boardModel;
    private BoardView boardView;
    private int playerPos;
    private Player[] players;
    private int turn;

    public BoardController(Board boardModel, Player[] players){
        this.boardModel = boardModel;
        this.players = players;
        boardView = new BoardView();
        boardView.setTurn(players[0].getSymbol());
        this.setListeners();

    }

    private void setListeners() {
        Square[][] squares = this.boardModel.getSquares();
        for(int x = 0; x < squares.length; x++) {
            for(int y = 0; y < squares.length; y++) {
                String boardPosition = String.format("%d,%d", x, y);
                this.boardView.setButtonActionListener(boardPosition,this);
            }
        }
    }

    public void updateSquare(String[] chords){
        // TODO: implementar método en view
        this.boardView.setSquareSymbol(chords[0], chords[1], players[playerPos].getSymbol().toString());
        this.boardView.disableSquare(chords[0], chords[1]);
    }

    public void updateTurn(){
        // TODO: implementar método en view
        this.boardView.setTurn(players[playerPos].getSymbol());
    }

    public void nextTurn(){
        turn++;
        playerPos = turn % players.length;
        //players[playerPos];
    }



    public boolean isItAVictory(){
        int countRow0 = 0,countRow1 = 0, countRow2 = 0;
        int countColumn0 = 0,countColumn1 = 0, countColumn2 = 0;
        int countDiagonalR = 0,countDiagonalL = 0;
        Square[][] squares = this.boardModel.getSquares();
        for(int x = 0; x < squares.length; x++) {
            for(int y = 0; y < squares.length; y++) {
                if (squares[x][y].getSymbol() == players[playerPos].getSymbol()) {
                    if (x == y) {
                        countDiagonalR++;
                    }
                    if (x + y == squares.length - 1) {
                        countDiagonalL++;
                    }
                    if(x == 0) {
                        countRow0++;
                    }
                   if(x == 1) {
                        countRow1++;
                    }
                    if(x == 2) {
                        countRow2++;
                    }
                    if(y == 0) {
                        countColumn0++;
                    }
                    if(y == 1) {
                        countColumn1++;
                    }
                    if(y == 2) {
                        countColumn2++;
                    }
                }
            }
        }
        return (countRow0 == 3 || countRow1 == 3
                || countRow2 == 3 || countColumn0 == 3
                || countColumn1 == 3 || countColumn2 == 3
                || countDiagonalL == 3 || countDiagonalR == 3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String boardPosition = e.getActionCommand();
        String[] chords = boardPosition.split(",");

        Position position = new Position(Integer.parseInt(chords[0]), Integer.parseInt(chords[1]));
        this.boardModel.setSquareSymbol(position, players[playerPos].getSymbol());
        this.updateSquare(chords);
        if(this.boardModel.isFull()) {
            this.boardView.showDrawMessage();
            System.exit(0);
        }
        if(this.isItAVictory()) {
            this.boardView.showWinnerMessage();
            System.exit(0);
        }
        this.nextTurn();
        this.updateTurn();

    }
}
