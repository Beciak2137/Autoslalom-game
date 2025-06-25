package p02.game;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import p02.pres.CustomTableModel;
import p02.pres.ImageRenderer;
import p02.pres.SevenSegmentDigit;

public class Board extends JPanel implements KeyListener {

    int points;
    private boolean isRunning;
    boolean gameStarted;

    private final int[] board;
    private JTable table;
    private ImageIcon carIcon1, carIcon2, carIcon3;
    private ImageIcon przeszkoda1, przeszkoda2, przeszkoda3, przeszkoda4, przeszkoda5, przeszkoda6, przeszkoda0,przykrycie;
    private Timer timer; // Timer do obsługi cyklicznych zdarzeń
    private final SevenSegmentDigit jednosci;
    private final SevenSegmentDigit dziesiatki;
    private final SevenSegmentDigit setki;
    ImageIcon[] imageiconscars;
    ImageIcon[] imageiconsprzeszkody;
    int speed = 700;

    public Board() {
        this.board = new int[7];
        this.board[0] = 2;
        this.board[1]=0;
        this.board[2]=0;
        this.board[3]=0;
        this.board[4]=0;
        random_numbers();
        this.points = 0;
        this.isRunning = true;
        this.gameStarted = false;
        jednosci = new SevenSegmentDigit();
        dziesiatki = new SevenSegmentDigit();
        setki = new SevenSegmentDigit();


        addKeyListener(this); //dodaje keyListenera ktory odpowiada za reakcje po wcisnieciu klawiatury
        setFocusable(true); //ustawia komponent tak by byl fokusowany przez klawiature czyli odbiera zdarzenia klawiatury
        setFocusTraversalKeysEnabled(false);  // Potrzebne, aby klawisze A i D działały
        setBackground(new Color(191, 191, 191));

        try {
            przykrycie = new ImageIcon(ImageIO.read(new File("przykrycie.png")));
            carIcon1 = new ImageIcon(ImageIO.read(new File("car1.png")));
            carIcon2 = new ImageIcon(ImageIO.read(new File("car2.png")));
            carIcon3 = new ImageIcon(ImageIO.read(new File("car3.png")));
            przeszkoda0 = new ImageIcon(ImageIO.read(new File("przeszkoda0.png")));
            przeszkoda1 = new ImageIcon(ImageIO.read(new File("przeszkoda1.png")));
            przeszkoda2 = new ImageIcon(ImageIO.read(new File("przeszkoda2.png")));
            przeszkoda3 = new ImageIcon(ImageIO.read(new File("przeszkoda3.png")));
            przeszkoda4 = new ImageIcon(ImageIO.read(new File("przeszkoda4.png")));
            przeszkoda5 = new ImageIcon(ImageIO.read(new File("przeszkoda5.png")));
            przeszkoda6 = new ImageIcon(ImageIO.read(new File("przeszkoda6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageiconscars = new ImageIcon[]{carIcon1, carIcon2, carIcon3};
        imageiconsprzeszkody = new ImageIcon[]{przeszkoda0,przeszkoda1,przeszkoda2,przeszkoda3,przeszkoda4,przeszkoda5,przeszkoda6};
        InitializeTable();
        TickEvent();
    }
    //tworzy tabele na ekran i okresla jej wlasciwosci
    private void InitializeTable(){
        // Tworzenie nowego JTable z niestandardowym modelem tabeli CustomTableModel
        table = new JTable(new CustomTableModel(board,imageiconscars,imageiconsprzeszkody,przykrycie)) {
            // Przesłanianie metody changeSelection, aby zablokować możliwość zmiany zaznaczenia w tabeli
            public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
                // Przechwycenie i zablokowanie zmiany zaznaczenia
            }
        };

        // Ustawienie przezroczystości JTable
        table.setOpaque(false);

        // Ustawienie przezroczystości domyślnego renderera komórek tabeli
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        // Ustawienie niestandardowego renderera komórek tabeli, aby renderować obrazy w komórkach
        table.setDefaultRenderer(Object.class, new ImageRenderer());

        // Ukrycie linii dzielących wiersze i kolumny
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        // Ukrycie nagłówka tabeli
        JTableHeader header = table.getTableHeader();
        header.setVisible(false);


        // Ustawienie przezroczystości tła tabeli
        table.setFillsViewportHeight(true);
        table.setBackground(new Color(0, 0, 0, 0));
        // Dodanie nasłuchiwacza zdarzeń myszy do JTable
        // Wyłączenie możliwości wyboru wierszy
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);

        // Dodanie nasłuchiwacza zdarzeń myszy do JTable
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Zablokowanie kliknięcia myszą
                e.consume();
            }
        });
        // Ukrycie paska przewijania bocznego JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

        // Ustawienie własnego layoutu bez JScrollPane
        setLayout(new BorderLayout());
        add(scrollPane.getViewport(), BorderLayout.CENTER);

        // Ustawienie wysokości wierszy na podstawie ich indeksu
        table.setRowHeight(0, 40);  // Mniejszy wiersz na górze
        table.setRowHeight(1, 50);
        table.setRowHeight(2, 70);
        table.setRowHeight(3, 90);
        table.setRowHeight(4, 100);
        table.setRowHeight(5, 110);
        table.setRowHeight(6, 130);
        table.setRowHeight(7, 150);
        table.setRowHeight(8, 250);  // Największy wiersz na dole

