package controller.command;

import controller.interfaces.ICommand;
import model.MouseMode;
import model.interfaces.UserChoices;
import model.picture.Picture;
import model.picture.Point;

public class CommandFactory {

  public static ICommand makeCommand(Point X, Point Y, UserChoices userChoices, Picture picture) {
    if (userChoices.getActiveMouseMode().equals(MouseMode.DRAW)) {
      return new CreateShapesCommand(X, Y, userChoices, picture);
    } else if (userChoices.getActiveMouseMode().equals(MouseMode.SELECT)) {
      return new SelectCommand();
    } else if (userChoices.getActiveMouseMode().equals(MouseMode.MOVE)) {
      return new MoveCommand(X, Y, picture);
    } else {
      return null;
    }
  }
}
