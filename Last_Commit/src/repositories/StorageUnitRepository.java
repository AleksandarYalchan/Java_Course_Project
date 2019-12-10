package repositories;

import model.StorageUnit;
import model.StorageUnitAgent;
import model.StorageUnitOwner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class StorageUnitRepository {
    public void save(StorageUnit unit) {
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.save(unit);
        t.commit();
        session.close();
    }
    public  List<StorageUnit> getAllStorageUnits(){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query=session.createQuery("from StorageUnit");
        List<StorageUnit> unitList=query.list();
        t.commit();
        session.close();
        return unitList;
    }

    public List<StorageUnit> getStorageUnitByOwner(StorageUnitOwner owner)
    {
        long idOwner=owner.getIdOwner();
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query=session.createQuery("from StorageUnit c where c.owner=?0");
        query.setParameter(0,owner);
        List<StorageUnit> unitList=query.list();
        t.commit();
        session.close();
        return unitList;
    }

    public List<StorageUnit> getUnitsByAgent(StorageUnitAgent agent){


        List<StorageUnit> agentUnitList = new ArrayList<>();
        List<StorageUnit> unitList=getAllStorageUnits();
        Set<StorageUnitAgent> listAgentFromUnit;
        Iterator<StorageUnitAgent> it;
        for (int i = 0; i < unitList.size(); i++) {

            listAgentFromUnit = unitList.get(i).getAgent();
            it = listAgentFromUnit.iterator();
            while (it.hasNext()) {
                if (it.next().getIdAgent()== agent.getIdAgent()) {
                    agentUnitList.add(unitList.get(i));
                }
            }
        }
        return agentUnitList;
    }

    public List<StorageUnit> getUnrentedUnitsByAgent(StorageUnitAgent agent)
    {
        List<StorageUnit> unrentedUnitList=new ArrayList<>();
        List<StorageUnit> agentUnitsList=getUnitsByAgent(agent);
        for(int i=0;i<agentUnitsList.size();i++){
            if(agentUnitsList.get(i).isRented()==false)
                unrentedUnitList.add(agentUnitsList.get(i));
        }
        return unrentedUnitList;
    }
    public void addAgent(StorageUnit unit){
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.update(unit);
        t.commit();
        session.close();
    }

    public void update(StorageUnit unit) {
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.update(unit);
        t.commit();
        session.close();
    }
}
