package p02.pres;

import javax.swing.*;
import java.awt.*;

public class SevenSegmentDigit extends JPanel {

    private int digitValue;

    public SevenSegmentDigit() {
        this.digitValue = 0;
    }
    public void setValue(int value) {
        this.digitValue = value;
        repaint(); // Odświeżenie widoku po zmianie wartości
    }
    public void StartEvent() {
        this.digitValue = 0;
        repaint();
        // Generowanie zdarzenia StartEvent
    }
    public void PlusOneEvent() {
        this.digitValue++;
        if (this.digitValue > 9) {
            this.digitValue = 0;
        }
        repaint();
        // Generowanie zdarzenia PlusOneEvent
    }
    public void ResetEvent() {
        this.digitValue = 0;
        repaint();
        // Generowanie zdarzenia ResetEvent
    }

    public void paint(Graphics g, int x1){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(169,29,29));
        g2d.setStroke(new BasicStroke(6));
        if(digitValue == 0){


            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,190,200+x1,140); //kreska po lewej dolna
            g2d.drawLine(200+x1,120,200+x1,70); //kreska po lewej gorna
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

            //g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 1){

            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

        }
        if(digitValue == 2){

            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,190,200+x1,140); //kreska po lewej dolna
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna

            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 3){

            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 4){

            g2d.drawLine(200+x1,120,200+x1,70); //kreska po lewej gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 5){

            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,120,200+x1,70); //kreska po lewej gorna
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 6){

            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,190,200+x1,140); //kreska po lewej dolna
            g2d.drawLine(200+x1,120,200+x1,70); //kreska po lewej gorna
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 7){

            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

        }
        if(digitValue == 8){

            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,190,200+x1,140); //kreska po lewej dolna
            g2d.drawLine(200+x1,120,200+x1,70); //kreska po lewej gorna
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna

            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }
        if(digitValue == 9){

            g2d.drawLine(200+x1,200,270+x1,200); //dolna kreska
            g2d.drawLine(200+x1,120,200+x1,70); //kreska po lewej gorna
            g2d.drawLine(200+x1,60,270+x1,60); //kreska gorna
            g2d.drawLine(270+x1,120,270+x1,70); //kreska po prawej gorna
            g2d.drawLine(270+x1,190,270+x1,140); // kreska po prawej dolna
            g2d.drawLine(200+x1,130,270+x1,130); // kreska srodkowa
        }

    }
}
