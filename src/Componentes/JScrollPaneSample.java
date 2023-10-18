package Componentes;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneSample {

    public JScrollPaneSample() {
        JTextArea textArea = new JTextArea();
        textArea.setText("Indice LENGUAJES PROGRMACION");
        textArea.append("\n*************");
        textArea.append("\n 1 - Java");
        textArea.append("\n 2 - C");
        textArea.append("\n 3 - Phyton");
        textArea.append("\n 4 - C++");
        textArea.append("\n 5 - Visual Basic .NET");
        textArea.append("\n 6 - JavaScript");
        textArea.append("\n 7 - C#");
        textArea.append("\n 8 - PHP");
        textArea.append("\n 9 - SQL");
        textArea.append("\n 10 - Objective - C");
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(textArea);

        JFrame frame = new JFrame("Ejemplo JScrollPane");
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JScrollPaneSample();
    }

}