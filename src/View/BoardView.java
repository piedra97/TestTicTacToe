package View;

import Controller.BoardController;
import Model.Symbol;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame{
    private JButton[][] squares;
    private JLabel winner;

    public BoardView(){
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }

    private void addComponentsToPane(Container contentPane) {
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 3));
        squares= new JButton[3][3];
        for (int i=0;i<squares.length;i++) {
            for (int j = 0; j < squares.length; j++) {
                squares[i][j] = new JButton(" ");
                squares[i][j].setPreferredSize(new Dimension(75, 75));
                buttonsPanel.add(squares[i][j]);
            }
        }
        winner = new JLabel(" ", SwingConstants.CENTER);
        contentPane.add(winner, BorderLayout.NORTH);
        contentPane.add(buttonsPanel, BorderLayout.CENTER);
    }

    public void setButtonActionListener(String position, BoardController boardController) {
        String[] commands = position.split(",");
        this.squares[Integer.parseInt(commands[0])][Integer.parseInt(commands[1])].setActionCommand(position);
        this.squares[Integer.parseInt(commands[0])][Integer.parseInt(commands[1])].addActionListener(boardController);
    }

    public void setTurn(Symbol symbol) {
        winner.setText(symbol.toString());
    }

    public void setSquareSymbol(String chords1,String chords2, String symbol) {
        squares[Integer.parseInt(chords1)][Integer.parseInt(chords2)].setText(symbol);
    }

    public void disableSquare(String chord, String chord1) {
        squares[Integer.parseInt(chord)][Integer.parseInt(chord1)].setEnabled(false);
    }

    public void showDrawMessage() {
        JOptionPane.showMessageDialog(null, "A Draw. Sorry no one win.");
    }

    public void showWinnerMessage() {
        JOptionPane.showMessageDialog(null, "Player: " + winner.getText() + " has won the game.");
    }
}

