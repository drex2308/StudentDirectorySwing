import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.util.ArrayList;
import java.util.List;
/**
 * Program for a student directory GUI application.
 * @author DHANUSH VENKATARAMU.
 */
public final class DirectoryDriver {
    /**
     * Reference to the add button.
     */
    private JButton addButton;
    /**
     * Reference to the delete button.
     */
    private JButton delButton;
    /**
     * Reference to the id search button.
     */
    private JButton idButton;
    /**
     * Reference to the fName search button.
     */
    private JButton fNameButton;
    /**
     * Reference to the lName search button.
     */
    private JButton lNameButton;
    /**
     * Reference to the andrew id text field.
     */
    private JTextField idField;
    /**
     * Reference to the firstname text field.
     */
    private JTextField fField;
    /**
     * Reference to the lastname id text field.
     */
    private JTextField lField;
    /**
     * Reference to the phone number text field.
     */
    private JTextField phoneField;
    /**
     * Reference to the delete andrew id text field.
     */
    private JTextField delField;
    /**
     * Reference to the search andrew text field.
     */
    private JTextField searchField;
    /**
     * Reference to the results text area.
     */
    private JTextArea resultArea;
    /**
     * Reference to the application directory static variable.
     */
    private static  Directory appDirectory = new Directory();
    /**
     * Constructor where JFrame and other components are instantiated.
     */
    private DirectoryDriver() {
        JFrame frame = new JFrame("Student Directory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel addStudent = new JPanel();
        addStudent.setBorder(new TitledBorder("Add a new student"));
        addStudent.add(getLabel("First Name: ", c, 0, 0), c);
        fField = getTextField(c, 0, 1);
        addStudent.add(fField, c);
        addStudent.add(getLabel("Last Name: ", c, 3, 0), c);
        lField = getTextField(c, 4, 0);
        addStudent.add(lField, c);
        addStudent.add(getLabel("Andrew ID: ", c, 5, 0), c);
        idField = getTextField(c, 6, 0);
        addStudent.add(idField, c);
        addStudent.add(getLabel("Phone Number: ", c, 7, 0), c);
        phoneField = getTextField(c, 8, 0);
        addStudent.add(phoneField, c);
        addButton = getButton("Add", c, 9, 0);
        addStudent.add(addButton, c);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() != addButton) {
                    System.out.println("Somethings wrong, check !");
                    return;
                }
                addStudentFunc(idField.getText(), fField.getText(), lField.getText(), phoneField.getText());
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        pane.add(addStudent, c);

        JPanel delStudent = new JPanel();
        delStudent.setBorder(new TitledBorder("Delete a student"));
        delStudent.add(getLabel("Andrew ID: ", c, 0, 0));
        delField = getTextField(c, 1, 0);
        delStudent.add(delField, c);
        delButton = getButton("Delete", c, 2, 0);
        delStudent.add(delButton, c);
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() != delButton) {
                    System.out.println("Somethings wrong, check!");
                    return;
                }
                delStudent(delField.getText());
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(delStudent, c);

