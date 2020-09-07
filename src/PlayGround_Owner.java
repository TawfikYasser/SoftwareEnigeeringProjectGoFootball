
import java.io.IOException;

import java.util.Scanner;
public class PlayGround_Owner extends User{
	static public Administrator administrator = new Administrator();
	public PlayGround_Owner()
	{
		
	}
	public void Register(){
		Scanner Scan=new Scanner(System.in);
		System.out.println("Please Enter your nick name");
		String Name;
		Name=Scan.next();
		System.out.println("Please Enter Your Id");
		int Id=Scan.nextInt();
		System.out.println("Please Enter Your password");
		String Password=Scan.next();
		System.out.println("Please Enter Mail");
		String mail=Scan.next();
		System.out.println("please Enter Your location");
		String Location=Scan.next();
		System.out.println("Please Enter your phone");
		String ph=Scan.next();
		Registration(Name,Id,Password,mail,Location,ph,1);
	}
	public void login()
	{
		Scanner Scan=new Scanner(System.in);
		System.out.println("Please Enter Mail");
		String mail=Scan.next();
		System.out.println("Please Enter Your password");
		String Password=Scan.next();
		login(mail,Password);
	}
}
