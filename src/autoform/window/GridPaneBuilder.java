package autoform.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GridPaneBuilder {

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

  public GridPaneBuilder extendWithRow(Node leftNode, Node rightNode) {
    pane.add(leftNode, 0, iterator);
    pane.add(rightNode, 1, iterator);
    iterator += 1;
    return this;
  }

  public Stage buildStage() {
    Stage stage = new Stage();
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
