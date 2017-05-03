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
public class AgentRandom implements Runnable {

    private FeuilleDessin feuille;

    private List<Tortue> turtles;

    public final String ACTION_AVANCER = "Avancer";
    public final String ACTION_DROITE = "Droite";
    public final String ACTION_GAUCHE = "Gauche";

    private final ArrayList<String> actions = new ArrayList<String>() {};
    {
        getActions().add(ACTION_AVANCER);
        getActions().add(ACTION_DROITE);
        getActions().add(ACTION_GAUCHE);
    }

    public AgentRandom(List<Tortue> turtles, FeuilleDessin feuille) {
        this.turtles = turtles;
        this.feuille = feuille;
    }

    public ArrayList<String> getActions() {
        return actions;
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


    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void setFeuille(FeuilleDessin feuille) {
        this.feuille = feuille;
    }

    public List<Tortue> getTurtles() {
        return turtles;
    }

    public void setTurtles(List<Tortue> turtles) {
        this.turtles = turtles;
    }
}
