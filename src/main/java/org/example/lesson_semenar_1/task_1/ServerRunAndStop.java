package org.example.lesson_semenar_1.task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerRunAndStop extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 0;
    private static final int WINDOW_POSY = 0;

    JButton btnStartServer = new JButton("Server start");
    JButton btnStopServer = new JButton("Server Stop");

    boolean isServerWorking;
    JTextArea txtArea = new JTextArea("Состояние сервера: ");
    String message;
    ServerRunAndStop() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TASK 1");
        setResizable(false);

        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                    message = "Статус сервера: " + isServerWorking;
                    txtArea.append(message + "\n");
                } else {
                    message = "Статус сервера: " + isServerWorking;
                    txtArea.append(message + "\n");
                }
            }
        });
        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                    message = "Статус сервера: " + isServerWorking;
                    txtArea.append(message + "\n");
                } else {
                    message = "Сервер не работает!";
                    txtArea.append(message + "\n");
                }
            }
        });
        setLayout(new GridLayout(1,2));
        add(btnStartServer);
        add(btnStopServer);
        add(txtArea);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerRunAndStop();
    }

}
