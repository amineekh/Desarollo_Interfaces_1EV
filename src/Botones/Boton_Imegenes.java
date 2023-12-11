package Botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton_Imegenes extends JFrame {
    // Declaración de componentes (botones, etiqueta y panel principal)
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel imagenLabel;
    private JPanel mainPanel;

    // Constructor de la clase
    public Boton_Imegenes() {
        // ActionListener para el botón 1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar y mostrar la imagen 1 cuando se presiona el botón 1
                ImageIcon image = new ImageIcon("src\\Botones\\img4.jpeg");
                imagenLabel.setIcon(image);
            }
        });

        // ActionListener para el botón 2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar y mostrar la imagen 2 cuando se presiona el botón 2
                ImageIcon image = new ImageIcon("src\\Botones\\img3.jpeg");
                imagenLabel.setIcon(image);
            }
        });

        // ActionListener para el botón 3
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar y mostrar la imagen 3 cuando se presiona el botón 3
                ImageIcon image = new ImageIcon("src\\Botones\\img3.jpeg");
                imagenLabel.setIcon(image);
            }
        });

        // ActionListener para el botón 4
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar y mostrar la imagen 4 cuando se presiona el botón 4
                ImageIcon image = new ImageIcon("src\\Botones\\img4.jpeg");
                imagenLabel.setIcon(image);
            }
        });
    }

    // Método principal (main) para ejecutar la aplicación
    public static void main(String[] args) {
        // Crear una instancia del JFrame y configurar sus propiedades
        JFrame frame = new JFrame("Boton_Imegenes");
        // Configurar el contenido principal del JFrame con el panel principal de la instancia de Boton_Imegenes
        frame.setContentPane(new Boton_Imegenes().mainPanel);
        // Establecer la operación por defecto al cerrar el JFrame cuando se presiona el botón de cerrar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 600, 600); // Establecer el tamaño y la posición
        frame.setVisible(true); // Hacer visible el JFrame
    }
}
