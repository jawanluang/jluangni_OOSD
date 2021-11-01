package model.picture;

import java.util.ArrayList;
import model.interfaces.IShape;

public class CopyShapes {
  ArrayList<IShape> selectedShapes;
  ArrayList<IShape> copiedShapes = new ArrayList<>();
  Picture picture;

  public CopyShapes(Picture picture) {
    selectedShapes = picture.getSelectShapes();
    this.picture = picture;
  }

  public void createCopy() {
    for(IShape ishape : selectedShapes) {
      IShape copyShape = ishape.copy();
      copiedShapes.add(copyShape);
    }
    picture.copy(copiedShapes);
  }

}
