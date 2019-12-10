package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IncorrectUsernameOrPassword {

    public void show() throws IOException {

        Stage newWin = new Stage();
        Scene newScene;
        Parent logInParent;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/incorrectUsernameOrPassword.fxml"));
        logInParent = loader.load();
        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }
    public void cancelButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
