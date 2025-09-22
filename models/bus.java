package models;

public class bus extends vehicle {
	
	private int noofSeats;

	public bus(String vechileId, double rentalRate, int noofSeats) {
		super(vechileId, rentalRate);
		this.noofSeats = noofSeats;
	}
	
	public void DisplayInfo()
	{
		
	}
	

}
