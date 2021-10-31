package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.picture.PasteShapes;
import model.picture.Picture;

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
