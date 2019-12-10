package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Address;
import model.StorageUnit;
import model.StorageUnitAgent;
import model.StorageUnitOwner;
import service.StorageUnitService;

public class HireAgent {

    private StorageUnitService storageUnitService = new StorageUnitService();
    private ListAllAgent listAllAgent = new ListAllAgent();
    private ListStorageUnitByOwner listStorageUnit = new ListStorageUnitByOwner();
    @FXML
    private TableView<StorageUnit> tableViewUnits;
    @FXML
    private TableView<StorageUnitAgent> tableViewAgents;
    @FXML
    private TableColumn<StorageUnitAgent, String> userNameAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> firstNameAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> lastNameAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> chargingFeeAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> ratingAgentColumn;
    @FXML
    private TableColumn<StorageUnit, String> nameStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Address> addressStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Integer> sizeStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> categoryStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Double> rentPriceStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> climateStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> containingsStorageUnitColumn;


    public void closeButtonClicked(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void show(StorageUnitOwner owner) {
        firstNameAgentColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameAgentColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        chargingFeeAgentColumn.setCellValueFactory(new PropertyValueFactory<>("chargingFee"));
        ratingAgentColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        nameStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        sizeStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        categoryStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        rentPriceStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        climateStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("climateConditions"));
        containingsStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("content"));

        tableViewUnits.setItems(listStorageUnit.getListStorageUnitsByOwner(owner));
        tableViewAgents.setItems(listAllAgent.fetchAgents());
    }

    public StorageUnitAgent selectAgent() {
        int index = tableViewAgents.getSelectionModel().getSelectedIndex();
        StorageUnitAgent agent = tableViewAgents.getItems().get(index);
        System.out.println(agent);
        return agent;
    }

    public StorageUnit selectStorageUnit() {
        int index = tableViewUnits.getSelectionModel().getSelectedIndex();
        StorageUnit unit = tableViewUnits.getItems().get(index);
        System.out.println(unit);
        return unit;
    }

    public void addAgentToStorageUnit() {
        StorageUnit unit = selectStorageUnit();
        StorageUnitAgent agent = selectAgent();
        storageUnitService.addAgent(unit, agent);
    }
}
