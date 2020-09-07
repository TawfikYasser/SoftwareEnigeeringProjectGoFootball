
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Playground {

	private String Name,Location;
	private int Size,PricePerHour,cancellationPeriod;
	private boolean Status;
	static int NumberOfPlayGround=0;
	 public static ArrayList<String> name = new ArrayList<String>();
	 public static ArrayList<String> location = new ArrayList<String>();
	 public static ArrayList<Integer> size = new ArrayList<Integer>();
	 public static ArrayList<Integer> price_per_hour = new ArrayList<Integer>();
	 public static ArrayList<Integer> cancellation_peroid = new ArrayList<Integer>();
	 public static ArrayList<Boolean> status = new ArrayList<Boolean>();
	public static ArrayList<String>available_hours=new ArrayList<String>();
	public static ArrayList<Integer>PlayNum=new ArrayList<Integer>();
	static int number_Of_PlayGround=0;
	int current=0;
	public Playground()
	{
		
	}
	public Playground(String name, String location, int size, int pricePerHour, int cancellationPeriod, boolean status, String[] availableHours) {
		Name = name;
		Location = location;
		Size = size;
		PricePerHour = pricePerHour;
		this.cancellationPeriod = cancellationPeriod;
		Status = status;
		//this.availableHours = availableHours;
	}	
	public void open_file() throws IOException
	{
		File My_object=new File("PlayGround.txt");
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
		File MyObjec=new File("PlayGround.txt");
		try {
			Scanner myRead = new Scanner( MyObjec);
			while (myRead.hasNextLine()) {
		        String data = myRead.next();
		        name.add(data);
		        data=myRead.next();
		        location.add(data);
		        int Digi=Integer.parseInt(myRead.next());
		        size.add(Digi);
		        Digi=Integer.parseInt(myRead.next());
		        price_per_hour.add(Digi);
		        Digi=Integer.parseInt(myRead.next());
		        cancellation_peroid.add(Digi);
		        Boolean Stat=Boolean.parseBoolean(myRead.next());
		        status.add(Stat);
		      	//int i=0;
		     	myRead.nextLine();
		      	available_hours.add(myRead.next());
		      	NumberOfPlayGround++;
		      	myRead.nextLine();
				//System.out.println(data);
		      }
		      myRead.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean check(String a)
	{
		if(available_hours.contains(a))
		{
			return true;
		}
		return false;
		
	}
	public void print()
	{
		System.out.println("Playground_Name"+"\t\t\t"+"Location"+"\t\t"+"Status");
		for(int i=0;i<name.size();i++)
		{
			System.out.print(name.get(i)+"\t\t\t");
			System.out.print(location.get(i)+"\t\t\t");
			System.out.println(status.get(i));
			
		}
	}
	public void addPlayGround()
	{
		int num=0;
		try (Scanner Scan = new Scanner(System.in)) {
			System.out.println("please Enter playground Name");
			this.Name=Scan.next();
			System.out.println("please Enter playground Location");
			this.Location=Scan.next();
			System.out.println("please Enter playground Size");
			this.Size=Scan.nextInt();
			System.out.println("please Enter PricePreHoure");
			this.PricePerHour=Scan.nextInt();
			System.out.println("please Enter CancellationPeriod");
			this.cancellationPeriod=Scan.nextInt();
			System.out.println("please Enter playground Status");
			this.Status=Scan.nextBoolean();
			System.out.println("Please Enter the Number of Period");
			num=Scan.nextInt();
			PlayNum.add(num);
			for(int i=0;i<num;i++)
			{
				System.out.println("please Enter the period "+ "  "+ i+1);
				String Data; 
				Data=Scan.next();
				available_hours.add(Data);
			}
			System.out.println(number_Of_PlayGround);
		FileWriter My_Writer = null;
		try {
			My_Writer = new FileWriter("PlayGround.txt",true);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Administrator Admin=new Administrator();
			if(Admin.approvePlayground(Name, Location, Size, PricePerHour, cancellationPeriod, Status, available_hours))
			{
				this.Status=true;
				My_Writer.write(this.Name+" "+this.Location+" "+this.Size+" "+this.PricePerHour+" "+this.cancellationPeriod+" "+this.Status+"\n");
				for(int i=0;i<num;i++)
				{
					My_Writer.write(available_hours.get(i)+" ");
				}
				My_Writer.write("\n");
				number_Of_PlayGround++;
			}
			else
			{
				System.out.println("Admin Refused This approvement");
				System.out.println("you should Enter the Correct info");
			}
			
			/*
			for(int i=0;i<num;i++)
			{
				My_Writer.write(available_hours[NumberOfPlayGround][i]+" ");
			}
			My_Writer.write("\n");
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			My_Writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NumberOfPlayGround++;
	}
}
}
