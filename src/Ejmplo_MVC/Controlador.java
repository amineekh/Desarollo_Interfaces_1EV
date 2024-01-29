package Ejmplo_MVC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Paso 3: Creamos la clase del controlador (Controller)
class Controlador implements ActionListener {
    //private Modelo modelo;
    private Vista vista;

    // Constructor del controlador
    public Controlador( Vista vista) {
        //this.modelo = modelo;
        this.vista = vista;
        // Establecemos el controlador en la vista
        this.vista.setControlador(this);
    }

    // Método que se ejecuta cuando se hace clic en el botón
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos los textos de los campos de texto desde la vista
        String nombre = vista.getTexto1();
        String apellido = vista.getTexto2();

        // Creamos el mensaje de bienvenida
        String mensaje = "¡Bienvenido, " + nombre + " " + apellido + "!";

        // Mostramos el mensaje en la vista
        vista.mostrarMensaje(mensaje);
    }
}