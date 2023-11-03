package Application_Main;

import java.io.IOException;
import java.util.Scanner;

import Hotel_Management.HotelReserVation;
import User_Management.UserManagement;

public class ApplicationMain {
public static void main(String args[]) throws IOException {
	Scanner sc=new Scanner(System.in);
	System.out.println("***Hotel Reservation***");
	System.out.print("\n");
	System.out.println("***Login***");
	


System.out.println("Enter LoginName:");
String LoginName=sc.nextLine();

System.out.println("Enter Password:");
String PassWord=sc.nextLine();

 
	if(!UserManagement.validdataLoginNamePassWord(LoginName, PassWord))
	{
		System.out.println("Login Failed.closing the application");
		return ;
	}
	
	System.out.println("What would you want to do?");	
	System.out.println("1.Hotel_Reservation");
	System.out.println("2.Quit");
	
	int optionselectedbyuser=sc.nextInt();
	
	if(optionselectedbyuser==1) {
		HotelReserVation.HotelReserVation();
	}
	else if(optionselectedbyuser==2){
		System.out.println("!Quit");
	}
	
}


}