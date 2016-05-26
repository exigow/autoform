package autoform.wrappers;

import javafx.scene.Node;

public class UndefinedWrapper implements FieldWrapper<Void> {

  @Override
  public Node node() {
    return null;
  }

  @Override
  public Void value() {
    return null;
  }

}
