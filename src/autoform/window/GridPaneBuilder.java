package autoform.window;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class GridPaneBuilder {

  private final static int LEFT_SIDE = 0;
  private final static int RIGHT_SIDE = 1;
  private final Stage stage = new Stage();
  private final GridPane pane;
  private final String windowTitle;
  private int iterator = 0;

  private GridPaneBuilder(GridPane pane, String windowTitle) {
    this.pane = pane;
    this.windowTitle = windowTitle;
  }

  public static GridPaneBuilder loadInitialFxml(String title) {
    GridPane pane = (GridPane) loadFxml();
    return new GridPaneBuilder(pane, title);
  }

  public GridPaneBuilder putRow(String label, Node valueNode) {
    Node labelNode = new Label(label);
    pane.add(labelNode, LEFT_SIDE, iterator);
    pane.add(valueNode, RIGHT_SIDE, iterator);
    iterator += 1;
    return this;
  }

  public GridPaneBuilder putButton(Consumer<ActionEvent> eventConsumer) {
    HBox box = new HBox();
    box.setAlignment(Pos.CENTER_RIGHT);
    Button button = new Button("Click");
    button.setOnAction(event -> {
      eventConsumer.accept(event);
      stage.close();
    });
    box.getChildren().add(button);
    pane.add(box, RIGHT_SIDE, iterator++);
    return this;
  }

  public Stage buildStage() {
    stage.setTitle(windowTitle);
    Scene scene = new Scene(pane);
    stage.setScene(scene);
    return stage;
  }

  private static Parent loadFxml() {
    try {
      return FXMLLoader.load(GridPaneBuilder.class.getResource("grid.fxml"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
