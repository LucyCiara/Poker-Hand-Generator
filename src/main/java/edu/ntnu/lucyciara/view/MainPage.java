package edu.ntnu.lucyciara.view;

import edu.ntnu.lucyciara.controller.DeckController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A class for creating the main and only page, and methods for tying the UI to the controller.
 */
public class MainPage {
  private Scene scene;
  private HBox layout;
  private VBox leftSide;
  private TextField cards;
  private VBox cardCheck;
  private HBox sum;
  private Label sumText;
  private TextField sumResult;
  private HBox cardsOfHearts;
  private Label cardsOfHeartsText;
  private TextField cardsOfHeartsResult;
  private HBox flush;
  private Label flushText;
  private TextField flushResult;
  private HBox queenOfSpades;
  private Label queenOfSpadesText;
  private TextField queenOfSpadesResult;

  private VBox rightSide;
  private Button deal;
  private Button checkHand;

  private void createSum() {
    this.sum = new HBox();
    this.sumText = new Label();
    this.sumText.setText("The sum of your hand is: ");
    this.sumResult = new TextField();
    this.sum.getChildren().add(this.sumText);
    this.sum.getChildren().add(this.sumResult);
  }

  private void createCardsOfHeart() {
    this.cardsOfHearts = new HBox();
    this.cardsOfHeartsText = new Label();
    this.cardsOfHeartsText.setText("The cards of hearts in your hand are: ");
    this.cardsOfHeartsResult = new TextField();
    this.cardsOfHearts.getChildren().add(this.cardsOfHeartsText);
    this.cardsOfHearts.getChildren().add(this.cardsOfHeartsResult);
  }

  private void createFlush() {
    this.flush = new HBox();
    this.flushText = new Label();
    this.flushText.setText("Is your hand a flush? ");
    this.flushResult = new TextField();
    this.flush.getChildren().add(flushText);
    this.flush.getChildren().add(flushResult);
  }

  private void createQueenOfSpades() {
    this.queenOfSpades = new HBox();
    this.queenOfSpadesText = new Label();
    this.queenOfSpadesText.setText("Does your hand have a queen of spades? ");
    this.queenOfSpadesResult = new TextField();
    this.queenOfSpades.getChildren().add(this.queenOfSpadesText);
    this.queenOfSpades.getChildren().add(this.queenOfSpadesResult);
  }

  private void createLeftSide() {
    this.leftSide = new VBox();

    this.cards = new TextField();
    this.cardCheck = new VBox();

    this.createSum();
    this.createCardsOfHeart();
    this.createFlush();
    this.createQueenOfSpades();

    this.cardCheck.getChildren().add(this.sum);
    this.cardCheck.getChildren().add(this.cardsOfHearts);
    this.cardCheck.getChildren().add(this.flush);
    this.cardCheck.getChildren().add(this.queenOfSpades);

    this.leftSide.getChildren().add(this.cards);
    this.leftSide.getChildren().add(this.cardCheck);
  }

  private void createRightSide() {
    this.rightSide = new VBox();
    this.deal = new Button();
    this.deal.setText("Deal");
    this.checkHand = new Button();
    this.checkHand.setText("Check Hand");

    this.rightSide.getChildren().add(this.deal);
    this.rightSide.getChildren().add(this.checkHand);
  }

  private void createLayout() {
    this.layout = new HBox();
    this.createLeftSide();
    this.createRightSide();
    this.layout.getChildren().add(this.leftSide);
    this.layout.getChildren().add(this.rightSide);
  }

  private void createScene() {
    this.createLayout();
    this.scene = new Scene(this.layout, 300, 250);
  }

  public MainPage() {
    this.createScene();
  }

  public Scene getScene() {
    return this.scene;
  }

  public void setCards(String cardsString) {
    this.cards.setText(cardsString);
  }

  public void setSum(String sumString) {
    this.sumResult.setText(sumString);
  }

  public void setHearts(String heartString) {
    this.cardsOfHeartsResult.setText(heartString);
  }

  public void setFlush(String flushString) {
    this.flushResult.setText(flushString);
  }

  public void setQueenOfSpades(String queenOfSpadesString) {
    this.queenOfSpadesResult.setText(queenOfSpadesString);
  }

  public void setController(DeckController controller) {
    this.deal.setOnAction(e -> controller.drawHand());
    this.checkHand.setOnAction(e -> controller.checkHand());
  }
}
