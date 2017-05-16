package tortue.controller;

import tortue.model.Tortue;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class BaseController implements ActionListener, Observer {
    protected FeuilleDessin feuille;
    protected Window window;

    protected List<Tortue> turtles;

    public BaseController (Window window) {
        this.setWindow(window);
        this.setFeuille(this.generateFeuille());
        this.setTurtles(new ArrayList<>());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        switch (c) {
            case "Add Turtle":
                this.addTurtle();
                break;
        }
    }

    public abstract void leftClick(int x, int y);

    protected void quitter() {
        System.exit(0);
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        this.turtles.clear();
        getFeuille().reset();
    }

    public Tortue generateTurtle() {
        return this.generateTurtle(500 / 2, 400 / 2, 0);
    }

    public Tortue generateTurtle(int x, int y, int dir){
        Tortue turtle = new Tortue();
        turtle.addObserver(this);
        turtle.setPosition(500 / 2, 400 / 2);
        this.getTurtles().add(turtle);

        return turtle;
    }

    public Tortue addTurtle() {
        return this.addTurtle(500 / 2, 400 / 2, 0);
    }

    public Tortue addTurtle(int x, int y, int dir){
        Tortue turtle = generateTurtle();
        this.getFeuille().addTortue(turtle);
        this.getTurtles().add(turtle);

        return turtle;
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
