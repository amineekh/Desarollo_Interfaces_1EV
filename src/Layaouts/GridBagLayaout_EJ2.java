package Layaouts;

import javax.swing.*;
import java.awt.*;
import java.awt.GridBagLayout;

public class GridBagLayaout_EJ2 extends JFrame {

    public  GridBagLayaout_EJ2() {

        // Crear un panel principal con un diseño GridBagLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Agregar un JLabel "NOMBRE" al panel principal con restricciones específicas
        mainPanel.add(
                new JLabel("NOMBRE:"),
                new GridBagConstraints(
                        0,  0,  1,  1,  1.0,  0.5, // gridx, gridy, gridwidth, gridheight, weightx, weighty
                        GridBagConstraints.EAST,  // anchor
                        GridBagConstraints.CENTER, // fill
                        new Insets(10,0,0,10), // insets
                        0,
                        0
                ));
        add(mainPanel);

        // Agregar un JTextField al panel principal con restricciones específicas
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

        // Repetir el proceso para otros campos (Street, City, Zip Code, Address, Phone, Age)

        // Agregar un JLabel "Street" al panel principal con restricciones específicas
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

        // Agregar un JLabel "City" al panel principal con restricciones específicas
        mainPanel.add(
                new JLabel("City"),
                new GridBagConstraints(
                        2,  1,  1,  1,  1.0,  1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        // Agregar un JLabel "Zip Code" al panel principal con restricciones específicas
        mainPanel.add(
                new JLabel("Zip Code"),
                new GridBagConstraints(
                        3,  1,  1,  1,  1.0,  1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));
        add(mainPanel);

        // Agregar un JLabel "Address" al panel principal con restricciones específicas
        mainPanel.add(
                new JLabel("Address"),
                new GridBagConstraints(
                        0,  2,  1,  1,  1.0,  1.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        // Agregar un JTextField al panel principal con restricciones específicas
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

        // Agregar otro JTextField al panel principal con restricciones específicas
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

        // Agregar otro JTextField al panel principal con restricciones específicas
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

        // Agregar un JLabel "Phone" al panel principal con restricciones específicas
        mainPanel.add(
                new JLabel("Phone"),
                new GridBagConstraints(
                        0,  3,  1,  1,  1.0,  1.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        // Agregar un JTextField al panel principal con restricciones específicas
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

        // Agregar un JLabel "Age" al panel principal con restricciones específicas
        mainPanel.add(
                new JLabel("Age"),
                new GridBagConstraints(
                        2,  3,  1,  1,  1.0,  1.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,10),
                        0,
                        0
                ));
        add(mainPanel);

        // Agregar un JTextField al panel principal con restricciones específicas
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

        // Agregar un JLabel "Description" al panel principal con restricciones específicas
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

        // Agregar un JTextField grande al panel principal para la descripción con restricciones específicas
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

        // Agregar un JButton "Submit" al panel principal con restricciones específicas
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

        // Crear una instancia de la clase GridBagLayaout_EJ2
        GridBagLayaout_EJ2 tabla = new GridBagLayaout_EJ2();

        // Establecer la posición y el tamaño de la ventana
        tabla.setBounds(100, 100, 400, 300);

        // Hacer visible la ventana
        tabla.setVisible(true);

        // Establecer la operación predeterminada al cerrar la ventana
        tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

