package Layaouts;

import javax.swing.*;

public class FlowLayaout {
    public static void main(String[] args) {

        JFrame flowlayaout = new JFrame();
        JButton bton1= new JButton("boton 1");
        JButton bton2= new JButton("boton 2");
        JButton bton3= new JButton("boton 3");
        JButton bton4= new JButton("boton 4");
        JButton bton5= new JButton("apply oretiation");

        JLabel labelSexo = new JLabel("Sexo:");
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});

        for (int i =0; i<100; i++){
            JButton miboton = new JButton("boton"+i);
            flowlayaout.add(miboton );
        }
/*
        flowlayaout.add(bton1);
        flowlayaout.add(bton2);
        flowlayaout.add(bton3);
        flowlayaout.add(bton4);
        flowlayaout.add(bton5);
*/
        flowlayaout.setLayout(new java.awt.FlowLayout());

        flowlayaout.setBounds(0,0, 400,200);



        flowlayaout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flowlayaout.setVisible(true);


    }
}
