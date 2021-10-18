package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.picture.MoveShape;
import model.picture.Picture;
import model.picture.Point;

public class MoveCommand implements ICommand, Undoable {
  ArrayList<IShape> selectShapes;
  Point moveX;
  Point moveY;
  MoveShape ms;

  public MoveCommand(Point x, Point y, Picture picture) {
    moveX = x;
    moveY = y;
    selectShapes = picture.getSelectShapes();
  }

  @Override
  public void run() {
    ms = new MoveShape(selectShapes, moveX, moveY);
    ms.moveAll();
  }

  @Override
  public void undo() {
    ms.reverseMove();
  }

  @Override
  public void redo() {
    ms.moveAll();
  }
}
