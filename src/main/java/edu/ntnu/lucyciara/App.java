package edu.ntnu.lucyciara;

import edu.ntnu.lucyciara.controller.DeckController;
import edu.ntnu.lucyciara.model.DeckOfCards;
import edu.ntnu.lucyciara.view.MainPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The App class that ties the MVC structure together.
 */
public class App extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Poker-Hand generator");
    MainPage mainPage = new MainPage();
    DeckOfCards deck = new DeckOfCards();
    DeckController controller = new DeckController(mainPage, deck);
    mainPage.setController(controller);
    primaryStage.setScene(mainPage.getScene());
    primaryStage.show();
  }
}
