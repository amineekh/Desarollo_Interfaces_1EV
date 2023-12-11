package Boton_Cambia_Imagenes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarImagenBotones_GUIForm {
    private JButton boton1;
    private JButton boton2;
    private JButton boton4;
    private JButton boton3;
    private JLabel imagenLabel;
    private JPanel mainPanel;

    public CambiarImagenBotones_GUIForm(){
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("C:\\Users\\kevin\\Desktop\\LOGOS_GAMESHOP\\2.jpg");
                imagenLabel.setIcon(image);
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("C:\\Users\\kevin\\Desktop\\LOGOS_GAMESHOP\\3.jpg");
                imagenLabel.setIcon(image);
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("C:\\Users\\kevin\\Desktop\\LOGOS_GAMESHOP\\4.jpg");
                imagenLabel.setIcon(image);
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("C:\\Users\\kevin\\Desktop\\LOGOS_GAMESHOP\\5.jpg");
                imagenLabel.setIcon(image);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CambiarImagenBotones_GUIForm");
        frame.setContentPane(new CambiarImagenBotones_GUIForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 600, 600);// Establece el tamaño y la posición
        frame.setVisible(true);
    }
}

