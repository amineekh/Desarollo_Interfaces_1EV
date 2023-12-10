package Ejmplo_MVC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Paso 2: Creamos la clase de la vista (View)
class Vista extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton boton;

    // Constructor de la vista
    public Vista() {
        // Configuramos la ventana
        setTitle("Ejemplo MVC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos los componentes
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        boton = new JButton("Mostrar mensaje");

        // Configuramos el diseño usando un gestor de diseño (puede ser BorderLayout, GridLayout, etc.)
        setLayout(new java.awt.FlowLayout());

        // Añadimos los componentes a la ventana
        add(new JLabel("Nombre: "));
        add(textField1);
        add(new JLabel("Apellido: "));
        add(textField2);
        add(boton);

        // Mostramos la ventana
        setVisible(true);
    }

    // Métodos para obtener el texto de los campos de texto
    public String getTexto1() {
        return textField1.getText();
    }

    public String getTexto2() {
        return textField2.getText();
    }

    // Método para establecer el controlador
    public void setControlador(Controlador controlador) {
        boton.addActionListener(controlador);
    }

    // Método para mostrar un mensaje en una ventana emergente
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}