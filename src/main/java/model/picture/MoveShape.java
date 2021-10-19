package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

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