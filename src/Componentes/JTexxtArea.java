package Componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JTexxtArea {
    public static void main(String[] args) {

        // Crear un marco
        JFrame frame = new JFrame("Ejemplo JTextArea");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel es para mostar los datos en la interfz gráfica
        JLabel area_text = new JLabel("Introduce el texto");
        // Crear un área de texto
        JTextArea textArea = new JTextArea();
        textArea.setText("Este es un área de texto");

        JScrollPane scroll = new JScrollPane(textArea);

        // Agregar el área de texto al scroll
        frame.getContentPane().add(scroll);

        // Agregar el área de texto al marco
        frame.add(area_text, BorderLayout.WEST);

        // Establecer los márgenes del marco
        //frame.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Mostrar el marco
        frame.setVisible(true);

    }
}
