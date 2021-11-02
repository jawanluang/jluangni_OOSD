/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 3: Sprint 3
  11/2/2021
 */
package model.interfaces;

import java.awt.Graphics2D;

/**
 * The ShapeDecorator class implements the IShape interface (@see model.interfaces.IShape) and provides
 * a template for other shape decorators to follow. Shape decorators included are OutlineDecorator and
 * EmptyShapeDecorator. The class creates a decoratedShape and region to be accessed for all shape decorator.
 * as well as a standard draw method.
 */
public abstract class ShapeDecorator implements IShape{
  protected IShape decoratedShape;
  protected Region region;

  public ShapeDecorator(IShape decoratedShape) {
    this.decoratedShape = decoratedShape;
    region = decoratedShape.getRegion();
  }

  public void draw(Graphics2D graphics2D) {
    decoratedShape.draw(graphics2D);
  }

}
