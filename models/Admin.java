package models;


public class Admin {
	
	private static String username="Rahul";
	private static String Password="Rahul@123";
	
	public Admin(String username,String Password)
	{
		username=username;
		Password=Password;
	}
	public static boolean adminauthenticate(String uname, String pass)
	{
		if(username.equals(uname) && Password.equals(pass))
		{
			return true;
		}
		return false;
	}
}
