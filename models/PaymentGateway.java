package models;

import java.util.Scanner;

public class PaymentGateway {

	static Scanner sc=new Scanner(System.in);
	public static boolean processpayment(int days, double bill)
	{
		System.out.println("Enter amount to pay");
		int amount=sc.nextInt();
		System.out.println("processing payment.........");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Payment Done :"+amount);
		if(bill<=amount)
		{
			if(bill==amount)
			System.out.println("Process Done ");
			if(bill<=amount)
				System.out.println("Paid Extra :"+(amount-bill));
			
			System.out.println("Vehicle rented succesfully");
			return true;
		}else if(bill>amount){
			System.out.println("pending amount :"+(bill-amount));
			System.out.println("Vehicle not allocated ");
			return false;
		}
		return false;
		
	}
}
