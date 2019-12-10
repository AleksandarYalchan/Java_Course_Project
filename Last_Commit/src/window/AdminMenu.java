package window;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMenu {
    @FXML
    private RadioButton createOwner;
    @FXML
    private RadioButton createAgent;
    @FXML
    private RadioButton listAllAgent;

    private ToggleGroup myOptionGroup;

    public void groupTheChoice(){
        myOptionGroup=new ToggleGroup();
        this.createOwner.setToggleGroup(myOptionGroup);
        this.createAgent.setToggleGroup(myOptionGroup);
        this.listAllAgent.setToggleGroup(myOptionGroup);
    }

    public void selectButton()throws IOException {
        Parent logInParent;
        Stage newWin=new Stage();
        Scene newScene;
        if(createOwner.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../fxml/createOwner.fxml"));
        else if (createAgent.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../fxml/createAgent.fxml"));
        else
            logInParent = FXMLLoader.load(getClass().getResource("../fxml/listAllAgent.fxml"));
        newScene=new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }
}
