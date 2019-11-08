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
@Table(name="agent_details")
public class StorageUnitAgent {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int agent_id;
	private String First_Name;
	private String Last_Name;
	private double Charging_Fee;
	private double Rating; 
	private double Rate_Number;
	
	public StorageUnitAgent() {}
	
	public StorageUnitAgent(String fName, String lName, double cFee) {
		First_Name = fName;
		Last_Name = lName;
		Charging_Fee = cFee;
		Rating = 0.0;
	}
	
	public int getID() {
		return agent_id;
	}
	
	public double getRate_Number() {
		return Rate_Number;
	}
	public double getRating() {
		return Rating;
	}
	public void setRate_Number(double num) {
		Rate_Number = num;
	}
	public void setRating(double rate) {
		Rating = rate;
	}
	
	public String toString() {
		return "Storage Unit Agent: " + First_Name + " " + Last_Name + " Charging Fee: " 
				+ Charging_Fee + " Rating: " + Rating;
	}
	
	public void PrintAgent() {
		System.out.println("Storage Unit Agent: " + First_Name + " " + Last_Name + " Charging Fee: " 
				+ Charging_Fee + " Rating: " + Rating);
	}
	
	public void RateAgent() {
		Scanner var = new Scanner(System.in);
		double buff;
		Rate_Number++;
		System.out.println("Enter Agent's latest Rating: ");
		buff = var.nextDouble();
		Rating = (Rating += buff) / Rate_Number;
	}
	
	public void CreateContract() {
		
	}

}
