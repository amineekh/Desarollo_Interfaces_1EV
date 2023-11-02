package Tablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserApplication extends JFrame {

    // Declaración de variables para los componentes de la interfaz
    private JTextField nameField, lastNameField, dniField, emailField, passwordField, idField;
    private JButton newButton, deleteButton, modifyButton, addButton;
    private JTable table;
    private DefaultTableModel model;
    private int idCounter = 1;

    // Constructor de la clase UserApplication
    public UserApplication() {
        // Configuración inicial de la ventana
        setTitle("User Application"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación al cerrar la ventana
        setLayout(new BorderLayout());// Establece el diseño de la ventana

        // Creación del panel para introducir datos de usuario
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        // Inicialización de los campos de texto y del campo de ID
        idField = new JTextField();
        idField.setEditable(false); // Hacemos el campo de ID no editable al inicio
        idField.setText(String.valueOf(idCounter)); // Mostramos el ID actual
        nameField = new JTextField();
        lastNameField = new JTextField();
        dniField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        // Agregar etiquetas y campos de texto al panel
        inputPanel.add(new JLabel("ID"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nombre"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Apellidos"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("DNI (opcional)"));
        inputPanel.add(dniField);
        inputPanel.add(new JLabel("Email"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Contraseña (opcional)"));
        inputPanel.add(passwordField);

        // Agregar el panel de entrada en la parte superior de la ventana
        add(inputPanel, BorderLayout.NORTH);

        // Creación del modelo de tabla y definición de la no edición de la columna ID
        model = new DefaultTableModel() {
            // Hacemos que la columna ID sea no editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // Hacemos que la columna ID sea no editable
            }
        };
        // Agregar columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("DNI");
        model.addColumn("Email");

        // Inicialización de la tabla con el modelo de datos
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER); // Agregar la tabla en el centro de la ventana

        // Creación del panel para los botones y adición de los botones al panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        newButton = new JButton("Nuevo");
        deleteButton = new JButton("Eliminar");
        modifyButton = new JButton("Modificar");
        addButton = new JButton("Añadir");

        buttonPanel.add(newButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(addButton);

        // Agregar el panel de botones en la parte inferior de la ventana
        add(buttonPanel, BorderLayout.SOUTH);

        // Acción para el botón Nuevo
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields(); // Limpia los campos de texto
            }
        });

        // Acción para el botón Añadir
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && !emailField.getText().isEmpty()) {
                    String[] rowData = {
                            idField.getText(),
                            nameField.getText(),
                            lastNameField.getText(),
                            dniField.getText(),
                            emailField.getText()
                    };
                    model.addRow(rowData);
                    idCounter++;
                    idField.setText(String.valueOf(idCounter));
                } else {
                    JOptionPane.showMessageDialog(UserApplication.this, "Por favor, rellene los campos obligatorios.");
                }
            }
        });

        // Acción para el botón Modificar
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1 && !nameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && !emailField.getText().isEmpty()) {
                    table.setValueAt(nameField.getText(), selectedRow, 1);
                    table.setValueAt(lastNameField.getText(), selectedRow, 2);
                    table.setValueAt(dniField.getText(), selectedRow, 3);
                    table.setValueAt(emailField.getText(), selectedRow, 4);
                } else {
                    JOptionPane.showMessageDialog(UserApplication.this, "Por favor, seleccione una fila y rellene los campos obligatorios.");
                }
            }
        });

        // Acción para el botón Eliminar
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(UserApplication.this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(UserApplication.this, "Por favor, seleccione una fila para eliminar.");
                }
            }
        });

        pack(); // Ajusta el tamaño de la ventana
        setVisible(true); // Hace visible la ventana
    }

    // Método para limpiar los campos de texto del formulario
    private void clearFields() {
        nameField.setText("");
        lastNameField.setText("");
        dniField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }


    public static void main(String[] args) {
        UserApplication UserApplication= new UserApplication();
        // Hacer visible la ventana
        UserApplication.setVisible(true);
    }
}
