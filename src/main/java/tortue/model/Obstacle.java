package tortue.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Obstacle extends Observable {
    private int x;
    private int y;
    private int size;
    private int coul;

    public void setColor(int n) {
        setCoul(n);
    }

    public int getColor() {
        return getCoul();
    }

    public Obstacle() {
        this.setColor(0); // default color is black
        this.setSize(10); // default size
        this.setChanged();
        this.notifyObservers();
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

    public void couleur(int n) {
        setCoul(n % 12);
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

    public int getCoul() {
        return coul;
    }

    public void setCoul(int coul) {
        this.coul = coul;
        setChanged();
        notifyObservers();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOnObstacle(int x, int y){

        int minRangeX = this.x - size;
        int maxRangeX = this.x + size;
        int minRangeY = this.y - size;
        int maxRangeY = this.y + size;

        if (x > minRangeX && x < maxRangeX && y > minRangeY && y < maxRangeY)
            return true;

        return false;
    }
}
