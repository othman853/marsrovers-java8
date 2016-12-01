import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlateauTest {


    @Test
    public void shouldContainBoundaries() throws Exception {

        Plateau plateau = new Plateau(10, 10);

        assertEquals(10, plateau.horizontalBoundary);
        assertEquals(10, plateau.verticalBoundary);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreatePlateauWithoutHorizontalBoundary() throws Exception {
        Plateau plateau = new Plateau(0, 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreatePlateauWithoutVerticalBoundary() throws Exception {
        Plateau plateau = new Plateau(10, 0);
    }
}
