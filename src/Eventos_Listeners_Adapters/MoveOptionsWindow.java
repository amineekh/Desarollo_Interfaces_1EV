package Eventos_Listeners_Adapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveOptionsWindow extends JFrame {
    private DefaultListModel<String> leftListModel;
    private DefaultListModel<String> rightListModel;
    private JList<String> leftList;
    private JList<String> rightList;

    public MoveOptionsWindow() {
        super("Move Options");  // Crear una ventana con título "Move Options"

        // Crear modelos para las listas
        leftListModel = new DefaultListModel<>();
        rightListModel = new DefaultListModel<>();

        // Inicializar las listas con los modelos
        leftList = new JList<>(leftListModel);
        rightList = new JList<>(rightListModel);

        // Crear botones
        JButton moveRightButton = new JButton(">");  // Botón para mover elementos de izquierda a derecha
        JButton moveLeftButton = new JButton("<");   // Botón para mover elementos de derecha a izquierda
        JButton addAllButton = new JButton(">>");     // Botón para mover todos los elementos de izquierda a derecha
        JButton removeAllButton = new JButton("<<");  // Botón para mover todos los elementos de derecha a izquierda

        // Agregar elementos a la lista izquierda (para demostración)
        leftListModel.addElement("Item 1");
        leftListModel.addElement("Item 2");
        leftListModel.addElement("Item 3");
        leftListModel.addElement("Item 4");

        // Configurar acciones para los botones ">", "<", ">>" y "<<"

        // Configurar la acción para el botón ">"
        moveRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSelectedItems(leftList, leftListModel, rightListModel);
            }
        });


        // Configurar la acción para el botón "<"
        moveLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSelectedItems(rightList, rightListModel, leftListModel);
            }
        });

        // Configurar la acción para el botón ">>"
        addAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAllItems(leftListModel, rightListModel);
            }
        });

        // Configurar la acción para el botón "<<"
        removeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAllItems(rightListModel, leftListModel);
            }
        });

        // Crear un panel para organizar los botones ">", "<", ">>" y "<<" en el centro
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(moveRightButton);
        buttonPanel.add(moveLeftButton);
        buttonPanel.add(addAllButton);
        buttonPanel.add(removeAllButton);

        // Crear etiquetas para las cajas de lista
        JLabel leftLabel = new JLabel("Disponibles");
        JLabel rightLabel = new JLabel("Seleccionados");

        // Crear un panel principal con GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        // Agregar la etiqueta y el JScrollPane de la lista izquierda con márgenes
        mainPanel.add(leftLabel, constraints);
        constraints.insets = new Insets(10, 10, 10, 10); // Márgenes
        constraints.gridy++;
        mainPanel.add(new JScrollPane(leftList), constraints);

        constraints.gridx = 1;
        constraints.insets = new Insets(0, 10, 0, 10); // Restablecer márgenes
        mainPanel.add(buttonPanel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0; // Ajustar a la misma fila que la etiqueta "Disponibles"
        constraints.insets = new Insets(10, 10, 10, 10); // Márgenes
        mainPanel.add(rightLabel, constraints);
        constraints.gridy++; // Ajustar a la siguiente fila
        mainPanel.add(new JScrollPane(rightList), constraints);

        // Agregar el panel principal al contenido del JFrame
        getContentPane().add(mainPanel);
    }

    // Método para mover los elementos seleccionados entre listas
    private void moveSelectedItems(JList<String> sourceList, DefaultListModel<String> sourceModel, DefaultListModel<String> targetModel) {
        // Obtener índices de elementos seleccionados en la lista de origen
        int[] selectedIndices = sourceList.getSelectedIndices();

        // Verificar si se seleccionó al menos un elemento
        if (selectedIndices.length == 0) {
            // Mostrar mensaje de error y salir del método si no hay elementos seleccionados
            JOptionPane.showMessageDialog(this, "Seleccione al menos un elemento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Iterar a través de los índices seleccionados en orden inverso
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            // Obtener el elemento correspondiente al índice actual
            String item = sourceModel.remove(selectedIndices[i]);
            // Agregar el elemento a la lista de destino
            targetModel.addElement(item);
        }
    }


    // Método para mover todos los elementos entre listas
    private void moveAllItems(DefaultListModel<String> sourceModel, DefaultListModel<String> targetModel) {
        // Verificar si la lista de origen está vacía
        if (sourceModel.isEmpty()) {
            // Mostrar mensaje de error y salir del método si la lista de origen está vacía
            JOptionPane.showMessageDialog(this, "La lista está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el tamaño de la lista de origen
        int size = sourceModel.getSize();

        // Iterar a través de la lista de origen
        for (int i = 0; i < size; i++) {
            // Obtener el primer elemento de la lista de origen
            String item = sourceModel.elementAt(0);
            // Eliminar el elemento de la lista de origen
            sourceModel.remove(0);
            // Agregar el elemento a la lista de destino
            targetModel.addElement(item);
        }
    }


    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        MoveOptionsWindow window = new MoveOptionsWindow();
        window.setSize(600, 300);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
