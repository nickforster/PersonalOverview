package view;

import javax.swing.*;
import java.awt.*;

public class PopOut extends JFrame {
    JLabel nameLabel = new JLabel();
    JLabel functionLabel = new JLabel("Funktion: ");
    JLabel departmentLabel = new JLabel("Abteilung: " );
    JLabel teamLabel = new JLabel("Teams: ");
    JLabel imageLabel = new JLabel("Bild");
    JLabel permissonLabel = new JLabel("Berechtigung: ");
    JLabel hrPersonLabel = new JLabel("HR-Person: ");
    JLabel adminLabel = new JLabel("Admin: ");
    JPanel labelPanel = new JPanel(new GridLayout(7,1));

    JLabel lastNameLabel = new JLabel("Nachname: ");
    JTextField firstnameTextfield = new JTextField(20);
    JTextField lastnameTextfield = new JTextField(20);
    JComboBox functionComboBox = new JComboBox(); //TO:DO read all functions
    JComboBox departmentComboBox = new JComboBox(); //TO:DO read all departments
    JList teamsList = new JList<>(); //TO:DO reas all Teams
    JButton saveBtn = new JButton("Speichern");
    JButton deleteBtn = new JButton("Löschen");
    JCheckBox hrPersonCheckBox = new JCheckBox();
    JCheckBox adminCheckBox = new JCheckBox();
    JPanel inputPanel = new JPanel(new GridLayout(7,1));
    JPanel btnPanel = new JPanel(new BorderLayout());
     public PopOut(String name, String function, String department, String teams, String permission, int state){
         setTitle(name);
         setSize(400,200);
         setResizable(false);

         if(state == 0){
             nameLabel.setText(name);
             nameLabel.setFont(new Font("Calibri",Font.BOLD,50));
             functionLabel.setText(functionLabel.getText() + function);
             departmentLabel.setText(departmentLabel.getText() + department);
             teamLabel.setText(teamLabel.getText() + teams);
             permissonLabel.setText(permissonLabel.getText() + permission);

             labelPanel.add(functionLabel);
             labelPanel.add(departmentLabel);
             labelPanel.add(teamLabel);
             labelPanel.add(permissonLabel);

             getContentPane().add(nameLabel,BorderLayout.NORTH);
             getContentPane().add(labelPanel,BorderLayout.WEST);
             getContentPane().add(imageLabel,BorderLayout.EAST);
         }
         else if ((state == 1) || (state == 2)) {
             nameLabel.setText("Vorname: ");

             labelPanel.add(nameLabel);
             labelPanel.add(lastNameLabel);
             labelPanel.add(functionLabel);
             labelPanel.add(departmentLabel);
             labelPanel.add(teamLabel);

             inputPanel.add(firstnameTextfield);
             inputPanel.add(lastnameTextfield);
             inputPanel.add(functionComboBox);
             inputPanel.add(departmentComboBox);
             inputPanel.add(teamsList);

             if(state == 2){
                 labelPanel.add(hrPersonLabel);
                 labelPanel.add(adminLabel);
                 inputPanel.add(hrPersonCheckBox);
                 inputPanel.add(adminCheckBox);
             }

             btnPanel.add(saveBtn,BorderLayout.WEST);
             btnPanel.add(deleteBtn,BorderLayout.EAST);

             getContentPane().add(labelPanel,BorderLayout.WEST);
             getContentPane().add(inputPanel,BorderLayout.CENTER);
             getContentPane().add(imageLabel,BorderLayout.EAST);
             getContentPane().add(btnPanel,BorderLayout.SOUTH);

         }
         setVisible(true);


     }

}
