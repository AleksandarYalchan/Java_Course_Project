package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.Validator;

import java.io.IOException;

public class CreateAgent {
    private Validator validator = new Validator();
    @FXML
    TextField userNameAgent = new TextField();
    @FXML
    TextField firstNameAgent = new TextField();
    @FXML
    TextField lastNameAgent = new TextField();
    @FXML
    TextField changingFeeAgent = new TextField();
    @FXML
    TextField passwordAgent = new TextField();

    public void createAgent() throws NumberFormatException, IOException {

        String userName, fName, lName, passName;
        Double changingFee;
        userName = userNameAgent.getText();
        fName = firstNameAgent.getText();
        lName = lastNameAgent.getText();
        changingFee = Double.parseDouble(changingFeeAgent.getText());
        passName = passwordAgent.getText();

        validator.createAgent(userName, passName, fName, lName, changingFee);

        userNameAgent.clear();
        firstNameAgent.clear();
        lastNameAgent.clear();
        changingFeeAgent.clear();
        passwordAgent.clear();
    }

    public void cancelButtonClicked(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
