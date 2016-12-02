import location.Plateau;
import location.PlateauFactory;
import location.Position;

public class MarsRovers {

    public static void main(String[] args) {


        Plateau plateau = new PlateauFactory().createDefaultPlateau();

        plateau.add(new Position(1,1));

    }

}
