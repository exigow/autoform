package autoform.wrappers;

import javafx.scene.Node;

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
