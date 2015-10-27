import java.io.*;
import java.util.*;
public class mvt_allocation
{
	public static int no,memory=500,mem_avai=500,mem_alloc=0,temp=0;
	public static char file[];
	public static int size[];
	public static int start[];
	public static int end[];
	public static String status[];
	public static void display()
	{
		System.out.println("\t\t\tFile Status Table");
		System.out.println("File\tSize\tStart\tEnd\tStatus");
		for(int i=0;i<no;i++)
		{
			System.out.println(file[i]+"\t"+size[i]+"\t"+start[i]+"\t"+end[i]+"\t"+status[i]);
		}
		System.out.println();
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter the number of Files:- ");
		no=sc.nextInt();
		file=new char[no];
		size=new int[no];
		start=new int[no];
		end=new int[no];
		status=new String[no];
		System.out.println("Please  Enter File Information:- ");
		for(int i=0;i<no;i++)
		{
			file[i]=(char)System.in.read();
			size[i]=sc.nextInt();
			status[i]="Not Allocated";
		}
		display();
		for(int i=0;i<no;i++)
		{
			if(size[i]>memory)
			{
				System.out.println(file[i]+" too large for memory......Skipping");
				continue;
			}
			else
			{	
				if(size[i]>mem_avai)
				{	
					System.out.println(file[i]+" cannot be allocated due to insufficient memory");
					continue;
				}
				else
				{
					start[i]=temp;
					end[i]=start[i]+size[i];
					temp=end[i];
					status[i]="Allocated";
					mem_alloc=mem_alloc+size[i];
					mem_avai=mem_avai-size[i];
				}
			}
		}
		display();
		System.out.println("Total External Fragmentation:- "+mem_avai);
	}
}
