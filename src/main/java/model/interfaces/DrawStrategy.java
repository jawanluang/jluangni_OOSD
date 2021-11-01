package model.interfaces;

import java.awt.Graphics2D;

public interface DrawStrategy {
  void draw(Graphics2D graphics2D, IShape shape);
  void drawOutline(Graphics2D graphics2D, IShape shape);
  void drawSelect(Graphics2D graphics2D, IShape shape);
}
