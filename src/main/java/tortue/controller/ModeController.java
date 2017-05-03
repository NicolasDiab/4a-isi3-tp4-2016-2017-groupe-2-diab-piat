package tortue.controller;


import tortue.view.ModeWindow;
import tortue.view.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        Window window = new Window();

        switch (c) {
            case "Tortues controlées":
                System.out.println("Tortues controlées");
                ManualController manualController = new ManualController(window);
                manualController.setWindow(window);
                window.setController(manualController);
                window.logoInit();
                break;
            case "Tortues aléatoires":
                System.out.println("Tortues aléatoires");
                RandomController randomController = new RandomController(window);
                randomController.setWindow(window);
                window.setController(randomController);
                window.logoInit();
                break;
            case "Flocking":
                System.out.println("Flocking");
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
