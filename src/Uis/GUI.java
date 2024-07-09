package Uis;

import Controllers.ServiceParcare;
import Domain.LocDeParcare;
import Domain.Parcare;
import Validators.ValidationException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GUI extends Application {
    private static ServiceParcare s;
    private TableView<Parcare> tv = new TableView<>();
    private VBox lyMain = new VBox(10); // Added spacing between elements
    private TextField adresaEdit = new TextField();
    private Label adresaLbl = new Label("Adresa: ");
    private TextField numeEdit = new TextField();
    private Label numeLbl = new Label("Nume: ");
    private TextField dimensioneEdit = new TextField();
    private Label dimensioneLbl = new Label("Dimensiune: ");
    private TextField locuritotaleEdit = new TextField();
    private Label locuritotaleLbl = new Label("Locuri Totale: ");
    private TextField liniiEdit = new TextField();
    private Label liniiLbl = new Label("Linii: ");
    private TextField coloaneEdit = new TextField();
    private Label coloaneLbl = new Label("Coloane: ");


    private Button btnAdd = new Button("Add");
    private Button btnRemove = new Button("Remove");

    public static void setService(ServiceParcare service) {
        s = service;
    }

    @Override
    public void start(Stage primaryStage) {
        init_gui(primaryStage);
        init_connect();
    }

    private void init_gui(Stage primaryStage) {
        tv.setMinWidth(500);
        tv.setMaxHeight(500);


        primaryStage.setMinWidth(750);
        primaryStage.setMinHeight(600);
        primaryStage.setMaxWidth(750);
        primaryStage.setMaxHeight(650);

        VBox.setVgrow(tv, Priority.ALWAYS);
        HBox.setHgrow(adresaEdit, Priority.ALWAYS);
        HBox.setHgrow(numeEdit, Priority.ALWAYS);
        HBox.setHgrow(dimensioneEdit, Priority.ALWAYS);
        HBox.setHgrow(locuritotaleEdit, Priority.ALWAYS);
        HBox.setHgrow(liniiEdit, Priority.ALWAYS);
        HBox.setHgrow(coloaneEdit, Priority.ALWAYS);

        TableColumn<Parcare, String> adresa = new TableColumn<>("Adresa");
        adresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));

        TableColumn<Parcare, String> nume = new TableColumn<>("Nume");
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));

        TableColumn<Parcare, Double> dimensiune = new TableColumn<>("Dimensiune");
        dimensiune.setCellValueFactory(new PropertyValueFactory<>("dimensiune"));

        TableColumn<Parcare, Integer> locuriTotale = new TableColumn<>("Locuri Totale");
        locuriTotale.setCellValueFactory(new PropertyValueFactory<>("locuriTotale"));

        TableColumn<Parcare, Integer> locuriOcupate = new TableColumn<>("Locuri Ocupate");
        locuriOcupate.setCellValueFactory(new PropertyValueFactory<>("locuriOcupate"));

        TableColumn<Parcare, Integer> locuriLibere = new TableColumn<>("Locuri Libere");
        locuriLibere.setCellValueFactory(new PropertyValueFactory<>("locuriLibere"));

        tv.getColumns().addAll(adresa, nume, dimensiune, locuriTotale, locuriOcupate, locuriLibere);
        tv.getItems().addAll(s.get_all()); // Assuming getAllParcari() returns a List<Parcare>

        adresaEdit.setPromptText("Scrieti adresa");
        numeEdit.setPromptText("Scrieti nume");
        dimensioneEdit.setPromptText("Scrieti dimensiunea");
        locuritotaleEdit.setPromptText("Scrieti locurile totale");

        adresa.setMinWidth(100);
        nume.setMinWidth(100);
        dimensiune.setMinWidth(100);
        locuriTotale.setMinWidth(100);
        locuriOcupate.setMinWidth(100);
        locuriLibere.setMinWidth(100);

        // Create HBox for each row of label and text field
        HBox adresaBox = new HBox(10, adresaLbl, adresaEdit);
        HBox numeBox = new HBox(10, numeLbl, numeEdit);
        HBox dimensiuneBox = new HBox(10, dimensioneLbl, dimensioneEdit);
        HBox locuriTotaleBox = new HBox(10, locuritotaleLbl, locuritotaleEdit);
        HBox liniiBox = new HBox(10, liniiLbl, liniiEdit);
        HBox coloaneBox = new HBox(10, coloaneLbl, coloaneEdit);

        // Create an HBox for the button and center the button
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(btnAdd);
        buttonBox.getChildren().add(btnRemove);

        // Apply inline CSS styling to the button
        btnAdd.setStyle("-fx-background-color: #79af4c; -fx-text-fill: #efe9e9; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        btnRemove.setStyle("-fx-background-color: #c40808; -fx-text-fill: #efe9e9; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        HBox campuriEdit = new HBox();
        campuriEdit.setSpacing(20);
        campuriEdit.setAlignment(Pos.CENTER);
        VBox AN = new VBox(30,adresaBox, numeBox);
        VBox DL = new VBox(30, dimensiuneBox, locuriTotaleBox);
        VBox LC = new VBox(30, liniiBox, coloaneBox);
        campuriEdit.getChildren().addAll(AN, DL, LC);
        lyMain.getChildren().addAll(tv, campuriEdit, buttonBox);
        lyMain.setSpacing(10);

        Scene scene = new Scene(lyMain, 1000, 800); // Specify width and height
        primaryStage.setScene(scene);
        primaryStage.setTitle("Parcare Table");
        primaryStage.show();
    }

    private void init_connect() {
        btnAdd.setOnAction(_ -> {
            try {
                String adresa = adresaEdit.getText();
                String nume = numeEdit.getText();
                if (adresa.isEmpty() || nume.isEmpty() || dimensioneEdit.getText().isEmpty() || locuritotaleEdit.getText().isEmpty() || liniiEdit.getText().isEmpty() || coloaneEdit.getText().isEmpty()) {
                    throw new IllegalArgumentException("Toate câmpurile trebuie completate.");
                }
                Double dimensiune = Double.parseDouble(dimensioneEdit.getText());
                Integer nrLinii = Integer.parseInt(liniiEdit.getText());
                Integer coloaneTotale = Integer.parseInt(coloaneEdit.getText());
                Integer locuriTotale = nrLinii * coloaneTotale;

                String distributieLocuri = "";
                for (int i = 0; i < locuriTotale; i++) {
                    distributieLocuri += "-";
                }

                Parcare p = new Parcare(adresa, nume, dimensiune, locuriTotale, 0, locuriTotale, nrLinii, coloaneTotale, distributieLocuri);
                s.adaugaParcare(p);
                tv.getItems().setAll(s.get_all());
                adresaEdit.clear();
                numeEdit.clear();
                dimensioneEdit.clear();
                locuritotaleEdit.clear();
                liniiEdit.clear();
                coloaneEdit.clear();
            } catch (NumberFormatException e) {
                showMessage(Alert.AlertType.ERROR, "Input Error", "Dimensiunea, linii și coloane trebuie să fie numere valide.");
            } catch (IllegalArgumentException e) {
                showMessage(Alert.AlertType.ERROR, "Input Error", e.getMessage());
            } catch (Exception ex) {
                showMessage(Alert.AlertType.ERROR, "Validation error", ex.getMessage());
            }
        });

        btnRemove.setOnAction(_ -> {
            try {
                //get adresa from selected row
                String adresa = tv.getSelectionModel().getSelectedItem().getAdresa();
                if (adresa.isEmpty()) {
                    throw new IllegalArgumentException("Adresa trebuie completată.");
                }
                s.stergeParcare(adresa);
                tv.getItems().setAll(s.get_all());
            } catch (IllegalArgumentException e) {
                showMessage(Alert.AlertType.ERROR, "Input Error", e.getMessage());
            } catch (ValidationException e) {
                showMessage(Alert.AlertType.ERROR, "Validation error", e.getMessage());
            }
        });

        tv.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                Parcare p = tv.getSelectionModel().getSelectedItem();
                if (p != null) {
                    Stage parkingStage = new Stage();
                    parkingStage.setTitle("Parking Layout for " + p.getNume());

                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(10, 10, 10, 10));

                    for (int i = 0; i < p.getLinii(); i++) {
                        for (int j = 0; j < p.getColoane(); j++) {
                            Button parkingSpot = new Button();
                            parkingSpot.setPrefSize(50, 50);
                            LocDeParcare loc = p.getLocuriDeParcare().get(i * p.getColoane() + j);

                            if (loc.isFree()) {
                                parkingSpot.setStyle("-fx-background-color: #00FF00;"); // Green for free
                            } else {
                                parkingSpot.setStyle("-fx-background-color: #FF0000;"); // Red for occupied
                            }

                            // Toggle parking spot status on click
                            parkingSpot.setOnAction(event -> {
                                if (loc.isFree()) {
                                    loc.setState(false);
                                    p.refreshLocuri();
                                    s.RefreshFile();
                                    tv.getItems().setAll(s.get_all());
                                    parkingSpot.setStyle("-fx-background-color: #FF0000;");
                                } else {
                                    loc.setState(true); // Mark as free
                                    p.refreshLocuri();
                                    s.RefreshFile();
                                    tv.getItems().setAll(s.get_all());
                                    parkingSpot.setStyle("-fx-background-color: #00FF00;");
                                }
                            });

                            grid.add(parkingSpot, j, i);
                        }
                    }

                    Scene scene = new Scene(grid);
                    parkingStage.setScene(scene);
                    parkingStage.show();
                }
            }
        });
    }

    private void showMessage(Alert.AlertType alertType, String title, String message) {
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
