package Hotel_Management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import User_Management.User;

public class HotelReserVation {
	static ArrayList <Customer>al=new ArrayList();


public static void HotelReserVation()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("***Welcome to HotelReserVation***");
	System.out.println("\n");
	System.out.println("What would you like to do?");
	System.out.println("1.Reserve a Booking:");
	System.out.println("2.Update Booking:");
	System.out.println("3.Cancle Booking:");
	System.out.println("4.Check Booking:");
	System.out.println("5.Quit:");
	
	boolean canIkeepRunningTheProgram=true;
	while(canIkeepRunningTheProgram==true)
	{
		
		int OptionSelectedByCustomer=sc.nextInt();
	if(OptionSelectedByCustomer==CustomerOption.Quit)	{
		System.out.println("!Quit");
		canIkeepRunningTheProgram=false;
	}
	else if(OptionSelectedByCustomer==CustomerOption.Reserve_a_Room) {
		BookingRoom();
	}
	else if(OptionSelectedByCustomer==CustomerOption.Check_Booking) {
		System.out.println("Enter BookingName to Search:");
	    sc.nextLine();
	    String st=sc.nextLine();
	   SearchBooking(st);
	  
	}
	else if(OptionSelectedByCustomer==CustomerOption.cancle_Booking) {
		System.out.println("Enter BookingName to Delete:");
	    sc.nextLine();
	    String Dc=sc.nextLine();
	   DeleteBooking(Dc);
	  
	}
	
	else if(OptionSelectedByCustomer==CustomerOption.Edit_Booking) {
		System.out.println("Enter BookingName to Edit:");
	    sc.nextLine();
	    String Ec=sc.nextLine();
	   EditBooking(Ec);
	  
	}
	
	}
	System.out.println("after while loop");
	for(Customer c:al) {
		System.out.println(c.CustomerName);}
		
}
public static void BookingRoom () {
	Scanner sc=new Scanner(System.in);
	Customer cust=new Customer();
	
	System.out.println("Enter CustomerName:");
	cust.CustomerName=sc.nextLine();
	
	System.out.println("Enter Contact:");
	cust.Contact=sc.next();
	
	System.out.println("Enter Room_no:");
	cust.Room_no=sc.nextInt();
	
	System.out.println("Enter Room_Rent:");
	cust.Room_Rent=sc.nextInt();
	
	System.out.println("Enter Total_Days:");
	cust.Total_Days=sc.nextInt();
	
	System.out.println("Enter Booking date:");
	cust.Booking_date=sc.next();
	
	System.out.println("CustomerName:"+cust.CustomerName);
	System.out.println("Contact:"+cust.Contact);
	System.out.println("Room_no:"+cust.Room_no);
	System.out.println("Room_Rent:"+cust.Room_Rent);
	System.out.println("Total_Days:"+cust.Total_Days);
	System.out.println("Booking date:"+cust.Booking_date);
	al.add(cust);
	HotelReserVation();
	

	
}
public static void SearchBooking(String customername) {
	for(Customer c:al) {
		if(c.CustomerName.equalsIgnoreCase(customername)) {
			System.out.println("CustomerName:"+c.CustomerName);
			System.out.println("Contact:"+c.Contact);
			System.out.println("Room_no:"+c.Room_no);
			System.out.println("Room_Rent:"+c.Room_Rent);
			System.out.println("Total_Days:"+c.Total_Days);
			System.out.println("Booking date:"+c.Booking_date);
			return;
		}
	}
	System.out.println("Booking is not found");
}
public static void DeleteBooking(String customername) {
	Iterator <Customer>c1iterator= al.iterator();
	while(c1iterator.hasNext()) {
		Customer c1= c1iterator.next();	
		if(c1.CustomerName.equalsIgnoreCase(customername)) {
			c1iterator.remove();
			System.out.println(c1.CustomerName+" has been deleted");
			break;
		}
		
	}
//	System.out.println(" Booking Not found");

	
}
public static void EditBooking(String customername) {
	Scanner sc=new Scanner(System.in);
	for(Customer cust:al) {
		if(cust.CustomerName.equalsIgnoreCase(customername)) {
	System.out.println("Enter new CustomerName:");
	cust.CustomerName=sc.nextLine();
	

	System.out.println("Enter new contact:");
	cust.Contact=sc.next();
	
	System.out.println("Enter new Room_no:");
	cust.Room_no=sc.nextInt();
	
	System.out.println("Enter new Room_Rent:");
	cust.Room_Rent=sc.nextInt();
	
	System.out.println("Enter new Total_Days:");
	cust.Total_Days=sc.nextInt();
	
	System.out.println("Enter new Booking date:");
	cust.Booking_date=sc.next();
	
	System.out.println("Enter new CustomerName:"+cust.CustomerName);
	System.out.println("Enter new Contact:"+cust.Contact);
	System.out.println("Enter new Room_no:"+cust.Room_no);
	System.out.println("Enter new Room_Rent:"+cust.Room_Rent);
	System.out.println("Enter new Total_Days:"+cust.Total_Days);
	System.out.println("Enter new Booking date:"+cust.Booking_date);
	al.add(cust);
	return;
		}
	}
	System.out.println("Booking is not found");
	
}
	
}
