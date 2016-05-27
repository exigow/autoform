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

Fields have been completed for presentation purposes. It is possible to initialize window with predefined data, as shown in [example] (https://github.com/exigow/autoform/blob/master/test/autoform/example/Example.java).

TODO
----
* Annotation #name or #title param should be **optional**. In case of lack, field labels should be humanized automatically (with customizable strategy pattern), eg. __carProductionDate__ will output __"Car production date:"__.
