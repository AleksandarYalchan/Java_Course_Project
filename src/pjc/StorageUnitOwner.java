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
@Table(name="owner_details")
public class StorageUnitOwner {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int owner_id;
	private String First_Name;
	private String Last_Name;
	private int Storage_Units_Owned;
	
	public StorageUnitOwner() {}
	
	public StorageUnitOwner(String fName, String lName) {
		First_Name = fName;
		Last_Name = lName;
		Storage_Units_Owned = 0;
	}
	
	public int get_owner_id() {
		return owner_id;
	}
	
	public String Get_First_Name() {
		return First_Name;
	}
	
	public String Get_Last_Name() {
		return Last_Name;
	}
	
	public int Get_Number_Of_Storage_Units_Owned() {
		return Storage_Units_Owned;
	}
	
	public void PrintOwner() {
		System.out.println("Storage Unit Owner: " + First_Name + " " 
				+ Last_Name + " Storage Units Owned: " + Storage_Units_Owned);
	}
	
	public String toString() {
		return "Storage Unit Owner: " + First_Name + " " 
				+ Last_Name + " Storage Units Owned: " + Storage_Units_Owned;
	}
	
	public void CreateStorageUnit() {
		Scanner sc = new Scanner(System.in);
		String Name, Address, Climatic_Conditions, Containings, Category;
		int Size;
		System.out.println("Enter Storage Unit's Name: ");
		Name = sc.nextLine();
		System.out.println("Enter Storage Unit's Address: ");
		Address = sc.nextLine();
		System.out.println("Enter Storage Unit's Category: ");
		Category = sc.nextLine();
		System.out.println("Enter Storage Unit's Climatic Conditions: ");
		Climatic_Conditions = sc.nextLine();
		System.out.println("Enter Storage Unit's Containings: ");
		Containings = sc.nextLine();
		System.out.println("Enter Storage Unit's Size: ");
		Size = sc.nextInt();
		
		StorageUnit Unit = new StorageUnit(this, Name, Address, Size,
				Category, Climatic_Conditions, Containings);
		Storage_Units_Owned++;
		
		try {
			SessionFactory factory;
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.save(Unit);
			t.commit();
			session.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
	
	public void ListStorageUnits() {
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		System.out.println("List of my Units");
		Query query = session.createQuery("FROM  StorageUnit");
	    List list = query.list();
	    
	    for (int i = 0; i < list.size(); i++) {
	    	if (this.get_owner_id() == 
	    			((StorageUnit) list.get(i)).getOwned_By().get_owner_id()) {
	    		((StorageUnit) list.get(i)).PrintUnit();
	    	}
	    	else {
	    		System.out.println("No Storage Units Owned");
	    	}
	    }
		t.commit();
		session.close();
	}
	
}
