import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Label label = new Label("Hello, JavaFX!");
        Button button = new Button("Click Me");
        button.setOnAction(e->System.out.println("Click Me"));
        VBox vBox = new VBox();
        vBox.getChildren().add(button);
        //scene.getChildren().add(button);
        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
