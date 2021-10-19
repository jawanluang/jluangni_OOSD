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
 * The SelectShape class handles the data for the selected shapes. It gives access to an add method
 * for other classes to use, and it returns the ArrayList of IShape with the getSelectedShapes method
 */
public class SelectShape {
  ArrayList<IShape> shapeList = new ArrayList<>();

  public void addSelect(IShape shape) {
    shapeList.add(shape);
  }

  public ArrayList<IShape> getSelectedShapes() {
    return shapeList;
  }
}
