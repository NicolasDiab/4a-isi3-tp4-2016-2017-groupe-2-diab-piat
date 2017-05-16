package tortue.controller;

import tortue.model.agent.FlockingAgent;
import tortue.view.Window;

public class FlockingController extends TurtleController {

    private FlockingAgent flockingAgent;

    public FlockingController (Window window) {
        super(window);

        // add 30 turtles
        for (int i=0; i<30; i++)
            this.addRandomTurtle();

        this.flockingAgent = new FlockingAgent(this.getTurtles());
        Thread agent = new Thread(this.flockingAgent);
        agent.start();
        this.getFeuille().setShowSegments(false); // hide segments
    }

    @Override
    public void leftClick(int x, int y) {

    }
}
