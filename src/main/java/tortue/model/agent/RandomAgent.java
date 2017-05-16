package tortue.model.agent;

import tortue.model.Environnement;
import tortue.model.Obstacle;
import tortue.model.Tortue;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class RandomAgent extends BaseAgent {

    public RandomAgent(List<Tortue> turtles, List<Obstacle> obstacles) {
        this.setEnvironnement(new Environnement(turtles));
        this.setTurtles(turtles);
        this.setObstacles(obstacles);
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();

            // choix de la tortue
            Tortue turtle = this.getTurtles().get(rand.nextInt(this.getTurtles().size()));

            // choix de l'action
            String action = getActions().get(rand.nextInt(this.getActions().size()));
            switch (action) {
                case ACTION_AVANCER:
                    int futureX = turtle.getFutureX(100);
                    int futureY = turtle.getFutureY(100);

                    //check obstacle
                    if (!this.getEnvironnement().isOnObstacle(futureX, futureY))
                        turtle.avancer(rand.nextInt(100));
                    else
                        turtle.droite(rand.nextInt(360));
                    break;
                case ACTION_DROITE:
                    turtle.droite(rand.nextInt(360));
                    break;
                case ACTION_GAUCHE:
                    turtle.gauche(rand.nextInt(360));
                    break;
            }

            try {
                Thread.sleep(Math.min(100 / getTurtles().size(), 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
