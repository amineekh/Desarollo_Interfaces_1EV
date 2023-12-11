// Importación de paquetes y clases necesarias
package TA_Folmulario_MVC.Controlador;

import TA_Folmulario_MVC.Modelo.UserModel;
import TA_Folmulario_MVC.Vista.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Definición de la clase UserController
public class UserController {

    // Declaración de variables de instancia
    private UserModel model;
    private UserView view;

    // Constructor de la clase UserController que recibe un modelo y una vista
    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    // Método para obtener un ActionListener para el botón "Nuevo"
    public ActionListener getNuevoButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearFields(); // Llama al método clearFields() de la vista para limpiar los campos
            }
        };
    }

    // Método para obtener un ActionListener para el botón "Añadir"
    public ActionListener getAñadirButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si los campos obligatorios están llenos antes de añadir una nueva fila a la tabla
                if (!view.getNombreField().getText().isEmpty() && !view.getApellidoField().getText().isEmpty() &&
                        !view.getEmailField().getText().isEmpty() && !view.getPassField().getText().isEmpty()) {
                    String[] rowData = {
                            view.getIdField().getText(),
                            view.getNombreField().getText(),
                            view.getApellidoField().getText(),
                            view.getDNIField().getText(),
                            view.getEmailField().getText(),
                            view.getPassField().getText()
                    };
                    model.getModel().addRow(rowData); // Añade una nueva fila al modelo de la tabla
                    model.incrementIdCounter(); // Incrementa el contador de ID en el modelo
                    view.getIdField().setText(String.valueOf(model.getIdCounter())); // Actualiza el campo de ID en la vista
                } else {
                    // Muestra un mensaje si los campos obligatorios no están llenos
                    JOptionPane.showMessageDialog(view, "Por favor, rellene los campos obligatorios.");
                }
            }
        };
    }

    // Método para obtener un ActionListener para el botón "Modificar"
    public ActionListener getModificarButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow(); // Obtiene la fila seleccionada en la tabla
                if (selectedRow != -1 && !view.getNombreField().getText().isEmpty() && !view.getApellidoField().getText().isEmpty() &&
                        !view.getEmailField().getText().isEmpty() && !view.getPassField().getText().isEmpty()) {
                    // Actualiza los valores de la fila seleccionada con los valores de los campos de texto en la vista
                    view.getTable().setValueAt(view.getNombreField().getText(), selectedRow, 1);
                    view.getTable().setValueAt(view.getApellidoField().getText(), selectedRow, 2);
                    view.getTable().setValueAt(view.getDNIField().getText(), selectedRow, 3);
                    view.getTable().setValueAt(view.getEmailField().getText(), selectedRow, 4);
                    view.getTable().setValueAt(view.getPassField().getText(), selectedRow, 5);
                } else {
                    // Muestra un mensaje si no se ha seleccionado una fila o los campos obligatorios no están llenos
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila y rellene los campos obligatorios.");
                }
            }
        };
    }

    // Método para obtener un ActionListener para el botón "Borrar"
    public ActionListener getBorrarButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow(); // Obtiene la fila seleccionada en la tabla
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model.getModel().removeRow(selectedRow); // Elimina la fila seleccionada del modelo de la tabla
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila para eliminar."); // Muestra un mensaje si no se ha seleccionado ninguna fila para eliminar
                }
            }
        };
    }

    // Otros métodos y lógica del controlador
}
