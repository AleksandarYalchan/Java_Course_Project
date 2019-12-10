package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.StorageUnit;
import model.StorageUnitAgent;
import model.Tenant;
import service.ContractService;
import service.TenantService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class CreateContract {
    private ContractService contractService=new ContractService();
    private TenantService tenantService=new TenantService();
    private StorageUnit unit;
    private StorageUnitAgent storageUnitAgent;
    @FXML
    private TextField firstNameTenant;
    @FXML
    private TextField lastNameTenant;
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;
    private String firstName;
    private String lastName;
    private Date dateBegin;
    private Date dateEnd;
    private double finalPrice;
    public void fetch(){
        this.finalPrice=unit.getPrice()*1;
        this.firstName=firstNameTenant.getText();
        this.lastName=lastNameTenant.getText();
        this.dateBegin=getDateFromPicker(dateFrom);
        this.dateEnd=getDateFromPicker(dateTo);
    }
    public void createContract(){
        fetch();
        tenantService.createTenant(firstName,lastName);
        Tenant tenant=tenantService.getTenantById();
        contractService.ctreateContract(unit,storageUnitAgent,tenant,dateBegin,dateEnd,finalPrice);
    }

    public Date getDateFromPicker(DatePicker datePicker){
        LocalDate localDate=datePicker.getValue();
        Calendar calendar=Calendar.getInstance();
        calendar.set(localDate.getYear(),localDate.getMonthValue()-1,localDate.getDayOfMonth());
        Date date=calendar.getTime();
        return date;
    }
    public void cancelButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


    public void show(StorageUnit unit, StorageUnitAgent storageUnitAgent)
    {
     this.unit=unit;
     this.storageUnitAgent=storageUnitAgent;

    }
}
