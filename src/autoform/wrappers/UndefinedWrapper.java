package autoform.wrappers;

import javafx.scene.Node;
import sun.plugin.dom.exception.InvalidStateException;

public class UndefinedWrapper implements FieldWrapper<Void> {

  @Override
  public Node node() {
    throw new RuntimeException();
  }

  @Override
  public Void readValue() {
    throw new RuntimeException();
  }

  @Override
  public void setValue(Void value) {
    throw new RuntimeException();
  }

}
