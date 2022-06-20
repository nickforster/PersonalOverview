package view;

import model.DataHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Overview extends JFrame {
    JTextField searchField = new JTextField(20);
    String[] filterContent = {"Vorname", "Nachname"};
    JComboBox  filter = new JComboBox(filterContent);
    String[][] data;
    String[] column = {"Vorname","Nachname","Funktion","Abteilung","Team", "Berechtigung"};
    JTable userList;
    JScrollPane scrollPane;
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
    JComboBox functionComboBox;
    JComboBox departmentComboBox;
    JComboBox teamCombobox;
    JCheckBox hrPersonCheckbox = new JCheckBox();
    JCheckBox adminCheckbox = new JCheckBox();
    JButton saveBtn = new JButton("Speichern");
    JPanel formPanel = new JPanel(new GridBagLayout());
    JPanel btnPanel = new JPanel(new BorderLayout());
    //Third Tab
    JPanel inputPanel = new JPanel(new GridBagLayout());
    JPanel masterDatePanel = new JPanel(new BorderLayout());
    JComboBox departmentCombobox;
    JComboBox functionCombobox;
    JComboBox teamList;
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

    DataHandler dataHandler = new DataHandler();

    public Overview(int state){
        int personCnt = dataHandler.getPersons().size();
        System.out.println(personCnt);
        data = new String[personCnt][6];

        for (int i = 0; i < dataHandler.getPersons().size(); i++) {
            data[i][0] = dataHandler.getPersons().get(i).getFirstName();
            data[i][1] = dataHandler.getPersons().get(i).getLastName();
            data[i][2] = dataHandler.getPersons().get(i).getFunction().getDesignation();
            data[i][3] = dataHandler.getPersons().get(i).getDepartment().getDesignation();
            data[i][4] = dataHandler.getTeams().get(i).getDesignation();

        }
        userList = new JTable(data,column);
        scrollPane = new JScrollPane(userList);


        setTitle("SuperTouperFullComputer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
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

            c.gridx = 1;
            c.gridy = 0;
            formPanel.add(firstNameTextField, c);

            c.gridx = 1;
            c.gridy = 1;
            formPanel.add(lastNameTextField, c);

            String[] functions = new String[dataHandler.getFunctions().size()];
            for (int i = 0; i < dataHandler.getFunctions().size(); i++) {
                functions[i] = dataHandler.getFunctions().get(i).getDesignation();
            }
            c.gridx = 1;
            c.gridy = 2;
            functionComboBox = new JComboBox(functions);
            formPanel.add(functionComboBox, c);

            String[] departments = new String[dataHandler.getDepartments().size()];
            for (int i = 0; i < dataHandler.getDepartments().size(); i++) {
                departments[i] = dataHandler.getDepartments().get(i).getDesignation();
            }
            c.gridx = 1;
            c.gridy = 3;
            departmentComboBox = new JComboBox(departments);
            formPanel.add(departmentComboBox, c);

            String[] teams = new String[dataHandler.getTeams().size()];
            for (int i = 0; i < dataHandler.getTeams().size(); i++) {
                teams[i] = dataHandler.getTeams().get(i).getDesignation();
            }
            c.gridx = 1;
            c.gridy = 4;

            teamCombobox = new JComboBox(teams);
            formPanel.add(teamCombobox, c);

            btnPanel.add(saveBtn,BorderLayout.NORTH);

            createPersonPanel.add(formPanel,BorderLayout.NORTH);
            createPersonPanel.add(btnPanel,BorderLayout.CENTER);

            if(state == 2){
                c.gridx = 0;
                c.gridy = 5;
                formPanel.add(hrPersonLabel, c);

                c.gridx = 0;
                c.gridy = 6;
                formPanel.add(adminLabel, c);

                c.gridx = 1;
                c.gridy = 5;
                formPanel.add(hrPersonCheckbox, c);

                c.gridx = 1;
                c.gridy = 6;
                formPanel.add(adminCheckbox, c);

                tabbedPane.addTab("Stammdaten erfassen", masterDatePanel);
                departmentBtnPanel.add(addBtnDepartment);
                departmentBtnPanel.add(editBtnDepartment);
                departmentBtnPanel.add(deleteBtnDepartment);
                departmentCombobox = new JComboBox(departments);
                departmentInputPanel.add(departmentCombobox,BorderLayout.NORTH);
                departmentInputPanel.add(departmentBtnPanel,BorderLayout.CENTER);

                functionBtnPanel.add(addBtnFunction);
                functionBtnPanel.add(editBtnFunction);
                functionBtnPanel.add(deleteBtnFunction);
                functionCombobox = new JComboBox(functions);
                functionInputPanel.add(functionCombobox,BorderLayout.NORTH);
                functionInputPanel.add(functionBtnPanel,BorderLayout.CENTER);

                teamBtnPanel.add(addBtnTeam);
                teamBtnPanel.add(editBtnTeam);
                teamBtnPanel.add(deleteBtnTeam);
                teamCombobox = new JComboBox(teams);
                teamInputPanel.add(teamCombobox,BorderLayout.NORTH);
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
                    String firstName = (String) userList.getValueAt(viewRow, 0);
                    String lastName = (String) userList.getValueAt(viewRow, 1);
                    String function = (String) userList.getValueAt(viewRow, 2);
                    String department = (String) userList.getValueAt(viewRow,3);
                    String teams = (String) userList.getValueAt(viewRow, 4);
                    String permission = (String) userList.getValueAt(viewRow, 5);
                    //String permission = dataHandler.getPersons().get(viewRow).getPermission();
                    new PopOut(firstName, lastName,function,department,teams,permission,state);
                }
            }
        });
    }


}
