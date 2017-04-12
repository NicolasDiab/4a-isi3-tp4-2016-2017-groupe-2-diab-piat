package tortue.model.shapes;


import tortue.model.Tortue;

public class Square {

    public Square (Tortue turtle){

        for (int i = 0; i < 4; i++) {
            turtle.avancer(100);
            turtle.droite(90);
        }
    }
}
