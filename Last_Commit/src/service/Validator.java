package service;

import model.Admin;
import model.StorageUnitAgent;
import model.StorageUnitOwner;
import repositories.AdminRepository;
import repositories.StorageUnitAgentRepository;
import repositories.StorageUnitOwnerRepository;
import window.IncorrectUsernameOrPassword;

import java.io.IOException;
import java.util.List;

public class Validator {

    private AdminRepository adminRepository = new AdminRepository();
    private StorageUnitAgentRepository agentRepository = new StorageUnitAgentRepository();
    private StorageUnitOwnerRepository ownerRepository = new StorageUnitOwnerRepository();
    private IncorrectUsernameOrPassword errorWindow=new IncorrectUsernameOrPassword();

    public void createOwner(String uName, String passName, String fName, String lName) throws IOException {
        StorageUnitOwner owner = new StorageUnitOwner(uName, passName, fName, lName);
        System.out.println(owner);
        if (!isUsernameExist(owner.getUsername()))
            StorageUnitOwnerRepository.save(owner);
        else{

            errorWindow.show();
        }
    }

    public void createAgent(String uName, String passName, String fName, String lName, Double chargingFee) throws IOException {
        StorageUnitAgent agent = new StorageUnitAgent(uName, passName, fName, lName, chargingFee);

        if (!isUsernameExist(agent.getUsername()))
            StorageUnitAgentRepository.save(agent);
        else
            errorWindow.show();

    }

    public boolean isUsernameExist(String username) {
        if(isUsernameExistAsAdmin(username))
            return true;
        if(isUsernameExistAsAgent(username))
            return true;
        if(isUsernameExistAsOwner(username))
            return true;
        return  false;

    }

    public boolean isUsernameExistAsAdmin(String username) {
        List<Admin> adminList = adminRepository.getAllAdmins();
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getUsername().equals( username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUsernameExistAsAgent(String username) {
        List<StorageUnitAgent> agentList = agentRepository.getAllAgents();
        for (int i = 0; i < agentList.size(); i++) {
            if (agentList.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;

    }

    public boolean isUsernameExistAsOwner(String username) {
        List<StorageUnitOwner> ownerList = ownerRepository.getAllOwners();
        for (int i = 0; i < ownerList.size(); i++) {
            if (ownerList.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
