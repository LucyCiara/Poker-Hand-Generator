package edu.ntnu.lucyciara;

import edu.ntnu.lucyciara.view.MainPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Poker-Hand generator");
    MainPage mainPage = new MainPage();
    primaryStage.setScene(mainPage.getScene());
    primaryStage.show();
  }
}
