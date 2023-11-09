

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class Helloword extends JFrame {
    private JTextField idField;
    private JTextField nombre_Field;
    private JTextField apellido_Field;
    private JTextField DNI_Field;

    private JLabel Email;
    private JTextField email_Field;

    private JTextField pass_Field;


    private JPanel mainpanel;
    private JPanel Panel2;
    private JButton añadir_Button;
    private JButton nuevo_Button;
    private JButton borrar_Button;
    private JButton modificar_Button;
    private JTable table;

    private DefaultTableModel model;

    private int idCounter = 1;


    public Helloword() {

        // Inicializar el modelo de la tabla
        model = new DefaultTableModel();
        createtable();

        // Configurar la interfaz de usuario
        configureUI();
    }


    private void createtable() {


        // Agregar columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Contraseña");

        // Asignar el modelo a la tabla
        table.setModel(model);

    }

    private void configureUI() {

        // Añadir márgenes a la ventana
        int marginSize = 20; // Tamaño del margen en píxeles
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));

        // Inicialización de los campos de texto y del campo de ID
        idField = new JTextField();
        idField.setEditable(false); // Hacemos el campo de ID no editable al inicio
        idField.setText(String.valueOf(idCounter)); // Mostramos el ID actual

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof String) {
                    setText("\u2022\u2022\u2022\u2022\u2022\u2022");
                } else {
                    super.setValue(value);
                }
            }
        };
        table.getColumnModel().getColumn(5).setCellRenderer(renderer);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        idField = new JTextField();
        nombre_Field = new JTextField();
        apellido_Field = new JTextField();
        DNI_Field = new JTextField();
        Email = new JLabel("Email: ");
        email_Field = new JTextField();
        pass_Field = new JTextField();

        inputPanel.add(new JLabel("ID: "));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nombre: "));
        inputPanel.add(nombre_Field);
        inputPanel.add(new JLabel("Apellidos: "));
        inputPanel.add(apellido_Field);
        inputPanel.add(new JLabel("DNI: "));
        inputPanel.add(DNI_Field);
        inputPanel.add(Email);
        inputPanel.add(email_Field);
        inputPanel.add(new JLabel("Contraseña: "));
        inputPanel.add(pass_Field);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        nuevo_Button = new JButton("Nuevo");
        borrar_Button = new JButton("Eliminar");
        modificar_Button = new JButton("Modificar");
        añadir_Button = new JButton("Añadir");

        buttonPanel.add(nuevo_Button);
        buttonPanel.add(borrar_Button);
        buttonPanel.add(modificar_Button);
        buttonPanel.add(añadir_Button);


        add(buttonPanel, BorderLayout.SOUTH);

        nuevo_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        añadir_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nombre_Field.getText().isEmpty() && !apellido_Field.getText().isEmpty() && !email_Field.getText().isEmpty() && !pass_Field.getText().isEmpty()) {
                    String[] rowData = {
                            String.valueOf(idCounter),
                            nombre_Field.getText(),
                            apellido_Field.getText(),
                            DNI_Field.getText(),
                            email_Field.getText(),
                            pass_Field.getText()
                    };
                    model.addRow(rowData);
                    idCounter++;
                    idField.setText(String.valueOf(idCounter)); // Actualiza el campo de ID
                } else {
                    JOptionPane.showMessageDialog(Helloword.this, "Por favor, rellene los campos obligatorios.");
                }
            }
        });

        modificar_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1 && !nombre_Field.getText().isEmpty() && !apellido_Field.getText().isEmpty() && !email_Field.getText().isEmpty() && !pass_Field.getText().isEmpty()) {
                    table.setValueAt(nombre_Field.getText(), selectedRow, 1);
                    table.setValueAt(apellido_Field.getText(), selectedRow, 2);
                    table.setValueAt(DNI_Field.getText(), selectedRow, 3);
                    table.setValueAt(email_Field.getText(), selectedRow, 4);
                    table.setValueAt(pass_Field.getText(), selectedRow, 5);
                } else {
                    JOptionPane.showMessageDialog(Helloword.this, "Por favor, seleccione una fila y rellene los campos obligatorios.");
                }
            }
        });

        borrar_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(Helloword.this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(Helloword.this, "Por favor, seleccione una fila para eliminar.");
                }
            }
        });

        pack();
        setVisible(true);
    }

    private void clearFields() {
        nombre_Field.setText("");
        apellido_Field.setText("");
        DNI_Field.setText("");
        email_Field.setText("");
        pass_Field.setText("");
    }

    public static void main(String[] args) {
        Helloword Helloword= new Helloword();
        // Configuración inicial de la ventana
        Helloword.setTitle("Hello Word"); // Establece el título de la ventana
        Helloword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación al cerrar la ventana

        // Hacer visible la ventana
        Helloword.setVisible(true);
    }
}
