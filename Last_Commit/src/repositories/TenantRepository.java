package repositories;

import model.Tenant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TenantRepository {

    public void save(Tenant tenant){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(tenant);
        t.commit();
        session.close();
    }
    public List<Tenant> tenantList(){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query=session.createQuery("from Tenant");
        List<Tenant> tenantList=query.list();
        t.commit();
        session.close();
        return tenantList;
    }
 }
