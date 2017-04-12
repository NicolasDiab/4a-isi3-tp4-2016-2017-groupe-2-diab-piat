package tortue.view;

import tortue.controller.SimpleLogo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {


    private SimpleLogo controller;
    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){

                Window window = new Window();
                window.setVisible(true);
                window.setController(new SimpleLogo());
            }
        });

    }


    @Override
    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e)
    {
        String c = e.getActionCommand();
        this.getController().manageAction(c);
        this.repaint();
    }


    public SimpleLogo getController() {
        return controller;
    }

    public void setController(SimpleLogo controller) {
        this.controller = controller;
    }
}
