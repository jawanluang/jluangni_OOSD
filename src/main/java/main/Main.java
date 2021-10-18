package main;

import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import controller.command.CommandController;
import java.awt.Graphics2D;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import model.picture.Picture;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Picture picture = new Picture();
        PaintCanvas paintCanvas = new PaintCanvas(picture);
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoices appState = new UserChoicesImpl(uiModule);
        CommandController commandController = new CommandController(appState, picture, paintCanvas);
        EventConnector controller = new EventConnectorImpl(uiModule, appState, commandController);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();
        MouseHandler mouse = new MouseHandler(commandController);
        paintCanvas.addMouseListener(mouse);
        controller.setup();

        Thread.sleep(500);

        Graphics2D graphics2d = paintCanvas.getGraphics2D();

    }
}
