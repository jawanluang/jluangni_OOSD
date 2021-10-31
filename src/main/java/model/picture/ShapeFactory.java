/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model.picture;

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

    switch (st) {
      case RECTANGLE:
        return new Rectangle(region, userChoices);
      case ELLIPSE:
        return new Ellipse(region, userChoices);
      case TRIANGLE:
        return new Triangle(region, userChoices);
      default:
        System.out.println("No Shape found");
        break;
    }

    return null;
  }
}
