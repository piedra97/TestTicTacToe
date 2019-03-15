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

    public void updateSquare(){
        // TODO: implementar método en view
        //this.boardView.setSquareSymbol(players[playerPos].getSymbol());
    }

    public void updateTurn(){
        // TODO: implementar método en view
        //this.boardView.setTurn(players[playerPos].getSymbol());
    }

    public void nextTurn(){
        turn++;
        playerPos = turn % players.length;
        //players[playerPos];
    }



    public void checkWinner(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String boardPosition = e.getActionCommand();
        String[] chords = boardPosition.split(",");

        Position position = new Position(Integer.parseInt(chords[0]), Integer.parseInt(chords[1]));
        this.boardModel.setSquareSymbol(position, players[playerPos].getSymbol());
        this.updateSquare();
        this.checkWinner();
        this.nextTurn();
        this.updateTurn();

    }
}
