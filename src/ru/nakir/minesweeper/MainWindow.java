package ru.nakir.minesweeper;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    private JLabel time;
    private JLabel numberOfMines;
    private Field field;

    public MainWindow(final GameModel model) {
        field  = new Field(model);
        field.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Cell[][] tempField = model.getField();
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (e.getX() / (Cell.CELL_WIDTH + 2) < model.getField().length && e.getY() / (Cell.CELL_WIDTH + 2) < model.getField()[0].length )
                        tempField[e.getX() / (Cell.CELL_WIDTH + 2)][e.getY() / (Cell.CELL_WIDTH + 2)].setOpen(true);
                    field.repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (e.getX() / (Cell.CELL_WIDTH + 2) < model.getField().length && e.getY() / (Cell.CELL_WIDTH + 2) < model.getField()[0].length )
                        tempField[e.getX() / (Cell.CELL_WIDTH + 2)][e.getY() / (Cell.CELL_WIDTH + 2)].setMarked(
                                !tempField[e.getX() / (Cell.CELL_WIDTH + 2)][e.getY() / (Cell.CELL_WIDTH + 2)].isMarked());
                    field.repaint();
                }
            }
        });
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createMenuBar();
        numberOfMines = new JLabel();
        time = new JLabel();
        add(field);
        setResizable(false);
        setSize(field.getFrameSize());
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
