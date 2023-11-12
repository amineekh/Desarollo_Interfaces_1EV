package Tablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabla_1 extends JFrame{

    private  JTextField id, nombre_cliente, apellido, DNI, email, nacionalidad,pais;
    private JTable tabla;
    private DefaultTableModel model;
    private JButton nuevo, eliminar, modificar, añadir;

    private  int idCounter =1;

    public Tabla_1() {
        JPanel datos = new JPanel(new GridLayout(7,2));
        nombre_cliente= new JTextField();
        apellido= new JTextField();
        DNI= new JTextField();
        email= new JTextField();
        nacionalidad=  new JTextField();
        pais = new JTextField();

        id= new JTextField();
        id.setEditable(false);
        id.setText(String.valueOf(idCounter));

        datos.add(new JLabel("id"));
        datos.add(id);
        datos.add(new JLabel("nombre_cliente"));
        datos.add(nombre_cliente);
        datos.add(new JLabel("apellido"));
        datos.add(apellido);
        datos.add(new JLabel("DNI"));
        datos.add(DNI);
        datos.add(new JLabel("email"));
        datos.add(email);
        datos.add(new JLabel("nacionalidad"));
        datos.add(nacionalidad);
        datos.add(new JLabel("pais"));
        datos.add(pais);



        add(datos, BorderLayout.NORTH);
        datos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Establecer márgenes



        JPanel butonpanel = new JPanel(new FlowLayout());
        nuevo = new JButton("nuevo");
        eliminar = new JButton("eliminar");
        modificar = new JButton("modificar");
        añadir = new JButton("añadir");

        butonpanel.add(nuevo);
        butonpanel.add(eliminar);
        butonpanel.add(modificar);
        butonpanel.add(añadir);

        add(butonpanel, BorderLayout.CENTER);
        butonpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Establecer márgenes


        // Inicializar el modelo de la tabla
        model = new DefaultTableModel();
        //agregamos las columnas de las tablas
        model.addColumn("id");
        model.addColumn("nombre_cliente");
        model.addColumn("apellido");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Nacionalidad");
        model.addColumn("pais");

        //iniciamos la tabla
        tabla = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabla);

        // Crear un panel adicional para agregar margen
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Establecer márgenes
        panel.add(scroll, BorderLayout.CENTER);

        // Agregar el panel a la ventana
        add(panel, BorderLayout.SOUTH);

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                borrar_celdas();
            }
        });

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nombre_cliente.getText().isEmpty() && !apellido.getText().isEmpty() && !DNI.getText().isEmpty() && !email.getText().isEmpty()  && !nacionalidad.getText().isEmpty() &&  !pais.getText().isEmpty()){
                    String[] rowData = {
                            id.getText(),
                            nombre_cliente.getText(),
                            apellido.getText(),
                            DNI.getText(),
                            email.getText(),
                            nacionalidad.getText(),
                            pais.getText()
                    };
                    model.addRow(rowData);
                    idCounter++;
                    id.setText(String.valueOf(idCounter));

                }else {
                    JOptionPane.showMessageDialog(Tabla_1.this, "Porfavor rellene los campos obligatorios");
                }
            }
        });

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccionar_fila = tabla.getSelectedRow();

                if(seleccionar_fila != -1 && !nombre_cliente.getText().isEmpty() && !apellido.getText().isEmpty() && !DNI.getText().isEmpty() && !email.getText().isEmpty() && !nacionalidad.getText().isEmpty() && !pais.getText().isEmpty()){
                    tabla.setValueAt(nombre_cliente.getText(), seleccionar_fila, 1);
                    tabla.setValueAt(apellido.getText(), seleccionar_fila, 2);
                    tabla.setValueAt(DNI.getText(), seleccionar_fila, 3);
                    tabla.setValueAt(email.getText(), seleccionar_fila, 4);
                    tabla.setValueAt(nacionalidad.getText(), seleccionar_fila,5);
                    tabla.setValueAt(pais.getText(), seleccionar_fila, 6);

                }
                else {
                    JOptionPane.showMessageDialog(Tabla_1.this, "Porfavor, seleccione una fila y rellene los datos obligatorios");
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selecionar_fila=tabla.getSelectedRow();
                if (selecionar_fila != -1){
                    int confirmar = JOptionPane.showConfirmDialog(Tabla_1.this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmar == JOptionPane.YES_OPTION){
                        model.removeRow(selecionar_fila);
                    }else{
                        JOptionPane.showMessageDialog(Tabla_1.this, "Por favor, seleccione una fila para eliminar.");
                    }
                }
            }
        });


        pack(); // Ajusta el tamaño de la ventana
    }

    private void borrar_celdas(){
        nombre_cliente.setText("");
        apellido.setText("");
        DNI.setText("");
        email.setText("");
        nacionalidad.setText("");
        pais.setText("");
    }

    public static void main(String[] args) {
        Tabla_1 tabla = new Tabla_1();
        tabla.setTitle("Tabla");
        tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabla.setVisible(true);
    }

}
