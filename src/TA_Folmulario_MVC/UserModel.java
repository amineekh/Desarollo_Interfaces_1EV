package TA_Folmulario_MVC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserModel {
    private DefaultTableModel model;
    private int idCounter = 1; // Agrega un contador de ID

    public UserModel(DefaultTableModel model) {
        this.model = model;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void incrementIdCounter() {
        idCounter++;
    }

    public int getIdCounter() {
        return idCounter;
    }
    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel();
        UserView userView = new UserView(model);

        // Configuración inicial de la ventana
        userView.setTitle("User Application");
        userView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible la ventana
        userView.setVisible(true);
    }
}
