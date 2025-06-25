import p02.game.Board;

import javax.swing.*;


public class S30595P02 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Autoslalom");
            Board board = new Board();
            frame.add(board);
            frame.setSize(800, 600);  // Ustawienie rozmiaru okna
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
