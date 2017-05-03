package tortue.controller;

import tortue.model.Tortue;
import tortue.model.agent.AgentRandom;
import tortue.view.Window;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class RandomController extends TurtleController {

    private AgentRandom agentRandom;

    public RandomController (Window window) {
        super(window);
        this.addTurle();

        this.agentRandom = new AgentRandom(this.getTurtles());
        Thread agent = new Thread(this.agentRandom);
        agent.start();

     //   this.run();
    }

    @Override
    public void leftClick(int x, int y) {

    }






}
