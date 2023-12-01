package org.example.lesson_semenar_1.task_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 0;
    private static final int WINDOW_POSY = 0;
    JPanel panUp = new JPanel(new GridLayout(6, 2));
    JPanel panDown = new JPanel(new GridLayout(4, 1));

    JButton btnSend = new JButton("Отправить");


    JLabel lblLogin = new JLabel("Введите логин: ");
    JTextField txtFieldLogin = new JTextField();

    JLabel lblPassword = new JLabel("Введите пароль: ");
    JTextField txtFieldPassword = new JTextField();

    JLabel lblMessage = new JLabel("Введите сообщение: ");
    JTextField txtFieldMessage = new JTextField();

    JLabel lblIp = new JLabel("Введите id: ");
    JTextField txtFieldIp = new JTextField();

    JTextArea areaMessage = new JTextArea();

    String login;
    String password;
    String IP;
    String message;

    JList<String> asd = new JList<String>();


    Chat() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TASK 2");
        setResizable(false);
        panUp.add(lblLogin);
        panUp.add(txtFieldLogin);
        panUp.add(lblPassword);
        panUp.add(txtFieldPassword);
        panUp.add(lblIp);
        panUp.add(txtFieldIp);
        panDown.add(lblMessage);
        panDown.add(txtFieldMessage);
        panDown.add(btnSend);
        panDown.add(areaMessage);

//        txtFieldLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                login = txtFieldLogin.getText();
//            }
//        });
//        txtFieldPassword.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                password = txtFieldPassword.getText();
//            }
//        });
//        txtFieldIp.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                IP = txtFieldIp.getText();
//            }
//        });
//        txtFieldMessage.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                message = txtFieldMessage.getText();
//            }
//        });

//        FileWriter file = new FileWriter("src/main/java/org/example/lesson_semenar_1/file.txt");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = txtFieldMessage.getText() + "\n";
                IP = txtFieldIp.getText();
                password = txtFieldPassword.getText();
                login = txtFieldLogin.getText();
                areaMessage.append(message);
                System.out.println("Отправленно сообщение:" + message);
                File newFile = new File("file.txt");
                try ( FileWriter file = new FileWriter(newFile, false);){
                    file.write(message);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        btnSend.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                message = txtFieldMessage.getText() + "\n";
                IP = txtFieldIp.getText();
                password = txtFieldPassword.getText();
                login = txtFieldLogin.getText();
                areaMessage.append(message);
                System.out.println("Отправленно сообщение:" + message);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        setLayout(new GridLayout(2, 1));
        add(panUp);
        add(panDown);

        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Chat();
    }

}
