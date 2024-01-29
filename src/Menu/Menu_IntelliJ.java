package Menu;

import javax.swing.*;

public class Menu_IntelliJ {
    private JPanel Mainpanel;
    private JPanel panel_menu;
    private JMenuBar menubar_file;
    private JMenu menu_file;
    private JMenuItem item_new;
    private JMenuItem item_open;
    private JMenuItem item_recent;
    private JMenuItem item_close;
    private JMenuItem item_setings;
    private JMenuItem item_project;
    private JMenuItem item_Filepropieties;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu_IntelliJ");
        frame.setContentPane(new Menu_IntelliJ().Mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
