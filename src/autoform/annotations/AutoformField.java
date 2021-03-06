package autoform.annotations;

import autoform.wrappers.FieldWrapper;
import autoform.wrappers.UndefinedWrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoformField {

  String label();

  Class<? extends FieldWrapper> wrapper() default UndefinedWrapper.class;

}
