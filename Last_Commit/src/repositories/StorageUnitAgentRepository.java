package repositories;

import model.StorageUnitAgent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class StorageUnitAgentRepository {

    public static void save(StorageUnitAgent agent){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(agent);
        t.commit();
        session.close();
    }
    public  List<StorageUnitAgent> getAllAgents(){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query=session.createQuery("from StorageUnitAgent");
        List<StorageUnitAgent> agentList=query.list();
        t.commit();
        session.close();
        return agentList;
    }
}
