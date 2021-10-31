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
import model.ShapeShadingType;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.interfaces.UserChoices;

/**
 * This class implements the IShape interface and follows the abstract methods presented.
 * (@see model.interfaces.IShape)
 * The Triangle class takes two Point objects and a UserChoices object as an input. Using the
 * Point objects to create an array of x-coordinates and y-coordinates. With the UserChoices object,
 * the class extracts the primary and secondary color of the shape.
 */
public class Triangle implements IShape {
  Region region;
  Color primary;
  Color secondary;
  int[] xPoints;
  int[] yPoints;
  UserChoices userChoices;
  ShapeShadingType sst;

  public Triangle(Region region, UserChoices userChoices) {
    this.region = region;
    xPoints = region.getXArray();
    yPoints = region.getYArray();

    this.userChoices = userChoices;
    primary = userChoices.getActivePrimaryColor().value;
    secondary = userChoices.getActiveSecondaryColor().value;
    sst = userChoices.getActiveShapeShadingType();
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawTriangle(graphics, xPoints, yPoints, primary, secondary, sst);
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
    return region.getStartRegion();
  }

  @Override
  public Point getEnd() {
    return region.getEndRegion();
  }
}
