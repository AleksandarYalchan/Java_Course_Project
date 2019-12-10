import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/logIn.fxml"));
        primaryStage.setTitle("Storage Unit Project");
        Scene scene=new Scene(root, 422, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
