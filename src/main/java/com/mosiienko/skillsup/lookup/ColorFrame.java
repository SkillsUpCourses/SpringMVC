package com.mosiienko.skillsup.lookup;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Class {@link ColorFrame
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 08.12.15
 */
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(600));
        Color color = setColor();
        getContentPane().setBackground(color);
        repaint();
    }

    /** This method will be overridden (equivalent xml - lookup-method or replace-method)
     *
     * @return
     */
    public abstract Color setColor();
}
