import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    public void start(Stage primaryStage) {
        primaryStage = new GUI();
        this.stage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}