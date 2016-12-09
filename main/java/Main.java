import cli.MainMenu;
import control.CommandExecutor;
import control.MissionController;
import io.IOHandler;
import io.IOHandlerFactory;
import location.PlateauFactory;


public class Main {

    public static void main(String[] args) {
        MissionController controller = new MissionController(new PlateauFactory().createDefaultPlateau(), new CommandExecutor());
        IOHandler io = new IOHandlerFactory().createDefaultIOHandler();
        MainMenu menu = new MainMenu(io, controller);

        MarsRovers rovers = new MarsRovers(io, controller, menu);

        while (true) {
            rovers.menu();
        }
    }
}
