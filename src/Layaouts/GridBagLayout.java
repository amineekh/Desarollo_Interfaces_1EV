package Layaouts;

import javax.swing.*;
import java.awt.*;

public class GridBagLayout extends JFrame {

    private JPanel mainPanel;

    public GridBagLayout(){

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.GridBagLayout());
        mainPanel.add(
                new JButton("Button 1"),
                new GridBagConstraints(
                        0,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JButton("Button 2"),
                new GridBagConstraints(
                        1,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        add(mainPanel);

        mainPanel.add(
                new JButton("Button 3"),
                new GridBagConstraints(
                        2,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        add(mainPanel);

        mainPanel.add(
                new JButton("Long named button 4"),
                new GridBagConstraints(
                        0,
                        1,
                        3,
                        1,
                        1.0,
                        4.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        add(mainPanel);

        mainPanel.add(
                new JButton("5"),
                new GridBagConstraints(
                        1,
                        2,
                        2,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

    }


    public static void main(String[] args) {

        GridBagLayout baglayaout= new GridBagLayout();
        baglayaout.setBounds(0,0, 400,200);
        baglayaout.setVisible(true);


        baglayaout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}




