/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W6HW;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JApplet;

/**
 *
 * @author Lisa
 */
public class JCarlys extends JApplet {

    Image image;
    AudioClip sound;
    String logo = "Carly's Catering";
    String motto = "It's a piece of cake!";

    public void init() {
        setSize(500, 360);
        getContentPane().setBackground(Color.DARK_GRAY);
        image = getImage(getCodeBase(), "W6HW\\restaurantGif.gif");
        sound = getAudioClip(getCodeBase(), "W6HW\\restaurantSound.au");
    }

    public void start() {
        sound.loop();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Font logoFont = new Font("Arial", Font.PLAIN, 30);
        Font mottoFont = new Font("Arial", Font.ITALIC, 14);

        GradientPaint gp = new GradientPaint(100, 70, new Color(68, 255, 245), 150, 150, new Color(68, 117, 255), true);
        g2D.setPaint(gp);
        g2D.setFont(logoFont);
        g2D.drawString(logo, 130, 44);

        g2D.setPaint(new Color(68, 255, 245));
        g2D.setFont(mottoFont);
        g2D.drawString(motto, 195, 60);

        g.drawImage(image,0,80,this);
    }
}
