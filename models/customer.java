package models;

import java.util.ArrayList;
import java.util.List;

public class customer {
	
	private String name;
	private long mobileno;
	private boolean isLicenceAvailable;
	private List<vehicle> vehicle;
	
	public customer(String name, long mobileno, boolean isLicenceAvailable) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.isLicenceAvailable = isLicenceAvailable;
		vehicle=new ArrayList<vehicle>();
	}

	public void rentvechile(vehicle vehicles,int days)
	{
		if(vehicles.rent(days,this.name, mobileno)) {
				vehicle.addAll(vehicle);
			}
			
		
	}
	public void returnVehicle()
	{
	for (vehicle Vehicle : vehicle) {
		Vehicle.returnVechile();
	}
	vehicle.clear();
	}
	
	public void viewRentedVehicle()
	{
		if(vehicle.isEmpty())
		{
			System.out.println(" No rented vehicle available......");
		}else
		{
			System.out.println("List of all rented vehicle ");
		}
		vehicle.forEach(val->System.out.println(val.getVehicleID()+"\n Rented Days :"+val.getRentedDays()));
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public boolean isLicenceAvailable() {
		return isLicenceAvailable;
	}

	public void setLicenceAvailable(boolean isLicenceAvailable) {
		this.isLicenceAvailable = isLicenceAvailable;
	}

	public List<vehicle> getVehicle() {
		return vehicle;
	}

	public void setVechiles(List<vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
	

}
