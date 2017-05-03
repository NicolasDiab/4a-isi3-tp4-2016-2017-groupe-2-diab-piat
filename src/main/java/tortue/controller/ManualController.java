package tortue.controller;// package logo;

import tortue.model.Tortue;
import tortue.model.shapes.Poly;
import tortue.model.shapes.Spiral;
import tortue.model.shapes.Square;
import tortue.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ManualController extends TurtleController {

    private Tortue courante;

    public ManualController(Window window) {
        super(window);
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
            this.getCourante().setColor(n);
        } else {
            String c = e.getActionCommand();

            switch (c) {
                case "Avancer":
                    System.out.println("command avancer");
                    try {
                        int v = Integer.parseInt(this.getInputValueString());
                        this.getCourante().avancer(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
                    }
                    break;
                case "Droite":
                    try {
                        int v = Integer.parseInt(this.getInputValueString());
                        this.getCourante().droite(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
                    }
                    break;
                case "Gauche":
                    try {
                        int v = Integer.parseInt(this.getInputValueString());
                        this.getCourante().gauche(v);
                    } catch (NumberFormatException ex) {
                        System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
                    }
                    break;
                case "Lever":
                    this.getCourante().leverCrayon();
                    break;
                case "Baisser":
                    this.getCourante().baisserCrayon();
                    // actions des boutons du bas
                case "Proc1":
                    this.proc1();
                    break;
                case "Proc2":
                    this.proc2();
                    break;
                case "Proc3":
                    this.proc3();
                    break;
                case "Effacer":
                    this.effacer();
                    break;
                case "Quitter":
                    this.quitter();
                    break;
                case "Add Turtle":
                    this.addTurle();
                    break;
            }
        }
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

    public void changeCurrentTurtle(double clicX, double clicY) {
        System.out.println("x:" + clicX + " y:"+ clicY);

        // click has a 20-pixel precision
        int precision = 25;

        for (Tortue tortue : this.getTurtles()) {
            if (tortue.getX() <= clicX + precision && tortue.getX() >= clicX - precision &&
                    tortue.getY() <= clicY + precision && tortue.getY() >= clicY - precision) {
                System.out.println("Changement de tortue courant !");
                System.out.println("nouvelle tortue: x=" + tortue.getX() + " y="+ tortue.getY());
                this.setCourante(tortue);
                break;
            }
        }
    }





    public void setCourante(Tortue courante) {
        this.courante = courante;
    }

    public Tortue getCourante() {
        return courante;
    }


    @Override
    public void effacer() {
        super.effacer();

        // ajoute une nouvelle tortue
        Tortue tortue = this.generateTurtle();

        // la place au milieu
        this.setCourante(tortue);
        Dimension size = getFeuille().getSize();
        getCourante().setPosition(size.width / 2, size.height / 2);
    }

    @Override
    public Tortue addTurle(){
        Tortue turtle = super.addTurle();

        if (this.getCourante() == null)
            this.setCourante(turtle);

        turtle.setColor(this.getCourante().getColor()); // change color of default turtle
        this.setCourante(turtle);

        return turtle;
    }


    public void leftClick(int x, int y) {
        this.changeCurrentTurtle(x, y);
    }

}