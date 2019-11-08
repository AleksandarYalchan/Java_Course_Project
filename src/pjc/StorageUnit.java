package pjc;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@Entity
@Table(name="unit_details")
public class StorageUnit {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int unit_id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id")
	StorageUnitOwner Owned_By;
	//boolean status;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="unit_agent_mapping",joinColumns=@JoinColumn(name="unit_id"),
	inverseJoinColumns=@JoinColumn(name="agent_id"))
	private Collection<StorageUnitAgent> Contracted_By = new ArrayList<>();;
	private String Name;
	private String Address;
	private int Size;
	private String Category;
	private String Climatic_Conditions;
	private String Containings;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenant_id")
	StorageUnitTenant Current_Tenant;
	private double Rent_Price;
	private Date Rented_From;
	private Date Rented_Until;
	
	public StorageUnit() {
	}
	
	
	public StorageUnit(StorageUnitOwner Owner, StorageUnitAgent Agent, String Name, String Address, int Size,
			String Category, String Climatic_Conditions, String Containings,
			StorageUnitTenant Tenant, double Rent_Price, Date Rented_From, Date Rented_Until) {
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		this.Owned_By = Owner;
		//this.status = 1;
		this.Contracted_By.add(Agent);
		this.Name = Name;
		this.Address = Address;
		this.Size = Size;
		this.Category = Category;
		this.Climatic_Conditions = Climatic_Conditions;
		this.Containings = Containings;
		this.Current_Tenant = Tenant;
		this.Rent_Price = Rent_Price;
		this.Rented_From = Rented_From;
		this.Rented_Until = Rented_Until;
		session.save(this);
		t.commit();
		session.close();
	}
	
	public StorageUnit(StorageUnitOwner Owner, String Name, String Address, int Size,
			String Category, String Climatic_Conditions, String Containings) {		
		Owned_By = Owner;
		this.Name = Name;
		this.Address = Address;
		this.Size = Size;
		this.Category = Category;
		this.Climatic_Conditions = Climatic_Conditions;
		this.Containings = Containings;	
	}
	
	public StorageUnitOwner getOwned_By() {
		return (StorageUnitOwner) Owned_By;
	}
	
	public Date getRented_From() {
		return Rented_From;
	}
	
	public ArrayList<StorageUnitAgent> getAgents() {
		return (ArrayList<StorageUnitAgent>) Contracted_By;
	}
	
	public String toString() {
		return "Storage Unit Owner: " + Owned_By.Get_Last_Name() + " " +
				" Unit Name: " + Name + " Address: " + Address + " Size(m^2): " +
				Size + " Category: " + Category + " Climatic Conditions: " + 
				Climatic_Conditions + " Containings: " + Containings + 
				"Agents working with this Unit: ";// + getAgents().toString();
	}
	
	public void SetContractor(StorageUnitAgent Agent) {
		Contracted_By.add(Agent);
	}

	public void PrintUnit() {
		System.out.println("Storage Unit Owner: " + Owned_By.Get_Last_Name() + " " +
				" Unit Name: " + Name + " Address: " + Address + " Size(m^2): " +
				Size + " Category: " + Category + " Climatic Conditions: " + 
				Climatic_Conditions + " Containings: " + Containings + 
				" Tenant: " + Current_Tenant + "Rented From: " + Rented_From + "Rented Until: " + 
				Rented_Until);
		if (!Contracted_By.isEmpty()) {
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		System.out.println("Agents Currently Working with Unit: ");
		Query query = session.createQuery("FROM  StorageUnitAgent");
	    List list = query.list();

	    for (int i = 0; i < list.size(); i++) {
	        System.out.println((i + 1) + ". " + list.get(i).toString());
	    }
	    t.commit();
		session.close();
		}
	}
}
