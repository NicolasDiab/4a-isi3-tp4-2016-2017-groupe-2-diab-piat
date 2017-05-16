package tortue.model;

import java.util.ArrayList;
import java.util.List;

public class Environnement {
    private List<Tortue> turtles;

    public Environnement(List<Tortue> turtles) {
        this.setTurtles(turtles);
    }

    public List<Tortue> getTurtlesInRange (int x, int y, int range) {
        List<Tortue> turtles = new ArrayList<>();

        for (Tortue turtle : this.getTurtles()) {
            if (turtle.getX() <= x + range && turtle.getX() >= x - range &&
                    turtle.getY() <= y + range && turtle.getY() >= y - range)
                turtles.add(turtle);
        }

        return turtles;
    }


    public List<Tortue> getTurtles() {
        return turtles;
    }

    public void setTurtles(List<Tortue> turtles) {
        this.turtles = turtles;
    }
}
