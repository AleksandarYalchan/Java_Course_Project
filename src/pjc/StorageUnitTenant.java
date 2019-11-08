package pjc;

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

@Entity
@Table(name="tenant_details")
public class StorageUnitTenant {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private String First_Name;
	private String Last_Name;
	private int Rented_Storage_Units;
	
	StorageUnitTenant() {}
	
	StorageUnitTenant(String fName, String lName) {
		First_Name = fName;
		Last_Name = lName;
		Rented_Storage_Units = 0;
		
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
	
	public String toString() {
		return "Tenant: " + First_Name + " " + Last_Name +
				" Rented Storage Units: " + Rented_Storage_Units;
	}
	
	public void RateAgent(Object object) {
		Scanner var = new Scanner(System.in);
		double buff, old_rating = ((StorageUnitAgent) object).getRating();
		buff = ((StorageUnitAgent) object).getRate_Number();
		((StorageUnitAgent) object).setRate_Number(buff+1);
		System.out.println("Enter Agent's latest Rating: ");
		buff = var.nextDouble();
		((StorageUnitAgent) object).setRating((old_rating += buff) / ((StorageUnitAgent) object).getRate_Number());
		
		try {
			SessionFactory factory;
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			t.commit();
			session.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
		
		
	}
	
	
}
