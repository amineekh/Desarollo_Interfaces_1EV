package Tablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Altadeusuarios {
    private JPanel panel1;
    private JButton nuevoButton;
    private JButton eliminarButton;
    private JButton añadirButton;
    private JButton modificarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTable table1;
    private JPasswordField passwordField;
    private DefaultTableModel tableModel;
    private int nextID = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui_form");
        frame.setContentPane(new Altadeusuarios().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Altadeusuarios() {
        createTable();
        // configuracion de ordenamiento
        TableRowSorter<DefaultTableModel> sorter =new TableRowSorter<>(tableModel);
        table1.setRowSorter(sorter);
        // Ordenar por defecto por el nombre de manera ascendente
        sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
        sorter.sort();

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        });

        añadirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String lastName = textField2.getText();
                String dni = textField3.getText();
                String email = textField4.getText();
                char[] passwordChars = textField5.getText().toCharArray();

                if (name.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos Nombre, Apellidos y Email son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int id = nextID++;
                String password = new String(new char[passwordChars.length]).replace('\0', '*');

                tableModel.addRow(new Object[]{id, name, lastName, dni, email, password});
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String name = textField1.getText();
                    String lastName = textField2.getText();
                    String dni = textField3.getText();
                    String email = textField4.getText();
                    char[] passwordChars = textField5.getText().toCharArray();

                    if (name.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Los campos Nombre, Apellidos y Email son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String password = new String(new char[passwordChars.length]).replace('\0', '*');

                    tableModel.setValueAt(name, selectedRow, 1);
                    tableModel.setValueAt(lastName, selectedRow, 2);
                    tableModel.setValueAt(dni, selectedRow, 3);
                    tableModel.setValueAt(email, selectedRow, 4);
                    tableModel.setValueAt(password, selectedRow, 5);

                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });
    }

    private void createTable() {
        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","Nombre", "Apellidos",  "DNI","Email","Contraseña"}
        ));

        tableModel = (DefaultTableModel) table1.getModel();
    }
}