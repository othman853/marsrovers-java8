package cli;


import control.MissionController;
import io.IOHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddRoverCliComponentTest {

    @Mock
    MissionController controller;

    @Mock
    IOHandler handler;

    AddRoverCliComponent component;

    @Before
    public void setUp() throws Exception {
        component = new AddRoverCliComponent(handler, controller);
    }

    @Test
    public void shouldReadParametersCorrectly() throws Exception {
        when(handler.readWithMessage(anyString())).thenReturn("");

        component.execute();

        verify(handler).readWithMessage("rover_ID>");
        verify(handler).readWithMessage("rover_X>");
        verify(handler).readWithMessage("rover_Y>");
        verify(handler).readWithMessage("rover_Orientation>");

    }

    @Test
    public void shouldWriteErrorWhenRoverIdIsEmpty() throws Exception {
        when(handler.readWithMessage("rover_ID>")).thenReturn("");

        component.execute();

        verify(handler).write("roverId can not be empty");

    }

    @Test
    public void shouldWriteErrorWhenRoverXIsNotANumber() throws Exception {
        when(handler.readWithMessage("rover_ID>")).thenReturn("a");
        when(handler.readWithMessage("rover_X>")).thenReturn("A");

        component.execute();

        verify(handler).write("An invalid number was received, the error is: For input string: \"A\"");

    }

    @Test
    public void shouldWriteErrorWhenRoverYIsNotANumber() throws Exception {
        when(handler.readWithMessage("rover_ID>")).thenReturn("a");
        when(handler.readWithMessage("rover_X>")).thenReturn("1");
        when(handler.readWithMessage("rover_Y>")).thenReturn("B");

        component.execute();

        verify(handler).write("An invalid number was received, the error is: For input string: \"B\"");
    }

    @Test
    public void shouldWriteErrorWhenRoverOrientationIsInvalid() throws Exception {
        when(handler.readWithMessage("rover_ID>")).thenReturn("a");
        when(handler.readWithMessage("rover_X>")).thenReturn("1");
        when(handler.readWithMessage("rover_Y>")).thenReturn("2");
        when(handler.readWithMessage("rover_Orientation>")).thenReturn("P");

        component.execute();

        verify(handler).write("Orientation P does not exists");
    }
}
