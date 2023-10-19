package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

// calculadora funcional
public class Prueba_calculadora  extends JFrame {
    private JTextField pantalla;
    private double resultado = 0;
    private String operador = "";
    private boolean inicio = true;

    // Creación de la clase Calculadora
    public Prueba_calculadora () {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Creación de un panel para la pantalla en la parte superior
        JPanel panelPantalla = new JPanel();
        pantalla = new JTextField(13);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.PLAIN, 18));

        // Configuración del color de fondo en la parte superior
        panelPantalla.setBackground(Color.BLACK);
        panelPantalla.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Configuración del tamaño del JTextField (panel de pantalla) a un valor más grande
        Dimension alto_panel_pantalla = new Dimension(pantalla.getPreferredSize().width, 45);
        pantalla.setPreferredSize(alto_panel_pantalla);
        pantalla.setBackground(Color.BLACK);
        pantalla.setForeground(Color.WHITE);
        panelPantalla.add(pantalla);

        // Creación del panel principal con un BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Creación del panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 4, 5, 5));

        // Configuración del color de fondo del panel de botones
        panelBotones.setBackground(Color.BLACK);

        // Arreglo de los botones de la calculadora
        String[] botones = {
                "%", "√", "x²", "C",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
        };

        // Mapa para asociar botones con colores de fondo
        Map<String, Color> botonesColores = new HashMap<>();
        botonesColores.put("%", Color.BLUE);
        botonesColores.put("√", Color.BLUE);
        botonesColores.put("x²", Color.BLUE);
        botonesColores.put("C", Color.BLUE);
        botonesColores.put("/", Color.BLUE);
        botonesColores.put("*", Color.BLUE);
        botonesColores.put("-", Color.BLUE);
        botonesColores.put("+", Color.BLUE);

        // Mapa para asociar botones con color de texto
        Map<String, Color> botonesColoresTexto = new HashMap<>();
        botonesColoresTexto.put("%", Color.WHITE);
        botonesColoresTexto.put("√", Color.WHITE);
        botonesColoresTexto.put("x²", Color.WHITE);
        botonesColoresTexto.put("C", Color.WHITE);
        botonesColoresTexto.put("/", Color.WHITE);
        botonesColoresTexto.put("*", Color.WHITE);
        botonesColoresTexto.put("-", Color.WHITE);
        botonesColoresTexto.put("+", Color.WHITE);

        // Agregando los botones al panel de botones
        for (String boton : botones) {
            JButton btn = new JButton(boton);
            btn.setPreferredSize(new Dimension(20, 20));
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.GREEN);
            btn.setSize(btn.getPreferredSize());
            btn.setFont(new Font("Arial", Font.PLAIN, 18));

            if (botonesColores.containsKey(boton)) {
                btn.setBackground(botonesColores.get(boton));
            }

            if (botonesColoresTexto.containsKey(boton)) {
                btn.setForeground(botonesColoresTexto.get(boton));
            }

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String textoEnPantalla = pantalla.getText();
                    String textoBoton = e.getActionCommand();

                    if (textoBoton.matches("[0-9]")) {
                        if (inicio) {
                            textoEnPantalla = "";
                            inicio = false;
                        }
                        pantalla.setText(textoEnPantalla + textoBoton);
                    } else {
                        operar(textoBoton);
                    }
                }
            });

            panelBotones.add(btn);
        }

        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelPrincipal.add(panelPantalla, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    // Método para realizar operaciones
    private void operar(String boton) {
        if (boton.equals("C")) {
            pantalla.setText("");
            resultado = 0;
            operador = "";
            inicio = true;
        } else if (boton.matches("[+\\-*/]")) {
            realizarOperacionAnterior();
            operador = boton;
            resultado = Double.parseDouble(pantalla.getText());
            inicio = true;
        } else if (boton.equals("=")) {
            realizarOperacionAnterior();
            inicio = true;
        } else if (boton.equals(".")) {
            if (!pantalla.getText().contains(".")) {
                pantalla.setText(pantalla.getText() + ".");
                inicio = false;
            }
        } else if (boton.equals("%")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = numero / 100;
            pantalla.setText("" + resultado);
        } else if (boton.equals("√")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = Math.sqrt(numero);
            pantalla.setText("" + resultado);
        } else if (boton.equals("x²")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = Math.pow(numero, 2);
            pantalla.setText("" + resultado);
        }

    }

    // Método para realizar la operación anterior
    private void realizarOperacionAnterior() {
        if (!operador.equals("")) {
            double segundoNumero = Double.parseDouble(pantalla.getText());
            switch (operador) {
                case "+":
                    resultado += segundoNumero;
                    break;
                case "-":
                    resultado -= segundoNumero;
                    break;
                case "*":
                    resultado *= segundoNumero;
                    break;
                case "/":
                    resultado /= segundoNumero;
                    break;
            }
            pantalla.setText("" + resultado);
        }
    }

    // Método principal
    public static void main(String[] args) {
        Prueba_calculadora Prueba_calculadora  = new Prueba_calculadora ();
        Prueba_calculadora .setVisible(true);
    }
}
