package p02.pres;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
    private final int[] board;
    private final ImageIcon [] imageIconscars;
    private final ImageIcon [] imageIconsprzeszkody;
    private final ImageIcon przykrycie;


    public CustomTableModel(int[] board, ImageIcon [] imageIconscars,ImageIcon [] imageIconsprzeszkody,ImageIcon przykrycie) {
        this.imageIconscars = imageIconscars;
        this.imageIconsprzeszkody = imageIconsprzeszkody;
        this.board = board;
        this.przykrycie=przykrycie;

    }
    ImageIcon obrazek(int[] board, int i){
        return switch (board[i]) {
            case 1 -> imageIconsprzeszkody[1];
            case 2 -> imageIconsprzeszkody[2];
            case 3 -> imageIconsprzeszkody[3];
            case 4 -> imageIconsprzeszkody[4];
            case 5 -> imageIconsprzeszkody[5];
            case 6 -> imageIconsprzeszkody[6];
            case 0 -> imageIconsprzeszkody[0];
            default -> przykrycie;
        };
    }

    @Override
    public int getRowCount() {
        return 9;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex == 8 && board != null) {
            return switch (board[0]) {
                case 1 -> imageIconscars[1];
                case 2 -> imageIconscars[0];
                case 4 -> imageIconscars[2];
                default -> null;
            };
        } else if (rowIndex == 7 && board != null) {
            return obrazek(board,1);
        }else if (rowIndex == 6 && board != null) {
            return obrazek(board,2);
        }
        else if (rowIndex == 5 && board != null) {
            return przykrycie;
        }
        else if (rowIndex == 4 && board != null) {
            return obrazek(board,4);
        }
        else if (rowIndex == 3 && board != null) {
            return obrazek(board,5);
        }
        else if (rowIndex == 2 && board != null) {
            return przykrycie;
        }
        else if (rowIndex == 1 && board != null) {
            return obrazek(board,6);
        }
        else if (rowIndex == 0 && board != null) {
            return obrazek(board,3);
        }
        else {
            return przykrycie;
        }
    }

}