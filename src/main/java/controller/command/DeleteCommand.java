/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 4: Sprint 4
  11/11/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.picture.DeleteShape;
import model.picture.Picture;

/**
 * The DeleteCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The DeleteCommand takes in a Picture object. The class uses these fields to
 * create a DeleteShape object that holds a composition relationship to the class. In the undo method,
 * it calls the undoDelete method of MakeShape. In the redo method, it recalls the deleteAll method
 * from MakeShape.
 */
public class DeleteCommand implements ICommand, Undoable {
  DeleteShape deleteShape;
  Picture picture;

  public DeleteCommand(Picture picture) {
    this.picture = picture;
  }

  @Override
  public void run() {
    deleteShape = new DeleteShape(picture);
    deleteShape.deleteAll();
  }

  @Override
  public void undo() {
    deleteShape.undoDelete();
  }

  @Override
  public void redo() {
    deleteShape.deleteAll();
  }
}
