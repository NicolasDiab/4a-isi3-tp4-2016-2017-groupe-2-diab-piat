package tortue.model.agent;

import tortue.model.Environnement;
import tortue.model.Obstacle;
import tortue.model.Tortue;
import java.util.List;
import java.util.Random;

public class FlockingAgent extends BaseAgent {

    private final int RANGE = 20;
    private final int MAX_DIR_CHANGE = 15;
    private final int MAX_COLLISION_AVOIDANCE_DIR= 15;
    private final int TURTLE_SPEED = 5;
    private final int TURTLE_LOW_SPEED = 3;

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
                // neighbours turtles
                List<Tortue> flock = this.getEnvironnement().getTurtlesInRange(turtle.getX(), turtle.getY(), this.RANGE);

                /**
                 * Compute average dir
                 */
                averageDir = (((int) flock.stream()
                        .mapToInt(t -> t.getDir())
                        .average().getAsDouble()));

                //for (Tortue item : flock){
//
                //    int minRangeX = item.getX() - 4;
                //    int maxRangeX = item.getX() + 4;
                //    int minRangeY = item.getY() - 4;
                //    int maxRangeY = item.getY() + 4;
//
                //    if (turtle.getX() > minRangeX && turtle.getX() < maxRangeX)
                //        turtle.setDir(averageDir + rand.nextInt(5));
//
                //    if (turtle.getY() > minRangeY && turtle.getY() < maxRangeY)
                //        turtle.setDir(averageDir + rand.nextInt(5));
                //}


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
                int dir = turtle.getDir();
                int offset = 0;
                int newX = turtle.getFutureX(speed, dir);
                int newY = turtle.getFutureY(speed, dir);
                int finalDir = - 1000;

                while (getEnvironnement().isOnObstacle(newX, newY) && offset <= 45){
                    offset += rand.nextInt(5);
                    dir = turtle.getDir() + offset;
                    newX = turtle.getFutureX(speed, dir);
                    newY = turtle.getFutureY(speed, dir);

                    if (!getEnvironnement().isOnObstacle(newX, newY))
                        finalDir = dir;
                }

                if (finalDir == - 1000){
                    offset = 0;

                    while (getEnvironnement().isOnObstacle(newX, newY) && offset >= -45){
                        offset += rand.nextInt(5);
                        dir = turtle.getDir() - offset;
                        newX = turtle.getFutureX(speed, dir);
                        newY = turtle.getFutureY(speed, dir);

                        if (!getEnvironnement().isOnObstacle(newX, newY))
                            finalDir = dir;
                    }
                }

                if (finalDir == - 1000)
                    turtle.setDir(averageDir);
                else
                    turtle.setDir(finalDir);
                turtle.avancer(speed);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
