package view;

import model.DataHandler;
import model.Person;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JFrame {
    private int state = 0;
    JLabel userNameLabel = new JLabel("user:");
    JTextField userNameField = new JTextField();
    JLabel passwordLabel = new JLabel("password:");
    JPasswordField passwordField = new JPasswordField();
    JButton loginBtn = new JButton("Login");
    JPanel loginPanel = new JPanel(new BorderLayout());
    JPanel labelPanel = new JPanel(new GridLayout(3,1));
    JPanel inputPanel = new JPanel(new GridLayout(3,1));

    public Login(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setResizable(false);

        labelPanel.add(userNameLabel);
        labelPanel.add(passwordLabel);

        inputPanel.add(userNameField);
        inputPanel.add(passwordField);
        inputPanel.add(loginBtn);

        loginPanel.setBorder(new EmptyBorder(30,30,30,30));
        loginPanel.add(labelPanel,BorderLayout.WEST);
        loginPanel.add(inputPanel,BorderLayout.CENTER);


        getContentPane().add(loginPanel,BorderLayout.CENTER);

        setVisible(true);

        loginBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DataHandler dataHandler = new DataHandler();
                Person person = dataHandler.login(userNameField.getText(), new String(passwordField.getPassword()));
                if (person != null) {
                    if (person.getPermission().equals("admin")) {
                        state = 2;
                    }
                    else if (person.getPermission().equals("hrPerson")) {
                        state = 1;
                    } else {
                        state = 0;
                    }
                    new Overview(state);
                    setVisible(false);
                } else {
                    // show error
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }




}
