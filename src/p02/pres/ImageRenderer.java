package p02.pres;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof ImageIcon) {
            if (row == 8) {
                label.setIcon((ImageIcon) value);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
            }
            if (row == 7) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                int width = 1650;
                int height = 260;
                Image scaledimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledimage);

                label.setIcon(scaledIcon);

                label.setHorizontalAlignment(JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setText(null); // Usunięcie tekstu
            }
            if (row == 6) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                int width = 1400;
                int height = 220;
                Image scaledimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledimage);

                label.setIcon(scaledIcon);

                label.setHorizontalAlignment(JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setText(null); // Usunięcie tekstu

            }
            if (row == 5) {
                label.setIcon((ImageIcon) value);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
            }
            if (row == 4) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                int width = 1000;
                int height = 180;
                Image scaledimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledimage);

                label.setIcon(scaledIcon);

                label.setHorizontalAlignment(JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setText(null); // Usunięcie tekstu
            }
            if (row == 3) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                int width = 825;
                int height = 160;
                Image scaledimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledimage);

                label.setIcon(scaledIcon);

                label.setHorizontalAlignment(JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setText(null); // Usunięcie tekstu
            }
            if (row == 2) {
                label.setIcon((ImageIcon) value);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
            }
            if (row == 1) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                int width = 580;
                int height = 100;
                Image scaledimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledimage);

                label.setIcon(scaledIcon);

                label.setHorizontalAlignment(JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setText(null); // Usunięcie tekstu
            }
            if (row == 0) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                int width = 490;
                int height = 70;
                Image scaledimage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledimage);

                label.setIcon(scaledIcon);

                label.setHorizontalAlignment(JLabel.RIGHT);
                label.setVerticalAlignment(JLabel.CENTER);

                label.setText(null); // Usunięcie tekstu
            }
            label.setText(null); // Usunięcie tekstu
        }


        return label;
    }
}