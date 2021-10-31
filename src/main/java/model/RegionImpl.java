/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model;

import java.util.ArrayList;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.picture.Point;
import model.picture.SelectShape;

/**
 * RegionImpl is an implementation of the Region interface and follows the abstract methods
 * (@see model.interfaces.Region)
 * The RegionImpl class takes two Point objects, an ArrayList of IShapes, and a SelectShape object.
 * using the two Point object to create its region it iterates through the picture's shape list and
 * adds it to SelectShape's list if it is contained in the region.
 */
public class RegionImpl implements Region {
  Point startRegion;
  Point endRegion;
  Point start;
  Point end;


  public RegionImpl(Point start, Point end) {
    startRegion = new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
    endRegion = new Point(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean contains(Point shapeStart, Point shapeEnd) {
    Point bottomLeft = new Point(shapeStart.getX(), shapeEnd.getY());
    Point upperRight = new Point(shapeEnd.getX(), shapeStart.getY());

    if ((shapeStart.getX() <= endRegion.getX() && shapeStart.getX() >= startRegion.getX()) && (shapeStart.getY() <= endRegion.getY() && shapeStart.getY() >= startRegion.getY()))
      return true;

    if ((shapeEnd.getX() <= endRegion.getX() && shapeEnd.getX() >= startRegion.getX()) && (shapeEnd.getY() <= endRegion.getY() && shapeEnd.getY() >= startRegion.getY()))
      return true;

    if ((bottomLeft.getX() <= endRegion.getX() && bottomLeft.getX() >= startRegion.getX()) && (bottomLeft.getY() <= endRegion.getY() && bottomLeft.getY() >= startRegion.getY()))
      return true;

    if ((upperRight.getX() <= endRegion.getX() && upperRight.getX() >= startRegion.getX()) && (upperRight.getY() <= endRegion.getY() && upperRight.getY() >= startRegion.getY()))
      return true;

    if ((startRegion.getX() <= shapeEnd.getX() && startRegion.getX() >= shapeStart.getX()) && (startRegion.getY() <= shapeEnd.getY() && startRegion.getY() >= shapeStart.getY()))
      return true;

    if ((endRegion.getX() <= shapeEnd.getX() && endRegion.getX() >= shapeStart.getX()) && (endRegion.getY() <= shapeEnd.getY() && endRegion.getY() >= shapeStart.getY()))
      return true;

    return false;
  }

  public Point getStartRegion() {
    return startRegion;
  }

  public Point getEndRegion() {
    return endRegion;
  }

  public int[] getXArray() {
    int halfX = (Math.max(startRegion.getX(), endRegion.getX()) - Math.min(startRegion.getX(), endRegion.getX()))/2;
    int[] xPoints = new int[]{Math.min(startRegion.getX(), endRegion.getX()), Math.min(startRegion.getX(), endRegion.getX()) + halfX, Math.max(startRegion.getX(), endRegion.getX())};
    return xPoints;
  }

  public int[] getYArray() {
    int[] yPoints = new int[]{Math.max(startRegion.getY(), endRegion.getY()), Math.min(startRegion.getY(), endRegion.getY()), Math.max(startRegion.getY(), endRegion.getY())};
    return yPoints;
  }

  public Point getStart(){
    return start;
  }

  public Point getEnd() {
    return end;
  }
}
