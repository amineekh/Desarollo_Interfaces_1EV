package Layaouts; // Declaración del paquete

import javax.swing.*; // Importación de las clases de interfaz gráfica
import java.awt.*; // Importación de clases para manejo de GUI
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Declaración de la clase principal para demostrar el uso de GridBagLayout
public class GridBagLayoutDemo extends JFrame {

    private JPanel mainPanel; // Panel principal que utiliza GridBagLayout
    private JButton button1; // Primer botón en el panel
    private JButton button4; // Cuarto botón en el panel

    // Constructor de la clase
    public GridBagLayoutDemo() {
        // Inicialización del panel principal con GridBagLayout
        mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.GridBagLayout());

        // Inicialización de los botones
        button1 = new JButton("Button 1");
        button4 = new JButton("Long named button 4");

        // Configuración de restricciones para el botón 1 en GridBagLayout
        GridBagConstraints gbcButton1 = new GridBagConstraints();
        gbcButton1.gridx = 0;
        gbcButton1.gridy = 0;
        gbcButton1.gridwidth = 1;
        gbcButton1.gridheight = 1;
        gbcButton1.weightx = 1.0;
        gbcButton1.weighty = 1.0;
        gbcButton1.fill = GridBagConstraints.BOTH;
        gbcButton1.insets = new Insets(0, 0, 0, 0);

        // Configuración de ActionListener para el botón 1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Elimina el botón 4 del panel
                mainPanel.remove(button4);

                // Agrega un JLabel con el mensaje en lugar del botón 4
                JLabel messageLabel = new JLabel("Texto convertido por el botón 1");
                GridBagConstraints gbcMessageLabel = new GridBagConstraints();
                gbcMessageLabel.gridx = 0;
                gbcMessageLabel.gridy = 1;
                gbcMessageLabel.gridwidth = 3;
                gbcMessageLabel.gridheight = 1;
                gbcMessageLabel.weightx = 1.0;
                gbcMessageLabel.weighty = 4.0;
                gbcMessageLabel.fill = GridBagConstraints.BOTH;
                gbcMessageLabel.insets = new Insets(0, 0, 0, 0);
                mainPanel.add(messageLabel, gbcMessageLabel);

                // Repinta el panel para reflejar los cambios
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        // Agrega el botón 1 al panel principal con las restricciones definidas
        mainPanel.add(button1, gbcButton1);

        // Configuración de restricciones para el botón 4 en GridBagLayout
        GridBagConstraints gbcButton4 = new GridBagConstraints();
        gbcButton4.gridx = 0;
        gbcButton4.gridy = 1;
        gbcButton4.gridwidth = 3;
        gbcButton4.gridheight = 1;
        gbcButton4.weightx = 1.0;
        gbcButton4.weighty = 4.0;
        gbcButton4.fill = GridBagConstraints.BOTH;
        gbcButton4.insets = new Insets(0, 0, 0, 0);

        // Agrega el botón 4 al panel principal con las restricciones definidas
        mainPanel.add(button4, gbcButton4);

        // Agrega otros botones al panel principal sin cambios en las restricciones
        // Agrega el botón 2 al panel principal con restricciones específicas
        mainPanel.add(
                new JButton("Button 2"),  // Creación de un nuevo botón con etiqueta "Button 2"
                new GridBagConstraints(   // Configuración de las restricciones utilizando GridBagConstraints
                        1,                 // Posición en la cuadrícula en el eje X (columna)
                        0,                 // Posición en la cuadrícula en el eje Y (fila)
                        1,                 // Número de columnas que ocupa en la cuadrícula
                        1,                 // Número de filas que ocupa en la cuadrícula
                        1.0,               // Peso en el eje X (ancho relativo)
                        1.0,               // Peso en el eje Y (altura relativa)
                        GridBagConstraints.CENTER,  // Alineación horizontal (en el centro)
                        GridBagConstraints.BOTH,    // Relleno en ambas direcciones (horizontal y vertical)
                        new Insets(0, 0, 0, 0),      // Espaciado externo (insets)
                        0,                 // Relleno interno en el eje X
                        0                  // Relleno interno en el eje Y
                ));

        // Agrega el botón 3 al panel principal con restricciones específicas
        mainPanel.add(
                new JButton("Button 3"),  // Creación de un nuevo botón con etiqueta "Button 3"
                new GridBagConstraints(   // Configuración de las restricciones utilizando GridBagConstraints
                        2,                 // Posición en la cuadrícula en el eje X (columna)
                        0,                 // Posición en la cuadrícula en el eje Y (fila)
                        1,                 // Número de columnas que ocupa en la cuadrícula
                        1,                 // Número de filas que ocupa en la cuadrícula
                        1.0,               // Peso en el eje X (ancho relativo)
                        1.0,               // Peso en el eje Y (altura relativa)
                        GridBagConstraints.CENTER,  // Alineación horizontal (en el centro)
                        GridBagConstraints.BOTH,    // Relleno en ambas direcciones (horizontal y vertical)
                        new Insets(0, 0, 0, 0),      // Espaciado externo (insets)
                        0,                 // Relleno interno en el eje X
                        0                  // Relleno interno en el eje Y
                ));

        // Agrega el botón 5 al panel principal con restricciones específicas
        mainPanel.add(
                new JButton("5"),          // Creación de un nuevo botón con etiqueta "5"
                new GridBagConstraints(   // Configuración de las restricciones utilizando GridBagConstraints
                        1,                 // Posición en la cuadrícula en el eje X (columna)
                        2,                 // Posición en la cuadrícula en el eje Y (fila)
                        2,                 // Número de columnas que ocupa en la cuadrícula
                        1,                 // Número de filas que ocupa en la cuadrícula
                        1.0,               // Peso en el eje X (ancho relativo)
                        1.0,               // Peso en el eje Y (altura relativa)
                        GridBagConstraints.SOUTH,   // Alineación en la parte inferior
                        GridBagConstraints.HORIZONTAL, // Relleno solo en dirección horizontal
                        new Insets(0, 0, 0, 0),      // Espaciado externo (insets)
                        0,                 // Relleno interno en el eje X
                        0                  // Relleno interno en el eje Y
                ));

        // Agrega el panel principal a la ventana
        add(mainPanel);

        // Configuración de la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configuración del tamaño de la ventana
        setSize(400, 200);
        // Hace visible la ventana
        setVisible(true);
    }

    // Método principal para iniciar la aplicación Swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crea una instancia de GridBagLayoutDemo al ejecutar la aplicación
                new GridBagLayoutDemo();
            }
        });
    }
}
