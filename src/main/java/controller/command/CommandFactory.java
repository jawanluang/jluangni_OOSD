/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import model.MouseMode;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import model.picture.Picture;
import model.picture.Point;

/**
 * The CommandFactory utilizes the factory method design in relation to the classes that implement
 * the ICommand interface. The class takes in two Point objects, a UserChoices object, and a
 * Picture object to help fill in the fields for the new commands. It chooses the command made based
 * on the current ENUM for MouseMode.
 */
public class CommandFactory {

  public static ICommand makeCommand(Region region, UserChoices userChoices, Picture picture) {
    if (userChoices.getActiveMouseMode().equals(MouseMode.DRAW)) {
      return new CreateShapesCommand(region, userChoices, picture);
    } else if (userChoices.getActiveMouseMode().equals(MouseMode.SELECT)) {
      return new SelectCommand(region, picture);
    } else if (userChoices.getActiveMouseMode().equals(MouseMode.MOVE)) {
      return new MoveCommand(region, picture);
    } else {
      return null;
    }
  }
}
