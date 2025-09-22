package models;

public class ReceiptGenrator {
	
	public static  void genraterecipt(String name, long mobileno, vehicle vehicle, double bill)
	{
		System.out.println("-------------Bill Reciept-------------");
		System.out.println("Customer Name       :"+name);
		System.out.println("Vehicle ID          :"+vehicle.getVehicleID());
		System.out.println("Vehicle Rental Rate :"+vehicle.getRentalRate());
		System.out.println("Rental Days         :"+vehicle.getRentedDays());
		System.out.println("Total Bill          :"+bill+"Rs");
		System.out.println("---------------------------------------");
	}

}
