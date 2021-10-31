/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.picture.MoveShape;
import model.picture.Picture;
import model.picture.Point;

/**
 * The MoveCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The MoveCommand takes in two Point objects and a Picture object. The class uses these fields to
 * create a MoveShape object that holds a composition relationship to the class. In the undo method,
 * it calls the reverseMove method of MakeShape. In the redo method, it recalls the moveAll method
 * from MakeShape.
 */
public class MoveCommand implements ICommand, Undoable {
  ArrayList<IShape> selectShapes;
  Point start;
  Point end;
  MoveShape ms;

  public MoveCommand(Region region, Picture picture) {
    start = region.getStart();
    end = region.getEnd();
    selectShapes = picture.getSelectShapes();
  }

  @Override
  public void run() {
    ms = new MoveShape(selectShapes, start, end);
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
