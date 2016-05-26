package autoform;

import autoform.annotations.Autoform;
import autoform.annotations.AutoformField;
import autoform.window.GridPaneBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoformInstancer {

  public static <T> void instantiateForm(T input, Consumer<T> filledResult) {
    Autoform classAnnotation = readClassAnnotation(input);
    GridPaneBuilder builder = GridPaneBuilder.loadInitialFxml(classAnnotation.title());
    for (Field field : readAnnotatedFields(input)) {
      AutoformField autoformField = field.getAnnotation(AutoformField.class);
      Node left = new Label(autoformField.label());
      Node right = new TextField();
      builder.extendWithRow(left, right);
    }
    builder.buildStage().show();
  }

  private static Autoform readClassAnnotation(Object input) {
    Autoform annotation = input.getClass().getAnnotation(Autoform.class);
    if (annotation == null)
      throw new RuntimeException();
    return annotation;
  }

  private static Collection<Field> readAnnotatedFields(Object input) {
    return Stream.of(input.getClass().getFields())
      .filter(e -> e.getAnnotation(AutoformField.class) != null)
      .collect(Collectors.toList());
  }

}
