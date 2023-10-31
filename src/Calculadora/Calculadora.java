package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//calculadora funcional
public class Calculadora extends JFrame {
    private JTextField pantalla;
    private double resultado = 0;
    private String operador = "";
    private boolean inicio = true;

    private Stack<Double> numeros = new Stack<>();
    private Stack<Character> operadores = new Stack<>();

    public Calculadora() {
        // Configura la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crea un panel para la pantalla en la parte superior
        JPanel panelPantalla = new JPanel();
        pantalla = new JTextField(13);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        // Configura el tamaño del texto de los botones
        pantalla.setFont(new Font("Arial", Font.PLAIN, 18));

        // Crea un panel principal con un BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Configura el color de fondo en la parte superior
        panelPantalla.setBackground(Color.black);

        // Configura el margen superior del panel de texto
        panelPantalla.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Configura el alto del JTextField (panel de pantalla) a un valor más grande
        Dimension alto_panel_pantalla = new Dimension(pantalla.getPreferredSize().width, 45); // Cambia 35 al alto que desees
        pantalla.setPreferredSize(alto_panel_pantalla);

        // Configura el color de fondo y el color de texto de la pantalla
        pantalla.setBackground(Color.black);
        pantalla.setForeground(Color.white);

        panelPantalla.add(pantalla);

        // Crea el panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 4, 5, 5)); // 5 filas para acomodar los botones especiales

        // Configura el color de fondo del panel de botones
        panelBotones.setBackground(Color.black);

        // Agrega los botones a panelBotones
        String[] botones = {
                "%", "√", "x²", "C",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
        };

        // Crea un mapa para asociar botones con colores de fondo
        Map<String, Color> botonesColores = new HashMap<>();
        botonesColores.put("%", Color.blue);
        botonesColores.put("√", Color.blue);
        botonesColores.put("x²", Color.blue);
        botonesColores.put("C", Color.blue);
        botonesColores.put("/", Color.blue);
        botonesColores.put("*", Color.blue);
        botonesColores.put("-", Color.blue);
        botonesColores.put("+", Color.blue);

        // Crea un mapa para asociar botones con color de texto
        Map<String, Color> botonesColoresTexto = new HashMap<>();
        botonesColoresTexto.put("%", Color.WHITE); // Color de texto para "%"
        botonesColoresTexto.put("√", Color.WHITE); // Color de texto para "√"
        botonesColoresTexto.put("x²", Color.WHITE); // Color de texto para "x²"
        botonesColoresTexto.put("C", Color.WHITE); // Color de texto para "C"
        botonesColoresTexto.put("/", Color.WHITE); // Color de texto para "/"
        botonesColoresTexto.put("*", Color.WHITE); // Color de texto para "*"
        botonesColoresTexto.put("-", Color.WHITE); // Color de texto para "-"
        botonesColoresTexto.put("+", Color.WHITE); // Color de texto para "+"

        for (String boton : botones) {
            JButton btn = new JButton(boton);

            // Configura el tamaño de los botones
            btn.setPreferredSize(new Dimension(20, 20));

            // Configura el color de fondo y el color de texto de los botones
            btn.setBackground(Color.black);
            btn.setForeground(Color.green);

            // Configura el tamaño real de los botones
            btn.setSize(btn.getPreferredSize());

            // Configura el tamaño del texto de los botones
            btn.setFont(new Font("Arial", Font.PLAIN, 18));

            // Verifica si el botón está en el mapa de colores y establece el color de fondo correspondiente
            if (botonesColores.containsKey(boton)) {
                btn.setBackground(botonesColores.get(boton));
            } else {
                btn.setBackground(Color.BLACK); // Color de fondo predeterminado para otros botones
            }
            // Configura el color de texto de los botones
            if (botonesColoresTexto.containsKey(boton)) {
                btn.setForeground(botonesColoresTexto.get(boton));
            } else {
                btn.setForeground(Color.GREEN); // Color de texto predeterminado para otros botones
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

        // Configura el margen de los botones
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Agrega los paneles al panel principal
        panelPrincipal.add(panelPantalla, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);



        // Agrega el panel principal a la ventana
        add(panelPrincipal);
    }

    // Método para realizar operaciones en la calculadora
    private void operar(String boton) {
        // Se verifica si el botón es de reinicio
        if (boton.equals("C")) {
            // Se limpia la pantalla y se reinician las variables
            pantalla.setText("");
            resultado = 0;
            operador = "";
            inicio = true;
            numeros.clear();
            operadores.clear();
        }
        // Se verifica si el botón es de alguna operación aritmética
        else if (boton.matches("[+*/-]")) {
            // Se guarda el operador en la pila de operadores y el número en la pila de números
            operadores.push(boton.charAt(0));
            if (!pantalla.getText().isEmpty()) {
                numeros.push(Double.parseDouble(pantalla.getText()));
            }
            pantalla.setText("");
            inicio = true;
        }
        // Se verifica si el botón es de igualdad para obtener el resultado
        else if (boton.equals("=")) {
            if (!pantalla.getText().isEmpty()) {
                numeros.push(Double.parseDouble(pantalla.getText()));
            }
            // Se realiza el cálculo de acuerdo con el operador almacenado
            while (!operadores.isEmpty()) {
                char operadorActual = operadores.pop();
                double num2 = numeros.pop();
                double num1 = numeros.pop();
                switch (operadorActual) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        resultado = num1 * num2;
                        break;
                    case '/':
                        resultado = num1 / num2;
                        break;
                }
                numeros.push(resultado);
            }
            // Se muestra el resultado en la pantalla
            pantalla.setText(String.valueOf(numeros.peek()));
            resultado = numeros.pop();
            inicio = true;
        }
        // Se verifica si el botón es para agregar un punto decimal
        else if (boton.equals(".")) {
            if (!pantalla.getText().contains(".")) {
                pantalla.setText(pantalla.getText() + ".");
                inicio = false;
            }
        }
        // Se verifica si el botón es para calcular un porcentaje
        else if (boton.equals("%")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = numero / 100;
            pantalla.setText(String.valueOf(resultado));
        }
        // Se verifica si el botón es para calcular la raíz cuadrada
        else if (boton.equals("√")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = Math.sqrt(numero);
            pantalla.setText(String.valueOf(resultado));
        }
        // Se verifica si el botón es para elevar un número al cuadrado
        else if (boton.equals("x²")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = Math.pow(numero, 2);
            pantalla.setText(String.valueOf(resultado));
        }
    }
    public static void main(String[] args) {

        Calculadora calculadora= new Calculadora();
        // Hacer visible la ventana
        calculadora.setVisible(true);
        calculadora.setResizable(false);

    }
}
