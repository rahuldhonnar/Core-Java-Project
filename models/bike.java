package models;

public class bike extends vehicle {
	
	private boolean helmateAvailable;

	public bike(String vehicleID, double rentalRate, boolean ha) {
		super(vehicleID, rentalRate);
		this.helmateAvailable = ha;
	}
	public void DisplayInfo()
	{
		
	}
	
	

}
