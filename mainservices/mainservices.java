package mainservices;

import java.util.List;
import java.util.Scanner;

import models.Admin;
import models.bike;
import models.bus;
import models.car;
import models.customer;
import models.vehicle;

public class mainservices {

	private static Scanner sc=new Scanner(System.in);
	private static vehicleinventory inventory=new vehicleinventory();
	private static customer customer;

	public static void main(String[] args) {

		initializevehicle();

		boolean flag=true;
		System.out.println("\n Welcome to Vechile Rental Services \n ");
		while(flag)
		{
			showmenu();
			int ch=sc.nextInt();

			switch(ch)
			{
			case 1->handleAdminLogin();
			case 2->handleCustomerLogin();
			case 3->flag=false;
			default->
			System.out.println("Invalid Choice...");
			}
		}
		System.out.println("Thank You For Visiting......");

	}
	public static void initializevehicle()
	{
		inventory.addvechile(new car("c001", 1200, 6));
		inventory.addvechile(new car("c002", 2000, 8));
		inventory.addvechile(new bus("Bs01", 5000, 16));
		inventory.addvechile(new bus("Bs02", 15000, 30));
		inventory.addvechile(new bike("B001", 700, false));
		inventory.addvechile(new bike("B002", 400, true));
	}
	public static void showmenu()
	{
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		System.out.println("Enter your choice..");
	}
	public static void handleAdminLogin()
	{
		System.out.println("Enter your username");
		String uname=sc.next();
		System.out.println("Enter your Password ");
		String  Pass=sc.next();
		if(Admin.adminauthenticate(uname,Pass))
		{
			System.out.println("login Succesfully.......");
			Adminmenu();
		}else{
			System.out.println("Invalid username and password ...Please try again..");
		}
	}

	public static void Adminmenu()
	{
		System.out.println("-------OPTION-------");
		System.out.println(" 1 Add Vechile");
		System.out.println(" 2 Remove Vechile");
		System.out.println(" 3 send vechile for maintance");
		System.out.println(" 4 complete vechile  maintance");
		System.out.println(" 5 View All customerDetails with rented vechile details");
		System.out.println(" 6 show all vechile info");

		System.out.println("---------------------");
		System.out.println("Enter your choice ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1->{
		System.out.println("1.Bike \n 2 Bus \n 3 Car");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		System.out.println("Enter vehicle ID");
		String id=sc.next();
		System.out.println("Enter a Rental Rate ");
		double rate=sc.nextDouble();
		switch(ch){
		case 1->{
			System.out.println("helmet available ? yes/no");
			String ha=sc.next();
			boolean b=ha.equalsIgnoreCase("yes");
			inventory.addvechile( new bike(id, rate, b));
			System.out.println("vehicle added succesfully .. ");
		}
		case 2->{
			inventory.addvechile(new bus(id, rate, ch));
			System.out.println("vehicle added succesfully .. ");
		}
		case 3->{
			inventory.addvechile(new car(id, rate, ch));
			System.out.println("vehicle added succesfully .. ");
		}

		}

		}
		//		case 2->
		case 3->{
			System.out.println("Enter the Vehicle ID");
			String  id=sc.next();
			vehicle vehicle=getvechileByID(id);
			if(vehicle!=null)
			{
				vehicle.sendforMaintenance();
			}else {
				System.out.println("Vehicle not Available");
			}

		}
		case 4->{
			System.out.println("Enter the Vehicle ID");
			String  id=sc.next();
			vehicle vehicle=getvechileByID(id);
			if(vehicle.isUndermainatnce())
			{
				vehicle.completeMaintenance();
			}else {
				System.out.println("Vehicle not Undermainatance ");
			}

		}
		case 5->{
//			inventory.getAllCustomers().forEach(val->System.out.println("  Customer Name :"+val.getName()+"\n Customer Number : "+val.getMobileno()+"\n Rented vehicle :"+val.getVehicle()));
			for(customer customer:inventory.getAllCustomers()) {
				System.out.println("name "+customer.getName());
				System.out.println("Mobile "+customer.getMobileno());
				System.out.println("Licesience :"+(customer.isLicenceAvailable()? "yes":"No"));
				System.out.println("Rented Vehicle Ids");
				customer.getVehicle().forEach(val->System.out.println(" "+val.getVehicleID()));
			}
		}
		case 6->{
			System.out.println("--------------All Vehicle -------------------");
			System.out.println(" Vehicle ID :       Rate :        VehicleAvailable:      underMaintance:");
			
			for(vehicle vehicle:inventory.getAllVehicle()) {
				System.out.println(vehicle.getVehicleID()+"      "+(vehicle.getRentalRate())+"        "+((vehicle.isAvailable()?"yes":"No"))+"        "+((vehicle.isUndermainatnce()?"yes":"No")));
			}
		}
		}

	} 
	public static void handleCustomerLogin()
	{
		System.out.println("------------REGISTRATION fORM--------------");
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter your Mobile No");
		long mobile=sc.nextLong();
		System.out.println("Licence available (yes/no)");
		String available=sc.next();
		boolean lic=available.equalsIgnoreCase("yes");

		customer=new customer(name, mobile, lic);
		inventory.addcustomers(customer);
		if(customer!=null)
		{
			System.out.println("Registration Succesfully...");
			customerMenu();
		}else{
			System.out.println("Registration failed.... Please try again....");
		}
	}
	public static void customerMenu()
	{
		boolean flag=true;
		while(flag)
		{
			System.out.println("--------MENU-------");
			System.out.println("1.show available bikes");
			System.out.println("2.show available cars");
			System.out.println("3.show available buses");
			System.out.println("4.rent Vechiles");
			System.out.println("5.return vechiles details");
			System.out.println("6.view rented vechile");
			System.out.println("---------------------");
			System.out.println("Enter your Choice...");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1->inventory.showAvaialblevechile(bike.class);
			case 2->inventory.showAvaialblevechile(car.class);
			case 3->inventory.showAvaialblevechile(bus.class);
			case 4->
			{
				System.out.println("Enter the vehicle ID ");
				String ID=sc.next();
				vehicle vechile=getvechileByID(ID);
				System.out.println("Enter the Number of Days");
				int days=sc.nextInt();
				if(vechile!=null)
				{
					customer.rentvechile(vechile,days);
				}
				else {
					System.out.println("vechile not Found ..");
				}
			}
			case 5->customer.returnVehicle();
			case 6->customer.viewRentedVehicle();
			case 7-> flag=false;
			default->
			System.out.println("invalid choice..");

			}
		}
	}
	private static vehicle getvechileByID(String ID) {
		List<vehicle>  vehicles=inventory.getAllVehicle();	
		for(vehicle Vehicle:vehicles)
		{
			if(Vehicle.getVehicleID().equalsIgnoreCase(ID))
			{
				return Vehicle;
			}
		}
		return null;
	}

}


