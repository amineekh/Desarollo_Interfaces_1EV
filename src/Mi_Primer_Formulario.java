import javax.swing.*;
import java.text.SimpleDateFormat;


public class Mi_Primer_Formulario {
    public static void main(String[] args) {

        // Crear una ventana
        JFrame ventana = new JFrame("Formulario de Información Personal");
        ventana.setBounds(10,10,300,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel  p = new JPanel();
        ventana.add(p);

        // Crear etiquetas y campos de texto
        JLabel labelNombre = new JLabel("NOMBRE:");
        JTextField campoNombre = new JTextField(20);


        JLabel LabelApellido = new JLabel("APELLIDO:");
        JTextField campoApellido = new JTextField(20);

        JLabel labelDNI = new JLabel("DNI:");
        JTextField campoDNI = new JTextField(20);

        JLabel labelSexo = new JLabel("Sexo:");
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});

        JLabel LabelNacionalidad = new JLabel("Nacionalidad:");
        JTextField campoNacionalidad = new JTextField(20);

        JLabel labelFechaNacimiento = new JLabel("Fecha de Nacimiento (dd/mm/yyyy):");
        JFormattedTextField campoFechaNacimiento = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        campoFechaNacimiento.setColumns(10);

        JLabel labelDomicilio = new JLabel("Domicilio:");
        JTextField campoDomicilio = new JTextField(20);



        // Agregar componentes a la ventana
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



        ventana.setVisible(true);


    }

}
