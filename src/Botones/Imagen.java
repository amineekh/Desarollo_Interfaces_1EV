package Botones;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Imagen extends JFrame {
    private JLabel imagenLabel;
    public Imagen(){
        JButton boton1=new JButton("Boton1");
        JButton boton2=new JButton("Boton2");
        JButton boton3=new JButton("Boton3");
        JButton boton4=new JButton("Boton4");

        imagenLabel=new JLabel();
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        imagenLabel.setVerticalAlignment(JLabel.CENTER);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("src/Botones/img1.jpeg");
                imagenLabel.setIcon(image);
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("src/Botones/img1.jpeg");
                imagenLabel.setIcon(image);


            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("src/Botones/img1.jpeg");
                imagenLabel.setIcon(image);

            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image= new ImageIcon("src/Botones/img1.jpeg");
                imagenLabel.setIcon(image);


            }
        });
        setLayout(new BorderLayout());
        add(boton1, BorderLayout.NORTH);
        add(boton2,BorderLayout.SOUTH);
        add(boton3, BorderLayout.WEST);
        add(boton4,BorderLayout.EAST);
        add(imagenLabel, BorderLayout.CENTER);



    }

    public static void main(String[] args) {
        Imagen frame =new Imagen();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 300, 200);// Establece el tamaño y la posición
        frame.setVisible(true); // Lo hace visible
    }
}