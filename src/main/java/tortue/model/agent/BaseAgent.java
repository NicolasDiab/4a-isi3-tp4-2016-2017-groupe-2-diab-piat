package tortue.model.agent;

import tortue.model.Tortue;
import tortue.view.FeuilleDessin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 03/05/2017.
 */
public abstract class BaseAgent implements Runnable {
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

    public ArrayList<String> getActions() {
        return actions;
    }

    public List<Tortue> getTurtles() {
        return turtles;
    }

    public void setTurtles(List<Tortue> turtles) {
        this.turtles = turtles;
    }

    @Override
    public abstract void run();
}
