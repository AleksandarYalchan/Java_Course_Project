package pjc;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@Entity
@Table(name="admin_details")
public class Administrator {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int admin_id;
	private String First_Name;
	private String Last_Name;
	
	public Administrator() {}
	
	public Administrator(String fName, String lName) {
		First_Name = fName;
		Last_Name = lName; 
		try {
			SessionFactory factory;
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.save(this);
			t.commit();
			session.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
	
	public void PrintAdministrator() {
		System.out.println("Administrator: " + First_Name + " " + Last_Name + " " + admin_id);
	}
	
	public String toString() {
		return "Administrator: " + First_Name + " " + Last_Name;
	}
	
	public void CreateStorageUnitOwner() {
		Scanner sc = new Scanner(System.in);
		String fName, lName;
		System.out.println("Enter The New Owner's First Name: ");
		fName = sc.nextLine();
		System.out.println("Enter The New Owner's Last Name: ");
		lName = sc.nextLine();
		
		StorageUnitOwner newOwner = new StorageUnitOwner(fName, lName); 
		
		try {
			SessionFactory factory;
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.save(newOwner);
			t.commit();
			session.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
	
	public void CreateStorageUnitAgent() {
		Scanner sc = new Scanner(System.in);
		String fName, lName;
		double cFee;
		System.out.println("Enter The New Agent's First Name: ");
		fName = sc.nextLine();
		System.out.println("Enter The New Agent's Last Name: ");
		lName = sc.nextLine();
		System.out.println("Enter The New Agent's Charging Fee: ");
		cFee = sc.nextDouble();
		
		StorageUnitAgent newAgent = new StorageUnitAgent(fName, lName, cFee); 

		try {
			SessionFactory factory;
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.save(newAgent);
			t.commit();
			session.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
	
	public void ListOwners() {
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		System.out.println("List of Storage Unit Owners");
		Query query = session.createQuery("FROM  StorageUnitOwner");
	    List list = query.list();

	    for (int i = 0; i < list.size(); i++) {
	        System.out.println((i + 1) + ". " + list.get(i).toString());
	    }
	    t.commit();
		session.close();
	}
	
	public void ListAgents() {
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		System.out.println("List of Storage Unit Agents");
		Query query = session.createQuery("FROM  StorageUnitAgent");
	    List list = query.list();

	    for (int i = 0; i < list.size(); i++) {
	        System.out.println((i + 1) + ". " + list.get(i).toString());
	    }
	    t.commit();
		session.close();
	}
	
	public void ListOwnersUnits() {
		String OwnerLName;
		Scanner scS = new Scanner(System.in);
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
	    Query query = session.createQuery("FROM  StorageUnit");
	    List list = query.list();
	    
	    System.out.println("Enter Owner Last Name: ");
	    OwnerLName = scS.nextLine();
	    
	    for	 (int i = 0; i < list.size(); i++) {
	    	if ((( StorageUnit ) list.get(i)).getOwned_By().Get_Last_Name().equals(OwnerLName)) {
	    		(( StorageUnit ) list.get(i)).PrintUnit();
	    	}
	    }
	    
	    t.commit();
		session.close();
	}
}

