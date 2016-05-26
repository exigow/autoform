package autoform.example;

import autoform.annotations.Autoform;
import autoform.annotations.AutoformField;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Autoform(title = "Register your car")
public class Car {

  @AutoformField(label = "Model name:")
  public String modelName;

  @AutoformField(label = "Producer name:")
  public String producerName;

  @AutoformField(label = "Date of production:")
  public LocalDate productionDate;

  //@AutoformField(label = "Car price:")
  public BigDecimal price;

  //@AutoformField(label = "Is insured?")
  public Boolean isInsured;

  public String notAnnotadedField;

}
