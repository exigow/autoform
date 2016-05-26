package autoform;

import autoform.annotations.Autoform;
import autoform.annotations.AutoformField;
import autoform.window.GridPaneBuilder;
import autoform.wrappers.BigDecimalWrapper;
import autoform.wrappers.FieldWrapper;
import autoform.wrappers.LocalDateWrapper;
import autoform.wrappers.StringWrapper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoformInstancer {

  public static <T> void instantiateForm(T input, Consumer<T> filledResult) {
    Autoform classAnnotation = readClassAnnotation(input);
    GridPaneBuilder builder = GridPaneBuilder.loadInitialFxml(classAnnotation.title());
    Map<Field, FieldWrapper> map = new HashMap<>();
    for (Field field : findAnnotatedFields(input)) {
      AutoformField autoformField = field.getAnnotation(AutoformField.class);
      FieldWrapper wrapper = instantiateGenericWrapper(field);
      builder.putRow(autoformField.label(), wrapper.node());
      map.put(field, wrapper);
    }
    builder.putButton(e -> {
      for (Field field : map.keySet()) {
        try {
          field.set(input, map.get(field).value());
        } catch (IllegalAccessException e1) {
          new RuntimeException();
        }
      }
      filledResult.accept(input);
    });
    builder.buildStage().show();
  }

  private static FieldWrapper instantiateGenericWrapper(Field field) {
    if (field.getType() == String.class)
      return new StringWrapper();
    if (field.getType() == LocalDate.class)
      return new LocalDateWrapper();
    if (field.getType() == BigDecimal.class)
      return new BigDecimalWrapper();
    throw new RuntimeException("unsupported type");
  }

  private static Autoform readClassAnnotation(Object input) {
    Autoform annotation = input.getClass().getAnnotation(Autoform.class);
    if (annotation == null)
      throw new RuntimeException();
    return annotation;
  }

  private static Collection<Field> findAnnotatedFields(Object input) {
    Predicate<Field> isAnnotated = e -> e.getAnnotation(AutoformField.class) != null;
    return Stream.of(input.getClass().getFields())
      .filter(isAnnotated)
      .collect(Collectors.toList());
  }

}
