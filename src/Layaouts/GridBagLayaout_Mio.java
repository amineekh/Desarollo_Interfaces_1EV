package Layaouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBagLayaout_Mio extends JFrame implements ActionListener {
    private JPanel mainPanel;

    private JLabel  messageLabel;
    private static JButton boton1;
    private static JButton boton4;

    public GridBagLayaout_Mio(){

        mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.add(
                boton1= new JButton("Button 1"),
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
        boton1.addActionListener(this);

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
                boton4= new JButton("Long named button 4"),
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
             mainPanel.remove(boton4);
             JLabel messageLabel = new JLabel("Texto convertido por el botón 1");

            GridBagConstraints datos_boton4 = new GridBagConstraints();
            datos_boton4.gridx = 0;
            datos_boton4.gridy = 1;
            datos_boton4.gridwidth = 3;
            datos_boton4.gridheight = 1;
            datos_boton4.weightx = 1.0;
            datos_boton4.weighty = 4.0;
            datos_boton4.fill = GridBagConstraints.BOTH;
            datos_boton4.insets = new Insets(0, 0, 0, 0);
            mainPanel.add(messageLabel, datos_boton4);

             // Repintamos el panel para que se reflejen los cambios
             mainPanel.revalidate();
             mainPanel.repaint();


        }
    }

    public static void main(String[] args) {

        GridBagLayaout_Mio GridBagLayaout_Mio = new GridBagLayaout_Mio();
        GridBagLayaout_Mio.setBounds(0,0, 400,200);
        GridBagLayaout_Mio.setVisible(true);

        GridBagLayaout_Mio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}



