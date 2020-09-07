
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Player extends User{
	static ArrayList<String>TeamMails=new ArrayList<String>();
	static ArrayList<String>TeamNames=new ArrayList<String>();
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
		Registration(Name,Id,Password,mail,Location,ph,0);
		Scan.close();
	}
	
	public void login()
	{
		Scanner Scan=new Scanner(System.in);
		System.out.println("Please Enter Mail");
		String mail=Scan.next();
		System.out.println("Please Enter Your password");
		String Password=Scan.next();
		login(mail,Password);
		Scan.close();
	}
	Playground object=new Playground();
	public void Booking()
	{
		System.out.println("Type playground name: ");
		Scanner scanner = new Scanner(System.in);
    	String name = scanner.next();
		for(int i=0;i<Playground.name.size();i++) {
			if(Playground.name.get(i).equals(name)) {
				System.out.println("Playground Found!");
				System.out.println(Playground.status.get(i));
					if(Playground.status.get(i)) {
							System.out.println("Type the hours to book like (5:00pm to 6:00pm)");
							Scanner scanner2 = new Scanner(System.in);
							String hour = scanner2.nextLine();
							for(int j =0;j<Playground.available_hours.size();j++) {
								if(Playground.check(hour)) {
									System.out.println(hour + " is available.");
									FileWriter My_Writer = null;
									try {
										My_Writer = new FileWriter("Booking.txt",true);
										My_Writer.write("Current User booked: "+Playground.name.get(i)+"  "+hour+" ");
										My_Writer.write("\n");
										My_Writer.close();
										System.out.print("Sucessfully Booking a PlayGound");
										break;
									} catch (IOException e1) {
										e1.printStackTrace();
										break;
									}
									//break;
								}
								else {
								System.out.println(hour + " is not available.");
								break;
								}
							}
					}else {
						System.out.println("This playground is not available now!");
						break;
					}
			}else {
				System.out.println("Playground not found!");
			}
			break;
		}
		scanner.close();
	}
	public static void Creating_Team()
	{
		System.out.println("Please Enter the Team Number");
		Scanner Scan=new Scanner(System.in);
		int num=Scan.nextInt();
		for(int i=0;i<num;i++) {
			System.out.println("Please Enter the ");
			TeamNames.add(Scan.next());
			System.out.println("Please Enter the Mail");
			TeamMails.add(Scan.next());
			FileWriter My_Writer = null;
			try {
				My_Writer = new FileWriter("Team&Mails.txt",true);			
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				My_Writer.write(TeamNames.get(i)+"              "+TeamMails.get(i)+"\n");
				My_Writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Scan.close();
	}
	public static void print_Team() {
		System.out.println("Name\t\t\t"+"Email\t\t\t");
		for(int i=0;i<TeamMails.size();i++)
		{
			System.out.println(TeamNames.get(i)+"\t\t\t"+TeamMails.get(i)+"\t\t\t");
		}
	}
}
