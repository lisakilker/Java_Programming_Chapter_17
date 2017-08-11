/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W6HW;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import javax.swing.JFrame;

/**
 *
 * @author Lisa
 */
public class FinalProjectLogoPanel extends JFrame {
    String logo = "**Lisa's Contacts**";

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        
        Font logoFont = new Font("Courier New", Font.BOLD, 30);
       
        GradientPaint gp = new GradientPaint(100, 70, new Color(77,40,201), 150, 150, new Color(66, 146, 244), true);
        g2D.setPaint(gp);
        g2D.setFont(logoFont);
        g2D.drawString(logo, 65, 60);
    }
}
