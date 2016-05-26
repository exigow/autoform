package autoform.wrappers;

import javafx.scene.Node;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class LocalDateWrapper implements FieldWrapper<LocalDate> {

  private final DatePicker node = new DatePicker();

  @Override
  public Node node() {
    return node;
  }

  @Override
  public LocalDate readValue() {
    return node.getValue();
  }

  @Override
  public void setValue(LocalDate value) {
    node.setValue(value);
  }

}
