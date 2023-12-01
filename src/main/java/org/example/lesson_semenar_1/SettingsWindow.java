package org.example.lesson_semenar_1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 236;
    private static final int WINDOW_WIDTH = 350;
    JPanel panelBottom;
    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("Выберите режим");
    JLabel gameField = new JLabel("Установленный размер поля: ");
    JLabel chooseWinLong = new JLabel("Установленная длинна: ");
    JSlider gameSlider = new JSlider(3,10);
    JSlider gameSliderLongWin = new JSlider(3,10);
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup gameModeButtonGroup = new ButtonGroup();

    SettingsWindow(GameWindow gameWindow) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        panelBottom = new JPanel(new GridLayout(8, 1));

        gameModeButtonGroup.add(humanVsAi);
        gameModeButtonGroup.add(humanVsHuman);

        panelBottom.add(gameMode);
        panelBottom.add(humanVsAi);
        panelBottom.add(humanVsHuman);
        panelBottom.add(gameField);
        panelBottom.add(gameSlider);
        panelBottom.add(chooseWinLong);
        panelBottom.add(gameSliderLongWin);
        panelBottom.add(btnStart);
        humanVsAi.setSelected(true);

        gameSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameField.setText("Установленный размер поля: " + gameSlider.getValue());
            }
        });

        gameSliderLongWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                chooseWinLong.setText("Установленная длинна: " + gameSliderLongWin.getValue());
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(humanVsAi.isSelected()?0:1, gameSlider.getValue(), gameSlider.getValue(), gameSliderLongWin.getValue());
                setVisible(false);
            }
        });
        add(panelBottom);
//        add(btnStart);
    }
}
