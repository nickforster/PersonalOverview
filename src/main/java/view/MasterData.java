package view;

import model.DataHandler;

import javax.swing.*;
import java.awt.*;

public class MasterData extends JFrame {
    DataHandler dataHandler = new DataHandler();
    JPanel inputPanel = new JPanel(new BorderLayout());
    JPanel btnPanel = new JPanel(new BorderLayout());
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JButton saveBtn = new JButton("Speichern");

    MasterData(String masterData, String content){
        setTitle("Edit " + masterData);
        setSize(400,200);
        setResizable(false);
        label.setText(masterData + ": ");
        textField.setText(content);

        inputPanel.add(label,BorderLayout.WEST);
        inputPanel.add(textField,BorderLayout.CENTER);

        btnPanel.add(saveBtn);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    MasterData(String masterData){
        setTitle("Create " + masterData);
        setSize(400,200);
        setResizable(false);

        label.setText(masterData + ": ");

        inputPanel.add(label,BorderLayout.WEST);
        inputPanel.add(textField,BorderLayout.CENTER);

        btnPanel.add(saveBtn);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
}
