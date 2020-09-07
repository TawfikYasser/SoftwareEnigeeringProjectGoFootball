import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class User {
	public String Name;
	private int ID;
	private String Password;
	private String Email;
	private String Location;
	private String Phone;
	private String Role;
	private ArrayList<String> Names=new ArrayList<String>();
	private ArrayList<String> Emails=new ArrayList<String>();
	private ArrayList<String> Passwords=new ArrayList<String>();
	ArrayList<Integer> ids = new ArrayList<>();
	static int numberOfUsers=0;
	public User()
	{
		
	}
	// this method used to open the file
	public void open_file() throws IOException
	{
		File My_object=new File("DataBase2.txt");
		if(My_object.createNewFile())
		{
			System.out.println("Created");
			System.out.println(My_object.getName());
		}
		else
		{
			System.out.println("there are some problem");
		}
	}
	
	public void Read_From_File()
	{
		File MyObject=new File("DataBase.txt");
		try {
			Scanner myReader = new Scanner( MyObject);
			while (myReader.hasNextLine()) {
		        String data = myReader.next();
		        Names.add(data);
		        int data1;
		        data1=Integer.parseInt(myReader.next());
		        ids.add(data1);
		        data=myReader.next();
		        Passwords.add(data);
		        data=myReader.next();
		        Emails.add(data);
		        data=myReader.nextLine();
		        numberOfUsers++;
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print()
	{
		for(int i=0;i<Names.size();i++)
		{
			System.out.println(Names.get(i));
		}
	}
	
	protected void login(String Email,String Password)
	{
		Read_From_File();
		if(Emails.contains(Email))
		{
			int index=Emails.indexOf(Email);
			if(Passwords.get(index).equals(Password))
			{
				System.out.print("Welcome to you in GO_FO System");
			}
			else
			{
				Scanner Scan=new Scanner(System.in);
				System.out.print("invalid authentication");
				int For_Pass=0;
				System.out.println("if you forget the password Enter 1");
				For_Pass=Scan.nextInt();
				if(For_Pass==1)
				{
					System.out.println("Please Enter Your Id");
					int Id=Scan.nextInt();
					if(Id==ids.get(index))
					{
						System.out.println("good job");
						System.out.println("Your Mail is: "+Email);
						System.out.println("Your Passords is: " +Passwords.get(index));
						System.out.println("Please Enter 1 if you want to change the password");
						int change=Scan.nextInt();
						if(change==1)
						{
							System.out.println("Please Enter your New Passwords");
							String New_Password=Scan.next();
							Passwords.add(index, New_Password);
							System.out.println("good your Password is chagned");
						}
					}
					
				}
				
			}
		}
		else
		{
			System.out.println("this mail is not exist");
			System.out.println("You should to Register First");
		}
	}
	protected void Registration(String Name,int Id,String Password,String mail,String loac,String phone,int num)
	{
		
		try {
			FileWriter My_Writer=new FileWriter("DataBase.txt",true);
			// Regular exp phone
			// that check that the phone number must have zero at the First 
			// and contain 10 numbers from 0 to 9
			String regex1="^[0]+[0-9]{10}";
			// this is Regular Exp Mail
			// that check that the mail should have character from a(A) to z(Z) and number from 0 to 9
			// and . and - and must contain @
			String regex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			// and if the both condirion is corrected then store user_info in DataBase_file
			if(phone.matches(regex1) && mail.matches(regex) && !Emails.contains(mail))
			{
				this.Name=Name;
				this.ID=Id;
				this.Password=Password;
				this.Location=loac;
				this.Phone=phone;
				this.Email=mail;
				// num this num if the num=0
				// the Role is 'Player'
				if(num==0)
				{
					this.Role="Player";
				}
				// else the num=1
				//the Role is 'PlayGround_owner'
				else
					this.Role="Owner";
				My_Writer.write(Name+" "+Id+" "+Password+" "+mail+" "+loac+" "+phone+" "+Role+" "+"\n");	
				My_Writer.close();
				// store all names into Array_List
				Names.add(Name);
				// store all Mails into Array_List(Emails)
				Emails.add(mail);
				// store all Passwords into Array_List(Passwords)
				Passwords.add(Password);
				ids.add(Id);
				// i think this this is trivial Variable
				numberOfUsers++;
				// Profile is Created Profile data  Saved in DataBase File
				System.out.println("Inserted Successfully and Created Profile");
			}
			else
			{
				System.out.println("Invalid in Mail oR Phone number");
				System.out.println("Or this is already exits");
				My_Writer.close();
				System.out.println("Please Register again");
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void Print() throws IOException {
		for(int i=0;i<numberOfUsers;i++) {
			System.out.println(Emails.get(i).toString());
	}
	}
}
