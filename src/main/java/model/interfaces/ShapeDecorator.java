package model.interfaces;

import java.awt.Graphics2D;


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
