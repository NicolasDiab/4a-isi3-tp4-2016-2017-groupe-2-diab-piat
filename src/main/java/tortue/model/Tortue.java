package tortue.model;// package logo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 Source originale : J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/2001

 **************************************************************************/


public class Tortue extends Observable {
    private static final int rp = 10;
    private static final int rb = 5; // Taille de la pointe et de la base de la fleche
    private static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)


    private ArrayList<Segment> listSegments; // Trace de la tortue

    private int x;
    private int y;
    private int dir;
    private boolean crayon;
    private int coul;

    public static int getRp() {
        return rp;
    }

    public static int getRb() {
        return rb;
    }

    public static double getRatioDegRad() {
        return ratioDegRad;
    }

    public void setColor(int n) {
        setCoul(n);
    }

    public int getColor() {
        return getCoul();
    }

    public Tortue() {
        this.setColor(0); // default color is black
        setListSegments(new ArrayList<Segment>());
        reset();
        setChanged();
        notifyObservers();
    }

    public void reset() {
        setX(0);
        setY(0);
        setDir(-90);
        setCoul(0);
        setCrayon(true);
        getListSegments().clear();
    }

    public void setPosition(int newX, int newY) {
        setX(newX);
        setY(newY);
    }

    public Color decodeColor(int c) {
        switch (c) {
            case 0:
                return (Color.black);
            case 1:
                return (Color.blue);
            case 2:
                return (Color.cyan);
            case 3:
                return (Color.darkGray);
            case 4:
                return (Color.red);
            case 5:
                return (Color.green);
            case 6:
                return (Color.lightGray);
            case 7:
                return (Color.magenta);
            case 8:
                return (Color.orange);
            case 9:
                return (Color.gray);
            case 10:
                return (Color.pink);
            case 11:
                return (Color.yellow);
            default:
                return (Color.black);
        }
    }

    public void avancer(int dist) {
        int newX = this.getFutureX(dist);
        int newY = this.getFutureY(dist);

        if (isCrayon() == true) {
            Segment seg = new Segment();

            seg.ptStart.x = getX();
            seg.ptStart.y = getY();
            seg.ptEnd.x = newX;
            seg.ptEnd.y = newY;
            seg.color = decodeColor(getCoul());

            getListSegments().add(seg);
        }

        setX(newX);
        setY(newY);
    }


    public int getFutureX(int dist, int dir) {
        return (int) Math.round(getX() + dist * Math.cos(getRatioDegRad() * dir));
    }
    public int getFutureY(int dist, int dir) {
        return (int) Math.round(getY() + dist * Math.sin(getRatioDegRad() * dir));
    }

    public int getFutureX(int dist) {
        return (int) Math.round(getX() + dist * Math.cos(getRatioDegRad() * getDir()));
    }
    public int getFutureY(int dist) {
        return (int) Math.round(getY() + dist * Math.sin(getRatioDegRad() * getDir()));
    }

    public void droite(int ang) {
        setDir((getDir() + ang) % 360);
    }

    public void gauche(int ang) {
        setDir((getDir() - ang) % 360);
    }

    public void baisserCrayon() {
        setCrayon(true);
    }

    public void leverCrayon() {
        setCrayon(false);
    }

    public void couleur(int n) {
        setCoul(n % 12);
    }

    public void couleurSuivante() {
        couleur(getCoul() + 1);
    }


    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public void setListSegments(ArrayList<Segment> listSegments) {
        this.listSegments = listSegments;
        setChanged();
        notifyObservers();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        setChanged();
        notifyObservers();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        setChanged();
        notifyObservers();
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
        setChanged();
        notifyObservers();
    }

    public boolean isCrayon() {
        return crayon;
    }

    public void setCrayon(boolean crayon) {
        this.crayon = crayon;
        setChanged();
        notifyObservers();
    }

    public int getCoul() {
        return coul;
    }

    public void setCoul(int coul) {
        this.coul = coul;
        setChanged();
        notifyObservers();
    }
}
