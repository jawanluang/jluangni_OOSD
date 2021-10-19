package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.picture.Point;
import model.picture.SelectShape;

public class RegionImpl implements Region {
  ArrayList<IShape> shapesDrawn;
  Point startRegion;
  Point endRegion;
  SelectShape selectShape;


  public RegionImpl(Point start, Point end, ArrayList<IShape> shapeList, SelectShape select) {
    startRegion = new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
    endRegion = new Point(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
    shapesDrawn = shapeList;
    selectShape = select;
  }

  public void putSelectedShapes() {
    for(IShape ishape: shapesDrawn) {
      if(contains(ishape.getStart(), ishape.getEnd())) {
        selectShape.addSelect(ishape);
        System.out.println("Shape added");
      }
    }
  }

  @Override
  public boolean contains(Point shapeStart, Point shapeEnd) {
    if ((shapeStart.getX() <= endRegion.getX() && shapeStart.getX() >= startRegion.getX()) || (shapeStart.getY() <= endRegion.getY() && shapeStart.getY() >= startRegion.getY()))
      return true;

    if ((shapeEnd.getX() <= endRegion.getX() && shapeEnd.getX() >= startRegion.getX()) || (shapeEnd.getY() <= endRegion.getY() && shapeEnd.getY() >= startRegion.getY()))
      return true;

    if ((startRegion.getX() <= shapeEnd.getX() && startRegion.getX() >= shapeStart.getX()) || (startRegion.getY() <= shapeEnd.getY() && startRegion.getY() >= shapeStart.getY()))
      return true;

    if ((endRegion.getX() <= shapeEnd.getX() && endRegion.getX() >= shapeStart.getX()) || (endRegion.getY() <= shapeEnd.getY() && endRegion.getY() >= shapeStart.getY()))
      return true;

    return false;
  }
}
