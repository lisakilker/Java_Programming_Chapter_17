/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W6HW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lisa
 */
public class FinalProject extends JFrame implements ActionListener, KeyListener {

    Path contactsFile;
    String contactData = "";
    String delimiter = ",";
    int zip = 0;
    int phone = 0;

    Container con = getContentPane();

    GridLayout mainGrid = new GridLayout(7, 1);
    GridLayout headerGrid = new GridLayout(1, 1);

    JPanel headerPanel = new JPanel();
    JPanel namePanel = new JPanel();
    JPanel addressPanel = new JPanel();
    JPanel cityStateZipPanel = new JPanel();
    JPanel zipPhonePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JPanel messagePanel = new JPanel();

    JLabel headerLabel = new JLabel();
    JLabel firstNameLabel = new JLabel("First Name");
    JLabel lastNameLabel = new JLabel("Last Name");
    JLabel addressLabel = new JLabel("Address");
    JLabel cityLabel = new JLabel("City");
    JLabel stateLabel = new JLabel("State");
    JLabel zipLabel = new JLabel("Zip");
    JLabel phoneLabel = new JLabel("Phone");
    JLabel messageLabel = new JLabel("Enter first name to search");

    JTextField firstNameTextField = new JTextField(14);
    JTextField lastNameTextField = new JTextField(14);
    JTextField addressTextField = new JTextField(25);
    JTextField cityTextField = new JTextField(12);
    JTextField stateTextField = new JTextField(4);
    JTextField zipTextField = new JTextField(8);
    JTextField phoneTextField = new JTextField(15);

    JButton findButton = new JButton("Find");
    JButton addButton = new JButton("Add");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");

    public FinalProject() {
        super("Lisa's Contacts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            contactsFile = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W6HW\\FinalProject.txt");
        } catch (Exception e) {
            messageLabel.setText("Error with file!");
        }

        con.setLayout(mainGrid);

        headerPanel.add(headerLabel);
        headerPanel.setLayout(headerGrid);
        con.add(headerPanel);

        namePanel.add(firstNameLabel);
        namePanel.add(firstNameTextField);
        namePanel.add(lastNameLabel);
        namePanel.add(lastNameTextField);
        con.add(namePanel);

        addressPanel.add(addressLabel);
        addressPanel.add(addressTextField);
        con.add(addressPanel);

        cityStateZipPanel.add(cityLabel);
        cityStateZipPanel.add(cityTextField);
        cityStateZipPanel.add(stateLabel);
        cityStateZipPanel.add(stateTextField);
        con.add(cityStateZipPanel);

        zipPhonePanel.add(zipLabel);
        zipPhonePanel.add(zipTextField);
        zipPhonePanel.add(phoneLabel);
        zipPhonePanel.add(phoneTextField);
        con.add(zipPhonePanel);

        buttonsPanel.add(addButton);
        buttonsPanel.add(findButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(clearButton);
        con.add(buttonsPanel);

        messagePanel.add(messageLabel);
        con.add(messagePanel);

        findButton.addActionListener(this);
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        addKeyListener(this);
        stateTextField.addKeyListener(this);
        zipTextField.addKeyListener(this);
        phoneTextField.addKeyListener(this);

        headerPanel.setBackground(new Color(253, 125, 212));
        namePanel.setBackground(new Color(255, 143, 142));
        addressPanel.setBackground(new Color(254, 154, 95));
        cityStateZipPanel.setBackground(new Color(255, 175, 0));
        zipPhonePanel.setBackground(new Color(254, 184, 0));
        buttonsPanel.setBackground(new Color(186, 188, 52));
        messagePanel.setBackground(new Color(41, 186, 231));
        findButton.setBackground(new Color(39, 55, 70));
        addButton.setBackground(new Color(39, 55, 70));
        updateButton.setBackground(new Color(39, 55, 70));
        deleteButton.setBackground(new Color(39, 55, 70));
        clearButton.setBackground(new Color(39, 55, 70));

        findButton.setForeground(Color.WHITE);
        addButton.setForeground(Color.WHITE);
        updateButton.setForeground(Color.WHITE);
        deleteButton.setForeground(Color.WHITE);
        clearButton.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.WHITE);

        headerLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        firstNameLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        lastNameLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        addressLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        cityLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        stateLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        zipLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        phoneLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        messageLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        firstNameTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        lastNameTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        addressTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        cityTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        stateTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        zipTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        phoneTextField.setFont(new Font("Courier New", Font.PLAIN, 15));
        findButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        addButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        updateButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        deleteButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        clearButton.setFont(new Font("Courier New", Font.PLAIN, 15));
    }

    public void paint(Graphics g) {
        super.paint(g);
        FinalProjectLogoPanel logo = new FinalProjectLogoPanel();
        logo.paint(g);
    }

    public static void main(String[] args) {
        FinalProject finalProject = new FinalProject();
        finalProject.setSize(485, 310);
        finalProject.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (stateTextField.getText().length() < 2 || stateTextField.getText().length() >= 2) {
            messageLabel.setText("The state must be 2 characters!");
        }

        if (zipTextField.getText().length() < 5 || zipTextField.getText().length() >= 5) {
            messageLabel.setText("The zip must be 5 characters!");
        }

        if (phoneTextField.getText().length() < 10 || phoneTextField.getText().length() >= 10) {
            messageLabel.setText("Phone must be 10 digits!");
        }

        try {
            zip = Integer.parseInt(zipTextField.getText());
        } catch (NumberFormatException e1) {
            messageLabel.setText("Zip should be digits only!");
            zipTextField.setText("");
        }

        try {
            phone = Integer.parseInt(phoneTextField.getText());
        } catch (NumberFormatException e2) {
            messageLabel.setText("Phone should be digits only!");
            phoneTextField.setText("");
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        String contactData;

        contactsFile = Paths.get("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W6HW\\FinalProject.txt");

        if (source == addButton) {
            if (stateTextField.getText().length() > 2 || stateTextField.getText().length() < 2 || zipTextField.getText().length() > 5 || zipTextField.getText().length() < 5 || phoneTextField.getText().length() > 10 || phoneTextField.getText().length() < 10) {
                messageLabel.setText("Check your data!");
                stateTextField.setText("");
                zipTextField.setText("");
                phoneTextField.setText("");

            } else {
                try {
                    OutputStream output = new BufferedOutputStream(Files.newOutputStream(contactsFile, APPEND));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

                    contactData = firstNameTextField.getText() + delimiter + lastNameTextField.getText() + delimiter + addressTextField.getText() + delimiter + cityTextField.getText() + delimiter + stateTextField.getText() + delimiter + zipTextField.getText() + delimiter + phoneTextField.getText() + System.getProperty("line.separator");
                    writer.write(contactData, 0, contactData.length());
                    firstNameTextField.setText("");
                    lastNameTextField.setText("");
                    addressTextField.setText("");
                    cityTextField.setText("");
                    stateTextField.setText("");
                    zipTextField.setText("");
                    phoneTextField.setText("");
                    messageLabel.setText("Added!");

                    writer.close();

                } catch (Exception e) {
                    messageLabel.setText("Error!");
                }
            }
        }

        if (source == findButton) {
            try {
                InputStream input = new BufferedInputStream(Files.newInputStream(contactsFile));
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                Scanner line = null;
                line = new Scanner(contactsFile);

                while (line.hasNext()) {
                    String readLine = line.nextLine();
                    String[] output = readLine.split(",");

                    if (readLine.contains(firstNameTextField.getText())) {
                        firstNameTextField.setText(output[0]);
                        lastNameTextField.setText(output[1]);
                        addressTextField.setText(output[2]);
                        cityTextField.setText(output[3]);
                        stateTextField.setText(output[4]);
                        zipTextField.setText(output[5]);
                        phoneTextField.setText(output[6]);
                        messageLabel.setText("Contact found!");
                        return;
                    } else {
                        messageLabel.setText("Contact does not exist yet!");
                    }
                    reader.close();
                }

            } catch (IOException ex) {
                messageLabel.setText("Error!");
            }
        }

        if (source == updateButton) {
            contactData = firstNameTextField.getText() + delimiter + lastNameTextField.getText() + delimiter + addressTextField.getText() + delimiter + cityTextField.getText() + delimiter + stateTextField.getText() + delimiter + zipTextField.getText() + delimiter + phoneTextField.getText() + System.getProperty("line.separator");

            try {
                File fileToBeModified = new File("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W6HW\\FinalProject.txt");

                String oldContent = "";
                BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
                String line = reader.readLine();

                while (line != null) {
                    oldContent = oldContent + line + System.lineSeparator();
                    line = reader.readLine();
                }
                String firstNameSearched = oldContent.replaceAll(firstNameTextField.getText(), " ");
                FileWriter writer = new FileWriter(fileToBeModified);
                writer.write(firstNameSearched);
                writer.write(contactData);
                reader.close();
                writer.close();

                firstNameTextField.setText("");
                lastNameTextField.setText("");
                addressTextField.setText("");
                cityTextField.setText("");
                stateTextField.setText("");
                zipTextField.setText("");
                phoneTextField.setText("");
                messageLabel.setText("Updated!");

            } catch (IOException ex) {
                messageLabel.setText("Error!");
            }
        }

        if (source == deleteButton) {
            try {
                File fileToBeModified = new File("C:\\Users\\lisak\\OneDrive\\Documents\\NetBeansProjects\\CIS_210_M5_2017_HW\\src\\W6HW\\FinalProject.txt");

                String oldContent = "";
                BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
                String line = reader.readLine();

                while (line != null) {
                    oldContent = oldContent + line + System.lineSeparator();
                    line = reader.readLine();
                }
                String firstNameDeleted = oldContent.replaceAll(firstNameTextField.getText(), " ");
                FileWriter writer = new FileWriter(fileToBeModified);
                writer.write(firstNameDeleted);
                reader.close();
                writer.close();

                firstNameTextField.setText("");
                lastNameTextField.setText("");
                addressTextField.setText("");
                cityTextField.setText("");
                stateTextField.setText("");
                zipTextField.setText("");
                phoneTextField.setText("");
                messageLabel.setText("Deleted!");

            } catch (IOException ex) {
                messageLabel.setText("Error!");
            }
        }

        if (source == clearButton) {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            addressTextField.setText("");
            cityTextField.setText("");
            stateTextField.setText("");
            zipTextField.setText("");
            phoneTextField.setText("");
            messageLabel.setText("");
        }
    }
}
