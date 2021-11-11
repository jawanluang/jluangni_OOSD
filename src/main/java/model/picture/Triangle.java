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
 * The Triangle class takes a Region, DrawStrategy object, and a UserChoices object as an input. Using the
 *  * Region object to create an origin and dimensions for the shape. With the UserChoices object,
 *  * the class extracts the primary and secondary color of the shape. Using the DrawStrategy to draw the shape.
 */
public class Triangle implements IShape {
  private final Region region;
  private final Color primary;
  private final Color secondary;
  private int[] xPoints;
  private int[] yPoints;
  private final UserChoices userChoices;
  private final ShapeShadingType sst;
  private final DrawStrategy drawStrategy;

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
  public void select(Graphics2D graphics2D){
    drawStrategy.drawSelect(graphics2D, this);
  }

  @Override
  public void move(int x, int y) {
    region.move(x, y);
    xPoints = region.getXArray();
    yPoints = region.getYArray();
  }

  @Override
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

  @Override
  public Region getRegion() {
    return region;
  }

  @Override
  public DrawStrategy getDrawStrategy() {
    return drawStrategy;
  }

  @Override
  public Color getPrimary() {
    return primary;
  }

  @Override
  public Color getSecondary() {
    return secondary;
  }

  @Override
  public ShapeShadingType getSst() {
    return sst;
  }
}
