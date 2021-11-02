/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 3: Sprint 3
  11/2/2021
 */
package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

/**
 * The CopyShapes class takes in a Picture object and gets the selected shapes list from the Picture class.
 * The class then interacts with the Picture's selectedShapes list and calls the copy method to create a new shape
 * that is then placed within a ArrayList of IShapes that is then sent to Picture.
 */
public class CopyShapes {
  ArrayList<IShape> selectedShapes;
  ArrayList<IShape> copiedShapes = new ArrayList<>();
  Picture picture;

  public CopyShapes(Picture picture) {
    selectedShapes = picture.getSelectShapes();
    this.picture = picture;
  }

  public void createCopy() {
    for(IShape ishape : selectedShapes) {
      IShape copyShape = ishape.copy();
      copiedShapes.add(copyShape);
    }
    picture.copy(copiedShapes);
  }

}
