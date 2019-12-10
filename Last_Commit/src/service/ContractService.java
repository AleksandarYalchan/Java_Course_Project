package service;

import model.Contract;
import model.StorageUnit;
import model.StorageUnitAgent;
import model.Tenant;
import repositories.ContractRepository;

import java.util.Date;

public class ContractService {
    private ContractRepository contractRepository=new ContractRepository();

    public void ctreateContract(StorageUnit storageUnit, StorageUnitAgent agent, Tenant tenant, Date dateFrom, Date dateUntil, double rentPrice){
        Contract contract=new Contract(storageUnit,agent,tenant,dateFrom,dateUntil,rentPrice);
    contractRepository.save(contract);
    }
}
