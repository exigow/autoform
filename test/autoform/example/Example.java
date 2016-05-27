package autoform.example;

import autoform.AutoformInstancer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Example extends Application {

  public static void main(String[] args) {
    Application.launch(Example.class, args);
  }

  @Override
  public void start(Stage primaryStage) {
    Car car = new Car();
    car.name = "Chrysler Voyager";
    car.isInsured = true;
    car.price = new BigDecimal("3299");
    car.productionDate =  LocalDate.now().minus(10, ChronoUnit.YEARS);
    AutoformInstancer.createDialog(car, Example::catchAcceptedCar);
  }

  private static void catchAcceptedCar(Car car) {
    System.out.println("Received: " + car);
  }

}
