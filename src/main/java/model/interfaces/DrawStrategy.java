/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 3: Sprint 3
  11/2/2021
 */
package model.interfaces;

import java.awt.Graphics2D;

/**
 * The DrawStrategy interface presents an abstract template for a draw strategy to follow. Draw strategies
 * included are DrawRectangle, DrawEllipse, and DrawTriangle. The abstract draw method uses the graphics and
 * shape to draw a filled in shape. The abstract drawOutline method uses the graphics and shape to draw
 * a shape's outline. The abstract drawSelect method uses the graphics and shape to draw the select border.
 */
public interface DrawStrategy {
  void draw(Graphics2D graphics2D, IShape shape);
  void drawOutline(Graphics2D graphics2D, IShape shape);
  void drawSelect(Graphics2D graphics2D, IShape shape);
}
