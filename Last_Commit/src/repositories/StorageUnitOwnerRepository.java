package repositories;

import model.StorageUnitOwner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class StorageUnitOwnerRepository {

    public static void save(StorageUnitOwner owner){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(owner);
        t.commit();
        session.close();
    }
    public List<StorageUnitOwner> getAllOwners(){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query=session.createQuery("from StorageUnitOwner");
        List<StorageUnitOwner> ownerList=query.list();
        t.commit();
        session.close();
        return ownerList;
    }
}
