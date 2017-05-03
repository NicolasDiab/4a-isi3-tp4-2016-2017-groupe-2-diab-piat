package tortue.controller;

import tortue.model.Tortue;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicolas on 03/05/2017.
 */
public abstract class BaseController implements ActionListener, Observer {
    protected FeuilleDessin feuille;
    protected Window window;

    protected List<Tortue> turtles;


    protected void quitter() {
        System.exit(0);
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        this.turtles.clear();
        getFeuille().reset();
    }

    public Tortue generateTurtle(){
        Tortue turtle = new Tortue();
        turtle.addObserver(this);
        turtle.setPosition(500 / 2, 400 / 2);
        this.getTurtles().add(turtle);

        return turtle;
    }

    public void addTurle(){
        Tortue turtle = generateTurtle();
        this.getFeuille().addTortue(turtle);
        this.getTurtles().add(turtle);

       // turtle.setColor(this.getCourante().getColor()); // default color is currently selected color
    }


    public FeuilleDessin generateFeuille(){

        FeuilleDessin feuille = new FeuilleDessin(); //500, 400);
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600, 400));
        feuille.setPreferredSize(new Dimension(600, 400));

        return feuille;
    }


    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void setFeuille(FeuilleDessin feuille) {
        this.feuille = feuille;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.getWindow().repaint();
    }

    public List<Tortue> getTurtles() {
        return turtles;
    }

    public void setTurtles(List<Tortue> turtles) {
        this.turtles = turtles;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }
}
