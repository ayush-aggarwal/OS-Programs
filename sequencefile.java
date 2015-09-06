import java.io.*;
import java.util.*;
public class sequencefile
{
	static int no;
	static int temp=1;
	static char file[];
	static int noblock[];
	static int start[];
	static int end[];
	static int time[];
	static int flag[];
	static String status[];
	public static void deallocate(int tt)
	{
		for(int k=0;k<no;k++)
		{
			if(time[k]==tt && flag[k]==1)
			{
				temp=temp-noblock[k];
				status[k]=status[k]+"/ Deallocated";
			}
		}	
	}
	public static int findtodeallocate()
	{
		int pos=0,t;
		for(int i=0;i<no;i++)
		{
			if(flag[i]==1)
			{
				pos=i;
				break;
			}
		}
		t=time[pos];
		for(int j=0;j<no;j++)
		{
			if(time[j]<t)
			{
				t=time[j];
			}	
		}
		return t;
	}
	public static void allocate(char d,int a,int b)
	{
		int c=temp+b;
		if(c<=31)
		{
			start[a]=temp;
			end[a]=start[a]+b-1;
			temp=c;
			flag[a]=1;
			status[a]="Yes";
		}
		else
		{
			System.out.println("\nFile "+d+" cannot be allocated");
			status[a]="No";
			flag[a]=2;
		}
	}
	public static void display()
	{
		System.out.println("File\tSize\tTime\tStart\tEnd\tFlag\tAllocated");
		for(int i=0;i<no;i++)
		{
			System.out.println(file[i]+"\t"+noblock[i]+"\t"+time[i]+"\t"+start[i]+"\t"+end[i]+"\t"+flag[i]+"\t"+status[i]);
		}
	}
	public static void main(String args[]) throws IOException
	{
		int mintime,gflag=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the number of files:- ");
		no=sc.nextInt();
		file=new char[no];
		noblock=new int[no];
		start=new int[no];
		end=new int[no];
		time=new int[no];
		flag=new int[no];
		status=new String[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Please enter the file information:- ");
			file[i]=(char)System.in.read();
			noblock[i]=sc.nextInt();
			time[i]=sc.nextInt();
		}
		for(int j=0;j<no;j++)
		{
			allocate(file[j],j,noblock[j]);
		}
		display();
		while(gflag==0)
		{
			for(int n=0;n<no;n++)
			{
				if(flag[n]==1)
				{
					gflag=1;
				}
				else
				{
					gflag=0;
				}
			}
			if(gflag==0)
			{	
		mintime=findtodeallocate();
		System.out.println(mintime);
		deallocate(mintime);
		System.out.println(temp);
		display();
		for(int k=0;k<no;k++)
		{
			if(flag[k]==2)
			{
				allocate(file[k],k,noblock[k]);
			}
		}
		display();
			}
		}
	}
}
