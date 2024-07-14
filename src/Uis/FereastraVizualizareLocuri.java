package Uis;

import Controllers.ServiceParcare;
import Domain.LocDeParcare;
import Domain.Parcare;
import Obs.Observer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Obs.Observer;
import java.util.List;

public class FereastraVizualizareLocuri extends Application implements Observer{
    private Parcare parcare;
    private ServiceParcare s;
    GridPane grid = new GridPane();
    private javafx.scene.control.TableView<Parcare> tv;


    public FereastraVizualizareLocuri(Parcare parcare, ServiceParcare s, javafx.scene.control.TableView<Parcare> tv) {
        this.parcare = parcare;
        this.s = s;
        this.tv = tv;
    }

    @Override
    public void start(Stage stage) {
        init_gui();
        s.addObserver(this);
        stage.setTitle("Parking Layout for " + parcare.getNume());

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        List<LocDeParcare> locuriDeParcare = parcare.getLocuriDeParcare();
        int linii = parcare.getLinii();
        int coloane = parcare.getColoane();

        for (int i = 0; i < linii; i++) {
            for (int j = 0; j < coloane; j++) {
                Button parkingSpot = new Button();
                parkingSpot.setPrefSize(50, 50);
                LocDeParcare loc = locuriDeParcare.get(i * coloane + j);

                if (loc.isFree()) {
                    parkingSpot.setStyle("-fx-background-color: #00FF00;"); // Green for free
                } else {
                    parkingSpot.setStyle("-fx-background-color: #FF0000;"); // Red for occupied
                }

                // Toggle parking spot status on click
                parkingSpot.setOnAction(event -> {
                    if (loc.isFree()) {
                        loc.setState(false);
                        parcare.refreshLocuri();
                        s.RefreshFile();
                        tv.getItems().setAll(s.get_all());
                        parkingSpot.setStyle("-fx-background-color: #FF0000;");
                    } else {
                        loc.setState(true); // Mark as free
                        parcare.refreshLocuri();
                        s.RefreshFile();
                        tv.getItems().setAll(s.get_all());
                        parkingSpot.setStyle("-fx-background-color: #00FF00;");
                    }
                });

                grid.add(parkingSpot, j, i);
            }
        }

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public void init_gui() {
    }
    public void update(){
        for(int i=0;i<parcare.getLinii();i++)
            for(int j=0;j<parcare.getColoane();j++)
                if(parcare.getLocuriDeParcare().get(i*parcare.getColoane()+j).isFree())
                    grid.getChildren().get(i*parcare.getColoane()+j).setStyle("-fx-background-color: #00FF00;");
                else
                    grid.getChildren().get(i*parcare.getColoane()+j).setStyle("-fx-background-color: #FF0000;");
    }
}
