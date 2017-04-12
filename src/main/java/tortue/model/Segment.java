package tortue.model;

import java.awt.*;
import java.util.Observable;

public class Segment extends Observable{
    public Point ptStart, ptEnd;
    public Color color;

    public Segment() {
        ptStart = new Point(0, 0);
        ptEnd = new Point(0, 0);
    }

    public Point getPtStart() {
        return ptStart;
    }

    public void setPtStart(Point ptStart) {
        this.ptStart = ptStart;
        setChanged();
        notifyObservers();
    }

    public Point getPtEnd() {
        return ptEnd;
    }

    public void setPtEnd(Point ptEnd) {
        this.ptEnd = ptEnd;
        setChanged();
        notifyObservers();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setChanged();
        notifyObservers();
    }
}