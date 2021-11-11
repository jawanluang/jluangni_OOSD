/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 4: Sprint 4
  11/11/2021
 */
package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

/**
 * The DeleteShape class takes in a Picture object and gets the selected shapes list from the Picture class.
 * The class then interacts with the Picture's selectedShapes list. In the deleteAll method, it calls on
 * the remove method in each select shape to remove it from the picture and each deleted shape is then
 * placed within an ArrayList of IShapes stored in the class. In the undoDelete method, it iterates through
 * the deleted shapes list and adds them back into the picture.
 */
public class DeleteShape {
  Picture picture;
  ArrayList<IShape> selectList;
  ArrayList<IShape> deletedList = new ArrayList<>();

  public DeleteShape(Picture picture){
    this.picture = picture;
    selectList = picture.getSelectShapes();
  }

  public void deleteAll() {
    for (IShape iShape : selectList) {
      deletedList.add(iShape);
      picture.remove(iShape);
    }
  }

  public void undoDelete() {
    for (IShape iShape : deletedList) {
      picture.add(iShape);
    }

    deletedList.clear();
  }

}
