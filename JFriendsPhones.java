/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W6HW;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Lisa
 */
public class JFriendsPhones extends JApplet implements ActionListener {

    String nameArray[] = {"Jamie", "Cersei", "Arya", "Sansa", "Jon", "Tyrian"};
    String phoneArray[] = {"334-333-3334", "444-332-5332", "334-555-2453", "434-322-3347", "487-413-7777", "874-223-4400"};

    JLabel headerLabel = new JLabel("Please enter the name or phone number of your friend:");
    JLabel nameLabel = new JLabel("Name:");
    JLabel phoneLabel = new JLabel("Phone:");
    JLabel messageLabel = new JLabel();
    JTextField nameTextField = new JTextField(10);
    JTextField phoneTextField = new JTextField(10);
    JButton submitButton = new JButton("Lookup");

    public void init() {
        setLayout(new FlowLayout());
        setSize(350, 200);

        add(headerLabel);
        add(nameLabel);
        add(nameTextField);
        add(phoneLabel);
        add(phoneTextField);
        add(submitButton);
        add(messageLabel);

        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == submitButton) {
            try {
                for (int i = 0; i < phoneArray.length; i++) {
                    if (nameTextField.getText().equalsIgnoreCase(nameArray[i])) {
                        phoneTextField.setText(phoneArray[i]);
                        messageLabel.setText("Contact Found!");
                        return;
                    }
                    
                    if (phoneTextField.getText().equals(phoneArray[i])) {
                        nameTextField.setText(nameArray[i]);
                        messageLabel.setText("Contact Found!");
                        return;
                        
                    } else {
                        messageLabel.setText("Contain not found!");
                    }
                }
                
            } catch (Exception e) {
                messageLabel.setText("Invalid entry!");
            }
        }
    }
}
