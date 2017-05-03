package tortue.model.agent;

import tortue.model.Tortue;

import java.util.List;
import java.util.Random;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class FlockingAgent extends BaseAgent {
    public FlockingAgent(List<Tortue> turtles) {
        this.setTurtles(turtles);
    }


    @Override
    public void run() {
        while (true) {

            //code here

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
