package window;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.StorageUnitAgent;
import repositories.StorageUnitAgentRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllAgent implements Initializable {
    private StorageUnitAgentRepository agentRepository=new StorageUnitAgentRepository();
    @FXML
    private TableView<StorageUnitAgent> tableView;
    @FXML
    private TableColumn<StorageUnitAgent, String> userNameColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> firstNameColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> lastNameColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> changingFeeColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> ratingColumn;

    public ObservableList<StorageUnitAgent> fetchAgents() {

        ObservableList<StorageUnitAgent> agentsTableList = FXCollections.observableArrayList();
        List<StorageUnitAgent> storageUnitAgentList = agentRepository.getAllAgents();
        agentsTableList.addAll(storageUnitAgentList);
        return agentsTableList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        changingFeeColumn.setCellValueFactory(new PropertyValueFactory<>("chargingFee"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tableView.setItems(fetchAgents());
    }

    public void cancelButtonClicked(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
