package service;

import model.Address;
import model.StorageUnit;
import model.StorageUnitAgent;
import model.StorageUnitOwner;
import repositories.StorageUnitRepository;

public class StorageUnitService {
    private StorageUnitRepository unitRepository=new StorageUnitRepository();

    public  void createStorageUnit(String name, Address address, String climate, String category,
                                   String contains, Integer size, Double price, StorageUnitOwner owner) {
        System.out.println(owner);
        StorageUnit unit=new StorageUnit(name,address,size,category,climate,contains, price,owner);
        unitRepository.save(unit);
    }

    public void addAgent(StorageUnit unit, StorageUnitAgent agent){
        (unit.getAgent()).add(agent);
        unitRepository.addAgent(unit);
    }
    public void updateStorageUnit(StorageUnit unit){
        unitRepository.update(unit);
    }
}
