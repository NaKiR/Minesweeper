package ru.nakir.minesweeper;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JLabel time;
    private JLabel numberOfMines;
    private Field field;

    public MainWindow(GameModel model) {
        field  = new Field(model);
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createMenuBar();
        numberOfMines = new JLabel();
        time = new JLabel();
        add(field);
        setSize(new Dimension(200, 250));
        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu game = new JMenu("Game");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem exit = new JMenuItem("Exit");
        game.add(newGame);
        game.add(exit);
        menuBar.add(game);
        setJMenuBar(menuBar);
    }
}
