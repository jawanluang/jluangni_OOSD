/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model.picture;

import model.DrawEllipse;
import model.DrawRectangle;
import model.DrawTriangle;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.interfaces.UserChoices;

/**
 * The ShapeFactory utilizes the factory method design in relation to the classes that implement
 * the IShape interface. The class takes in two Point objects, and a UserChoices object
 * to help fill in the fields for the new shapes. It chooses the command made based
 * on the current ENUM for ShapeType.
 */
public class ShapeFactory {

  public static IShape makeShape(Region region, UserChoices userChoices) {
    ShapeType st = userChoices.getActiveShapeType();
    ShapeShadingType shading = userChoices.getActiveShapeShadingType();

    switch (st) {
      case RECTANGLE:
        if (shading == ShapeShadingType.FILLED_IN) {
          return new Rectangle(region, userChoices, new DrawRectangle());
        } else if (shading == ShapeShadingType.OUTLINE) {
          return new EmptyShapeDecorator(new Rectangle(region, userChoices, new DrawRectangle()));
        } else {
          return new OutlineDecorator(new Rectangle(region, userChoices, new DrawRectangle()));
        }
      case ELLIPSE:
        if (shading == ShapeShadingType.FILLED_IN) {
          return new Ellipse(region, userChoices, new DrawEllipse());
        } else if (shading == ShapeShadingType.OUTLINE) {
          return new EmptyShapeDecorator(new Ellipse(region, userChoices, new DrawEllipse()));
        } else {
          return new OutlineDecorator(new Ellipse(region, userChoices, new DrawEllipse()));
        }
      case TRIANGLE:
        if (shading == ShapeShadingType.FILLED_IN) {
          return new Triangle(region, userChoices, new DrawTriangle());
        } else if (shading == ShapeShadingType.OUTLINE) {
          return new EmptyShapeDecorator(new Triangle(region, userChoices, new DrawTriangle()));
        } else {
          return new OutlineDecorator(new Triangle(region, userChoices, new DrawTriangle()));
        }
      default:
        throw new IllegalArgumentException("Unknown ShapeType");
    }
  }
}
