package Controller;

import Model.Board;
import Model.Player;
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
    }

    public void updateView(){

    }

    public void nextTurn(){
        turn++;
        playerPos = turn % players.length;
        //players[playerPos];
    }

    public void checkWinner(Player player){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            boardModel.setSquareSymbol(players[playerPos].getSymbol());
        }
    }
}
