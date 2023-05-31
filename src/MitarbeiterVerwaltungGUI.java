
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import MManager.Mitarbeiter;

public class MitarbeiterVerwaltungGUI extends Application {
    private List<Mitarbeiter> mitarbeiterListe;
    private ObservableList<String> abteilungen;
    private TableView<Mitarbeiter> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mitarbeiterListe = new ArrayList<>();
        abteilungen = FXCollections.observableArrayList("Abteilung 1", "Abteilung 2", "Abteilung 3");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        tableView = new TableView<>();
        TableColumn<Mitarbeiter, String> nachnameColumn = new TableColumn<>("Nachname");
        TableColumn<Mitarbeiter, String> vornameColumn = new TableColumn<>("Vorname");
        TableColumn<Mitarbeiter, String> personalnummerColumn = new TableColumn<>("Personalnummer");
        TableColumn<Mitarbeiter, String> abteilungColumn = new TableColumn<>("Abteilung");

        nachnameColumn.setCellValueFactory(data -> data.getValue().getNachname());
        vornameColumn.setCellValueFactory(data -> data.getValue().getVorname());
        personalnummerColumn.setCellValueFactory(data -> data.getValue().getPersonalnummer());
        abteilungColumn.setCellValueFactory(data -> data.getValue().getAbteilung());

        tableView.getColumns().addAll(nachnameColumn, vornameColumn, personalnummerColumn, abteilungColumn);
        tableView.setItems(FXCollections.observableArrayList(mitarbeiterListe));

        Button addButton = new Button("Mitarbeiter hinzufügen");
        addButton.setOnAction(e -> showAddDialog());

        Button deleteButton = new Button("Mitarbeiter löschen");
        deleteButton.setOnAction(e -> deleteSelectedMitarbeiter());

        VBox buttonsBox = new VBox(10, addButton, deleteButton);
        buttonsBox.setPadding(new Insets(10));

        root.setCenter(tableView);
        root.setRight(buttonsBox);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Mitarbeiterverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddDialog() {
        Dialog<Mitarbeiter> dialog = new Dialog<>();
        dialog.setTitle("Mitarbeiter hinzufügen");
        dialog.setHeaderText("Bitte geben Sie die Mitarbeiterdaten ein:");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        TextField nachnameField = new TextField();
        TextField vornameField = new TextField();
        TextField personalnummerField = new TextField();
        ComboBox<String> abteilungComboBox = new ComboBox<>(abteilungen);

        gridPane.add(new Label("Nachname:"), 0, 0);
        gridPane.add(nachnameField, 1, 0);
        gridPane.add(new Label("Vorname:"), 0, 1);
        gridPane.add(vornameField, 1, 1);
        gridPane.add(new Label("Personalnummer:"), 0, 2);
        gridPane.add(personalnummerField, 1, 2);
        gridPane.add(new Label("Abteilung:"), 0, 3);
        gridPane.add(abteilungComboBox, 2, 3);

        dialog.getDialogPane().setContent(gridPane);

        ButtonType addButton = new ButtonType("Hinzufügen", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        dialog.setResultConverter(buttonType -> {
            if (buttonType == addButton) {
                String nachname = nachnameField.getText();
                String vorname = vornameField.getText();
                String personalnummer = personalnummerField.getText();
                String abteilung = abteilungComboBox.getValue();

                return new Mitarbeiter(nachname, vorname, personalnummer, abteilung);
            }
            return null;
        });

        dialog.showAndWait().ifPresent(mitarbeiter -> {
            mitarbeiterListe.add(mitarbeiter);
            tableView.setItems(FXCollections.observableArrayList(mitarbeiterListe));
        });
    }

    private void deleteSelectedMitarbeiter() {
        Mitarbeiter selectedMitarbeiter = tableView.getSelectionModel().getSelectedItem();
        if (selectedMitarbeiter != null) {
            mitarbeiterListe.remove(selectedMitarbeiter);
            tableView.setItems(FXCollections.observableArrayList(mitarbeiterListe));
        }
    }
}
