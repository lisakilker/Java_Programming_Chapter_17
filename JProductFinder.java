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
public class JProductFinder extends JApplet implements ActionListener {

    String productDescription;
    String productPrice;

    String productNumberArray[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String productDescriptionArray[] = {"Hand Soap", "Shampoo", "Conditioner", "Toothpaste", "Mouthwash", "Deodorant", "Coconut Oil", "Argan Oil", "Q-Tips"};
    String productPriceArray[] = {".89", "3.99", "2.99", "1.99", "2.49", "3.59", "1.39", "8.99", ".99"};

    JLabel headerLabel = new JLabel("Please enter the product number:");
    JLabel productDescriptionLabel = new JLabel();
    JLabel productPriceLabel = new JLabel();
    JLabel messageLabel = new JLabel();
    JTextField productNumberTextField = new JTextField(4);
    JButton submitButton = new JButton("Lookup");

    public void init() {
        setLayout(new FlowLayout());
        setSize(400, 200);

        add(headerLabel);
        add(productNumberTextField);
        add(submitButton);
        add(messageLabel);
        add(productDescriptionLabel);
        add(productPriceLabel);

        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        try {
            int productNumberInt = Integer.parseInt(productNumberTextField.getText());

            if (source == submitButton) {
                for (int i = 0; i < productNumberArray.length; i++) {
                    if (productNumberTextField.getText().equals(productNumberArray[i])) {
                        productDescriptionLabel.setText(productDescriptionArray[i]);
                        productPriceLabel.setText("$" + productPriceArray[i]);
                        messageLabel.setText("Product found!");
                        return;

                    } else {
                        messageLabel.setText("That is not a valid item number.");
                    }
                }
            }

        } catch (Exception ex) {
            messageLabel.setText("Invalid entry!");
        }
    }
}
