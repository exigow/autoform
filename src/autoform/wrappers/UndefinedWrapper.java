package autoform.wrappers;

import javafx.scene.Node;
import sun.plugin.dom.exception.InvalidStateException;

// todo throw new InvalidStateException(); wszędzie!
public class UndefinedWrapper implements FieldWrapper<Void> {

  @Override
  public Node node() {
    return null;
  }

  @Override
  public Void readValue() {
    return null;
  }

  @Override
  public void setValue(Void value) {
  }

}
