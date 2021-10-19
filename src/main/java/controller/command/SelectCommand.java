package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.RegionImpl;
import model.interfaces.IShape;
import model.picture.Picture;
import model.picture.Point;
import model.picture.SelectShape;

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
