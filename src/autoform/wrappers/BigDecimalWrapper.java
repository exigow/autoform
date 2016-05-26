package autoform.wrappers;

import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class BigDecimalWrapper implements FieldWrapper<BigDecimal> {

  private final TextField node = new TextField("0");

  {
    node.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d*"))
        node.setText(oldValue);
    });
  }

  @Override
  public Node node() {
    return node;
  }

  @Override
  public BigDecimal readValue() {
    return new BigDecimal(node.getText());
  }

  @Override
  public void setValue(BigDecimal value) {
    node.setText(value.toString());
  }

}
