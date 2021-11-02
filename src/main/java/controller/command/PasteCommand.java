/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 3: Sprint 3
  11/2/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.picture.PasteShapes;
import model.picture.Picture;

/**
 * The PasteCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The CopyCommand takes in a Region and a Picture object. The class uses these fields to
 * create a PasteShapes object that holds a composition relationship to the class. In the undo method,
 * it calls undoPaste from the PasteShapes class. In the redo method, it pastes the shapes again in
 * from the PasteShapes class.
 */
public class PasteCommand implements ICommand, Undoable {
  Picture picture;
  PasteShapes pShapes;

  public PasteCommand(Picture picture) {
    this.picture = picture;
    pShapes = new PasteShapes(picture);
  }

  @Override
  public void run() {
    pShapes.pasteShapes();
  }

  @Override
  public void undo() {
    pShapes.undoPaste();
  }

  @Override
  public void redo() {
    pShapes.pasteShapes();
  }
}
