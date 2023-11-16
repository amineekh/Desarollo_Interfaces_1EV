package FormularioBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;

public class Helloword extends JFrame {

    conexion con1 = new conexion();
    Connection conet;
    Statement st;
    ResultSet rs;

    int idc;

    private JTextField idField;
    private JTextField nombre_Field;
    private JTextField apellido_Field;
    private JTextField DNI_Field;

    private JTextField email_Field;

    private JPasswordField pass_Field;

    private JPanel mainpanel;
    private JPanel Panel2;
    private JButton añadir_Button;
    private JButton nuevo_Button;
    private JButton borrar_Button;
    private JButton modificar_Button;
    private JTable table;

    private DefaultTableModel model;

    private int idCounter = 1; // Establecer el valor inicial del contador de ID a 1


    public Helloword() {
        // Inicializar el modelo de la tabla
        model = new DefaultTableModel();
        // Metodo para la creacion de la tabla
        createTable();
        consultar();

        // Configurar la interfaz de usuario
        configuracion_UI();
        añadir_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar();
                consultar();
                Nuevo();
            }
        });
        nuevo_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nuevo();
            }
        });
        modificar_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar();
                consultar();
                Nuevo();
            }
        });
    }

    private void Modificar() {
        String id = idField.getText().trim();
        String nombre = nombre_Field.getText().trim();
        String apellidos = apellido_Field.getText().trim();
        String dni = DNI_Field.getText().trim();
        String email = email_Field.getText().trim();
        String contrasena = pass_Field.getText().trim();

        try {
            if (nombre.equals("") || apellidos.equals("") || email.equals("")){
                JOptionPane.showMessageDialog(null, "Debes rellenar nombre, apellido y email");
                limpiartabla();
            }
            else {
                String sql = "Update users set id ='"+idc+"', username='"+nombre+"', surname='"+apellidos+"', dni='"+dni+"', email='"+email+"', password= '"+contrasena+"' where id="+idc;
                conet = con1.getConnection();
                st = conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Datos del cliente modificados");

                idCounter++;
                idField.setText(Integer.toString(idCounter));

                limpiartabla();
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    private void Nuevo() {
        idField.setText("");
        nombre_Field.setText("");
        apellido_Field.setText("");
        DNI_Field.setText("");
        email_Field.setText("");
        pass_Field.setText("");
    }

    private void Agregar() {
        String id = idField.getText().trim();
        String nombre = nombre_Field.getText().trim();
        String apellidos = apellido_Field.getText().trim();
        String dni = DNI_Field.getText().trim();
        String email = email_Field.getText().trim();
        String contrasena = pass_Field.getText().trim();

        try {
            if (nombre.equals("") || apellidos.equals("") || email.equals("")){
                JOptionPane.showMessageDialog(null, "Debes rellenar nombre, apellido y email");
                limpiartabla();
            }
            else {

                String sql = "insert into users(id, username, surname, dni, email, password) values ('"+id+"', '"+nombre+"', '"+apellidos+"', '"+dni+"', '"+email+"', '"+contrasena+"')";
                conet = con1.getConnection();
                st = conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo cliente registrado");

                idCounter++;
                idField.setText(Integer.toString(idCounter));

                limpiartabla();
            }

        } catch (Exception e){
            System.out.println(e);
        }

    }

    private void limpiartabla() {
        for (int i = 0;i<table.getRowCount();i++){
            model.removeRow(i);
            i = i-1;
        }
    }

    private void consultar() {
        String sql = "select * from users";

        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object[] usuarios = new Object[6];
            model= (DefaultTableModel) table.getModel();
            while (rs.next()){

                usuarios [0] = rs.getInt("id");
                usuarios [1] = rs.getString("username");
                usuarios [2] = rs.getString("surname");
                usuarios [3] = rs.getString("dni");
                usuarios [4] = rs.getString("email");
                usuarios [5] = rs.getString("password");

                model.addRow(usuarios);

            }

            table.setModel(model);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void createTable() {

       // idField.setEditable(false); // Hacemos el campo de ID no editable al inicio
        idField.setText(String.valueOf(idCounter)); // Mostramos el ID actual

        // Creación del modelo de tabla y definición de la no edición de la columna ID
        model = new DefaultTableModel() {
            // Hacemos que la columna ID sea no editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // Hacemos que la columna ID sea no editable
            }
        };
        // Agregar columnas al modelo de la tabla si es necesario
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Contraseña");

        // Asignar el modelo a la tabla
        table.setModel(model);

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
    }

    private void configuracion_UI() {
        // Configurar la ventana
        setTitle("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainpanel); // Establecer el panel principal

        pack(); // Ajusta el tamaño de la ventana
        setVisible(true); // Hace visible la ventana
    }


    public static void main(String[] args) {
        Helloword Helloword= new Helloword();
        // Hacer visible la ventana
        Helloword.setVisible(true);
    }
}