        // Dostosowanie wielkości kolumn i wierszy
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setWidth(490);  // Ustawienie szerokości kolumny
        columnModel.getColumn(0).setPreferredWidth(490);  // Ustawienie preferowanej szerokości kolumny

        // Dodanie nasłuchiwania na zmianę rozmiaru
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Kod do dostosowania rozmiaru komponentów, jeśli potrzebny
            }
        });
    }
    //start gry po nacisnieciu s
    public void startGame() {
        isRunning = true;
        gameStarted = true;
        points = 0;
        jednosci.StartEvent();
        dziesiatki.StartEvent();
        setki.StartEvent();
        repaint();
    }

    //reset stanu gry
    public void ResetEvent(){
        gameStarted=false;
        points=0;
        board[0]=2;
        board[1]=0;
        board[2]=0;
        board[3]=0;
        board[4]=0;
        random_numbers();
        jednosci.ResetEvent();
        dziesiatki.ResetEvent();
        setki.ResetEvent();
        speed=700;
        table.repaint();
        repaint();

    }
    //generuje randomowa liczbe z przedzialu 1-6
    void generateNumber(){
        Random random = new Random();
        int newNumber;
        do {
            newNumber = random.nextInt(6) + 1; // generuje liczby od 1 do 6
        } while (newNumber == board[5]); // sprawdza, czy nowa liczba nie jest taka sama jak poprzednia
        this.board[6]=newNumber;
    }
    //generuje liczby do tabeli startowej po uruchomieniu gry
    void random_numbers() {
        Random random = new Random();
        for (int i = 5; i < board.length; i++) {
            int newNumber;
            do {
                newNumber = random.nextInt(6) + 1; // generuje liczby od 1 do 6
            } while (newNumber == board[i - 1]); // sprawdza, czy nowa liczba nie jest taka sama jak poprzednia

            this.board[i] = newNumber;
        }
    }
    //przesuwa elementy w tablicy w lewo,sprawdza kolizje, generuje nowa liczbe na koniec tabeli i aktualizuje wyswietlana tabele z obrazkami
    void updateBoard() {
        for (int i = 1; i < board.length; i++) {
            if(i-1==0){
                checkCollision();
            }
            else {
                board[i - 1] = board[i];}
        }
        generateNumber();

        table.repaint();
    }
    //aktualizuje punkty przesyla je do sevenSegmentDigit i aktualizuje predkosc w zaleznie od punktow
    private void updatePoints() {
        int hundreds = points / 100;
        int tens = (points / 10) % 10;
        int units = points % 10;
        jednosci.setValue(units);
        dziesiatki.setValue(tens);
        setki.setValue(hundreds);
        updateSpeed();
    }
    //sprawdza kolizje przez koniunkcje bitowa i jesli kolizja nie nastapila to dodaje punkty oraz jesli punktow jest 999 to generuje plusOneEvent ktory zatrzymuje gre
    void checkCollision(){
        if((board[0]&board[1])==board[0]){
            ResetEvent();
        }
        else{
            if(board[1]!=0){
                points++;
                updatePoints();
            }
            if(points==999){
                jednosci.PlusOneEvent();
                dziesiatki.PlusOneEvent();
                setki.PlusOneEvent();
                ResetEvent();
            }
        }
    }
    //aktualizuje predkosc w zaleznie od punktow
    private void updateSpeed() {
        if (points % 10 == 0 && points != 0) {
            speed = Math.max(speed - 20, 340); // Zmniejszamy prędkość o 6 milisekund, minimum to 340 ms
            timer.setDelay(speed); // Aktualizujemy interwał timera
        }
    }
    void TickEvent(){

        timer = new Timer(speed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameStarted) {
                    updateBoard();
                    repaint();
                }
            }
        });
        timer.start(); // Rozpoczęcie Timera
    }
    //rysuje plansze i licznik
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawPlansza(g);
        jednosci.paint(g,200);
        dziesiatki.paint(g,100);
        setki.paint(g,0);
    }

    private void DrawPlansza(Graphics g) {
        int[] xPoints = {getWidth() / 2 - 250, getWidth() / 2 + 200, getWidth() / 2 + 350, getWidth() / 2 - 150};
        int[] yPoints = {-50, -200, -20, 200};
        int nPoints = 4;
        int[] xPoints2 = {getWidth() - 50, getWidth() + 100, getWidth() + 150, getWidth() - 150};
        int[] yPoints2 = {0, 0, getHeight() / 2 + 180, getHeight() / 2 + 130};
        int nPoints2 = 4;

        g.setColor(new Color(0, 120, 80));
        g.fillPolygon(xPoints, yPoints, nPoints);
        g.fillPolygon(xPoints2, yPoints2, nPoints2);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(180, 30, 0));
        g2d.setStroke(new BasicStroke(8)); // Grubość linii
        g2d.drawLine(0, getHeight() - 160, getWidth() - 450, 0);
        g2d.drawLine(0, getHeight() - 350, getWidth() - 540, 0);
        g2d.drawLine(getWidth() - 250, getHeight() - 160, getWidth() - 64, 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_S && !gameStarted) {
            startGame();
        }

        if (isRunning && gameStarted) {
            if (key == KeyEvent.VK_A) {
                if (board[0] == 2) {
                    board[0] = 4;
                } else if (board[0] == 1) {
                    board[0] = 2;
                }
            } else if (key == KeyEvent.VK_D) {
                if (board[0] == 2) {
                    board[0] = 1;
                } else if (board[0] == 4) {
                    board[0] = 2;
                }
            }
            table.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}


