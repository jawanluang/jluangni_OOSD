/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import model.interfaces.UserChoices;
import model.picture.Picture;
import model.picture.Point;
import controller.interfaces.Undoable;
import model.interfaces.IShape;
import model.picture.Rectangle;
import view.gui.PaintCanvas;

/**
 * The CreateShapesCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The class takes an input of two Point objects, a UserChoices object, a Picture object,
 * and a PaintCanvas object. In its run method it creates a new shape and adds it to Picture.
 * In the class's redo and undo methods, it interacts with the Picture and calls the
 * PaintCanvas object to repaint the graphics.
 */
public class CreateShapesCommand implements ICommand, Undoable {
  IShape shape;
  Point start;
  Point end;
  UserChoices userChoices;
  Picture picture;
  PaintCanvas paintCanvas;

  public CreateShapesCommand(Point start, Point end, UserChoices userChoices, Picture picture, PaintCanvas paintCanvas) {
    this.start = start;
    this.end = end;
    this.userChoices = userChoices;
    this.picture = picture;
    this.paintCanvas = paintCanvas;
  }

  @Override
  public void run() {
    shape = new Rectangle(start, end, userChoices);
    picture.add(shape);
  }

  @Override
  public void redo() {
    picture.add(shape);
    paintCanvas.repaint();
  }

  @Override
  public void undo() {
    picture.remove(shape);
    paintCanvas.repaint();
  }
}
