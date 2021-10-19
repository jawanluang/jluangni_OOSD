package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

public class SelectShape {
  ArrayList<IShape> shapeList = new ArrayList<>();

  public void addSelect(IShape shape) {
    shapeList.add(shape);
  }

  public ArrayList<IShape> getSelectedShapes() {
    return shapeList;
  }
}
