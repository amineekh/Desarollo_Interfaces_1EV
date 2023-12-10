package TA_Folmulario_MVC;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserView extends JFrame {
    private JTextField nombre_Field, apellido_Field, DNI_Field, email_Field, idField;
    private JPasswordField pass_Field;
    private JButton nuevo_Button, borrar_Button, modificar_Button, añadir_Button;
    private JTable table;
    private DefaultTableModel model;
    private int idCounter = 1;

    public UserView(DefaultTableModel model) {
        this.model = model;

        // Añadir márgenes a la ventana
        int marginSize = 20; // Tamaño del margen en píxeles
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));

        // Creación del panel para introducir datos de usuario
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        // Inicialización de los campos de texto y del campo de ID
        idField = new JTextField();
        idField.setEditable(false);
        idField.setText(String.valueOf(idCounter));

        nombre_Field = new JTextField();
        apellido_Field = new JTextField();
        DNI_Field = new JTextField();
        email_Field = new JTextField();
        pass_Field = new JPasswordField();

        // Agregar etiquetas y campos de texto al panel
        inputPanel.add(new JLabel("ID"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nombre"));
        inputPanel.add(nombre_Field);
        inputPanel.add(new JLabel("Apellidos"));
        inputPanel.add(apellido_Field);
        inputPanel.add(new JLabel("DNI (opcional)"));
        inputPanel.add(DNI_Field);
        inputPanel.add(new JLabel("Email"));
        inputPanel.add(email_Field);
        inputPanel.add(new JLabel("Contraseña (opcional)"));
        inputPanel.add(pass_Field);

        // Agregar el panel de entrada en la parte superior de la ventana
        add(inputPanel, BorderLayout.NORTH);

        // Creación del modelo de tabla y definición de la no edición de la columna ID
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        // Agregar columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Contraseña");

        // Inicialización de la tabla con el modelo de datos
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        // Resto del código...

        pack(); // Ajusta el tamaño de la ventana
        setVisible(true); // Hace visible la ventana
    }

    public void setController(UserController controller) {
        nuevo_Button.addActionListener(controller.getNuevoButtonListener());
        añadir_Button.addActionListener(controller.getAñadirButtonListener());
        modificar_Button.addActionListener(controller.getModificarButtonListener());
        borrar_Button.addActionListener(controller.getBorrarButtonListener());
    }

    public void clearFields() {
        nombre_Field.setText("");
        apellido_Field.setText("");
        DNI_Field.setText("");
        email_Field.setText("");
        pass_Field.setText("");
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getNombreField() {
        return nombre_Field;
    }

    public JTextField getApellidoField() {
        return apellido_Field;
    }

    public JTextField getDNIField() {
        return DNI_Field;
    }

    public JTextField getEmailField() {
        return email_Field;
    }

    public JPasswordField getPassField() {
        return pass_Field;
    }

    public JTextField getIdField() {
        return idField;
    }
}
