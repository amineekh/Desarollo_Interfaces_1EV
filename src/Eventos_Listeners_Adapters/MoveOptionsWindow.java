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
        super("Move Options");

        // Crear modelos para las listas
        leftListModel = new DefaultListModel<>();
        rightListModel = new DefaultListModel<>();

        // Inicializar las listas con los modelos
        leftList = new JList<>(leftListModel);
        rightList = new JList<>(rightListModel);

        // Crear botones
        JButton moveRightButton = new JButton(">");
        JButton moveLeftButton = new JButton("<");
        JButton addAllButton = new JButton(">>");
        JButton removeAllButton = new JButton("<<");


        // Agregar elementos a la lista izquierda (para demostración)
        leftListModel.addElement("Item 1");
        leftListModel.addElement("Item 2");
        leftListModel.addElement("Item 3");
        leftListModel.addElement("Item 4");

        // Configurar acciones para los botones ">>" y "<<"
        moveRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSelectedItems(leftList, leftListModel, rightListModel);
            }
        });

        moveLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSelectedItems(rightList, rightListModel, leftListModel);
            }
        });

        // Configurar acciones para los botones ">>" y "<<"
        addAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAllItems(leftListModel, rightListModel);
            }
        });

        removeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAllItems(rightListModel, leftListModel);
            }
        });

        // Crear un panel para organizar los botones ">>" y "<<" en el centro
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

    private void moveSelectedItems(JList<String> sourceList, DefaultListModel<String> sourceModel, DefaultListModel<String> targetModel) {
        int[] selectedIndices = sourceList.getSelectedIndices();
        if (selectedIndices.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un elemento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            String item = sourceModel.remove(selectedIndices[i]);
            targetModel.addElement(item);
        }
    }

    private void moveAllItems(DefaultListModel<String> sourceModel, DefaultListModel<String> targetModel) {
        if (sourceModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int size = sourceModel.getSize();
        for (int i = 0; i < size; i++) {
            String item = sourceModel.elementAt(0);
            sourceModel.remove(0);
            targetModel.addElement(item);
        }
    }

    public static void main(String[] args) {
        MoveOptionsWindow window = new MoveOptionsWindow();
        window.setSize(600, 300);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
