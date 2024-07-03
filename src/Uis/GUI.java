package Uis;

import Controllers.ServiceParcare;
import Domain.Parcare;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import org.w3c.dom.Text;


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

    public static void setService(ServiceParcare service) {
        s = service;
    }

    @Override
    public void start(Stage primaryStage) {
        init_gui(primaryStage);
    }

    private void init_gui(Stage primaryStage){

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

        lyMain.getChildren().addAll(tv, adresaLbl, adresaEdit, numeLbl, numeEdit, dimensioneLbl, dimensioneEdit, locuritotaleLbl, locuritotaleEdit);

        Scene scene = new Scene(lyMain, 800, 600); // Specify width and height
        primaryStage.setScene(scene);
        primaryStage.setTitle("Parcare Table");
        primaryStage.show();
    }

    private void init_connect(){}
}
