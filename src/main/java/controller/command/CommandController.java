/**
 * SE 350 Fall 2021
 * Jawan Luangnikone Davis
 * Project Assignment 1: Sprint 1
 * 10/5/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.interfaces.UserChoices;
import model.picture.Picture;
import model.picture.Point;
import view.gui.PaintCanvas;

public class CommandController {
  private ICommand command;
  private UserChoices userChoices;
  private Picture picture;
  private PaintCanvas paintCanvas;

  public CommandController(UserChoices userChoices, Picture picture, PaintCanvas paintCanvas) {
    this.userChoices = userChoices;
    this.picture = picture;
    this.paintCanvas = paintCanvas;
  }

  public void onDraw(Point startPoint, Point endPoint) {
    command = new CreateShapesCommand(startPoint, endPoint, userChoices, picture, paintCanvas);
    command.run();
    CommandHistory.add((Undoable) command);
    paintCanvas.repaint();
  }
}
