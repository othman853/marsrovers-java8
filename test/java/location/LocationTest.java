package location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {


    @Test
    public void locationShouldMoveOrientationLeft() throws Exception {

        Location location = new Location(Orientation.NORTH,new Position(1,1));

        Location newLocation = location.left();

        assertEquals(Orientation.WEST, newLocation.orientation);

    }

    @Test
    public void locationShouldMoveOrientationRight() throws Exception {

        Location location = new Location(Orientation.NORTH,new Position(1,1));

        Location newLocation = location.right();

        assertEquals(Orientation.EAST, newLocation.orientation);

    }

    @Test
    public void locationShouldMovePositionUp() throws Exception {

        Location location = new Location(Orientation.NORTH,new Position(1,1));

        Location newLocation = location.move();

        assertEquals(2, newLocation.position.y);

    }

    @Test
    public void locationShouldMovePositionDown() throws Exception {

        Location location = new Location(Orientation.SOUTH, new Position(1,1));

        Location newLocation = location.move();

        assertEquals(0, newLocation.position.y);

    }
}
