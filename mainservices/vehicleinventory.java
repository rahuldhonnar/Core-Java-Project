package mainservices;

import java.util.ArrayList;
import java.util.List;

import models.bike;
import models.customer;
import models.vehicle;

public class vehicleinventory {
	
	private List<vehicle>  vehicles;
	private List<customer> customers;
	
	public vehicleinventory() {
		vehicles=new ArrayList();
		customers=new ArrayList<customer>();
	}
	public void addvechile(vehicle vehicle)
	{
		vehicles.add(vehicle);
//		System.out.println("Data Addes succesfully");
	}
	public void removeVehicle()
	{
		
	}
	public List<vehicle> getAllVehicle()
	{
		return vehicles;
		
	}
	public void  showAvaialblevechile(Class<?> type) 
	{
		System.out.println("Available "+type.getSimpleName()+"s");
		
		System.out.println("--------------");
		
		for(vehicle Vehicle: vehicles) {
			if(type.isInstance(Vehicle)&&Vehicle.isAvailable())
			{
				System.out.println(type.getSimpleName()+" ID "+Vehicle.getVehicleID());
				System.out.println("Rental Rate "+Vehicle.getRentalRate());
				System.out.println("------------------");
			}
		}
	
	}
	public void addcustomers(customer customer) {
		customers.add(customer); 
		
	}
	public List<customer> getAllCustomers() {
		return this.customers;
		
	}

}
