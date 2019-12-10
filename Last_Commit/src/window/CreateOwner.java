package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.Validator;

import java.io.IOException;

public class CreateOwner {
    private Validator validator=new Validator();
    @FXML
    TextField firstName = new TextField();
    @FXML
    TextField lastName = new TextField();
    @FXML
    TextField userName = new TextField();
    @FXML
    TextField passWord=new TextField();

    public void createOwner() throws IOException {
        String fName,lName,uName,passName;
        fName=firstName.getText();
        lName=lastName.getText();
        uName=userName.getText();
        passName=passWord.getText();

        validator.createOwner(uName,passName,fName,lName);

        userName.clear();
        firstName.clear();
        lastName.clear();
        passWord.clear();
    }
    public void cancelButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
