package org.example.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.demo3.DatabaseManager;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Titre
        Text title = new Text("Ajouter un nouveau membre");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Champs de texte
        TextField nomField = new TextField();
        nomField.setPromptText("Nom");

        TextField prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Téléphone");

        // Bouton Insérer
        Button insertButton = new Button("Insérer");
        insertButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Création de l'objet DatabaseManager
        DatabaseManager dbManager = new DatabaseManager();

        // Gestion de l'événement clic sur le bouton
        insertButton.setOnAction(event -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            // Vérification des champs vides
            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Tous les champs doivent être remplis.");
            } else {
                // Insérer dans la base de données en utilisant la classe DatabaseManager
                if (dbManager.insertMembre( nom, prenom, email, phone)) {
                    showAlert(Alert.AlertType.INFORMATION, "Succès", "Membre ajouté avec succès !");
                    nomField.clear();
                    prenomField.clear();
                    emailField.clear();
                    phoneField.clear();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Erreur", "Échec de l'insertion.");
                }
            }
        });

        // Disposition des éléments dans une grille
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        grid.add(nomField, 0, 0);
        grid.add(prenomField, 0, 1);
        grid.add(emailField, 0, 2);
        grid.add(phoneField, 0, 3);

        // Disposition principale
        VBox root = new VBox(15, title, grid, insertButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Création de la scène
        Scene scene = new Scene(root, 400, 300);

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Ajouter un membre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Affiche une boîte de dialogue d'alerte.
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
