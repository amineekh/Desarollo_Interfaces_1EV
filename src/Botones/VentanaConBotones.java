package Botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConBotones extends JFrame implements ActionListener {
    private JButton botonSuperiorIzquierdo, botonSuperiorDerecho, botonInferiorIzquierdo, botonInferiorDerecho;
    private JLabel etiquetaImagen;

    public VentanaConBotones() {
        super("Ventana con Botones");

        // Configurar el diseño del JFrame con un GridLayout y espacio entre componentes
        setLayout(new GridLayout(2, 2, 30, 30)); // Aumentar espacio entre componentes

        // Crear botones con texto más corto para reducir su tamaño
        botonSuperiorIzquierdo = new JButton("1");
        botonSuperiorDerecho = new JButton("2");
        botonInferiorIzquierdo = new JButton("3");
        botonInferiorDerecho = new JButton("4");

        // Establecer un tamaño más pequeño para los botones
        Dimension buttonSize = new Dimension(100, 50);
        botonSuperiorIzquierdo.setPreferredSize(buttonSize);
        botonSuperiorDerecho.setPreferredSize(buttonSize);
        botonInferiorIzquierdo.setPreferredSize(buttonSize);
        botonInferiorDerecho.setPreferredSize(buttonSize);

        // Agregar ActionListener a cada botón
        botonSuperiorIzquierdo.addActionListener(this);
        botonSuperiorDerecho.addActionListener(this);
        botonInferiorIzquierdo.addActionListener(this);
        botonInferiorDerecho.addActionListener(this);

        // Crear etiqueta para mostrar la imagen
        etiquetaImagen = new JLabel();
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);

        // Agregar botones y etiqueta al JFrame
        add(botonSuperiorIzquierdo);
        add(botonSuperiorDerecho);
        add(botonInferiorIzquierdo);
        add(botonInferiorDerecho);

        // Establecer tamaño y visibilidad de la ventana
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonClicado = (JButton) e.getSource();

        // Imprimir la ruta de la imagen para depuración
        System.out.println("Ruta de la imagen: " + obtenerRutaImagen(botonClicado));

        ImageIcon imagen = new ImageIcon(obtenerRutaImagen(botonClicado));
        etiquetaImagen.setIcon(imagen);
    }

    // Método para obtener la ruta de la imagen correspondiente al botón clicado
    private String obtenerRutaImagen(JButton boton) {
        if (boton == botonSuperiorIzquierdo) {
            return "src/Botones/img1.jpeg";
        } else if (boton == botonSuperiorDerecho) {
            return "src/Botones/img2.jpeg";
        } else if (boton == botonInferiorIzquierdo) {
            return "src/Botones/img3.jpeg";
        } else if (boton == botonInferiorDerecho) {
            return "src/Botones/img4.jpeg";
        }
        return null;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaConBotones());
    }
}

