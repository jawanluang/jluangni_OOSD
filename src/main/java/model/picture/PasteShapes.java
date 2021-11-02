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
 * The Paste Shapes class takes in a Picture object and gets the copied shapes list from Pictures.
 * Interacting with Picture by creating new pasted shapes and inserting it into the shapesList & pastedShapes arraylist
 * in the pastShapes method. In the undoPaste method, it goes through the pastedShapes list and removes the
 * shape from the shapesList.
 */
public class PasteShapes {
  ArrayList<IShape> copiedShapes;
  ArrayList<IShape> pastedShapes = new ArrayList<>();
  Picture picture;
  int pasteIterator = -10;

  public PasteShapes(Picture picture) {
    copiedShapes = picture.getCopiedShapes();
    this.picture = picture;
  }

  public void pasteShapes() {
    for (IShape ishape : copiedShapes) {
      IShape newShape = ishape.copy();
      newShape.move(pasteIterator, pasteIterator);
      picture.add(newShape);
      pastedShapes.add(newShape);
    }
  }

  public void undoPaste() {
    for (IShape ishape : pastedShapes) {
      ishape.move(-1 * pasteIterator, -1 * pasteIterator);
      picture.remove(ishape);
    }
  }
}
