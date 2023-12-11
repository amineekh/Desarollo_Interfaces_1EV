package Botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonesCambioColor extends JFrame implements ActionListener {
    private JButton boton1, boton2;
    private Color colorOriginalBoton1, colorOriginalBoton2;

    // Constructor de la clase
    public BotonesCambioColor() {
        // Crear la ventana
        super("Cambio de Color");

        // Configurar el diseño del JFrame
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los botones
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");

        // Agregar ActionListener a cada botón
        boton1.addActionListener(this);
        boton2.addActionListener(this);

        // Guardar los colores originales de los botones
        colorOriginalBoton1 = boton1.getBackground();
        colorOriginalBoton2 = boton2.getBackground();

        // Agregar los botones al JFrame
        add(boton1);
        add(boton2);

        // Establecer tamaño y visibilidad de la ventana
        setSize(300, 200);
        setVisible(true);
    }

    // Método invocado cuando se hace clic en algún botón
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cambiar el color del otro botón y restaurar el color original del botón actual
        if (e.getSource() == boton1) {
            // Botón 1 fue clicado
            // Cambiar color de Botón 2 a azul
            cambiarColor(boton2, colorOriginalBoton1);
            // Restaurar color original de Botón 1
            boton1.setBackground(colorOriginalBoton1);
        } else if (e.getSource() == boton2) {
            // Botón 2 fue clicado
            // Cambiar color de Botón 1 a azul
            cambiarColor(boton1, colorOriginalBoton2);
            // Restaurar color original de Botón 2
            boton2.setBackground(colorOriginalBoton2);
        }
    }

    // Método para cambiar el color de un botón
    private void cambiarColor(JButton boton, Color colorOriginal) {
        // Cambiar el color del botón al azul
        boton.setBackground(Color.BLUE);
    }

    public static void main(String[] args) {
        BotonesCambioColor bt= new BotonesCambioColor();
        // Configuración inicial de la ventana
        bt.setTitle("BOTONES COLOR"); // Establece el título de la ventana
        bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación al cerrar la ventana


        // Hacer visible la ventana
        bt.setVisible(true);
    }
}
