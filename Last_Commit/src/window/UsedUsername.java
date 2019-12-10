package window;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class UsedUsername {

    public void cancelButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
