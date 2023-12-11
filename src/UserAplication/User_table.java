package UserAplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_table extends JFrame{
    private JPanel mainpanel;
    private JTextField idfild;
    private JTextField nombrefield;
    private JTextField apellidofield;
    private JTextField dnifield;
    private JPasswordField passfield;
    private JTextField emailfield;
    private JButton nuevo;
    private JButton añadir;
    private JButton Eliminar;
    private JButton modificar;
    private JTable tabla;

    private DefaultTableModel modelo ;
    private  int countid= 1;

    public User_table(){
        setTitle("XXXXXX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainpanel); // Establecer el panel principal

        modelo = new DefaultTableModel();

        idfild.setEditable(false);
        idfild.setText(String.valueOf(countid));

        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return column != 0; // Hacemos que la columna ID sea no editable
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("Email");
        modelo.addColumn("Contraseña");
        tabla.setModel(modelo);

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
        tabla.getColumnModel().getColumn(5).setCellRenderer(renderer);

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrar_datos();

            }
        });
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!nombrefield.getText().isEmpty() && !apellidofield.getText().isEmpty() && !emailfield.getText().isEmpty()&& !passfield.getText().isEmpty()){
                    String[] datos={
                            idfild.getText(),
                            nombrefield.getText(),
                            apellidofield.getText(),
                            dnifield.getText(),
                            emailfield.getText(),
                            passfield.getText()
                    };
                    modelo.addRow(datos);
                    countid++;
                    idfild.setText(String.valueOf(countid)); // Actualiza el campo de ID

                }
                else {
                    JOptionPane.showMessageDialog(User_table.this, "Por favor, rellene los campos obligatorios.");
                }
            }
        });

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int select = tabla.getSelectedRow();

                if (select !=-1 &&!nombrefield.getText().isEmpty() && !apellidofield.getText().isEmpty() && !emailfield.getText().isEmpty()&& !passfield.getText().isEmpty()) {

                    tabla.setValueAt(nombrefield.getText(), select, 1);
                    tabla.setValueAt(apellidofield.getText(), select, 2);
                    tabla.setValueAt(dnifield.getText(), select, 3);
                    tabla.setValueAt(emailfield.getText(),select,  4);
                    tabla.setValueAt(passfield.getText(), select, 5);
                }     else {
                    JOptionPane.showMessageDialog(User_table.this, "por favor sellecione una fila y rellene los campos obligatorios");
                }
            }
        });
        Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int select = tabla.getSelectedRow();
                if (select != -1) {
                    int confirm = JOptionPane.showConfirmDialog(User_table.this, "¿Está seguro de que desea eliminar este usuario?",
                            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        modelo.removeRow(select);
                    }
                } else {
                    JOptionPane.showMessageDialog(User_table.this, "Por favor, seleccione una fila para eliminar.");

                }
            }
        });

        pack();
        setVisible(true);
    }

    private void borrar_datos() {
        nombrefield.setText("");
        apellidofield.setText("");
        dnifield.setText("");
        emailfield.setText("");
        passfield.setText("");
    }

    public static void main(String[] args) {
        User_table User_table= new User_table();
        // Hacer visible la ventana
        User_table.setVisible(true);
    }


}
