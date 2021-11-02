/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import model.picture.Picture;
import controller.interfaces.Undoable;
import model.interfaces.IShape;
import model.picture.ShapeFactory;

/**
 * The CreateShapesCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The class takes an input of Region Object, a UserChoices object, a Picture object,
 * and a UserChoices object. In its run method it creates a new shape and adds it to Picture.
 * In the class's redo and undo methods, it interacts with the Picture and calls the
 * PaintCanvas object to repaint the graphics.
 */
public class CreateShapesCommand implements ICommand, Undoable {
  IShape shape;
  Region region;
  UserChoices userChoices;
  Picture picture;


  public CreateShapesCommand(Region region, UserChoices userChoices, Picture picture) {
    this.region = region;
    this.userChoices = userChoices;
    this.picture = picture;
  }

  @Override
  public void run() {
    shape = ShapeFactory.makeShape(region, userChoices);
    picture.add(shape);
  }

  @Override
  public void redo() {
    picture.add(shape);
  }

  @Override
  public void undo() {
    picture.remove(shape);
  }
}
