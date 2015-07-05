package ru.nakir.minesweeper;

import javax.swing.*;
import java.awt.*;

public class Minesweeper {
    private GameModel model = new GameModel();
    private MainWindow mainWindow = new MainWindow(model);

    public Minesweeper() {}

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Minesweeper minesweeper = new Minesweeper();
            }
        });
    }
}
