package pjc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/*  */
public class Main {
	public static void main(String[] args) throws ParseException {
	/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//Administrator Admin = new Administrator("Aleksandar", "Vasilev");
	StorageUnitOwner Owner = new StorageUnitOwner("Pesho", "Slepiq");
	StorageUnitAgent Agent = new StorageUnitAgent("Bulgar", "Bulgarov", 300);
	StorageUnitAgent Agent2 = new StorageUnitAgent("Petko", "Petkov", 300);
	StorageUnitAgent Agent3 = new StorageUnitAgent("Tishenskiq", "Dobrqka", 300);
	
	StorageUnitTenant Tenant = new StorageUnitTenant("Vrachka", "Vrachkova");
	Date Rented_From = sdf.parse("2009-12-31");
    Date Rented_Until = sdf.parse("2010-01-31");
	
	StorageUnit Unit = new StorageUnit(Owner, Agent3, "B333A", "Slivnica 2",
			15, "B", "Warm", "Drugs", Tenant, 120, Rented_From, Rented_Until);
	Unit.PrintUnit();*/
	//admin.PrintAdministrator();
	//admin.PrintAdministrator();
	//admin.CreateStorageUnitAgent();
	//admin.CreateStorageUnitOwner();
	UserMenus Menu = new UserMenus();
	Menu.MainMenu();
	}
}
