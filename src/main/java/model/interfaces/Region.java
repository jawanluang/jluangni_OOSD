package model.interfaces;

import java.awt.Graphics2D;
import model.picture.Point;

public interface Region {
  boolean contains(Point shapeStart, Point shapeEnd);
}
