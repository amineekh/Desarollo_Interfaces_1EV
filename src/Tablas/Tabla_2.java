package Tablas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class Tabla_2 extends JFrame{
    private JTextField id, nombre_empleado, apellido, DNI, email, password, nacionalidad;
    private JButton nuevo2, eliminar2, modificar2, añadir2;
    private DefaultTableModel model;
    private  JTable tablas;

    private int counter_id=1;

    public Tabla_2(){
        JPanel ingresar = new JPanel(new GridLayout(7, 2));
        id = new JTextField();
        id.setEditable(false);
        id.setText(String.valueOf(counter_id));

        nombre_empleado = new JTextField();
        apellido = new JTextField();
        DNI = new JTextField();
        email = new JTextField();
        password= new JTextField();
        nacionalidad = new JTextField();

        ingresar.add(new JLabel("id"));
        ingresar.add(id);
        ingresar.add(new JLabel("nombre_empleado"));
        ingresar.add(nombre_empleado);
        ingresar.add(new JLabel("apellido"));
        ingresar.add(apellido);
        ingresar.add(new JLabel("DNI"));
        ingresar.add(DNI);
        ingresar.add(new JLabel("email"));
        ingresar.add(email);
        ingresar.add(new JLabel("password"));
        ingresar.add(password);
        ingresar.add(new JLabel("nacionalidad"));
        ingresar.add(nacionalidad);

        add(ingresar, BorderLayout.NORTH);
        ingresar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel botones = new JPanel(new FlowLayout());
        nuevo2 = new JButton("nuevo");
        eliminar2 = new JButton("eliminar");
        modificar2 = new JButton("modificar");
        añadir2 = new JButton("añadir");

        botones.add(nuevo2);
        botones.add(eliminar2);
        botones.add(modificar2);
        botones.add(añadir2);

        add(botones, BorderLayout.CENTER);
        botones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        model = new DefaultTableModel(){
          public  boolean isCellEditable(int row, int column){
              return  column !=0;
          }
        };


        model.addColumn("id");
        model.addColumn("nombre_emplaedo");
        model.addColumn("apellido");
        model.addColumn("DNI");
        model.addColumn("email");
        model.addColumn("password");
        model.addColumn("Nacionalidad");

        tablas = new JTable(model);
        JScrollPane scrollp = new JScrollPane(tablas);

        JPanel tabla = new JPanel(new BorderLayout());
        tabla.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        tabla.add(scrollp, BorderLayout.CENTER);

        add(tabla, BorderLayout.SOUTH);

        nuevo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celdas_vacias();
            }
        });
        añadir2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nombre_empleado.getText().isEmpty() && !apellido.getText().isEmpty() && !DNI.getText().isEmpty() && !email.getText().isEmpty() && !nacionalidad.getText().isEmpty()){
                    String[] rowDatos = {
                        id.getText(),
                        nombre_empleado.getText(),
                        apellido.getText(),
                        DNI.getText(),
                        email.getText(),
                        password.getText(),
                        nacionalidad.getText()
                    };
                    model.addRow(rowDatos);
                    counter_id++;
                    id.setText(String.valueOf(counter_id));
                }else {
                    JOptionPane.showMessageDialog(Tabla_2.this, "Rellene los campos obligatorios");
                }
            }
        });
        modificar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selcionar_row = tablas.getSelectedRow();

                if(selcionar_row != -1 && !nombre_empleado.getText().isEmpty() && !apellido.getText().isEmpty() && !DNI.getText().isEmpty() && !email.getText().isEmpty() && !password.getText().isEmpty() && !nacionalidad.getText().isEmpty()){
                    tablas.setValueAt(nombre_empleado.getText(), selcionar_row, 1);
                    tablas.setValueAt(apellido.getText(), selcionar_row, 2);
                    tablas.setValueAt(DNI.getText(), selcionar_row, 3);
                    tablas.setValueAt(email.getText(), selcionar_row, 4);
                    tablas.setValueAt(password.getText(), selcionar_row, 5);
                    tablas.setValueAt(nacionalidad.getText(), selcionar_row, 6);

                }else{
                    JOptionPane.showMessageDialog(Tabla_2.this,  "Porfavor, seleccione una fila y rellene los datos obligatorios");
                }
            }
        });

        eliminar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selecionar_row = tablas.getSelectedRow();

                if (selecionar_row != -1){

                    int confirmar = JOptionPane.showConfirmDialog( Tabla_2.this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION );
                    if (confirmar == JOptionPane.YES_OPTION){
                        model.removeRow(selecionar_row);
                    }

                }else{
                    JOptionPane.showMessageDialog( Tabla_2.this, "Por favor seleccione una fila para eliminar");
                }
            }
        });



        pack();
    }

    private void celdas_vacias(){
        nombre_empleado.setText("");
        apellido.setText("");
        DNI.setText("");
        email.setText("");
        password.setText("");
        nacionalidad.setText("");
    }

    public static void main(String[] args) {
        Tabla_2 tabla2 = new Tabla_2();
        tabla2.setTitle("Repaso");
        tabla2.setVisible(true);
    }

}
