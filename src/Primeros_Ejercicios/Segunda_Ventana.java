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

        /*
        JFrame f=new JFrame();
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(200,150,500,250);
        JButton boton1=new JButton("Boton 1");
        JButton boton2=new JButton("Boton 2");
        JButton boton3=new JButton("Boton 3");

        f.add(boton1);
        p1.add(boton2);
        p2.add(boton3);

        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.red);

        f.add(boton1);
        f.add(boton2);
        f.add(boton3);

        //f.setLayout(new FlowLayout);
        //f.setLayout(new

        f.setVisible(true);

     */
    }


}





