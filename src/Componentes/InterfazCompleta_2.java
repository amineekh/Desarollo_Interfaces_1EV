package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfazCompleta_2 extends Frame {
    private JTextField pasword;
    private JTextField nombre;
    private JButton boton_agregar, borrar, eliminar;

    private  DefaultListModel modelo_lista;

    private JList lista;

    public InterfazCompleta_2(){

        JPanel password_agregar = new JPanel(new GridLayout(2,2));
        password_agregar.add(new JLabel("password"));
        pasword = new JPasswordField();
        password_agregar.add(pasword);

        nombre=new JTextField();
        password_agregar.add(nombre);
        boton_agregar = new JButton("agregar");
        password_agregar.add(boton_agregar);

        add(password_agregar , BorderLayout.NORTH);

        boton_agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insertar_nombre= nombre.getText();
                if (!insertar_nombre.isEmpty()){
                    modelo_lista.addElement(insertar_nombre);
                    nombre.setText("");
                }
            }
        });


        JPanel listado = new JPanel(new BorderLayout());
        modelo_lista =new DefaultListModel<>();
        lista = new JList<>(modelo_lista);
        listado.add(lista);
        listado.add(new JScrollPane(lista));
        add(listado, BorderLayout.CENTER);

        borrar = new JButton("Borrar lista");
        eliminar = new JButton("Eliminar");
        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout());
        botones.add(borrar);
        botones.add(eliminar);

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo_lista.clear();
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccionar_nombre= lista.getSelectedIndex();
                if (seleccionar_nombre != -1){

                    int confirmar=JOptionPane.showConfirmDialog(InterfazCompleta_2.this, "¿Está seguro de que desea eliminar este nombre?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if(confirmar == JOptionPane.YES_OPTION){
                       modelo_lista.remove(seleccionar_nombre);
                     }

                }else{
                    JOptionPane.showMessageDialog(InterfazCompleta_2.this, "Por favor, seleccione un nombre.");
                }
            }
        });

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel areapanel = new JPanel();
        areapanel.setLayout(new BorderLayout());
        areapanel.add(botones, BorderLayout.NORTH);
        areapanel.add(scrollPane, BorderLayout.SOUTH);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(password_agregar, BorderLayout.NORTH); // Campo de contraseña arriba
        mainPanel.add(listado, BorderLayout.CENTER); // Lista en el centro
        mainPanel.add(areapanel, BorderLayout.SOUTH); // Botones y JTextArea debajo de la lista

        add(mainPanel);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla


        pack();
    }



    public static void main(String[] args) {
        InterfazCompleta_2 ic = new InterfazCompleta_2();
        ic.setTitle("Componentes");
        ic.setVisible(true);

    }
}
