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
import model.interfaces.DrawStrategy;
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
  private Region region;
  private Color primary;
  private Color secondary;
  private int[] xPoints;
  private int[] yPoints;
  private UserChoices userChoices;
  private ShapeShadingType sst;
  private DrawStrategy drawStrategy;

  public Triangle(Region region, UserChoices userChoices, DrawStrategy drawStrategy) {
    this.region = region;
    xPoints = region.getXArray();
    yPoints = region.getYArray();
    this.drawStrategy = drawStrategy;

    this.userChoices = userChoices;
    primary = userChoices.getActivePrimaryColor().value;
    secondary = userChoices.getActiveSecondaryColor().value;
    sst = userChoices.getActiveShapeShadingType();
  }

  @Override
  public void draw(Graphics2D graphics) {
    drawStrategy.draw(graphics, this);
  }

  @Override
  public void move(int x, int y) {
    for (int i = 0; i < xPoints.length; i++) {
      xPoints[i] = xPoints[i] + x;
      yPoints[i] = yPoints[i] + y;
    }
  }

  public IShape copy() {
    return new Triangle(region, userChoices, drawStrategy);
  }

  @Override
  public Point getStart() {
    return region.getStartRegion();
  }

  @Override
  public Point getEnd() {
    return region.getEndRegion();
  }

  public Region getRegion() {
    return region;
  }

  @Override
  public DrawStrategy getDrawStrategy() {
    return drawStrategy;
  }

  public Color getPrimary() {
    return primary;
  }

  public Color getSecondary() {
    return secondary;
  }

  public ShapeShadingType getSst() {
    return sst;
  }
}
