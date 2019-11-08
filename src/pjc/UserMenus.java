package pjc;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class UserMenus {
	public void MainMenu() {
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		int choice;
		System.out.println("Welcome to the Main Menu");
		System.out.println("1. Login as Administrator");
		System.out.println("2. Login as Owner");
		System.out.println("3. Login as Agent");
		System.out.println("4. Login as Tenant");
		System.out.println("0. Exit Program");
		do {
			System.out.println("Please Select User: ");
			choice = sc.nextInt();
		} while(choice < 0 || choice > 4);
		
		switch(choice) {
		case 1:
			do {
				System.out.println("Please Login or Create a New Profile");
				System.out.println("1. Login");
				System.out.println("2. Create New Administrator");
				System.out.println("0. Back To Main Menu");
				System.out.println("Choice: ");
				choice = sc.nextInt();
			} while(choice < 0 || choice > 3);
			
			switch(choice) {
			case 1:
				int id;
				SessionFactory factory;
				factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				
				System.out.println("List of Administrators");
				Query query = session.createQuery("FROM  Administrator");
			    List list = query.list();

			    for (int i = 0; i < list.size(); i++) {
			        System.out.println((i + 1) + ". " + list.get(i).toString());
			    }
			    System.out.println("Enter Your ID: ");
			    id = sc.nextInt();
				AdministratorMenu(list.get(--id));
				t.commit();
				session.close();
				break;
			case 2:	
				String fName, lName;
				System.out.println("Insert Administrator's First Name: ");
				fName = scString.nextLine();
				System.out.println("Insert Administrator's Last Name: ");
				lName = scString.nextLine();
				Administrator admin = new Administrator(fName, lName);
				AdministratorMenu(admin);
				break;
			case 0:
				MainMenu();
				break;
			}
			break;
		case 2: 	
			do {
				System.out.println("Please Login");
				System.out.println("1. Login");
				System.out.println("0. Back To Main Menu");
				System.out.println("Choice: ");
				choice = sc.nextInt();
			} while(choice < 0 || choice > 1);
			
			switch (choice) {
			case 1:
				int id;
				SessionFactory factory;
				factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				
				System.out.println("List of Owners");
				Query query = session.createQuery("FROM  StorageUnitOwner");
			    List list = query.list();

			    for (int i = 0; i < list.size(); i++) {
			        System.out.println((i + 1) + ". " + list.get(i).toString());
			    }
			    System.out.println("Enter Your ID: ");
			    id = sc.nextInt();
			    t.commit();
				session.close();
				OwnerMenu(list.get(--id));
				break;
			case 0:
				MainMenu();
				break;
			}
			break;
		case 3: 
			do {
				System.out.println("Please Login");
				System.out.println("1. Login");
				System.out.println("0. Back To Main Menu");
				System.out.println("Choice: ");
				choice = sc.nextInt();
			} while(choice < 0 || choice > 1);
			
			switch (choice) {
			case 1:
				int id;
				
				SessionFactory factory;
				factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				
				System.out.println("List of Owners");
				Query query = session.createQuery("FROM  StorageUnitAgent");
			    List list = query.list();

			    for (int i = 0; i < list.size(); i++) {
			        System.out.println((i + 1) + ". " + list.get(i).toString());
			    }
			    System.out.println("Enter Your ID: ");
			    id = sc.nextInt();
			    t.commit();
				session.close();
				AgentMenu(list.get(--id));
				break;
			case 0:
				MainMenu();
				break;
			}
			break;
		case 4: 
			do {
				System.out.println("Please Login or Create a New Profile");
				System.out.println("1. Login");
				System.out.println("2. Create New Tenant Profile");
				System.out.println("0. Back To Main Menu");
				System.out.println("Choice: ");
				choice = sc.nextInt();
			} while(choice < 0 || choice > 3);
			
			switch (choice) {
			case 1:
				int id;
				SessionFactory factory;
				factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				
				System.out.println("List of Tenants");
				Query query = session.createQuery("FROM  StorageUnitTenant");
			    List list = query.list();

			    for (int i = 0; i < list.size(); i++) {
			        System.out.println((i + 1) + ". " + list.get(i).toString());
			    }
			    System.out.println("Enter Your ID: ");
			    id = sc.nextInt();
				TenantMenu(list.get(--id));
				t.commit();
				session.close();
				break;
			case 2:
				String fName, lName;
				System.out.println("Insert Your First Name: ");
				fName = scString.nextLine();
				System.out.println("Insert Your Last Name: ");
				lName = scString.nextLine();
				StorageUnitTenant tenant = new StorageUnitTenant(fName, lName);
				TenantMenu(tenant);
				
				break;
			case 0:
				MainMenu();
				break;
			}
			break;
		case 0: 
			System.out.println("Program Terminated");
			break;
		}
	}
	
	public void AdministratorMenu(Object object) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Welcome to the Administator Menu ");
		System.out.println(object.toString());
		System.out.println("1. Create Owner");
		System.out.println("2. Create Agent");
		System.out.println("3. List Owners");
		System.out.println("4. List Agents");
		System.out.println("5. List Owner's Units (Last Name Check)");
		System.out.println("0. Back To Main Menu");
		
		do {
			System.out.println("Please Select Operation: ");
			choice = sc.nextInt();
		} while(choice < 0 || choice > 5);
		
		switch(choice) {
		case 1:
			((Administrator) object).CreateStorageUnitOwner();
			AdministratorMenu((Administrator) object);
			break;
		case 2: 
			((Administrator) object).CreateStorageUnitAgent();
			AdministratorMenu((Administrator) object);
			break;
		case 3:
			((Administrator) object).ListOwners();
			AdministratorMenu((Administrator) object);
			break;
		case 4:
			((Administrator) object).ListAgents();
			AdministratorMenu((Administrator) object);
			break;
		case 5:
			((Administrator) object).ListOwnersUnits();
			AdministratorMenu((Administrator) object);
			break;
		case 0: 
			MainMenu();
			break;
	}
}
	
	public void TenantMenu(Object object) { 	
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Welcome to the Tenant Menu ");
		System.out.println(object.toString());
		System.out.println("1. Rate Agent");
		System.out.println("0. Back To Main Menu");
		
		do {
			System.out.println("Please Select Operation: ");
			choice = sc.nextInt();
		} while(choice < 0 || choice > 1);
		
		switch(choice) {
		case 1:
			int id;
			
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
		    System.out.println("Enter Agent ID: ");
		    id = sc.nextInt();
			
		  ((StorageUnitTenant) object).RateAgent(list.get(--id));
		    
			t.commit();
			session.close();
			TenantMenu((StorageUnitTenant) object);
			break;
		case 0: 
			MainMenu();
			break;
	}
}
	// tenant menu не е нужно за сега после може да го изтрия
	
	public void OwnerMenu(Object object) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Welcome to the Owner Menu ");
		System.out.println(object.toString());
		System.out.println("1. Create Storage Unit");
		System.out.println("2. Edit Storage Unit");
		System.out.println("3. List Storage Units Owned");
		System.out.println("4. Hire Agents");
		System.out.println("0. Back To Main Menu");
		
		do {
			System.out.println("Please Select Operation: ");
			choice = sc.nextInt();
		} while(choice < 0 || choice > 4);
		
		switch (choice) {
		case 1:
			((StorageUnitOwner) object).CreateStorageUnit();
			OwnerMenu(object);
			break;
		case 2:
			OwnerMenu(object);
			break;
		case 3:
			((StorageUnitOwner) object).ListStorageUnits();
			OwnerMenu(object);
			break;
		case 4:
			OwnerMenu(object);
			break;
		case 0:
			MainMenu();
			break;
		}
	}

	public void AgentMenu(Object object) {
		System.out.println("Welcome to the Owner Menu ");
		System.out.println(object.toString());
		System.out.println("1. Create Storage Unit Contract");
		System.out.println("2. Edit Storage Unit");
		System.out.println("3. List Storage Units Owned");
		System.out.println("0. Back To Main Menu");
	}

}

	