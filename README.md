Automatic model dialog JavaFX utility
=====================================

Idea
----

1. Annotate your value object class like below:

    ```Java
    @Autoform(title = "Register your car")
    public class Car {
    
      @AutoformField(label = "Model name:")
      public String name;
    
      @AutoformField(label = "Date of production:")
      public LocalDate productionDate;
    
      @AutoformField(label = "Car price:")
      public BigDecimal price;
    
      @AutoformField(label = "Is insured?", wrapper = BooleanWrapper.class)
      public Boolean isInsured;
    
    }
    ```

2. Execute this:

    ```Java
    AutoformInstancer.createDialog(car, c -> System.out.println("Recieved " + c));
    ```

3. And see this:

    ![window screenshot] (https://raw.githubusercontent.com/exigow/autoform/master/screenshots/presentation.png)

Note, that lambda described in #2 will fire after completion. 
Fields have been completed for presentation purposes. It is possible to initialize window with predefined data, as shown in [example] (https://github.com/exigow/autoform/blob/master/test/autoform/example/Example.java).

Customization
-------------

Utility has done implementations wrappers for common types (Boolean, String, LocalDate, BigDecimal, etc.). It is possible to provide an implementation of your own wrapper that implements the [FieldWrapper] (https://github.com/exigow/autoform/blob/master/src/autoform/wrappers/FieldWrapper.java) interface.
Indicate wrapper class in the annotation, like below:

```Java
@AutoformField(label = "Is insured?", wrapper = CustomBooleanWrapper.class)
public String isInsured;
```

If the wrapper is not indicated, it will be selected automatically from field type (see [WrapperFactory] (https://github.com/exigow/autoform/blob/master/src/autoform/wrappers/WrapperFactory.java) impl). Unrecognized type **throws an exception** (at runtime).

TODO
----
* Annotation __#name__ or __#title__ param should be **optional**. In case of lack, field labels should be humanized automatically (with customizable strategy pattern (huh?)), eg. __carProductionDate__ will output __"Car production date:"__.
