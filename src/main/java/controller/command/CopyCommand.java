/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 3: Sprint 3
  11/2/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.picture.CopyShapes;
import model.picture.Picture;

/**
 * The CopyCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The CopyCommand takes in a Region and a Picture object. The class uses these fields to
 * create a CopyShape object that holds a composition relationship to the class. In the undo method,
 * it is passed over. In the redo method, it is passed over
 */
public class CopyCommand implements ICommand, Undoable {
  Picture picture;

  public CopyCommand(Picture picture) {
    this.picture = picture;
  }

  @Override
  public void run() {
    CopyShapes copyShapes = new CopyShapes(picture);
    copyShapes.createCopy();
  }

  @Override
  public void undo() {
    CommandHistory.undo();
  }

  @Override
  public void redo() {
    CommandHistory.redo();
  }
}
