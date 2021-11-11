/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.picture.Point;

/**
 * The IShape interface presents an abstract template for Shape objects to follow.
 * The Shape objects that are included are Rectangles, Ellipses, and Triangles. The
 * abstract method draw interacts with the graphics system to draw the shape. The abstract method
 * move allows any shape to change the origin point. There are various abstract getter methods that
 * allows other classes to get information from the IShape. The method copy gives a new shape of the
 * same likeness of the original.
 */
public interface IShape {
  void draw(Graphics2D graphics);
  void select(Graphics2D graphics2D);
  void move(int x, int y);
  IShape copy();
  Point getStart();
  Point getEnd();
  Color getPrimary();
  Color getSecondary();
  ShapeShadingType getSst();
  Region getRegion();
  DrawStrategy getDrawStrategy();
}
