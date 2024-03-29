/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package model.picture;

import java.awt.Graphics2D;
import java.util.ArrayList;
import model.interfaces.IShape;

/**
 * The Picture class contains ArrayLists of IShape objects. Each ArrayList has an add and get method
 * that allows the ArrayList to be available outside the class. The drawnShapes in shape container
 * can be removed with the public method remove. This class also has a draw method,
 * which loops through all the shapes in the ArrayList and calls the draw method to create a picture.
 */
public class Picture {
  private final ArrayList<IShape> shapesContainer = new ArrayList<>();
  private final ArrayList<IShape> selectContainer = new ArrayList<>();
  private final ArrayList<IShape> copyContainer = new ArrayList<>();

  public void add(IShape newShape){
    shapesContainer.add(newShape);
  }

  public ArrayList<IShape> getDrawnShapes() {
    return shapesContainer;
  }

  public void remove(IShape oldShape) {
    shapesContainer.remove(oldShape);
  }

  public void select(ArrayList<IShape> selectedShapes) {
    if (!selectContainer.isEmpty()) {
      selectContainer.clear();
    }
    selectContainer.addAll(selectedShapes);
  }

  public ArrayList<IShape> getSelectShapes() {
    return selectContainer;
  }

  public void copy(ArrayList<IShape> selectedShapes) {
    if (!copyContainer.isEmpty()) {
      copyContainer.clear();
    }
    copyContainer.addAll(selectedShapes);
  }

  public ArrayList<IShape> getCopiedShapes() {
    return copyContainer;
  }

  public void draw(Graphics2D graphics2D) {
    for (IShape iShape : shapesContainer) {
      iShape.draw(graphics2D);
      if (selectContainer.contains(iShape))
        iShape.getDrawStrategy().drawSelect(graphics2D, iShape);
    }
  }
}
