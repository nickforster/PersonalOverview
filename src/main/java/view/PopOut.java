package view;

import model.DataHandler;

import javax.swing.*;
import java.awt.*;

public class PopOut extends JFrame {
    JLabel nameLabel = new JLabel();
    JLabel functionLabel = new JLabel("Funktion: ");
    JLabel departmentLabel = new JLabel("Abteilung: " );
    JLabel teamLabel = new JLabel("Teams: ");
    JLabel permissonLabel = new JLabel("Berechtigung: ");
    JLabel hrPersonLabel = new JLabel("HR-Person: ");
    JLabel adminLabel = new JLabel("Admin: ");
    JPanel labelPanel = new JPanel(new GridLayout(7,1));

    JLabel lastNameLabel = new JLabel("Nachname: ");
    JTextField firstnameTextfield = new JTextField(20);
    JTextField lastnameTextfield = new JTextField(20);
    JComboBox functionComboBox;
    JComboBox departmentComboBox;
    JComboBox teamComboBox;
    JButton saveBtn = new JButton("Speichern");
    JButton deleteBtn = new JButton("Löschen");
    JCheckBox hrPersonCheckBox = new JCheckBox();
    JCheckBox adminCheckBox = new JCheckBox();
    JPanel inputPanel = new JPanel(new GridLayout(7,1));
    JPanel btnPanel = new JPanel(new BorderLayout());
    DataHandler dataHandler = new DataHandler();
     public PopOut(String firstName, String lastName, String function, String department, String team, String permission, int state){
         setTitle(firstName + " " + lastName);
         setSize(400,200);
         setResizable(false);

         if(state == 0){
             nameLabel.setText(firstName + " " + lastName);
             nameLabel.setFont(new Font("Calibri",Font.BOLD,50));
             functionLabel.setText(functionLabel.getText() + function);
             departmentLabel.setText(departmentLabel.getText() + department);
             teamLabel.setText(teamLabel.getText() + team);
             permissonLabel.setText(permissonLabel.getText() + permission);

             labelPanel.add(functionLabel);
             labelPanel.add(departmentLabel);
             labelPanel.add(teamLabel);
             labelPanel.add(permissonLabel);

             getContentPane().add(nameLabel,BorderLayout.NORTH);
             getContentPane().add(labelPanel,BorderLayout.WEST);
         }
         else if ((state == 1) || (state == 2)) {
             nameLabel.setText("Vorname: ");
             labelPanel.add(nameLabel);
             labelPanel.add(lastNameLabel);
             labelPanel.add(functionLabel);
             labelPanel.add(departmentLabel);
             labelPanel.add(teamLabel);

             firstnameTextfield.setText(firstName);
             inputPanel.add(firstnameTextfield);
             lastnameTextfield.setText(lastName);
             inputPanel.add(lastnameTextfield);

             String[] functions = new String[dataHandler.getFunctions().size()];
             for (int i = 0; i < dataHandler.getFunctions().size(); i++) {
                 functions[i] = dataHandler.getFunctions().get(i).getDesignation();
             }
             functionComboBox =  new JComboBox(functions);
             functionComboBox.setSelectedItem(function);
             inputPanel.add(functionComboBox);

             String[] departments = new String[dataHandler.getDepartments().size()];
             for (int i = 0; i < dataHandler.getDepartments().size(); i++) {
                 departments[i] = dataHandler.getDepartments().get(i).getDesignation();
             }
             departmentComboBox = new JComboBox(departments);
             departmentComboBox.setSelectedItem(department);
             inputPanel.add(departmentComboBox);

             String[] teams = new String[dataHandler.getTeams().size()];
             for (int i = 0; i < dataHandler.getTeams().size(); i++) {
                 teams[i] = dataHandler.getTeams().get(i).getDesignation();
             }
             teamComboBox = new JComboBox(teams);
             teamComboBox.setSelectedItem(team);
             inputPanel.add(teamComboBox);

             if(state == 2){
                 labelPanel.add(hrPersonLabel);
                 labelPanel.add(adminLabel);


                 if(permission.equals("admin")){
                     adminCheckBox.setSelected(true);
                 }
                 if(permission.equals("hrPerson")){
                     hrPersonCheckBox.setSelected(true);
                 }

                 inputPanel.add(hrPersonCheckBox);
                 inputPanel.add(adminCheckBox);
             }

             btnPanel.add(saveBtn,BorderLayout.WEST);
             btnPanel.add(deleteBtn,BorderLayout.EAST);

             getContentPane().add(labelPanel,BorderLayout.WEST);
             getContentPane().add(inputPanel,BorderLayout.CENTER);
             getContentPane().add(btnPanel,BorderLayout.SOUTH);

         }
         setVisible(true);


     }

}
