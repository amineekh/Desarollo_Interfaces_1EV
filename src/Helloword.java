import javax.swing.*;

public class Helloword extends JFrame {
    private JTextField textField1;
    private JTextField dsfdsfdfsTextField;
    private JTextField sdfdsdfsTextField;
    private JButton nuevoButton;
    private JTextField dsffdsfdTextField;
    private JButton nuevoButton1;
    private JButton eliminarButton;
    private JButton añadirButton;
    private JTextField textField2;
    private JPanel mainpanel;
    private JPanel Panel2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Helloword");
        frame.setContentPane(new Helloword().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
