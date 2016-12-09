package control;

import exceptions.RoverNotFoundException;
import location.Plateau;
import location.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import units.Rover;

import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MissionControllerTest {

    @Mock
    private Plateau plateau;

    @Mock
    private CommandExecutor executor;

    @Mock
    private Rover rover;

    @Mock
    private Rover movedRover;

    private MissionController controller;
    private Command command;


    @Before
    public void setUp() throws Exception {

        controller = new MissionController(plateau, executor);
        command = new Command("a");
    }

    @Test
    public void sendShouldCallPlateauGet() throws RoverNotFoundException {
        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(rover));
        when(plateau.isOccupied(any(Position.class))).thenReturn(true);
        when(executor.execute(any(Rover.class), any(Command.class))).thenReturn(movedRover);

        controller.send("abc", new Command("a"));

        verify(plateau).get("abc");

    }

    @Test
    public void sendShouldCallExecutor() throws RoverNotFoundException {
        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(rover));
        when(plateau.isOccupied(any(Position.class))).thenReturn(true);
        when(executor.execute(any(Rover.class), any(Command.class))).thenReturn(movedRover);

        controller.send("abc", command);

        verify(executor).execute(rover, command);

    }

    @Test
    public void sendShouldMoveRover() throws RoverNotFoundException {

        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(rover));
        when(plateau.isOccupied(any(Position.class))).thenReturn(false);
        when(executor.execute(any(Rover.class), any(Command.class))).thenReturn(movedRover);

        controller.send("abc", command);

        verify(plateau).set(movedRover);

    }

    @Test(expected = RoverNotFoundException.class)
    public void sendShouldThrowException() throws RoverNotFoundException {

        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(null));

        controller.send("abc", command);

    }
}