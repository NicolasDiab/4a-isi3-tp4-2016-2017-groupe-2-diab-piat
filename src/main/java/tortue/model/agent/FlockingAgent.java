package tortue.model.agent;

import tortue.model.Environnement;
import tortue.model.Tortue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlockingAgent extends BaseAgent {

    private final int RANGE = 50;
    private final int MAX_DIR_CHANGE = 15;
    private final int TURTLE_SPEED = 5;
    private final int TURTLE_LOW_SPEED = 3;

    public FlockingAgent(List<Tortue> turtles) {
        this.setEnvironnement(new Environnement(turtles));
        this.setTurtles(turtles);
    }


    @Override
    public void run() {
        while (true) {

            int nbTurtles = this.getTurtles().size();

            int averageDir = 0;

            for (Tortue turtle : this.getTurtles()) {
                // neighbours turtles
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
                    if (turtle.getDir() - averageDir > 0)
                        turtle.setDir(turtle.getDir() + MAX_DIR_CHANGE);
                    if (turtle.getDir() - averageDir < 0)
                        turtle.setDir(turtle.getDir() - MAX_DIR_CHANGE);
                }


                turtle.setDir(averageDir);

                if (flock.size() == 0)
                    turtle.avancer(TURTLE_LOW_SPEED);
                else
                    turtle.avancer(TURTLE_SPEED);
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
