package Eventos_Listeners_Adapters;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyJListWindow extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField nombreTextField;


    public  MyJListWindow(){
        super("Ejemplo MyJListWindow");

        JLabel titleLabel = new JLabel("JList");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Crear un JTextField para ingresar nombres
        nombreTextField = new JTextField(20);

        // Crear botón Agregar
        JButton agregarButton = new JButton("Agregar");

        // Agregar ActionListener al botón Agregar
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                if (!nombre.isEmpty()) {
                    listModel.addElement(nombre);
                    nombreTextField.setText("");
                }
            }
        });

        // Crear una lista y su modelo
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        // Crear botones Borrar Lista y Eliminar
        JButton borrarListaButton = new JButton("Borrar Lista");
        JButton eliminarButton = new JButton("Eliminar");

        // Agregar ActionListener al botón Borrar Lista
        borrarListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
            }
        });

        // Agregar ActionListener al botón Eliminar
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });





        // Crear un panel para organizar el botón Agregar y el campo de texto horizontalmente
        JPanel agregarPanel = new JPanel();
        agregarPanel.setLayout(new BoxLayout(agregarPanel, BoxLayout.X_AXIS));
        agregarPanel.add(nombreTextField);
        agregarPanel.add(agregarButton);
        agregarPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Crear un panel para organizar la lista y el panel del botón Agregar verticalmente
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JScrollPane(list), BorderLayout.CENTER);
        listPanel.add(agregarPanel, BorderLayout.NORTH);
        listPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));


        // Panel para los botones Borrar Lista y Eliminar
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(borrarListaButton);
        buttonPanel.add(eliminarButton);


        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Añadir márgenes
        mainPanel.add(listPanel, BorderLayout.CENTER); // Lista en el centro
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Botones en la parte inferior
        // Agregar el JLabel al panel principal
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Agregar el panel principal al contenido del JFrame
        getContentPane().add(mainPanel);

        // Crear un JLabel para el texto
        JLabel titleLabel1 = new JLabel("Seleccionado: ");
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 24));


        setLocationRelativeTo(null); // Centrar la ventana en la pantalla


    }


    public static void main(String[] args) {
        MyJListWindow tabla= new MyJListWindow();
        tabla.setBounds(100, 100, 300, 300);
        tabla.setVisible(true);
        tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
