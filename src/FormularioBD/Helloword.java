package FormularioBD;

import Tablas.UserApplication;
import com.mysql.cj.xdevapi.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        // ponemos el metodo nuevo
        // para que se actualize el id nada mas que se ejecute el programa
        //asi nos aseguramos que nos pondra el id siguiente, si la tabla ya tiene datos intertados
         Nuevo();

        añadir_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar();
                consultar();
                Nuevo();
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = table.getSelectedRow();
                if (fila == -1){
                    JOptionPane.showMessageDialog(null, "No se seleccionó fila");
                }
                else {
                    idc = Integer.parseInt((String) table.getValueAt(fila,0).toString());
                    String nombre = (String) table.getValueAt(fila,1);
                    String apellido = (String) table.getValueAt(fila,2);
                    String dni = (String) table.getValueAt(fila,3);
                    String email = (String) table.getValueAt(fila,4);
                    String contrasena = (String) table.getValueAt(fila,5);

                    idField.setText(""+idc);
                    nombre_Field.setText(nombre);
                    apellido_Field.setText(apellido);
                    DNI_Field.setText(dni);
                    email_Field.setText(email);
                    pass_Field.setText(contrasena);

                }
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

        borrar_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
                consultar();

            }
        });
        nuevo_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nuevo();
            }
        });
    }
    private void Nuevo() {
        idField.setText(String.valueOf(maximo_id()+1));
        nombre_Field.setText("");
        apellido_Field.setText("");
        DNI_Field.setText("");
        email_Field.setText("");
        pass_Field.setText("");
    }
    private int maximo_id() {
        int numero = 0;
        try {
            PreparedStatement ps = con1.conn.prepareStatement("select max(id) from users ");
            rs= ps.executeQuery();
            while (rs.next()) {
                numero = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return numero;
    }

    private void eliminar() {
        int fila = table.getSelectedRow();

        try{
            if (fila < 0) {
                // Muestra una confirmación antes de eliminar la fila seleccionada
                JOptionPane.showMessageDialog(null, "No has selecionado ningun usuario para eliminar");
                limpiartabla();

            } else {
                String sql ="delete from users where id ="+idc;
                conet = con1.getConnection();
                st = conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Datos del usuario eliminado");
                limpiartabla();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void Modificar() {
        String id =  idField.getText().trim();
        String nombre = nombre_Field.getText().trim();
        String apellidos = apellido_Field.getText().trim();
        String dni = DNI_Field.getText().trim();
        String email = email_Field.getText().trim();
        String contrasena = pass_Field.getText().trim();

        try {
            if (nombre.equals("") || apellidos.equals("") || email.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, Debes rellenar los siguientes campos: nombre, apellido y email");
                limpiartabla();
            }
            else {
                // sentencia sql para actualizar los datos de una fila de la tabla
                String sql = "Update users set id ='"+idc+"', username='"+nombre+"', surname='"+apellidos+"', dni='"+dni+"', email='"+email+"', password= '"+contrasena+"' where id="+idc;
                conet = con1.getConnection();
                st = conet.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Datos del cliente modificados");

                idCounter++;
                idField.setText(Integer.toString(idCounter));

                limpiartabla();
            }

        } catch (Exception e){
            System.out.println(e);
        }
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
                JOptionPane.showMessageDialog(null, "Por favor, Debes rellenar nombre, apellido y email");
                limpiartabla();
            }
            else {
                // sentencia sql para insertar los datos  en la tabla
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

        idField.setEditable(false); // Hacemos el campo de ID no editable al inicio
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
        setTitle("Folrmulario");
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
