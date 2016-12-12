package com.marsrovers.control;

import com.marsrovers.exceptions.RoverManipulationException;
import com.marsrovers.exceptions.RoverNotFoundException;
import com.marsrovers.location.Orientation;
import com.marsrovers.location.Plateau;
import com.marsrovers.location.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.marsrovers.units.Rover;

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
    private Position position;

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
    public void addShouldCallPlateauAdd() throws Exception, RoverManipulationException {
        when(plateau.isOccupied(rover)).thenReturn(false);

        controller.add(rover);

        verify(plateau).set(rover);
    }

    @Test(expected = RoverManipulationException.class)
    public void addShouldThrowExceptionWhenPositionIsOccupied() throws Exception, RoverManipulationException {
        Rover fakeRover = new Rover("a", Orientation.NORTH, new Position(1,1));
        when(plateau.isOccupied(fakeRover)).thenReturn(true);

        controller.add(fakeRover);
    }

    @Test
    public void sendShouldCallPlateauGet() throws RoverNotFoundException {
        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(rover));
        when(plateau.isOccupied(any(Rover.class))).thenReturn(true);
        when(executor.execute(any(Rover.class), any(Command.class))).thenReturn(movedRover);

        controller.send("abc", new Command("a"));

        verify(plateau).get("abc");

    }

    @Test
    public void sendShouldCallExecutor() throws RoverNotFoundException {
        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(rover));
        when(plateau.isOccupied(any(Rover.class))).thenReturn(true);
        when(executor.execute(any(Rover.class), any(Command.class))).thenReturn(movedRover);

        controller.send("abc", command);

        verify(executor).execute(rover, command);

    }

    @Test
    public void sendShouldMoveRover() throws RoverNotFoundException {

        when(plateau.get(anyString())).thenReturn(Optional.ofNullable(rover));
        when(plateau.isOccupied(any(Rover.class))).thenReturn(false);
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