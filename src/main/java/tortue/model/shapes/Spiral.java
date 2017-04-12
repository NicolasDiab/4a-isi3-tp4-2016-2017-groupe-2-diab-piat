package tortue.model.shapes;

import tortue.model.Tortue;

public class Spiral {

    public Spiral(Tortue turtle, int n, int k, int a) {
        for (int i = 0; i < k; i++) {
            turtle.couleur(turtle.getCoul() + 1);
            turtle.avancer(n);
            turtle.droite(360 / a);
            n = n + 1;
        }
    }
}
