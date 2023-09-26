import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Segunda_Ventana {

    public static void main(String[] args) {
    /*
       JPanel panel = new JPanel();
       panel.setBackground(Color.green);
       panel.setBounds(0,0,250,250);

        JPanel Bluepanel = new JPanel();
        Bluepanel.setBackground(Color.blue);
        Bluepanel.setBounds(0,250,250,250);

       JFrame frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(null);
       frame.setSize(750,750);
       frame.setVisible(true);
       frame.add(panel);
       frame.add(Bluepanel);

      */


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
    }


}





