package tortue.model.agent;

import tortue.model.Tortue;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nicolas on 03/05/2017.
 */
public class AgentRandom extends BaseAgent {

    public AgentRandom(List<Tortue> turtles, FeuilleDessin feuille) {
        this.setTurtles(turtles);
        this.setFeuille(feuille);
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
                    turtle.avancer(100);
                    break;
                case ACTION_DROITE:
                    turtle.droite(45);
                    break;
                case ACTION_GAUCHE:
                    turtle.gauche(45);
                    break;
            }

            this.getFeuille().repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
