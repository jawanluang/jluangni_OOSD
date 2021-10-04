/**
 * SE 350 Fall 2021
 * Jawan Luangnikone Davis
 * Project Assignment 1: Sprint 1
 * 10/5/2021
 */

package model.picture;

import java.awt.Graphics2D;
import java.util.ArrayList;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class Picture {
  private ArrayList<IShape> shapesContainer = new ArrayList<>();

  public void add(IShape newShape){
    shapesContainer.add(newShape);
  }

  public void remove(IShape oldShape) {
    shapesContainer.remove(oldShape);
  }

  public void draw(Graphics2D graphics2D) {
    for (int i= 0; i < shapesContainer.size(); i++)
      shapesContainer.get(i).draw(graphics2D);
  }
}
