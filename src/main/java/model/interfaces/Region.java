/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model.interfaces;

import model.picture.Point;

/**
 * The Region interface presents an abstract template for a region to follow. The Region objects included
 * are the RegionImpl class. The abstract method "contains" interacts with Point objects and compares
 * where the points lie in relation to the region. The abstract method move allows the region to change
 * the origin point. There are various abstract getter methods that allows other classes to get
 * information from the Region.
 */
public interface Region {
  boolean contains(Point shapeStart, Point shapeEnd);
  Point getStartRegion();
  Point getEndRegion();
  Point getStart();
  Point getEnd();
  int[] getXArray();
  int[] getYArray();
  int getHeight();
  int getWidth();
  void move(int x, int y);
}
