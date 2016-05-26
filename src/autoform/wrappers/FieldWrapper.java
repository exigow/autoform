package autoform.wrappers;

import javafx.scene.Node;

public interface FieldWrapper<T> {

  Node node();

  T readValue();

  void setValue(T value);

}
