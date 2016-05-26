package autoform.wrappers;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;

public class BooleanWrapper implements FieldWrapper<Boolean> {

  private final CheckBox node = new CheckBox("test");

  @Override
  public Node node() {
    return node;
  }

  @Override
  public Boolean value() {
    return node.isSelected();
  }

}
