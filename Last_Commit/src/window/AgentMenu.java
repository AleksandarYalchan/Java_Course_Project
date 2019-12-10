package window;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Address;
import model.StorageUnit;
import model.StorageUnitAgent;
import repositories.StorageUnitRepository;

import java.io.IOException;
import java.util.List;

public class AgentMenu {

    StorageUnitRepository storageUnitRepository=new StorageUnitRepository();
    @FXML
    private Label agentNameLabel = new Label();
    @FXML
    protected TableView<StorageUnit> tableView;
    @FXML
    protected TableColumn<StorageUnit, String> nameStorageUnitColumn;
    @FXML
    protected TableColumn<StorageUnit, Address> addressTableColumn;
    @FXML
    protected TableColumn<StorageUnit, Integer> sizeStorageUnitColumn;
    @FXML
    protected TableColumn<StorageUnit, String> categoryStorageUnitColumn;
    @FXML
    protected TableColumn<StorageUnit, String> climateStorageUnitColumn;
    @FXML
    protected TableColumn<StorageUnit, String> containingsStorageUnitColumn;

    private StorageUnitAgent storageUnitAgent;
    private StorageUnit unit;

    public ObservableList<StorageUnit> getListStorageUnitsByOwner(StorageUnitAgent agent) {

        ObservableList<StorageUnit> storageUnitOList = FXCollections.observableArrayList();
        List<StorageUnit> storageUnitList = storageUnitRepository.getUnrentedUnitsByAgent(agent);
        storageUnitOList.addAll(storageUnitList);
        return storageUnitOList;
    }
    public void loadTable() {
                agentNameLabel.setText(storageUnitAgent.getUsername());
        nameStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sizeStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        categoryStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        climateStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("climateConditions"));
        containingsStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableView.setItems(getListStorageUnitsByOwner(storageUnitAgent));
    }

    public void show(StorageUnitAgent agent){
        this.storageUnitAgent=agent;

        loadTable();
    }
    public void showContractWindow()throws IOException {
        selectStorageUnit();
        Parent logInParent;
        Stage newWin=new Stage();
        Scene newScene;
        FXMLLoader loader ;
        loader=new FXMLLoader(getClass().getResource("../fxml/createContract.fxml"));
        logInParent = loader.load();
        CreateContract createContract=loader.getController();
        createContract.show(unit,storageUnitAgent);
        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }

    public void selectStorageUnit() {
        int index = tableView.getSelectionModel().getSelectedIndex();
        StorageUnit unit = tableView.getItems().get(index);
        this.unit=unit;
        System.out.println(unit);

    }
}
