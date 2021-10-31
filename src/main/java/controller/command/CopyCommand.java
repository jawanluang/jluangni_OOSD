package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.interfaces.Region;
import model.picture.CopyShapes;
import model.picture.Picture;


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
