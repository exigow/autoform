package autoform.wrappers;

import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class BigDecimalWrapper implements FieldWrapper<BigDecimal> {

  private final TextField node = new TextField() {

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
  public BigDecimal value() {
    return new BigDecimal(node.getText());
  }

}
