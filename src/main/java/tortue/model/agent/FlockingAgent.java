package tortue.model.agent;

import tortue.model.Environnement;
import tortue.model.Obstacle;
import tortue.model.Tortue;
import java.util.List;
import java.util.Random;

public class FlockingAgent extends BaseAgent {

    private final int RANGE = 20;
    private final int MAX_DIR_CHANGE = 15;
    private final int MAX_COLLISION_AVOIDANCE_DIR = 180;
    private final int TURTLE_SPEED = 4;
    private final int TURTLE_LOW_SPEED = 2;

    private static final double RATION_DEG_RAD = 0.0174533; // Rapport radians/degres (pour la conversion)

    public FlockingAgent(List<Tortue> turtles, List<Obstacle> obstacles) {
        this.setEnvironnement(new Environnement(turtles));
        this.setTurtles(turtles);
        this.setObstacles(obstacles);
    }

    @Override
    public void run() {
        while (true) {
            int averageDir = 0;
            Random rand = new Random();

            for (Tortue turtle : this.getTurtles()) {

                /**
                 * Get turtle's neighbourhood
                 */
                List<Tortue> flock = this.getEnvironnement().getTurtlesInRange(turtle.getX(), turtle.getY(), this.RANGE);

                /**
                 * Compute average dir
                 */
                averageDir = (((int) flock.stream()
                        .mapToInt(t -> t.getDir())
                        .average().getAsDouble()));


                /**
                 * Set a maximum of dir change to 30 degrees
                 */
                if (Math.abs(turtle.getDir() - averageDir) > MAX_DIR_CHANGE){
                    if (turtle.getDir() - averageDir > 0) {
                        turtle.setDir(turtle.getDir() + MAX_DIR_CHANGE);
                    }
                    if (turtle.getDir() - averageDir < 0) {
                        turtle.setDir(turtle.getDir() - MAX_DIR_CHANGE);
                    }
                }
                else
                    turtle.setDir(averageDir);

                turtle.setDir(averageDir);

                /**
                 * Choose speed
                 */
                int speed;
                if (flock.size() == 0)
                    speed = TURTLE_LOW_SPEED;
                else
                    speed = TURTLE_SPEED;

                /**
                 * Check if a collision will occur
                 */
                int finalDir = this.changeDirObstacle(true, speed, turtle);

                if (finalDir == - 1000){
                    finalDir = this.changeDirObstacle(false, speed, turtle);
                }

                if (finalDir != - 1000){
                    turtle.setDir(finalDir);
                }
                turtle.avancer(speed);
            }

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int changeDirObstacle(boolean right, int speed, Tortue turtle) {
        int offset = 0;
        int dir = turtle.getDir();
        int newX = turtle.getFutureX(speed, dir);
        int newY = turtle.getFutureY(speed, dir);
        int finalDir = - 1000;
        Random rand = new Random();

        while (getEnvironnement().isOnObstacle(newX, newY) &&
                ((right && offset <= MAX_COLLISION_AVOIDANCE_DIR) ||
                (!right && offset >= - MAX_COLLISION_AVOIDANCE_DIR))) {
            offset += rand.nextInt(5);
            dir = right ? turtle.getDir() + offset : turtle.getDir() - offset;

            for (int i = 0; i <= speed; ++i){
                newX = turtle.getFutureX(i, dir);
                newY = turtle.getFutureY(i, dir);

                if (!getEnvironnement().isOnObstacle(newX, newY)){
                    finalDir = dir;
                }
            }
        }

        return finalDir;
    }
}
