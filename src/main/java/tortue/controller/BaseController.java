package tortue.controller;

import tortue.model.Obstacle;
import tortue.model.Tortue;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

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
                this.addRandomTurtle();
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
        return this.generateTurtle(500 / 2, 400 / 2, 0, 0);
    }

    public Tortue generateTurtle(int x, int y, int dir, int col){
        Tortue turtle = new Tortue();
        turtle.addObserver(this);
        turtle.setPosition(x, y);
        turtle.setDir(dir);
        turtle.setColor(col);
        this.getTurtles().add(turtle);

        return turtle;
    }

    public Tortue addTurtle() {
        return this.addTurtle(500 / 2, 400 / 2, 0, 0);
    }

    public Tortue addTurtle(int x, int y, int dir, int col){
        Tortue turtle = generateTurtle(x, y, dir, col);
        this.getFeuille().addTortue(turtle);
        this.getTurtles().add(turtle);

        return turtle;
    }

    public Tortue addRandomTurtle() {
        Random rand = new Random();
        int x = rand.nextInt(499);
        int y = rand.nextInt(399);
        int dir = rand.nextInt(359);
        int col = rand.nextInt(11);
        System.out.println("x "+x + " y "+ y + " dir "+ dir);
        return this.addTurtle(x, y, dir, col);
    }

    public Obstacle addRandomObstacle() {
        Random rand = new Random();
        int x = rand.nextInt(499);
        int y = rand.nextInt(399);
        int size = rand.nextInt(9);
        int col = rand.nextInt(11);

        return this.addObstacle(x, y, size, col);
    }

    public Obstacle addObstacle(int x, int y, int size, int col) {
        Obstacle obstacle = new Obstacle();
        obstacle.setX(x);
        obstacle.setY(y);
        obstacle.setSize(size);
        obstacle.setColor(col);

        return obstacle;
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
