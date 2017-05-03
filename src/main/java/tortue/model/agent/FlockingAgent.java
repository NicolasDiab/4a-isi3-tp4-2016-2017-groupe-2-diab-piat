package tortue.model.agent;

import tortue.model.Environnement;
import tortue.model.Tortue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class FlockingAgent extends BaseAgent {

    private final int RANGE = 80;

    public FlockingAgent(List<Tortue> turtles) {
        this.setTurtles(turtles);
        this.setEnvironnement(new Environnement(turtles));
    }


    @Override
    public void run() {
        while (true) {

            int nbTurtles = this.getTurtles().size();

            for (Tortue turtle : this.getTurtles()) {
                // neighbours turtles
                List<Tortue> flock = this.getEnvironnement().getTurtlesInRange(turtle.getX(), turtle.getY(), this.RANGE);

                int totalDir = 0;
                int dirCount = 0;
                for (Tortue flockTurtle : flock){
                    totalDir += flockTurtle.getDir();
                    dirCount ++;
                }
                // average dir
                int averageDir = totalDir / dirCount;

            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
