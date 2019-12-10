package repositories;

import model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AdminRepository {

    public List<Admin> getAllAdmins(){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query=session.createQuery("from Admin");
        List<Admin> adminList=query.list();
        t.commit();
        session.close();
        return adminList;
    }
}
