package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

public class PasteShapes {
  ArrayList<IShape> copiedShapes;
  ArrayList<IShape> pastedShapes = new ArrayList<>();
  Picture picture;

  public PasteShapes(Picture picture) {
    copiedShapes = picture.getCopiedShapes();
    this.picture = picture;
  }

  public void pasteShapes() {
    picture.pasteIterator += -10;

    for (IShape ishape : copiedShapes) {
      IShape newShape = ishape.copy();
      newShape.move(picture.pasteIterator, picture.pasteIterator);
      picture.add(newShape);
      pastedShapes.add(newShape);
    }
  }

  public void undoPaste() {
    for (IShape ishape : pastedShapes) {
      ishape.move(-1 * picture.pasteIterator, -1 * picture.pasteIterator);
      picture.remove(ishape);
    }
    picture.pasteIterator -= -10;
  }
}
