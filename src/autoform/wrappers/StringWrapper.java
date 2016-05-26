package autoform.wrappers;

import javafx.scene.Node;
import javafx.scene.control.TextField;

public class StringWrapper implements FieldWrapper<String> {

  private final TextField node = new TextField();

  @Override
  public Node node() {
    return node;
  }

  @Override
  public String value() {
    return node.getText();
  }

}
