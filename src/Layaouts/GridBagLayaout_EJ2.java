package Layaouts;

import javax.swing.*;
import java.awt.*;
import java.awt.GridBagLayout;

public class GridBagLayaout_EJ2 extends JFrame{

    public  GridBagLayaout_EJ2(){

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        mainPanel.add(
                new JLabel("NOMBRE:"),

                new GridBagConstraints(
                        0,  0,  1,  1,  1.0,  0.5,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(10,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JTextField(),

                new GridBagConstraints(
                        1,  0,  3,  1,  1.0,  1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(10,0,0,20),
                        0,
                        0

                ));


        add(mainPanel);



        mainPanel.add(
                new JLabel("Street"),

                new GridBagConstraints(
                        1,  1,  1, 1,  1.0, 1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JLabel("city"),

                new GridBagConstraints(
                        2,  1,  1,  1,  1.0,  1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JLabel("zip code"),

                new GridBagConstraints(
                        3,  1,  1,  1,  1.0,  1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JLabel("addres"),

                new GridBagConstraints(
                        0,  2,  1,  1,  1.0,  1.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JTextField(),
                new GridBagConstraints(
                        1,  2,  1,  1,  1.0,  1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);
        mainPanel.add(
                new JTextField(),
                new GridBagConstraints(
                        2,  2,  1,  1,  1.0,  1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);
        mainPanel.add(
                new JTextField(),
                new GridBagConstraints(
                        3,  2,  1,  1,  1.0,  1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,20),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JLabel("phone"),

                new GridBagConstraints(
                        0,  3,  1,  1,  1.0,  1.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JTextField(),
                new GridBagConstraints(
                        1,  3,  1,  1,  1.0,  1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JLabel("age"),

                new GridBagConstraints(
                        2,  3,  1,  1,  1.0,  1.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JTextField(),
                new GridBagConstraints(
                        3,  3,  1,  1,  1.0,  1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,20),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JLabel("Description"),

                new GridBagConstraints(
                        0,  4,  1,  1,  1.0,  1.0,
                        GridBagConstraints.NORTHEAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        mainPanel.add(
                new JTextField(),
                new GridBagConstraints(
                        1,  4,  3,  3,  1.0,  80.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,20),
                        0,
                        0
                ));
        add(mainPanel);


        mainPanel.add(
                new JButton("Submit"),
                new GridBagConstraints(
                        2, 8, 2, 1, 1.0, 1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,10,20),
                        0,
                        0
                ));


    }

    public static void main(String[] args) {

        GridBagLayaout_EJ2 tabla= new GridBagLayaout_EJ2();
        tabla.setBounds(100,100, 400,300);
        tabla.setVisible(true);
        tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
