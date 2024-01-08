package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import Properties.MyProperties;

public class mainWindow extends Component {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    private JButton button2;
    private JPanel mainPanel;
    private JLabel lb01;
    private JLabel lb02;
    private JButton button3;

    public mainWindow() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLanguage("INGLES");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLanguage("ESPANOL");
            }
        });

        // Acción para el botón Añadir
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showConfirmDialog(mainWindow.this, "ESTE PROGRAMA SIRVE PARA PODER TRADUCIR AL INGLES O ESPAÑOL LA VENTANA DEPIENDIENDO EL IDIOMA QUE ESTE LA VENTANA, CAMBIARA OTRO IDIOMA O A OTRO DEPENDIENDO DEL BOTON AL QUE PULSEMOS", "INFORMACION:", JOptionPane.OK_CANCEL_OPTION);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TRADUCCIÓN DE IDIOMAS");
        frame.setContentPane(new mainWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200,100,500,300);
        frame.setVisible(true);
    }

    public void loadLanguage(String language){
        Properties myProperties = new MyProperties(language);
        lb01.setText(myProperties.getProperty("lbEtiqueta1"));
        lb02.setText(myProperties.getProperty("lbEtiqueta2"));
        button1.setText(myProperties.getProperty("btnIngles"));
        button2.setText(myProperties.getProperty("btnEspanol"));

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
