package User_Management;
	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Scanner;

	public class UserManagement {
		static  ArrayList <User>al=new ArrayList();
	static {	
		try {
		loaddatafromUserManagementtofile() ;
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}	
	public static void Usermanagement() throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("****Welcome to the UserManagement***");
		System.out.println("\n");
		
		 boolean canIKeepRunningTheProgram=true;
		while(canIKeepRunningTheProgram==true) {
			System.out.println("What would you want to do?");
			System.out.println("1.Add User");
			System.out.println("2.Search User");
			System.out.println("3.Delete User");
			System.out.println("4.Edit User");
			System.out.println("5.Quit");
			 int optionselectedbyuser=sc.nextInt();
			if(optionselectedbyuser==UserOptions.Quit) {
			

				System.out.println("!!!program end");
				canIKeepRunningTheProgram=false;
				 
			}
			else if(optionselectedbyuser==UserOptions.Add_User) {
				AddUser();
			}
			else if(optionselectedbyuser==UserOptions.Edit_User) {
				System.out.println("Enter UserName to edit :");
				sc.nextLine();
				String eu=sc.nextLine();
				EditUser(eu);
			}
			else if(optionselectedbyuser==UserOptions.Search_User) {
				System.out.println("Enter UserName to Search :");
				sc.nextLine();
				String su=sc.nextLine();
				SearchUser(su);
			}
			else if(optionselectedbyuser==UserOptions.Delete_User) {
				System.out.println("Enter UserName to Delete :");
				sc.nextLine();
				String Du=sc.nextLine();
				DeleteUser(Du);
			}

		}
		System.out.println("after while loop");
		for(User u1:al)
		System.out.println(u1.UserName);
		
	}
	public static void AddUser() {
		Scanner sc=new Scanner(System.in);
		User user=new User();
		
		System.out.println("Enter UserName:");
		user.UserName=sc.nextLine();
		
		System.out.println("Enter LoginName:");
	  user.loginName=sc.nextLine();

		System.out.println("Enter PassWord: ");
		user.PassWord=sc.nextLine();

		System.out.println("Enter ConfirmPassWord :");
		user.ConfirmPassword=sc.nextLine();
		
		System.out.println("Enter UserRole:");
		user.userRole=sc.nextLine();

		System.out.println(" UserName:"+user.UserName);
		System.out.println(" LoginName:"+user.loginName);
		System.out.println(" Password:"+user.PassWord);
		System.out.println(" confirmPassword:"+user.ConfirmPassword);
		System.out.println(" UserRole:"+user.userRole);

		
		al.add(user);
		
	}
	public static void EditUser(String Customername) {
		Scanner sc=new Scanner(System.in);
		
		for(User u:al) {
			
			if(u.UserName.equalsIgnoreCase(Customername)) {
				System.out.println("Enter CustomerName:");
				u.UserName=sc.nextLine();
				
				System.out.println("Enter LoginName:");
				u.loginName=sc.nextLine();

				System.out.println("Enter PassWord: ");
				u.PassWord=sc.nextLine();

				System.out.println("Enter ConfirmPassWord :");
				u.ConfirmPassword=sc.nextLine();
				
				System.out.println("Enter UserRole:");
				u.userRole=sc.nextLine();
				
				System.out.println(" CustomerName:"+u.UserName);
				System.out.println(" LoginName:"+u.loginName);
				System.out.println(" Password:"+u.PassWord);
				System.out.println(" confirmPassword:"+u.ConfirmPassword);
				System.out.println(" UserRole:"+u.userRole);
				al.add(u);
return;
			}
		}
		System.out.println(" User Not found");

		
	}
	public static void SearchUser(String username) {
		for(User user:al) {
			if(user.UserName.equalsIgnoreCase(username)) {
				System.out.println(" CustomerName:"+user.UserName);
				System.out.println(" LoginName:"+user.loginName);
				System.out.println(" Password:"+user.PassWord);
				System.out.println(" confirmPassword:"+user.ConfirmPassword);
				System.out.println(" userRole:"+user.userRole);
				return;
			}
		}
		
		System.out.println(" User Not found");

	}
	
	public static void DeleteUser(String username) {
		Iterator <User>u1iterator= al.iterator();
		while(u1iterator.hasNext()) {
			User u1= u1iterator.next();	
			if(u1.UserName.equalsIgnoreCase(username)) {
				u1iterator.remove();
				System.out.println(u1.UserName+"has been deleted");
				break;
			}
			
		}
		System.out.println(" User Not found");

	}
	public static void loaddatafromUserManagementtofile() throws IOException {
		 File file=new File("\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\HotelManagement\\src\\User_Management\\user.csv");
		 FileReader fr=new FileReader(file);
		 BufferedReader br=new BufferedReader(fr);
		 String line="";
		 while((line=br.readLine())!=null) {
			User user=new User();
			String[] UserDataArray=line.split(",");
			if(UserDataArray.length>3) {
				user.UserName=UserDataArray[0];
				user.loginName=UserDataArray[1];
				user.PassWord=UserDataArray[2];
				user.userRole=UserDataArray[3];
				
				al.add(user);
			}
			
		 }
		 fr.close();
		 br.close();
		 file=null;
	}	 
	
	public static boolean validdataLoginNamePassWord(String Loginname,String PassWord) {
	Iterator <User>	u1iterator=al.iterator();
	while(u1iterator.hasNext()) {
		User user=u1iterator.next();
		if(user.UserName.equalsIgnoreCase(Loginname)&& user.PassWord.equalsIgnoreCase(PassWord)) {
			return true;
			
		}
		
	}
 return false;

	}
	}


