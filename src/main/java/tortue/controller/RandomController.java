package tortue.controller;

import tortue.model.agent.AgentRandom;
import tortue.view.Window;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class RandomController extends TurtleController {

    private AgentRandom agentRandom;

    public RandomController (Window window) {
        super(window);
        this.addTurtle();

        this.agentRandom = new AgentRandom(this.getTurtles());
        Thread agent = new Thread(this.agentRandom);
        agent.start();
    }

    @Override
    public void leftClick(int x, int y) {

    }
}
