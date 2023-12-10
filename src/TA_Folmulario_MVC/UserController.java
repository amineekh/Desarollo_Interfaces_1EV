package TA_Folmulario_MVC;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public ActionListener getNuevoButtonListener() {
        return e -> view.clearFields();
    }

    public ActionListener getAñadirButtonListener() {
        return e -> {
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
                model.getModel().addRow(rowData);
                model.incrementIdCounter();
                view.getIdField().setText(String.valueOf(model.getIdCounter()));
            } else {
                JOptionPane.showMessageDialog(view, "Por favor, rellene los campos obligatorios.");
            }
        };
    }

    public ActionListener getModificarButtonListener() {
        return e -> {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow != -1 && !view.getNombreField().getText().isEmpty() && !view.getApellidoField().getText().isEmpty() &&
                    !view.getEmailField().getText().isEmpty() && !view.getPassField().getText().isEmpty()) {
                view.getTable().setValueAt(view.getNombreField().getText(), selectedRow, 1);
                view.getTable().setValueAt(view.getApellidoField().getText(), selectedRow, 2);
                view.getTable().setValueAt(view.getDNIField().getText(), selectedRow, 3);
                view.getTable().setValueAt(view.getEmailField().getText(), selectedRow, 4);
                view.getTable().setValueAt(view.getPassField().getText(), selectedRow, 5);
            } else {
                JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila y rellene los campos obligatorios.");
            }
        };
    }

    public ActionListener getBorrarButtonListener() {
        return e -> {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow != -1) {
                int confirm = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    model.getModel().removeRow(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila para eliminar.");
            }
        };
    }

    // Otros métodos y lógica del controlador
}
