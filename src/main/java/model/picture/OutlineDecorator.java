/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 3: Sprint 3
  11/2/2021
 */
package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.DrawStrategy;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.interfaces.ShapeDecorator;

/**
 * The OutlineDecorator extends ShapeDecorator (@see model.interfaces.ShapeDecorator) which implements
 * IShape (@see model.interfaces.IShape).
 * The OutlineDecorator takes in an IShape and sets it as the decorated shape. In the setOutline method,
 * it gets the decorated shape's drawStrategy and calls the drawOutline method and draw method.
 */
public class OutlineDecorator extends ShapeDecorator {
  DrawStrategy drawStrategy;

  public OutlineDecorator(IShape decoratedShape) {
    super(decoratedShape);
  }

  @Override
  public void draw(Graphics2D graphics) {
    decoratedShape.draw(graphics);
    setOutline(graphics, decoratedShape);
  }

  @Override
  public void select(Graphics2D graphics) {
    decoratedShape.select(graphics);
  }

  private void setOutline(Graphics2D graphics, IShape decoratedShape) {
    drawStrategy = decoratedShape.getDrawStrategy();
    drawStrategy.drawOutline(graphics, decoratedShape);
  }

  @Override
  public void move(int x, int y) {
    decoratedShape.move(x, y);
  }

  @Override
  public IShape copy() {
    IShape newDecorShape = decoratedShape.copy();
    return new OutlineDecorator(newDecorShape);
  }

  @Override
  public Point getStart() {
    return region.getStart();
  }

  @Override
  public Point getEnd() {
    return region.getEnd();
  }

  @Override
  public Color getPrimary() {
    return decoratedShape.getPrimary();
  }

  @Override
  public Color getSecondary() {
    return decoratedShape.getSecondary();
  }

  @Override
  public ShapeShadingType getSst() {
    return decoratedShape.getSst();
  }

  @Override
  public Region getRegion() {
    return decoratedShape.getRegion();
  }

  @Override
  public DrawStrategy getDrawStrategy() {
    return decoratedShape.getDrawStrategy();
  }
}
