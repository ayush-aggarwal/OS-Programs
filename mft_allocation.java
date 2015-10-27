import java.io.*;
import java.util.*;
public class mft_allocation
{
	public static char filename[];
	public static int no;
	public static int size[];
	public static String status[];
	public static int start[];
	public static int end[];
	public static void display()
	{
		System.out.println("\t\t\tFile Allocation Status");
		System.out.println("File\tSize\tStart\tEnd\tStatus");
		for(int i=0;i<no;i++)
		{
			System.out.println(filename[i]+"\t"+size[i]+"\t"+start[i]+"\t"+end[i]+"\t"+status[i]);
		}
	}	
	public static void main(String args[]) throws IOException
	{
		int memory=1000,no_part=10,reqd_part,t=0,block_size=100,frag=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the number of Files:- ");
		no=sc.nextInt();
		filename=new char[no];
		size=new int[no];
		status=new String[no];
		start=new int[no];
		end=new int[no];
		System.out.println("Enter File Information:- ");
		for(int i=0;i<no;i++)
		{
			filename[i]=(char)System.in.read();
			size[i]=sc.nextInt();
			status[i]="Not Allocated";
		}
		display();
		for(int i=0;i<no;i++)
		{
			if(size[i]>memory)
			{
				System.out.println("File "+filename[i]+" Size Too Large for this memory...Skipping");
				continue;
			}
			else
			{
				reqd_part=(int)Math.ceil((float)size[i]/block_size);
				if(reqd_part>no_part)
				{
					System.out.println(filename[i]+" could'nt be allocated due to insufficient memory");
					continue;
				}
				else
				{
					no_part=no_part-reqd_part;
					start[i]=t;
					end[i]=start[i]+(reqd_part*block_size);
					t=end[i];
					status[i]="Allocated";
					if(size[i]%block_size!=0)
					{
						frag=frag+(block_size-(size[i]%block_size));
					}
				}
			}
		}
		display();		
		System.out.println("Total Internal Fragmentation:- "+frag);
	}
}
		
