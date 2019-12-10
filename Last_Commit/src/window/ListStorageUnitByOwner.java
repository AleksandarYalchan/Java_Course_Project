package window;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Address;
import model.StorageUnit;
import model.StorageUnitOwner;
import repositories.StorageUnitRepository;

import java.util.List;

public class ListStorageUnitByOwner {

    StorageUnitRepository storageUnitRepository=new StorageUnitRepository();

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
    protected TableColumn<StorageUnit, Double> rentPriceStorageUnitColumn;
    @FXML
    protected TableColumn<StorageUnit, String> climateStorageUnitColumn;
    @FXML
    protected TableColumn<StorageUnit, String> containingsStorageUnitColumn;

    public ObservableList<StorageUnit> getListStorageUnitsByOwner(StorageUnitOwner owner) {

        ObservableList<StorageUnit> storageUnitOList = FXCollections.observableArrayList();
        List<StorageUnit> storageUnitList = storageUnitRepository.getStorageUnitByOwner(owner);
        storageUnitOList.addAll(storageUnitList);
        return storageUnitOList;
    }

    public void initTable( StorageUnitOwner owner){
        nameStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sizeStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        categoryStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        rentPriceStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        climateStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("climateConditions"));
        containingsStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableView.setItems(getListStorageUnitsByOwner(owner));
    }
    public void closeButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
