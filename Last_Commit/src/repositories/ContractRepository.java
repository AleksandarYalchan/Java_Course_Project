package repositories;

import model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ContractRepository {

    public void save(Contract contract){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.clear();
        session.save(contract);
        t.commit();
        session.close();
    }
}
