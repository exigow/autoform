package autoform.example;

import autoform.AutoformInstancer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Example extends Application {

  public static void main(String[] args) {
    Application.launch(Example.class, args);
  }

  @Override
  public void start(Stage primaryStage) {
    Car car = new Car();
    car.modelName = "Initial value";
    AutoformInstancer.createDialog(car, c -> System.out.println("Recieved " + c));
  }

}
