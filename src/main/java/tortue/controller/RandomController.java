package tortue.controller;

import tortue.model.agent.RandomAgent;
import tortue.view.Window;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class RandomController extends TurtleController {

    private RandomAgent randomAgent;

    public RandomController (Window window) {
        super(window);
        this.addTurtle();

        this.randomAgent = new RandomAgent(this.getTurtles(), this.getFeuille().getObstacles());
        Thread agent = new Thread(this.randomAgent);
        agent.start();
    }

    @Override
    public void leftClick(int x, int y) {

    }
}
