package Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_IntelliJ {
    private JPanel Mainpanel;
    private JPanel panel_menu;
    private JMenuBar menubar;
    private JMenu menu_file;
    private JMenuItem item_new;
    private JMenuItem item_open;
    private JMenuItem item_recent;
    private JMenuItem item_close;
    private JMenuItem item_setings;
    private JMenuItem item_project;
    private JMenuItem item_Filepropieties;
    private JMenu menu_edit;
    private JMenu menu_view;
    private JMenu menu_navigate;
    private JMenu menu_Code;
    private JMenu menu_refactor;
    private JMenu menu_build;
    private JMenu menu_run;
    private JMenu menu_tools;
    private JMenu Git;
    private JMenu menu_window;
    private JMenu menu_help;
    private JButton ayudaButton;
    private JLabel descripcion;
    private JLabel Titulo;

    public Menu_IntelliJ() {
        ayudaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Para Mas Información Consulte el Manual de IntelliJ IDEA",
                        "Informacion", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu_IntelliJ");
        frame.setContentPane(new Menu_IntelliJ().Mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Evitar que la ventana sea maximizable
        frame.setResizable(false);
        frame.setBounds(0,  0,  400, 400);
        frame.pack();
        frame.setVisible(true);
    }
}
