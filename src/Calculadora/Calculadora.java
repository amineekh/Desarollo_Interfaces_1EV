package Calculadora; // Declaración del paquete

import javax.swing.*; // Importación de las clases de interfaz gráfica
import java.awt.*; // Importación de clases para manejo de GUI
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; // Para poner solo números en la pantalla de la calculadora y no letras

// Declaración de la clase principal que representa una calculadora
public class Calculadora extends JFrame implements KeyListener {
    // Declaración de variables de la calculadora
    private JTextField pantalla;
    private double resultado = 0;
    private String operador = "";
    private boolean inicio = true;

    private Stack<Double> numeros = new Stack<>();
    private Stack<Character> operadores = new Stack<>();

    // Constructor de la clase Calculadora
    public Calculadora() {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Creación de un panel para la pantalla en la parte superior
        JPanel panelPantalla = new JPanel();
        pantalla = new JTextField(13);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.addKeyListener(this); // Para permitir solo números en la pantalla de la calculadora
        pantalla.setFont(new Font("Arial", Font.PLAIN, 18));

        // Creación de un panel principal con un BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Configuración del color de fondo en la parte superior
        panelPantalla.setBackground(Color.black);

        // Configuración del margen superior del panel de texto
        panelPantalla.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Configuración del alto del JTextField (panel de pantalla) a un valor más grande
        Dimension alto_panel_pantalla = new Dimension(pantalla.getPreferredSize().width, 45);
        pantalla.setPreferredSize(alto_panel_pantalla);

        // Configuración del color de fondo y el color de texto de la pantalla
        pantalla.setBackground(Color.black);
        pantalla.setForeground(Color.white);

        panelPantalla.add(pantalla);

        // Creación del panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 4, 5, 5)); // 5 filas para acomodar los botones especiales

        // Configuración del color de fondo del panel de botones
        panelBotones.setBackground(Color.black);

        // Adición de los botones a panelBotones
        String[] botones = {
                "%", "√", "x²", "C",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
        };

        // Creación de un mapa para asociar botones con colores de fondo
        Map<String, Color> botonesColores = new HashMap<>();
        botonesColores.put("%", Color.blue);
        botonesColores.put("√", Color.blue);
        botonesColores.put("x²", Color.blue);
        botonesColores.put("C", Color.blue);
        botonesColores.put("/", Color.blue);
        botonesColores.put("*", Color.blue);
        botonesColores.put("-", Color.blue);
        botonesColores.put("+", Color.blue);

        // Creación de un mapa para asociar botones con color de texto
        Map<String, Color> botonesColoresTexto = new HashMap<>();
        botonesColoresTexto.put("%", Color.WHITE); // Color de texto para "%"
        botonesColoresTexto.put("√", Color.WHITE); // Color de texto para "√"
        botonesColoresTexto.put("x²", Color.WHITE); // Color de texto para "x²"
        botonesColoresTexto.put("C", Color.WHITE); // Color de texto para "C"
        botonesColoresTexto.put("/", Color.WHITE); // Color de texto para "/"
        botonesColoresTexto.put("*", Color.WHITE); // Color de texto para "*"
        botonesColoresTexto.put("-", Color.WHITE); // Color de texto para "-"
        botonesColoresTexto.put("+", Color.WHITE); // Color de texto para "+"

        // Iteración sobre los botones y adición al panel
        for (String boton : botones) {
            JButton btn = new JButton(boton);

            // Configuración del tamaño de los botones
            btn.setPreferredSize(new Dimension(20, 20));

            // Configuración del color de fondo y el color de texto de los botones
            btn.setBackground(Color.black);
            btn.setForeground(Color.green);

            // Configuración del tamaño real de los botones
            btn.setSize(btn.getPreferredSize());

            // Configuración del tamaño del texto de los botones
            btn.setFont(new Font("Arial", Font.PLAIN, 18));

            // Verificación si el botón está en el mapa de colores y establecimiento de color de fondo correspondiente
            if (botonesColores.containsKey(boton)) {
                btn.setBackground(botonesColores.get(boton));
            } else {
                btn.setBackground(Color.BLACK); // Color de fondo predeterminado para otros botones
            }
            // Configuración del color de texto de los botones
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

        // Configuración del margen de los botones
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adición de los paneles al panel principal
        panelPrincipal.add(panelPantalla, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Adición del panel principal a la ventana
        add(panelPrincipal);
    }

    // Método para realizar operaciones en la calculadora
    private void operar(String boton) {
        // Verificación si el botón es de reinicio
        if (boton.equals("C")) {
            // Limpieza de la pantalla y reinicio de las variables
            pantalla.setText("");
            resultado = 0;
            operador = "";
            inicio = true;
            numeros.clear();
            operadores.clear();
        }
        // Verificación si el botón es de alguna operación aritmética
        else if (boton.matches("[+*/-]")) {
            // Almacenamiento del operador en la pila de operadores y el número en la pila de números
            operadores.push(boton.charAt(0));
            if (!pantalla.getText().isEmpty()) {
                numeros.push(Double.parseDouble(pantalla.getText()));
            }
            pantalla.setText("");
            inicio = true;
        }
        // Verificación si el botón es de igualdad para obtener el resultado
        else if (boton.equals("=")) {
            if (!pantalla.getText().isEmpty()) {
                numeros.push(Double.parseDouble(pantalla.getText()));
            }
            // Cálculo de acuerdo con el operador almacenado
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
            // Mostrar el resultado en la pantalla
            pantalla.setText(String.valueOf(numeros.peek()));
            resultado = numeros.pop();
            inicio = true;
        }
        // Verificación si el botón es para agregar un punto decimal
        else if (boton.equals(".")) {
            if (!pantalla.getText().contains(".")) {
                pantalla.setText(pantalla.getText() + ".");
                inicio = false;
            }
        }
        // Verificación si el botón es para calcular un porcentaje
        else if (boton.equals("%")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = numero / 100;
            pantalla.setText(String.valueOf(resultado));
        }
        // Verificación si el botón es para calcular la raíz cuadrada
        else if (boton.equals("√")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = Math.sqrt(numero);
            pantalla.setText(String.valueOf(resultado));
        }
        // Verificación si el botón es para elevar un número al cuadrado
        else if (boton.equals("x²")) {
            double numero = Double.parseDouble(pantalla.getText());
            resultado = Math.pow(numero, 2);
            pantalla.setText(String.valueOf(resultado));
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        // Creación de una instancia de la calculadora y hacer visible la ventana
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
        calculadora.setResizable(false);
    }

    // Implementación de métodos de la interfaz KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        // Método para permitir solo números en la pantalla de la calculadora
        char c = e.getKeyChar();
        if (Character.isLetter(c)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Métodos de la interfaz KeyListener no utilizados en este ejemplo
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Métodos de la interfaz KeyListener no utilizados en este ejemplo
    }
}
