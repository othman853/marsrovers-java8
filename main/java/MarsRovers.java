import cli.CliComponent;
import cli.MainMenu;
import control.MissionController;
import io.IOHandler;

class MarsRovers {

    private final IOHandler handler;
    private final MissionController controller;
    private final MainMenu menu;

    MarsRovers(IOHandler handler, MissionController controller, MainMenu menu) {
        this.handler = handler;
        this.controller = controller;
        this.menu = menu;
    }

    void menu() {
        handler.write(controller.getStatus());

        CliComponent component = menu.getSelectedCliComponent();

        component.execute();
    }

}
