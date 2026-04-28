package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {

  private int compteurRouge;
  private int compteurVert;
  private int compteurBleu;

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();

    Button btnRouge = new Button("Rouge");
    btnRouge.setId("btn-rouge");
    Button btnVert = new Button("Vert");
    btnVert.setId("btn-vert");
    Button btnBleu = new Button("Bleu");
    btnBleu.setId("btn-bleu");

    HBox boutons = new HBox(10, btnRouge, btnVert, btnBleu);
    root.setTop(boutons);

    Pane zone = new Pane();
    zone.setId("zone");
    zone.setMinSize(300, 200);
    root.setCenter(zone);

    Label compteurs = new Label(getTexteCompteurs());
    compteurs.setId("compteurs");
    root.setBottom(compteurs);

    btnRouge.setOnAction(
        event -> {
          compteurRouge++;
          zone.setStyle("-fx-background-color: red;");
          compteurs.setText(getTexteCompteurs());
        });

    btnVert.setOnAction(
        event -> {
          compteurVert++;
          zone.setStyle("-fx-background-color: green;");
          compteurs.setText(getTexteCompteurs());
        });

    btnBleu.setOnAction(
        event -> {
          compteurBleu++;
          zone.setStyle("-fx-background-color: blue;");
          compteurs.setText(getTexteCompteurs());
        });

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private String getTexteCompteurs() {
    return "Rouge: " + compteurRouge + "  Vert: " + compteurVert + "  Bleu: " + compteurBleu;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
