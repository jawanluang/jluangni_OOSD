package model.picture;

import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

public class ShapeFactory {

  public static IShape makeShape(Point x, Point y, UserChoices userChoices) {
    ShapeType st = userChoices.getActiveShapeType();

    switch (st) {
      case RECTANGLE:
        return new Rectangle(x, y, userChoices);
      case ELLIPSE:
        return new Ellipse(x, y, userChoices);
      case TRIANGLE:
        return new Triangle(x, y, userChoices);
      default:
        System.out.println("No Shape found");
        break;
    }

    return null;
  }
}
