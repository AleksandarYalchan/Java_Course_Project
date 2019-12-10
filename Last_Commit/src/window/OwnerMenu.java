package window;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.StorageUnitOwner;

import java.io.IOException;

public class OwnerMenu {

    @FXML
    private Label ownerUserNameLabel=new Label();
    @FXML
    private RadioButton createStorageUnit;
    @FXML
    private RadioButton hireAgent;
    @FXML
    private RadioButton listStorageUnit;
    private ToggleGroup myOwnerOptionGroup;

    private StorageUnitOwner owner;

    public void groupTheChoice() {
        myOwnerOptionGroup = new ToggleGroup();
        createStorageUnit.setToggleGroup(myOwnerOptionGroup);
        hireAgent.setToggleGroup(myOwnerOptionGroup);
        listStorageUnit.setToggleGroup(myOwnerOptionGroup);
    }

    public void selectButton() throws IOException {
        Parent logInParent;
        FXMLLoader loader ;
        Stage newWin = new Stage();
        Scene newScene;
        if (createStorageUnit.isSelected()){
            loader=new FXMLLoader(getClass().getResource("../fxml/createStorageUnit.fxml"));
            logInParent = loader.load();
            CreateStorageUnit createStorageUnit=loader.getController();
            createStorageUnit.show(owner);
        }
        else if (hireAgent.isSelected()){
            loader=new FXMLLoader(getClass().getResource("../fxml/hireAgent.fxml"));
            logInParent = loader.load();
            HireAgent hireAgentWindow=loader.getController();
            hireAgentWindow.show(owner);

        }
        else {
            loader=new FXMLLoader(getClass().getResource("../fxml/listStorageUnitByOwner.fxml"));
            logInParent = loader.load();
            ListStorageUnitByOwner listStorageUnitByOwner=loader.getController();
            listStorageUnitByOwner.initTable(owner);
        }
        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }

    public void show(StorageUnitOwner owner){
        this.owner=owner;
        ownerUserNameLabel.setText(owner.getUsername());
    }



}
