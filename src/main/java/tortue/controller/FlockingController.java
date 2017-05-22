package tortue.controller;

import tortue.model.agent.FlockingAgent;
import tortue.view.Window;

public class FlockingController extends TurtleController {

    private FlockingAgent flockingAgent;

    public FlockingController(Window window) {
        super(window);

        // add 30 turtles
        for (int i = 0; i < 20; i++)
            this.addRandomTurtle();

        for (int i = 0; i < 3; i++)
            this.addRandomObstacle();

        this.flockingAgent = new FlockingAgent(this.getTurtles(), this.getFeuille().getObstacles());
        Thread agent = new Thread(this.flockingAgent);
        agent.start();
        this.getFeuille().setShowSegments(false); // hide segments
    }

    @Override
    public void leftClick(int x, int y) {

    }
}
