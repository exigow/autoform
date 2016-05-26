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
    AutoformInstancer.instantiateForm(new Car(), car -> System.out.println("Recieved " + car));
  }

}
