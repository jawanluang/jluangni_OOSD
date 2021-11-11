/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

/**
 * The MoveShape class takes in an ArrayList of IShapes and two Point objects that reference the start
 * and end of the current mouse release. Iterating through the shape list, it calls the move method of the individual
 * shapes in the moveAll function. In the reverseMove method, it uses the inverse of the change and calls the move
 * method of the individual shapes.
 */
public class MoveShape {
  ArrayList<IShape> shapeList;
  int changeX;
  int changeY;

  public MoveShape(ArrayList<IShape> shapeList, Point start, Point end) {
    this.shapeList = shapeList;
    changeX = end.getX() - start.getX();
    changeY = end.getY() - start.getY();
  }

  public void moveAll() {
    for (IShape iShape : shapeList) {
      iShape.move(changeX, changeY);
    }
  }

  public void reverseMove() {
    for (IShape iShape : shapeList) {
      iShape.move(-1*changeX, -1*changeY);
    }
  }
}
