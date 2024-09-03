package Uis;
import Controllers.ServiceParcare;
import Domain.LocDeParcare;
import Domain.Parcare;
import Obs.Observer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Obs.Observer;
import java.util.List;

public class FereastraPieChart extends Application implements Observer{
    private ServiceParcare s;
    private String adresa;
    PieChart pieChart = new PieChart();
    public FereastraPieChart(ServiceParcare s, String adresa) {
        this.s = s;
        this.adresa = adresa;
    }

    @Override
    public void start(Stage stage) {
        init_gui();
        s.addObserver(this);
    }
    public void init_gui(){
        Stage chartStage = new Stage();
        chartStage.setTitle("Pie Chart Ocupare");
        Parcare p = s.getParcare(adresa);
        pieChart.getData().add(new PieChart.Data("Ocupate", p.getLocuriOcupate()));
        pieChart.getData().add(new PieChart.Data("Libere", p.getLocuriLibere()));
        Scene scene = new Scene(pieChart, 800, 600);
        chartStage.setScene(scene);
        chartStage.show();
    }

    public void update() {
        Parcare p = s.getParcare(adresa);
        pieChart.getData().clear();
        pieChart.getData().add(new PieChart.Data("Ocupate", p.getLocuriOcupate()));
        pieChart.getData().add(new PieChart.Data("Libere", p.getLocuriLibere()));
    }
}
