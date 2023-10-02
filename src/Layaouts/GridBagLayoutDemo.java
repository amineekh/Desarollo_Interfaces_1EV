package Layaouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBagLayoutDemo extends JFrame {

    private JPanel mainPanel;
    private JButton button1;
    private JButton button4;

    public GridBagLayoutDemo() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.GridBagLayout());

        button1 = new JButton("Button 1");
        button4 = new JButton("Long named button 4");

        GridBagConstraints gbcButton1 = new GridBagConstraints();
        gbcButton1.gridx = 0;
        gbcButton1.gridy = 0;
        gbcButton1.gridwidth = 1;
        gbcButton1.gridheight = 1;
        gbcButton1.weightx = 1.0;
        gbcButton1.weighty = 1.0;
        gbcButton1.fill = GridBagConstraints.BOTH;
        gbcButton1.insets = new Insets(0, 0, 0, 0);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Elimina el botón 4
                mainPanel.remove(button4);

                // Agrega un JLabel con el mensaje en lugar del botón 4
                JLabel messageLabel = new JLabel("Texto convertido por el botón 1");
                GridBagConstraints gbcMessageLabel = new GridBagConstraints();
                gbcMessageLabel.gridx = 0;
                gbcMessageLabel.gridy = 1;
                gbcMessageLabel.gridwidth = 3;
                gbcMessageLabel.gridheight = 1;
                gbcMessageLabel.weightx = 1.0;
                gbcMessageLabel.weighty = 4.0;
                gbcMessageLabel.fill = GridBagConstraints.BOTH;
                gbcMessageLabel.insets = new Insets(0, 0, 0, 0);
                mainPanel.add(messageLabel, gbcMessageLabel);

                // Repintamos el panel para que se reflejen los cambios
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        mainPanel.add(button1, gbcButton1);

        GridBagConstraints gbcButton4 = new GridBagConstraints();
        gbcButton4.gridx = 0;
        gbcButton4.gridy = 1;
        gbcButton4.gridwidth = 3;
        gbcButton4.gridheight = 1;
        gbcButton4.weightx = 1.0;
        gbcButton4.weighty = 4.0;
        gbcButton4.fill = GridBagConstraints.BOTH;
        gbcButton4.insets = new Insets(0, 0, 0, 0);

        mainPanel.add(button4, gbcButton4);

        // Agregar otros botones sin cambios
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

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridBagLayoutDemo();
            }
        });
    }
}
