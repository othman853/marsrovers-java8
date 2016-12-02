package location;

import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlateauTest {


    @Test
    public void shouldContainBoundaries() throws Exception {

        Plateau plateau = new Plateau(10, 10);

        assertEquals(10, plateau.horizontalBoundary);
        assertEquals(10, plateau.verticalBoundary);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreatePlateauWithoutHorizontalBoundary() throws Exception {
        new Plateau(0, 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreatePlateauWithoutVerticalBoundary() throws Exception {
        new Plateau(10, 0);
    }


    @Test
    public void shouldAddNewPositionToOccupiedPositions() throws Exception {
        Position position = new Position(1,1);
        Plateau plateau = new Plateau(10, 10);

        plateau.add(position);

        assertTrue(plateau.isOccupied(position));
    }

    @Test
    public void shouldAInformThatThePositionIsFree() throws Exception {
        Position position = new Position(1,1);
        Plateau plateau = new Plateau(10, 10);

        plateau.add(position);
        boolean actualResponse = plateau.isOccupied(new Position(2,2));

        assertFalse(actualResponse);
    }

    @Test
    public void shouldAInformThatThePositionIsFreeInAnEmptyPositionsList() throws Exception {
        Plateau plateau = new Plateau(10, 10);

        boolean actualResponse = plateau.isOccupied(new Position(2,2));

        assertFalse(actualResponse);
    }
}
