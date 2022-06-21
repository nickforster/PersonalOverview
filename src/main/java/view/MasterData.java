package view;

import model.DataHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterData extends JFrame {
    DataHandler dataHandler = new DataHandler();
    JPanel inputPanel = new JPanel(new BorderLayout());
    JPanel btnPanel = new JPanel(new BorderLayout());
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JButton saveBtn = new JButton("Speichern");

    MasterData(String masterData, String content, int index){
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

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (masterData.equals("Department")) {
                    dataHandler.editDepartment(index, textField.getText());
                } else if (masterData.equals("Function")) {
                    dataHandler.editFunction(index, textField.getText());
                } else { // Team
                    dataHandler.editTeam(index, textField.getText());
                }
                dataHandler.addLog("edited " + masterData + ": " + content + " to " + textField.getText());
                setVisible(false);
            }
        });
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

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (masterData.equals("Department")) {
                    dataHandler.addDepartment(textField.getText());
                } else if (masterData.equals("Function")) {
                    dataHandler.addFunction(textField.getText());
                } else { // Team
                    dataHandler.addTeam(textField.getText());
                }
                dataHandler.addLog("created " + masterData + ": " + textField.getText());
                setVisible(false);
            }
        });
    }
}
