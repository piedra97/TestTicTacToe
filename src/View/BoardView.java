package View;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame{
    private JButton[] squares;
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
        squares= new JButton[9];
        for (int i=0;i<squares.length;i++) {
            squares[i] = new JButton(" ");
            squares[i].setPreferredSize(new Dimension(75,75));
            buttonsPanel.add(squares[i]);
        }
        winner = new JLabel("Player's name", SwingConstants.CENTER);
        contentPane.add(winner, BorderLayout.NORTH);
        contentPane.add(buttonsPanel, BorderLayout.CENTER);
    }

    }

