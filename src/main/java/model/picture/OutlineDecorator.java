package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.DrawStrategy;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.interfaces.ShapeDecorator;

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
    return new OutlineDecorator(decoratedShape);
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
