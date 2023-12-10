package Primeros_Ejercicios;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Segunda_Ventana {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ejemplo de Panel con Imagen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);

        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setBounds(125, 250, 488, 460);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(700, 250, 488, 460);

        // Carga una imagen desde un archivo (asegúrate de que la ruta sea correcta)
        ImageIcon imagen = new ImageIcon("C:\\Users\\MohamedAmineElkhayya\\Desktop\\ronaldo.jpg");

        // Crea un JLabel para mostrar la imagen
        JLabel label = new JLabel(imagen);

        // Establece la posición y el tamaño del JLabel en el panel
        label.setBounds(0, 0, 450, 450);

        // Agrega el JLabel al panel verde
        panel.add(label);

        frame.add(panel);
        frame.add(bluePanel);
        frame.setVisible(true);


        // EJEMPLO 2
        JFrame f = new JFrame("Ejemplo de Panel con Imagen");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);

        // Crea un JPanel
        JPanel p = new JPanel();

        // Carga una imagen desde un archivo (asegúrate de que la ruta sea correcta)
        ImageIcon img = new ImageIcon("C:\\Users\\MohamedAmineElkhayya\\Desktop\\ronaldo.jpg");

        // Crea un JLabel para mostrar la imagen
        JLabel label2 = new JLabel(imagen);

        // Agrega el JLabel al JPanel
        p.add(label2);

        // Agrega el JPanel al JFrame
        f.add(p);

        // Haz visible el JFrame
        f.setVisible(true);


    }


}





