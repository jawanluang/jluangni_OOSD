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
import model.RegionImpl;
import model.interfaces.IShape;
import model.picture.Picture;
import model.picture.Point;
import model.picture.SelectShape;

/**
 * The SelectCommand class implements the interfaces for ICommand and IUndoable.
 * (@see controller.interfaces.ICommand)
 * The SelectCommand class takes in two Point objects and a Picture object. The class uses these fields
 * to create a SelectShape object and a RegionImpl that holds a composition relationship to the class.
 * In the undo method, it gets the picture's selected shapes arraylist and clears it. In the redo
 * method, it inserts the saved list into the picture's selected shapes arraylist.
 */
public class SelectCommand implements ICommand, Undoable {
  Point regionX;
  Point regionY;
  Picture picture;
  ArrayList<IShape> selectedShapes;

  public SelectCommand(Point x, Point y, Picture picture){
    regionX = x;
    regionY = y;
    this.picture = picture;
  }

  @Override
  public void run() {
    SelectShape selected = new SelectShape();
    RegionImpl region = new RegionImpl(regionX, regionY, picture.getDrawnShapes(), selected);
    region.putSelectedShapes();
    picture.select(selected.getSelectedShapes());
    selectedShapes = selected.getSelectedShapes();
  }

  @Override
  public void undo() {
    picture.getSelectShapes().clear();
  }

  @Override
  public void redo() {
    picture.select(selectedShapes);
  }
}
