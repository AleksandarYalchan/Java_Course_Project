package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;
import model.StorageUnitAgent;
import model.StorageUnitOwner;
import repositories.AdminRepository;
import repositories.StorageUnitAgentRepository;
import repositories.StorageUnitOwnerRepository;

import java.io.IOException;
import java.util.List;

public class LogIn {

    @FXML
    private TextField userNameField = new TextField();
    @FXML
    private PasswordField passwordField=new PasswordField();

    private AdminRepository adminRepository=new AdminRepository();
    private StorageUnitOwnerRepository ownerRepository=new StorageUnitOwnerRepository();
    private StorageUnitAgentRepository agentRepository=new StorageUnitAgentRepository();

    private StorageUnitOwner owner = new StorageUnitOwner();
    private StorageUnitAgent agent=new StorageUnitAgent();
    private Admin admin=new Admin();

    private boolean isAgentLogin = false;
    private boolean isAdminLogin = false;
    private boolean isOwnerLogin = false;



    public void logInButtonClicked(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        logInAsAgent(agentRepository.getAllAgents());
        logInAsAdmin(adminRepository.getAllAdmins());
        logInAsOwner(ownerRepository.getAllOwners());


        Parent logInParent;
        Stage newWin = new Stage();
        Scene newScene;
        if (isAgentLogin) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/agentMenu.fxml"));
            logInParent = loader.load();

           AgentMenu agentMenu=loader.getController();
            agentMenu.show(agent);
            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
            currentStage.close();
        } else if (isOwnerLogin) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ownerMenu.fxml"));
            logInParent = loader.load();
            OwnerMenu ownerMenu= loader.getController();
            ownerMenu.show(owner);
            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
            currentStage.close();

        } else if (isAdminLogin) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/adminMenu.fxml"));
            logInParent = loader.load();
            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
            currentStage.close();
        } else {
            logInParent = FXMLLoader.load(getClass().getResource("../fxml/incorrectUsernameOrPassword.fxml"));
            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
        }
    }
    public void logInAsAdmin(List<Admin> storageUnitAdminList) {
        for (int i = 0; i < storageUnitAdminList.size(); i++) {
            if ((storageUnitAdminList.get(i).getUsername().equals(userNameField.getText()))&&
                    (storageUnitAdminList.get(i).getPassword().equals(passwordField.getText()))) {
                this.admin=storageUnitAdminList.get(i);
                isAdminLogin = true;
                break;
            }
        }
    }

    public void logInAsOwner(List<StorageUnitOwner> storageUnitOwnerList) {

        for (int i = 0; i < storageUnitOwnerList.size(); i++) {
            if ((storageUnitOwnerList.get(i).getUsername().equals(userNameField.getText()))
                    &&(storageUnitOwnerList.get(i).getPassword().equals(passwordField.getText()))) {
                this.owner=storageUnitOwnerList.get(i);
                isOwnerLogin = true;
                break;
            }
        }
    }
    public void logInAsAgent(List<StorageUnitAgent> storageUnitAgentList) {

                 for (int i = 0; i < storageUnitAgentList.size(); i++) {
            if ((storageUnitAgentList.get(i).getUsername().equals(userNameField.getText()))
                    &&(storageUnitAgentList.get(i).getPassword().equals(passwordField.getText()))) {
                isAgentLogin = true;
                this.agent=storageUnitAgentList.get(i);
                break;
            }
        }
    }

    public void cancelButtonClicked(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
