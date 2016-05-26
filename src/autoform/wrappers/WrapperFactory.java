package autoform.wrappers;

import autoform.annotations.AutoformField;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;


public class WrapperFactory {

  @SuppressWarnings("unchecked")
  public static FieldWrapper instantiateWrapper(Field field, AutoformField annotation) {
    Class<? extends FieldWrapper> type = (Class<? extends FieldWrapper>) field.getType();
    if (isUndefined(annotation))
      return instantiateGenericWrapper(type);
    return instantiateWrapper(annotation.wrapper());
  }

  private static boolean isUndefined(AutoformField annotation) {
    return annotation.wrapper() == UndefinedWrapper.class;
  }

  private static FieldWrapper instantiateGenericWrapper(Class<?> type) {
    if (type == String.class)
      return new StringWrapper();
    if (type == LocalDate.class)
      return new LocalDateWrapper();
    if (type == BigDecimal.class)
      return new BigDecimalWrapper();
    if (type == Boolean.class)
      return new BooleanWrapper();
    throw new RuntimeException("unsupported type");
  }

  private static FieldWrapper instantiateWrapper(Class<?> wrapperClass) {
    try {
      return (FieldWrapper) wrapperClass.getConstructor().newInstance();
    } catch (Exception  e) {
      throw new RuntimeException(e);
    }
  }

}
