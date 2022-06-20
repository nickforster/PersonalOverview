package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Overview extends JFrame {
    JTextField searchField = new JTextField(20);
    String[] filterContent = {"Vorname", "Nachname"};
    JComboBox  filter = new JComboBox(filterContent);
    String[][] data = {{"Hans","Muster","Sozialarbeiter","SozialArbeit","So2020","Admin"},
            {"Petra","Sutter","Bauarbeiterin","Bau","Bau2021","Admin"},
            {"Petra","Sutter","Bauarbeiterin","Bau","Bau2021","Mitarbeiter"},
            {"Petra","Sutter","Bauarbeiterin","Bau","Bau2021","HR-Person"},
            {"Petra","Sutter","Bauarbeiterin","Bau","Bau2021","Admin"},
            {"Petra","Sutter","Bauarbeiterin","Bau","Bau2021","Admin"},
            {"Petra","Sutter","Bauarbeiterin","Bau","Bau2021","Admin"}};
    String[] column = {"Vorname","Nachname","Funktion","Abteilung","Team", "Berechtigung"};
    JTable userList = new JTable(data,column);
    JScrollPane scrollPane = new JScrollPane(userList);
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel overviewPanel = new JPanel(new BorderLayout());
    JPanel searchPanel = new JPanel(new BorderLayout());
    JPanel listPanel = new JPanel(new BorderLayout());
    //Second Tab
    JLabel firstNameLabel = new JLabel("Vorname: ");
    JLabel lastNameLabel = new JLabel("Nachname: ");
    JLabel functionLabel = new JLabel("Funkton: ");
    JLabel departmentLabel = new JLabel("Abteilung: ");
    JLabel teamLabel = new JLabel("Teams: ");
    JLabel imageLabel = new JLabel("Image: ");
    JLabel hrPersonLabel = new JLabel("HR-Person: ");
    JLabel adminLabel = new JLabel("Admin: ");

    JFileChooser imageChooser = new JFileChooser();
    JTextField firstNameTextField = new JTextField(20);
    JTextField lastNameTextField = new JTextField(20);
    JComboBox functionComboBox = new JComboBox(); //TO:DO read all functions
    JComboBox departmentComboBox = new JComboBox(); //TO:DO read all departments
    JList teamsList = new JList<>(); //TO:DO reas all Teams
    JCheckBox hrPersonCheckbox = new JCheckBox();
    JCheckBox adminCheckbox = new JCheckBox();
    JButton saveBtn = new JButton("Speichern");
    JPanel formPanel = new JPanel(new GridBagLayout());
    JPanel btnPanel = new JPanel(new BorderLayout());
    //Third Tab
    JPanel inputPanel = new JPanel(new GridBagLayout());
    JPanel masterDatePanel = new JPanel(new BorderLayout());
    JList departmentList = new JList();
    JList functionList = new JList();
    JList teamList = new JList();
    JButton addBtnDepartment = new JButton("Add");
    JButton editBtnDepartment = new JButton("Edit");
    JButton deleteBtnDepartment = new JButton("Delete");
    JPanel departmentBtnPanel = new JPanel(new GridLayout(1,3));
    JPanel departmentInputPanel = new JPanel(new BorderLayout());

    JButton addBtnFunction = new JButton("Add");
    JButton editBtnFunction = new JButton("Edit");
    JButton deleteBtnFunction = new JButton("Delete");
    JPanel functionBtnPanel = new JPanel(new GridLayout(1,3));
    JPanel functionInputPanel = new JPanel(new BorderLayout());

    JButton addBtnTeam = new JButton("Add");
    JButton editBtnTeam = new JButton("Edit");
    JButton deleteBtnTeam = new JButton("Delete");
    JPanel teamBtnPanel = new JPanel(new GridLayout(1,3));
    JPanel teamInputPanel = new JPanel(new BorderLayout());


    JLabel functionLabelM = new JLabel("Funktonen: ");
    JLabel departmentLabelM = new JLabel("Abteilungen: ");
    JLabel teamLabelM = new JLabel("Teams: ");

    //Fourth Tab
    JPanel logPanel = new JPanel(new BorderLayout());

    JPanel createPersonPanel = new JPanel(new BorderLayout());
    JTextArea logTextArea = new JTextArea(50,100);

    public Overview(int state){
        setTitle("SuperTouperFullComputer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,400));
        setResizable(true);

        //First Tab
        tabbedPane.addTab("Overview",overviewPanel);
        searchPanel.add(searchField,BorderLayout.WEST);
        searchPanel.add(filter,BorderLayout.EAST);
        searchPanel.setBorder(new EmptyBorder(0,0,10,0));

        listPanel.add(scrollPane);
        overviewPanel.add(searchPanel,BorderLayout.NORTH);
        overviewPanel.add(listPanel,BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        //CreatePerson Tab
        if((state == 1) || (state == 2)){
            tabbedPane.addTab("Erfassen",createPersonPanel);
            c.gridx = 0;
            c.gridy = 0;
            formPanel.add(firstNameLabel, c);

            c.gridx = 0;
            c.gridy = 1;
            formPanel.add(lastNameLabel, c);

            c.gridx = 0;
            c.gridy = 2;
            formPanel.add(functionLabel, c);

            c.gridx = 0;
            c.gridy = 3;
            formPanel.add(departmentLabel, c);

            c.gridx = 0;
            c.gridy = 4;
            formPanel.add(teamLabel, c);

            c.gridx = 0;
            c.gridy = 5;
            formPanel.add(imageLabel, c);

            c.gridx = 1;
            c.gridy = 0;
            formPanel.add(firstNameTextField, c);

            c.gridx = 1;
            c.gridy = 1;
            formPanel.add(lastNameTextField, c);

            c.gridx = 1;
            c.gridy = 2;
            formPanel.add(functionComboBox, c);

            c.gridx = 1;
            c.gridy = 3;
            formPanel.add(departmentComboBox, c);

            c.gridx = 1;
            c.gridy = 4;
            formPanel.add(teamsList, c);

            c.gridx = 1;
            c.gridy = 5;
            formPanel.add(imageChooser, c);

            btnPanel.add(saveBtn,BorderLayout.CENTER);

            createPersonPanel.add(formPanel,BorderLayout.NORTH);
            createPersonPanel.add(btnPanel,BorderLayout.SOUTH);

            if(state == 2){

                c.gridx = 0;
                c.gridy = 6;
                formPanel.add(hrPersonLabel);

                c.gridx = 0;
                c.gridy = 7;
                formPanel.add(adminLabel);

                c.gridx = 1;
                c.gridy = 6;
                formPanel.add(hrPersonCheckbox);

                c.gridx = 1;
                c.gridy = 7;
                formPanel.add(adminCheckbox);

                tabbedPane.addTab("Stammdaten erfassen", masterDatePanel);
                departmentBtnPanel.add(addBtnDepartment);
                departmentBtnPanel.add(editBtnDepartment);
                departmentBtnPanel.add(deleteBtnDepartment);
                departmentInputPanel.add(departmentList,BorderLayout.NORTH);
                departmentInputPanel.add(departmentBtnPanel,BorderLayout.CENTER);

                functionBtnPanel.add(addBtnFunction);
                functionBtnPanel.add(editBtnFunction);
                functionBtnPanel.add(deleteBtnFunction);
                functionInputPanel.add(functionList,BorderLayout.NORTH);
                functionInputPanel.add(functionBtnPanel,BorderLayout.CENTER);

                teamBtnPanel.add(addBtnTeam);
                teamBtnPanel.add(editBtnTeam);
                teamBtnPanel.add(deleteBtnTeam);
                teamInputPanel.add(teamList,BorderLayout.NORTH);
                teamInputPanel.add(teamBtnPanel,BorderLayout.CENTER);

                c.gridx = 0;
                c.gridy = 0;
                inputPanel.add(departmentLabelM, c);

                c.gridx = 0;
                c.gridy = 1;
                inputPanel.add(functionLabelM, c);

                c.gridx = 0;
                c.gridy = 2;
                inputPanel.add(teamLabelM, c);

                c.gridx = 1;
                c.gridy = 0;
                inputPanel.add(departmentInputPanel, c);

                c.gridx = 1;
                c.gridy = 1;
                inputPanel.add(functionInputPanel, c);

                c.gridx = 1;
                c.gridy = 2;
                inputPanel.add(teamInputPanel, c);

                masterDatePanel.add(inputPanel, BorderLayout.NORTH);

                tabbedPane.addTab("Log",logPanel);
                logTextArea.setText("Logs"); //TO:DO Read Textfile
                logTextArea.setEditable(false);
                logPanel.add(logTextArea);
            }
        }

        getContentPane().add(tabbedPane, BorderLayout.NORTH);

        pack();
        setVisible(true);
        userList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int viewRow = userList.getSelectedRow();

                if (!e.getValueIsAdjusting() && viewRow != -1) {
                    String name = userList.getValueAt(viewRow, 0) + " " + userList.getValueAt(viewRow, 1);
                    String function = (String) userList.getValueAt(viewRow, 2);
                    String department = (String) userList.getValueAt(viewRow,3);
                    String teams = (String) userList.getValueAt(viewRow, 4);
                    String permission = (String) userList.getValueAt(viewRow,5);
                    new PopOut(name,function,department,teams,permission,state);
                }
            }
        });
    }


}
