package autoform.wrappers;

import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class NumberWrapper implements FieldWrapper<BigDecimal> {

  private final TextField node = new TextField("0") {

    @Override
    public void replaceText(int start, int end, String text) {
      if (isNumber(text))
        super.replaceText(start, end, text);
    }

    @Override
    public void replaceSelection(String text) {
      if (isNumber(text))
        super.replaceSelection(text);
    }

    private boolean isNumber(String text) {
      return text.matches("[0-9]*");
    }

  };

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
