package tortue.controller;


import tortue.view.ModeWindow;
import tortue.view.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class ModeController implements ActionListener {

    private ModeWindow window;


    private void quitter() {
        System.exit(0);
    }

    public ModeController(ModeWindow window) {
        this.setWindow(window);
    }

    @Override
    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        switch (c) {
            case "Mode 1":
                System.out.println("Mode 1");
                break;
            case "Mode 2":
                System.out.println("Mode 2");
                break;
            case "Mode 3":
                System.out.println("Mode 3");
                break;

        }
    }



    public ModeWindow getWindow() {
        return window;
    }

    public void setWindow(ModeWindow window) {
        this.window = window;
    }


    public void update(Observable o, Object arg) {
        this.getWindow().repaint();
    }

}
