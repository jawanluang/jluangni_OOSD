/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package model.interfaces;

import java.awt.Graphics2D;
import model.picture.Point;

/**
 * The IShape interface presents an abstract template for Shape objects to follow.
 * The Shape objects that are included are Rectangles, Ellipses, and Triangles. The
 * abstract method draw interacts with the graphics system to draw the shape.
 */
public interface IShape {
  void draw (Graphics2D graphics);
  void move(int x, int y);
  Point getStart();
  Point getEnd();
}
