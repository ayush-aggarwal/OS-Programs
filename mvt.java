import java.io.*;
import java.util.*;
public class mvt
{
	static int no,memory=500,mavai=500,malloc=0,st=0;
	static char proc[];
	static int size[];
	static int time[];
	static int start[];
	static int end[];
	static int flag[];
	public static int deallocate(int t)
	{
		int flg=0,temp;
		for(int i=0;i<no;i++)
		{
			if(time[i]==t)
			{
				flg=1;
				temp=size[i];
				mavai=mavai+temp;
				malloc=malloc-temp;
				st=st-temp;
				for(int j=i+1;j<no;j++)			//shift
				{
					if(flag[j]==1)
					{
					start[j]=start[j]-temp;
					end[j]=end[j]-temp;
					}
				}
			}
		}
		return flg;
	}
	public static int findmaxtime()
	{
		int t=time[0];
		for(int i=0;i<no;i++)
		{
			if(time[i]>t && flag[i]==1)
			{
				t=time[i];
			}
		}
		return t;
	}
	public static void allocate(int p)
	{
		if(size[p]<=mavai)
		{
			start[p]=st;
			end[p]=start[p]+size[p];
			st=end[p];
			malloc=malloc+size[p];
			mavai=mavai-size[p];
			flag[p]=1;
			System.out.println("Process:= "+proc[p]+" allocated");
		}
	}
	public static void display()
	{
		System.out.println("Process\tSize\tTime\tStart\tEnd\tFlag");
		for(int i=0;i<no;i++)
		{
			System.out.println(proc[i]+"\t"+size[i]+"\t"+time[i]+"\t"+start[i]+"\t"+end[i]+"\t"+flag[i]);
		}
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int maxtime,z,gflag=0;
		System.out.println("Please enter the number of process:- ");
		no=sc.nextInt();
		proc=new char[no];
		size=new int[no];
		time=new int[no];
		start=new int[no];
		end=new int[no];
		flag=new int[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter process "+(i+1)+" information:- ");
			proc[i]=(char)System.in.read();
			size[i]=sc.nextInt();
			time[i]=sc.nextInt();
			flag[i]=0;
		}
		display();
		for(int i=0;i<no;i++)
		{
			if(size[i]>memory)
			{
				System.out.println("Process too large..........Skipping");
				flag[i]=1;
				continue;
			}
			allocate(i);
		}
		display();
		maxtime=findmaxtime();
		//System.out.println(maxtime);
		while(gflag==0)
		{
		for(int i=1;i<=maxtime;i++)
			{
				System.out.println("Time:- "+i);
				z=deallocate(i);
				if(z==1)
				{
					for(int j=0;j<no;j++)
					{
						if(flag[j]==0)
						{
							allocate(j);
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
