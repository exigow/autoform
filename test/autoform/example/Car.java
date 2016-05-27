package autoform.example;

import autoform.annotations.Autoform;
import autoform.annotations.AutoformField;
import autoform.wrappers.BooleanWrapper;

import java.math.BigDecimal;
import java.time.LocalDate;

@Autoform(title = "Register your car")
public class Car {

  @AutoformField(label = "Model name:")
  public String modelName;

  @AutoformField(label = "Producer name:")
  public String producerName;

  @AutoformField(label = "Date of production:")
  public LocalDate productionDate;

  @AutoformField(label = "Car price:")
  public BigDecimal price;

  @AutoformField(label = "Is insured?", wrapper = BooleanWrapper.class)
  public Boolean isInsured;

  @Override
  public String toString() {
    return "Car{" +
      "modelName='" + modelName + '\'' +
      ", producerName='" + producerName + '\'' +
      ", productionDate=" + productionDate +
      ", price=" + price +
      ", isInsured=" + isInsured +
      '}';
  }

}
