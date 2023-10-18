package Componentes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JPaswordField {
    public static void main(String[] args) {

        // Crear un marco
        JFrame frame = new JFrame("Ejemplo JPasswordField");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // // Crear etiquetas y campos de texto
       // JLabel es para mostar los datos en la interfz gráfica
        JLabel pass = new JLabel("PASSWORD:");


        // Crear un campo de contraseña
        JPasswordField passwordField = new JPasswordField(10);

        // Agregar el campo de contraseña al marco
        frame.add(pass, BorderLayout.WEST);
        frame.add(passwordField, BorderLayout.CENTER);


        // Mostrar el marco

        frame.setVisible(true);
    }
}
