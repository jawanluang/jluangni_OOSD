/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.DrawTriangle;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

/**
 * This class implements the IShape interface and follows the abstract methods presented.
 * (@see model.interfaces.IShape)
 * The Triangle class takes two Point objects and a UserChoices object as an input. Using the
 * Point objects to create an array of x-coordinates and y-coordinates. With the UserChoices object,
 * the class extracts the primary and secondary color of the shape.
 */
public class Triangle implements IShape {
  Point start;
  Point end;
  Color primaryColor;
  Color secondaryColor;
  int[] xPoints;
  int[] yPoints;

  public Triangle(Point start, Point end, UserChoices userChoices) {
    this.start = start;
    this.end = end;
    int halfX = (Math.max(start.getX(), end.getX()) - Math.min(start.getX(), end.getX()))/2;
    xPoints = new int[]{Math.min(start.getX(), end.getX()), Math.min(start.getX(), end.getX()) + halfX, Math.max(start.getX(), end.getX())};
    yPoints = new int[]{Math.max(start.getY(), end.getY()), Math.min(start.getY(), end.getY()), Math.max(start.getY(), end.getY())};

    primaryColor = userChoices.getActivePrimaryColor().value;
    secondaryColor = userChoices.getActiveSecondaryColor().value;
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawTriangle(graphics, xPoints, yPoints, primaryColor);
  }

  @Override
  public void move(int x, int y) {
    for (int i = 0; i < xPoints.length; i++) {
      xPoints[i] = xPoints[i] + x;
      yPoints[i] = yPoints[i] + y;
    }
  }

  @Override
  public Point getStart() {
    return start;
  }

  @Override
  public Point getEnd() {
    return end;
  }
}
