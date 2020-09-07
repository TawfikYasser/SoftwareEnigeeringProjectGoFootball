import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Administrator {
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
	public static boolean approvePlayground(String Name,String Location,int Size,int PricePerHour,int cancellationPeriod,boolean Status,ArrayList<String>availableHours) throws IOException {
		// FileWriter My_Writer= new FileWriter("PlayGround.txt",true);
		 if(!Name.isEmpty()&&!Location.isEmpty()&&Size!=0&&PricePerHour!=0&&cancellationPeriod!=0&&Status==false&&availableHours.size()+1>0) {
			 System.out.println(".");
			 System.out.println(".");
			 System.out.println(".");
			 System.out.println("Playground data is correct, it is approved successfully!");
			 return true;	 
		 }else {
			 return false;
		 }
	}
}
