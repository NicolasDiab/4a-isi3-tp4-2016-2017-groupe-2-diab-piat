package tortue.controller;// package logo;

import tortue.model.Tortue;
import tortue.model.shapes.Poly;
import tortue.model.shapes.Spiral;
import tortue.model.shapes.Square;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/


 **************************************************************************/


public class LogoController implements ActionListener {
    private FeuilleDessin feuille;
    private Tortue courante;
    private Window window;

    private void quitter() {
        System.exit(0);
    }

    public LogoController(Window window) {
        this.setWindow(window);
    }

    public String getInputValueString() {
        return this.getWindow().getInputValue().getText();
    }

    @Override
    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) e.getSource();
            int n = cb.getSelectedIndex();
            getCourante().setColor(n);
        } else {
            String c = e.getActionCommand();

            switch (c) {
                case "Avancer":
                    System.out.println("command avancer");
                    try {
                        int v = Integer.parseInt(this.getInputValueString());
                        getCourante().avancer(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
                    }
                    break;
                case "Droite":
                    try {
                        int v = Integer.parseInt(this.getInputValueString());
                        getCourante().droite(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
                    }
                    break;
                case "Gauche":
                    try {
                        int v = Integer.parseInt(this.getInputValueString());
                        getCourante().gauche(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
                    }
                    break;
                case "Lever":
                    getCourante().leverCrayon();
                    break;
                case "Baisser":
                    getCourante().baisserCrayon();
                    // actions des boutons du bas
                case "Proc1":
                    proc1();
                    break;
                case "Proc2":
                    proc2();
                    break;
                case "Proc3":
                    proc3();
                    break;
                case "Effacer":
                    effacer();
                    break;
                case "Quitter":
                    quitter();
                    break;
            }

            getWindow().repaint();
        }
    }

    public void manageAction(String c) {
        // actions des boutons du haut


        getFeuille().repaint();
    }

    /**
     * les procedures Logo qui combinent plusieurs commandes..
     */

  	/* Square */
    public void proc1() {
        new Square(getCourante());
    }

    /* Poly */
    public void proc2() {
        new Poly(getCourante(), 60, 8);
    }

    /* Spiral */
    public void proc3() {
        new Spiral(getCourante(), 50, 40, 6);
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        getFeuille().reset();
        getFeuille().repaint();

        // Replace la tortue au centre
        Dimension size = getFeuille().getSize();
        getCourante().setPosition(size.width / 2, size.height / 2);
    }


    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void setFeuille(FeuilleDessin feuille) {
        this.feuille = feuille;
    }

    public Tortue getCourante() {
        return courante;
    }

    public void setCourante(Tortue courante) {
        this.courante = courante;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }
}
