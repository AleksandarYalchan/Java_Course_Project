package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Address;
import model.StorageUnitOwner;
import service.StorageUnitService;

import java.io.IOException;

public class CreateStorageUnit {
    private StorageUnitOwner storageUnitOwner=new StorageUnitOwner();
    private StorageUnitService storageUnitService=new StorageUnitService();
    @FXML
    TextField nameStorage = new TextField();
    @FXML
    TextField countryAddress = new TextField();
    @FXML
    TextField cityAddress = new TextField();
    @FXML
    TextField streetAddress = new TextField();
    @FXML
    TextField streetNumberAddress=new TextField();
    @FXML
    TextField postCodeAddress = new TextField();
    @FXML
    TextField sizeStorage = new TextField();
    @FXML
    TextField climateStorage = new TextField();
    @FXML
    TextField categoryStorage = new TextField();
    @FXML
    TextField rentPriceStorage = new TextField();
    @FXML
    TextField containsStorage = new TextField();


    public void createStorageUnit(){
        Address address;
        String name,country,city,street,postCode,climate,category,contains;
        Integer size,streetNum;
        Double price;
        name=nameStorage.getText();
        country=countryAddress.getText();
        city=cityAddress.getText();
        street=streetAddress.getText();
        streetNum=Integer.parseInt(streetNumberAddress.getText());
        postCode=postCodeAddress.getText();
        climate=climateStorage.getText();
        category=categoryStorage.getText();
        contains=containsStorage.getText();
        size=Integer.parseInt(sizeStorage.getText());
        price=Double.parseDouble(rentPriceStorage.getText());
        address=new Address(country,city,street,streetNum,postCode);
        System.out.println(this.storageUnitOwner);
        storageUnitService.createStorageUnit(name,address,climate,category,contains,size,price,this.storageUnitOwner);

        nameStorage.clear();
        countryAddress.clear();
        cityAddress.clear();
        streetAddress.clear();
        postCodeAddress.clear();
        climateStorage.clear();
        categoryStorage.clear();
        containsStorage.clear();
        sizeStorage.clear();
        rentPriceStorage.clear();
        streetNumberAddress.clear();
    }
    public void show(StorageUnitOwner owner) throws IOException {

        this.storageUnitOwner=owner;
    }
    public void cancelButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
