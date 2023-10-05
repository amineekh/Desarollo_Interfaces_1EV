package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Calculadora extends JFrame {
    private JTextField pantalla;
    public Calculadora() {
        // Configura la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crea un panel principal con un BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());


        // Crea un panel para la pantalla en la parte superior
        JPanel panelPantalla = new JPanel();
        pantalla = new JTextField(15);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);

        // Configura el color de fondo en la parte superior
        panelPantalla.setBackground(Color.black);

        // Configura el margen superior del panel de texto
        panelPantalla.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Configura el alto del JTextField (panel de pantalla) a un valor más grande
        Dimension alto_panel_pantalla = new Dimension(pantalla.getPreferredSize().width, 35); // Cambia 35 al alto que desees
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
                "0", ".", "=", "+",
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

    public static void main(String[] args) {

            Calculadora calculadora= new Calculadora();
            // Hacer visible la ventana
            calculadora.setVisible(true);

    }
}
