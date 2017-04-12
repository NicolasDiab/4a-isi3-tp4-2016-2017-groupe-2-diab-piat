package tortue.model.shapes;

import tortue.model.Tortue;

public class Poly {

    public Poly (Tortue turtle, int n, int a){

        for (int j = 0; j < a; j++) {
            turtle.avancer(n);
            turtle.droite(360 / a);
        }
    }
}
