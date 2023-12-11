// Importación de paquetes y clases necesarias
package TA_Folmulario_MVC.Vista;

import TA_Folmulario_MVC.Controlador.UserController;
import TA_Folmulario_MVC.Modelo.UserModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// Definición de la clase UserView que extiende de JFrame
public class UserView extends JFrame {

    // Declaración de componentes de la interfaz
    private JTextField nombre_Field, apellido_Field, DNI_Field, email_Field, idField;
    private JPasswordField pass_Field;
    private JButton nuevo_Button, borrar_Button, modificar_Button, añadir_Button;
    private JTable table;
    private DefaultTableModel model;
    private int idCounter = 1;

    // Constructor de la clase UserView
    public UserView(DefaultTableModel model) {
        this.model = model;

        // Configuración de márgenes en la ventana
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
                return column != 0; // La columna ID no es editable
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

        // Definir un DefaultTableCellRenderer para ocultar la contraseña en la tabla
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof String) {
                    setText("\u2022\u2022\u2022\u2022\u2022\u2022"); // Mostrar "••••••" en lugar del texto real
                } else {
                    super.setValue(value);
                }
            }
        };

        // Aplicar el renderer a la columna de contraseñas (índice 5)
        table.getColumnModel().getColumn(5).setCellRenderer(renderer);

        // Creación de los botones
        nuevo_Button = new JButton("Nuevo");
        borrar_Button = new JButton("Borrar");
        modificar_Button = new JButton("Modificar");
        añadir_Button = new JButton("Añadir");

        // Creación del panel para los botones y adición de los botones al panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(nuevo_Button);
        buttonPanel.add(borrar_Button);
        buttonPanel.add(modificar_Button);
        buttonPanel.add(añadir_Button);

        // Agregar el panel de botones en la parte inferior de la ventana
        add(buttonPanel, BorderLayout.SOUTH);

        // Configuración del controlador
        UserController controller = new UserController(new UserModel(model), this);
        setController(controller);

        // Ajusta el tamaño de la ventana
        pack();
        // Hace visible la ventana
        setVisible(true);
    }

    // Método para establecer el controlador en los botones
    public void setController(UserController controller) {
        nuevo_Button.addActionListener(controller.getNuevoButtonListener());
        añadir_Button.addActionListener(controller.getAñadirButtonListener());
        modificar_Button.addActionListener(controller.getModificarButtonListener());
        borrar_Button.addActionListener(controller.getBorrarButtonListener());
    }

    // Otros métodos de UserView...

    // Método para limpiar los campos de texto del formulario
    public void clearFields() {
        nombre_Field.setText("");
        apellido_Field.setText("");
        DNI_Field.setText("");
        email_Field.setText("");
        pass_Field.setText("");
    }


    // Métodos de obtención de componentes
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

    // Método principal que inicia la aplicación
    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel();
        UserView userView = new UserView(model);

        // Configuración inicial de la ventana
        userView.setTitle("xxx MVC xxx");
        userView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible la ventana
        userView.setVisible(true);
    }
}
