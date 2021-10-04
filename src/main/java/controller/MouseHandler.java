package controller;

import controller.command.CommandController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.picture.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {
  private final CommandController commandController;

  public MouseHandler(CommandController commandController) {
    this.commandController = commandController;
  }

  private Point startPoint;
  private static final Logger log = LoggerFactory.getLogger(MouseHandler.class);

  @Override
  public void mousePressed(MouseEvent e) {
    startPoint = new Point(e.getX(), e.getY());
    log.debug("Start " + e.getX() + " " + e.getY());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point endPoint = new Point(e.getX(), e.getY());
    log.debug("End " + e.getX() + " " + e.getY());
    commandController.onDraw(startPoint, endPoint);
  }
}
