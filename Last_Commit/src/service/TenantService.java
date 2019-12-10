package service;

import model.Tenant;
import repositories.TenantRepository;

import java.util.List;

public class TenantService {
    private TenantRepository tenantRepository=new TenantRepository();

    public void createTenant(String firstName,String lastName){
        Tenant tenant=new Tenant(firstName,lastName);
        tenantRepository.save(tenant);
    }
    public Tenant getTenantById(){
        List<Tenant> tenants=tenantRepository.tenantList();

                return tenants.get(tenants.size()-1);

    }
}
