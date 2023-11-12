package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCompleta extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField nombreTextField;
    private JPasswordField passwordField;
    private JTextArea textArea;

    public InterfazCompleta() {
        super("Ejemplo de Interfaz Completa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Crear un JPasswordField para contraseñas
        passwordField = new JPasswordField();


        // Crear un JTextField para ingresar nombres
        nombreTextField = new JTextField();

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

        // Crear un panel para organizar la lista y el panel del botón Agregar verticalmente
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JScrollPane(list), BorderLayout.CENTER);
        listPanel.add(agregarPanel, BorderLayout.NORTH);

        // Crear un JTextArea dentro de un JScrollPane
        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Panel para los botones Borrar Lista y Eliminar
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(borrarListaButton);
        buttonPanel.add(eliminarButton);

        // Crear un panel para organizar el JTextArea y los botones debajo
        JPanel textAreaButtonPanel = new JPanel();
        textAreaButtonPanel.setLayout(new BorderLayout());
        textAreaButtonPanel.add(buttonPanel, BorderLayout.NORTH);
        textAreaButtonPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir márgenes
        mainPanel.add(passwordField, BorderLayout.NORTH); // Campo de contraseña arriba
        mainPanel.add(listPanel, BorderLayout.CENTER); // Lista en el centro
        mainPanel.add(textAreaButtonPanel, BorderLayout.SOUTH); // Botones y JTextArea debajo de la lista

        // Agregar el panel principal al contenido del JFrame
        getContentPane().add(mainPanel);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        pack();
    }


    public static void main(String[] args) {
        InterfazCompleta interfaz = new InterfazCompleta();

        interfaz.setVisible(true);
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
