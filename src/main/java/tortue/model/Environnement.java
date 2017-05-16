package tortue.model;

import java.util.ArrayList;
import java.util.List;

public class Environnement {
    private List<Tortue> turtles;
    private List<Obstacle> obstacles;

    public Environnement(List<Tortue> turtles) {
        this.setTurtles(turtles);
        this.setObstacles(new ArrayList<>());
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

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean isOnObstacle(int x, int y){
        for (Obstacle obstacle : getObstacles()){
            if (obstacle.isOnObstacle(x, y))
                return true;
        }

        return false;
    }
}
