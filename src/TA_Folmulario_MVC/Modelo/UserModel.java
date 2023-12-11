// Importación de paquetes y clases necesarias
package TA_Folmulario_MVC.Modelo;

import TA_Folmulario_MVC.Vista.UserView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// Definición de la clase UserModel que extiende de Frame
public class UserModel extends Frame {

    // Declaración de variables
    private DefaultTableModel model;
    private int idCounter = 1; // Agrega un contador de ID

    // Constructor de la clase UserModel
    public UserModel(DefaultTableModel model) {
        // Inicialización del modelo
        this.model = model;
    }

    // Método para obtener el modelo de la tabla
    public DefaultTableModel getModel() {
        return model;
    }

    // Método para incrementar el contador de ID
    public void incrementIdCounter() {
        idCounter++;
    }

    // Método para obtener el valor actual del contador de ID
    public int getIdCounter() {
        return idCounter;
    }
}
