import java.io.*;
import java.util.*;
public class mft
{
	static int no,memory=300,part=100,ctr=0,st=0;
	static char proc[];
	static int size[];
	static int time[];
	static int flag[];
	static int start[];
	static int end[];
	static char mem[]=new char[3];
	static int status[]=new int[3];
	public static int checktodeallocate(int t)
	{
		int flg=0;
		for(int i=0;i<no;i++)
		{
			if(time[i]==t)
			{
				flg=1;
				if(start[i]==0)
				{
					status[0]=0;
					ctr=ctr-1;
					st=0;
					if(end[i]==200)
					{
						status[1]=0;
						ctr=ctr-1;
					}
					else if(end[i]==300)
					{
						status[2]=0;
						ctr=ctr-1;
					}
				}
				else if(start[i]==100)
				{
					status[1]=0;
					ctr=ctr-1;
					st=100;
					if(end[i]==300)
					{
						status[2]=0;
						ctr=ctr-1;
					}
				}
				else if(start[i]==200)
				{
					st=200;
					ctr=ctr-1;
					status[2]=0;
				}
			}
		}
		return flg;
	}
	public static int findmaxtime()
	{
		int m=time[0];
		for(int i=0;i<no;i++)
		{
			if(time[i]>m && flag[i]==1)
			{
				m=time[i];
			}
		}
		return m;
	}
	public static void display()
	{
		System.out.println("\nProcess\tTime\tSize\tStart\tEnd\tFlag");
		for(int i=0;i<no;i++)
		{
			System.out.println(proc[i]+"\t"+time[i]+"\t"+size[i]+"\t"+start[i]+"\t"+end[i]+"\t"+flag[i]);
		}
	}
	public static void allocate(int i)
	{
		int temp=0;
		for(int j=1;j<=3;j++)
		{
			if(flag[i]==0 && ctr<3)
			{
				temp=part*j;
				if(size[i]<=temp)
				{
					if(status[ctr]==0)
					{
						for(int k=1;k<=j;k++)
						{
							mem[k-1]=proc[i];
							status[k-1]=1;
							ctr=ctr+(k);
						}
						start[i]=st;
						end[i]=st+temp;
						st=end[i];
						System.out.println("Process:= "+ proc[i]+" allocated");
						flag[i]=1;
						break;
					}
				}
			}
		}
	}
	public static void main(String args[]) throws IOException
	{
		int maxtime,z,gflag=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter the number of processes:- ");
		no=sc.nextInt();
		proc=new char[no];
		size=new int[no];
		time=new int[no];
		flag=new int[no];
		start=new int[no];
		end=new int[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter process "+ (i+1) +" information:- ");
			proc[i]=(char)System.in.read();
			size[i]=sc.nextInt();
			time[i]=sc.nextInt();
			flag[i]=0;
		}
		display();
		for(int i=0;i<no;i++)
		{
			if(memory<size[i])
			{
				System.out.println("Process:= "+proc[i]+" too large for memory......Skipping");
				flag[i]=1;
				continue;
			}
			allocate(i);
		}
		display();
		maxtime=findmaxtime();
		while(gflag==0)
		{
			for(int i=1;i<=maxtime;i++)
			{
				System.out.println("Time:- "+i);
				z=checktodeallocate(i);
				if(z==1)
				{
					display();
					for(int k=0;k<no;k++)
					{
						if(flag[k]==0)
						{
							allocate(k);
							display();
						}
						else
						{
							gflag=1;
						}
					}
				}
			}
		}
	}
}				