        JPanel searchStudent = new JPanel();
        searchStudent.setBorder(new TitledBorder("Search student(s)"));
        searchStudent.add(getLabel("Search Key: ", c, 0, 0));
        searchField = getTextField(c, 1, 0);
        searchField.addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchFunc("andrewID", searchField.getText());
                    return;
                }
            }
        });
        searchStudent.add(searchField);
        idButton = getButton("By Andrew ID", c, 2, 0);
        idButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() != idButton) {
                    System.out.println("Somthings worng, check!");
                    return;
                }
                searchFunc("andrewID", searchField.getText());
            }
        });
        searchStudent.add(idButton, c);
        fNameButton = getButton("By First Name", c, 3, 0);

        fNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() != fNameButton) {
                    System.out.println("Somthings worng, check!");
                    return;
                }
                searchFunc("firstName", searchField.getText());
            }
        });
        searchStudent.add(fNameButton, c);
        lNameButton = getButton("By Last Name", c, 4, 0);

        lNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() != lNameButton) {
                    System.out.println("Somthings worng, check!");
                    return;
                }
                searchFunc("lastName", searchField.getText());
            }
        });
        searchStudent.add(lNameButton, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(searchStudent, c);

        JPanel results = new JPanel();
        results.setBorder(new TitledBorder("Results"));
        resultArea = new JTextArea(30, 60);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
        JScrollPane scroller = new JScrollPane(resultArea);
        results.add(scroller);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(results, c);

        frame.setContentPane(pane);
        frame.setVisible(true);
        frame.pack();
        searchField.requestFocusInWindow();
    }
 /**
 * static method getLabel to get labels with specific text.
 * @param display string to be displayed.
 * @param c constarints for the label.
 * @param x location row.
 * @param y location y.
 * @return label the created label to be returned.
 */
    private static JLabel getLabel(String display, GridBagConstraints c, int x, int y) {
        JLabel label = new JLabel(display);
        Font labelFont  = new Font(Font.SERIF, Font.PLAIN, 15);
        c.anchor = GridBagConstraints.EAST;
        c.gridx = x;
        c.gridy = y;
        label.setFont(labelFont);
        return label;
    }
/**
 * static method gettextField to get text field with specific text.
 * @param c constarints for the label.
 * @param x location row.
 * @param y location y.
 * @return textfield the created textfield to be returned.
 */
    private static JTextField getTextField(GridBagConstraints c, int x, int y) {
        JTextField field = new JTextField();
        Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        field.setFont(textFont);
        field.setColumns(10);
        field.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        c.gridx = x;
        c.gridy = y;
        return field;
    }
/**
 * static method getButton to get buttons with specific text.
 * @param display String to be on button.
 * @param c constarints for the button.
 * @param x location row.
 * @param y location y.
 * @return textfield the created button to be returned.
 */
    private static JButton getButton(String display, GridBagConstraints c, int x, int y) {
        JButton button = new JButton(display);
        Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        button.setFont(textFont);
        c.ipadx = 5;
        c.ipady = 5;
        c.weightx = 10;
        c.weighty = 10;
        c.gridx = x;
        c.gridy = y;
        return button;
    }
/**
 * static method validateField to validate field.
 * @param str field to be validated.
 * @return false if validation fails or true vice versa.
 */
    private static boolean validateField(String str) {
        if (str.equals("")) {
             return false;
        }
        return true;
    }
/**
 * instance method addStudentFunc to add students by user.
 * @param andrewid field to be validated and added.
 * @param fname field to be validated and added.
 * @param lname field to be validated and added.
 * @param phone field to be validated and added.
 */
    private void addStudentFunc(String andrewid, String fname, String lname, String phone) {
        try {
        if (!validateField(fField.getText())) {
            resultArea.setText("");
            resultArea.append("First name missing to add student\n");
            return;
        }
        if (!validateField(lField.getText())) {
            resultArea.setText("");
            resultArea.append("Last name missing to add student\n");
            return;
        }
        if (!validateField(idField.getText())) {
            resultArea.setText("");
            resultArea.append("Andrew ID missing to add student\n");
            return;
        }
        Student s = new Student(andrewid, fname, lname, phone);
        appDirectory.addStudent(s);
        resultArea.append(new StringBuilder().append("New entry was added: ")
                                             .append(s.toString())
                                             .append("\n")
                                             .toString());
        idField.setText("");
        fField.setText("");
        lField.setText("");
        phoneField.setText("");
        return;

        } catch (IllegalArgumentException e) {
            resultArea.setText("");
            resultArea.append("Data already contains an entry for this Andrew ID\n");
            return;
        }
    }
