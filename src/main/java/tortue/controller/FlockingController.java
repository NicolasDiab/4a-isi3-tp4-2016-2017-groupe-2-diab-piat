package tortue.controller;

import tortue.model.agent.FlockingAgent;
import tortue.view.Window;

public class FlockingController extends TurtleController {

    private FlockingAgent flockingAgent;

    public FlockingController (Window window) {
        super(window);
        this.addTurle();

        this.flockingAgent = new FlockingAgent(this.getTurtles());
        Thread agent = new Thread(this.flockingAgent);
        agent.start();
    }

    @Override
    public void leftClick(int x, int y) {

    }
}
