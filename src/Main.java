import Controllers.ServiceParcare;
import Repositories.RepoParcare;
import Uis.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RepoParcare r = new RepoParcare("/Users/vasilegeorge/IdeaProjects/JavaFirst/src/Data/DateReale");
        ServiceParcare s = new ServiceParcare(r);
        GUI.setService(s);
        GUI gui = new GUI();
        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