/**
 * instance method addStudentFunc to add students by user.
 * @param delID field to be validated and instance deleted.
 */
    private void delStudent(String delID) {
        if (!validateField(delID)) {
            resultArea.setText("");
            resultArea.append("Andrew ID missing to delete student\n");
            return;
        }
        if (appDirectory.searchByAndrewId(delID) == null) {
            resultArea.append(new StringBuilder().append("Student Entry not found for Andrew ID: ")
                                                 .append(delID)
                                                 .append("\n")
                                                 .toString());
            return;
        }
        resultArea.append(new StringBuilder().append("Student entry deleted: ")
                                             .append(appDirectory.searchByAndrewId(delID).toString())
                                             .append("\n")
                                             .toString());
        appDirectory.deleteStudent(delID);
        delField.setText("");
        return;
    }
/**
 * helper method to help searchFunc to display lists.
 * @param resArray field with result data.
 */
    private void listDisplay(List<Student> resArray) {
        for (Student s : resArray) {
            resultArea.append(new StringBuilder().append(s.toString())
                                                 .append("\n")
                                                 .toString());
        }
        searchField.setText("");
        return;
    }
/**
 * instance method searchFunc to search students by user key.
 * @param key field to be validated and used for search.
 * @param type field specifying last or first name search.
 */
    private void searchFunc(String type, String key) {
        if (!validateField(key)) {
            resultArea.setText("");
            resultArea.append("Key missing to search student\n");
            return;
        }
        if (type.equals("andrewID")) {
            Student res = appDirectory.searchByAndrewId(key);
            if (res == null) {
            resultArea.append(new StringBuilder().append("Student Entry not found for Andrew ID: ")
                                                 .append(key)
                                                 .append("\n")
                                                 .toString());
            return;
            }
            List<Student> resArray = new ArrayList<Student>();
            resArray.add(res);
            listDisplay(resArray);
            return;
        }
        if (type.equals("lastName")) {
            List<Student> resArray = appDirectory.searchByLastName(key);
            if (resArray.size() == 0) {
            resultArea.append(new StringBuilder().append("Student Entry not found for Last Name: ")
                                                 .append(key)
                                                 .append("\n")
                                                 .toString());
            return;
            }
            listDisplay(resArray);
            return;
        }
        List<Student> resArray = appDirectory.searchByFirstName(key);
        if (resArray.size() == 0) {
        resultArea.append(new StringBuilder().append("Student Entry not found for First Name: ")
                                             .append(key)
                                             .append("\n")
                                             .toString());
        return;
        }
        listDisplay(resArray);
        return;
    }
/**
 * static method loadData for class DirectoryDriver.
 * @param filename csv file with student info to be loaded.
 * @param d1 Directory refernce for created students to be added.
 */
    private static void loadData(String filename, Directory d1) {
        try {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        boolean eof = false;           //this part of code is from Professor Eppinger.
        while (!eof) {                 //this part of code is from Professor Eppinger.
            String line = br.readLine();
            if (line == null) {        //this part of code is from Professor Eppinger.
                eof = true;            //this part of code is from Professor Eppinger.
                continue;              //this part of code is from Professor Eppinger.
            }
            String[] values = line.split(",");
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].replaceAll("\"", "");
            }
            if (values[2].equals("Andrew ID")) {
                continue;
            }
            if (values.length == 3) {
                Student s = new Student(values[2], values[0], values[1], "");
                d1.addStudent(s);
                continue;
            }
            Student s = new Student(values[2], values[0], values[1], values[3]);
            d1.addStudent(s);
        }
        br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " was not found");
        } catch (IOException e) {
            System.out.println();
            System.out.println("IOException!");
        }
    }

/**
 * Main Maethod for DirectoryDriver class.
 * @param args Specifies command line arguments.
 */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("A program for Student Directory GUI application.");
            System.out.println("Usage: java DirectoryDriver filename(csv)");
            return;
        }
        loadData(args[0], appDirectory);
        new DirectoryDriver();
    }
}
