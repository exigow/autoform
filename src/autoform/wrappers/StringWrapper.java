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
  public String readValue() {
    return node.getText();
  }

  @Override
  public void setValue(String value) {
    node.setText(value);
  }

}
