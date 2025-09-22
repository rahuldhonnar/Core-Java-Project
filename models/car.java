package models;

public class car  extends vehicle{
	
	private int noofSeats;

	public car(String vehicleID, double rentalRate, int noofSeats) {
		super(vehicleID, rentalRate);
		this.noofSeats = noofSeats;
	}
	
	public void DisplayInfo()
	{
		
	}
	

}
