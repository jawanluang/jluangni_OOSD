package controller.command;


import controller.interfaces.Undoable;
import model.interfaces.IShape;

public class DrawCommand implements ICommand, Undoable {
  IShape shape;

  @Override
  public void run() {

  }

  @Override
  public void redo() {

  }

  @Override
  public void undo() {

  }
}
