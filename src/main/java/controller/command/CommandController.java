/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.RegionImpl;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import model.picture.Picture;
import model.picture.Point;
import view.gui.PaintCanvas;

/**
 * The CommandController class takes an input of a UserChoices object, a Picture object, and
 * a PaintCanvas object. The purpose of the class is to take the input and run the necessary
 * command that is chosen. After creating a command and running it, the command is added into
 * CommandHistory's undo stack.
 */
public class CommandController {
  private ICommand command;
  private final UserChoices userChoices;
  private final Picture picture;
  private final PaintCanvas paintCanvas;

  public CommandController(UserChoices userChoices, Picture picture, PaintCanvas paintCanvas) {
    this.userChoices = userChoices;
    this.picture = picture;
    this.paintCanvas = paintCanvas;
  }

  public void onDraw(Point startPoint, Point endPoint) {
    Region region = new RegionImpl(startPoint, endPoint);
    command = CommandFactory.makeCommand(region, userChoices, picture);
    if(command != null) {
      command.run();
      CommandHistory.add((Undoable) command);
      paintCanvas.repaint();
    }
  }

  public void onRedo() {
    CommandHistory.redo();
    paintCanvas.repaint();
  }

  public void onUndo() {
    CommandHistory.undo();
    paintCanvas.repaint();
  }
}
