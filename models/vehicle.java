package models;

import java.util.Date;
import java.util.Scanner;

public class vehicle {
	
	private String vehicleID;
	private double rentalRate;
	private boolean isAvailable ;
	private int rentedDays;
	private boolean undermainatnce;
	
	public vehicle(String vehicleID, double rentalRate) {
		super();
		this.isAvailable=true;
		this.undermainatnce=false;
		this.vehicleID = vehicleID;
		this.rentalRate = rentalRate;
		this.rentedDays=0;
	}
	
	public boolean rent(int days, String name, long mobileno)
	{
		if(this.isAvailable){
		double bill=this.rentalRate*days;
		System.out.println("total Bill Amount : "+bill);
		boolean payment=PaymentGateway.processpayment(days,bill);
		if(payment)
		{
			isAvailable=false;
			rentedDays=days;
			ReceiptGenrator.genraterecipt(name,mobileno,this,bill);
			System.out.println("Sending Bill to your mail.....");
			System.out.println("Enter your mail ID ,,");
			Scanner sc=new Scanner(System.in);
			String email=sc.next();
			EmailServices.sendBookingConfirmation(name,days,rentalRate,bill,vehicleID,email);
			
			return true;
		}
		System.out.println("Payment not Done...Please try again");
		return false;
		}
		System.out.println("Vehicle Not Available..........");
		return false;
	}
	
	
	public void returnVechile()
	{
		this.isAvailable=true;
		this.rentalRate=0;
		System.out.println(this.vehicleID+" Returned succesfully ");
	}
	public void sendforMaintenance()
	{
		isAvailable=false;
		undermainatnce=true;
		System.out.println(this.vehicleID+" is sending for maintance ");
	}
	public void completeMaintenance()
	{
		isAvailable=true;
		undermainatnce=false;
		System.out.println(this.vehicleID+" maintenance completed ");
	}

	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getRentedDays() {
		return rentedDays;
	}
	public void setRentedDays(int rentedDays) {
		this.rentedDays = rentedDays;
	}
	public boolean isUndermainatnce() {
		return undermainatnce;
	}
	public void setUndermainatnce(boolean undermainatnce) {
		this.undermainatnce = undermainatnce;
	}

}
