package Componentes;

import javax.swing.*;
import java.awt.*;

public class EjemploJList {
    public static void main(String[] args) {
        // Creamos un nuevo marco (JFrame) con un título
        JFrame frame = new JFrame("Ejemplo de JList");
        // Creamos un DefaultListModel que contendrá los elementos de la lista
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Creamos un JList y lo asociamos con el DefaultListModel
        JList<String> jList = new JList<>(listModel);
        // Agregamos algunos elementos predefinidos a la lista
        listModel.addElement("Elemento 1");
        listModel.addElement("Elemento 2");
        listModel.addElement("Elemento 3");
        listModel.addElement("Elemento 4");
        listModel.addElement("Elemento 5");
        listModel.addElement("Elemento 6");
        listModel.addElement("Elemento 7");
        listModel.addElement("Elemento 8");
        listModel.addElement("Elemento 9");
        listModel.addElement("Elemento 10");

        // Creamos un JScrollPane que contendrá el JList para que la lista sea desplazable
        JScrollPane scrollPane = new JScrollPane(jList);

        // Agregamos el JScrollPane al marco en la región central
        frame.add(scrollPane, BorderLayout.CENTER);
        // Establecemos el tamaño del marco
        frame.setSize(300, 200);
        // Establecemos la operación predeterminada cuando se cierra la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Hacemos el marco visible
        frame.setVisible(true);
    }
}
