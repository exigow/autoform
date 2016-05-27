Automatic model dialog JavaFX utility
=====================================

Idea
----

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

![window screenshot] (https://raw.githubusercontent.com/exigow/autoform/master/screenshots/presentation.png)