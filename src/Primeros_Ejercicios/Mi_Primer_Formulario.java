package Primeros_Ejercicios;

// Importar las clases necesarias
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

// Definir la clase principal
public class Mi_Primer_Formulario {
    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {

        // Crear una ventana utilizando la clase JFrame
        JFrame ventana = new JFrame("Formulario de Información Personal"); // Crear un objeto JFrame con título
        ventana.setBounds(10, 20, 320, 300); // Establecer las dimensiones y posición de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer la acción al cerrar la ventana

        // Crear un panel para organizar los componentes
        JPanel p = new JPanel(); // Crear un objeto JPanel
        ventana.add(p); // Agregar el panel a la ventana

        // Crear etiquetas y campos de texto para la información personal
        JLabel labelNombre = new JLabel("NOMBRE:"); // Etiqueta para el nombre
        JTextField campoNombre = new JTextField(20); // Campo de texto para ingresar el nombre

        JLabel LabelApellido = new JLabel("APELLIDO:"); // Etiqueta para el apellido
        JTextField campoApellido = new JTextField(20); // Campo de texto para ingresar el apellido

        JLabel labelDNI = new JLabel("DNI:"); // Etiqueta para el DNI
        JTextField campoDNI = new JTextField(20); // Campo de texto para ingresar el DNI

        JLabel labelSexo = new JLabel("Sexo:"); // Etiqueta para el sexo
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"}); // Lista desplegable para seleccionar el sexo

        // Establecer el ancho deseado para el JComboBox
        comboSexo.setPreferredSize(new Dimension(280, 25));

        JLabel LabelNacionalidad = new JLabel("Nacionalidad:"); // Etiqueta para la nacionalidad
        JTextField campoNacionalidad = new JTextField(20); // Campo de texto para ingresar la nacionalidad

        JLabel labelFechaNacimiento = new JLabel("Fecha de Nacimiento (dd/mm/yyyy):"); // Etiqueta para la fecha de nacimiento
        JFormattedTextField campoFechaNacimiento = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy")); // Campo de texto formateado para ingresar la fecha de nacimiento
        campoFechaNacimiento.setColumns(10); // Establecer el ancho del campo de fecha

        JLabel labelDomicilio = new JLabel("Domicilio:"); // Etiqueta para el domicilio
        JTextField campoDomicilio = new JTextField(20); // Campo de texto para ingresar el domicilio

        // Agregar componentes al panel
        p.add(labelDNI);
        p.add(campoDNI);
        p.add(labelNombre);
        p.add(campoNombre);
        p.add(LabelApellido);
        p.add(campoApellido);
        p.add(labelSexo);
        p.add(comboSexo);
        p.add(LabelNacionalidad);
        p.add(campoNacionalidad);
        p.add(labelFechaNacimiento);
        p.add(campoFechaNacimiento);
        p.add(labelDomicilio);
        p.add(campoDomicilio);

        // Hacer la ventana visible
        ventana.setVisible(true);
    }
}
