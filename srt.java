import java.io.*;
import java.util.*;
public class srt
{
	public static void main(String args[]) throws IOException
	{
		char proc[]=new char[100];
		int arrtime[]=new int[100];
		int servtime[]=new int[100];
		int starttime[]=new int[100];
		int fintime[]=new int[100];
		int waittime[]=new int[100];
		int turntime[]=new int[100];
		float ratio[]=new float[100];
		int flag[]=new int[100];
		int copyserv[]=new int[100];
		int no,a;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of processes:- ");
		no=sc.nextInt();
		for(int i=0;i<no;i++)
		{
			a=i+1;
			System.out.println("Enter Process "+a+" Information:- ");
			proc[i]=(char)System.in.read();
			arrtime[i]=sc.nextInt();
			servtime[i]=sc.nextInt();
			copyserv[i]=servtime[i];
			flag[i]=0;
		}
		int job=0,time=0;
		loopback:for(int k=0;k<no;time++)
		{
			for(int j=0;j<no && arrtime[j]<=time;j++)
			{
				if(copyserv[j]!=0 && (copyserv[j]<copyserv[job]|| copyserv[job]==0))
				{
					job=j;
					if(copyserv[job]==0)
					{
						time=time-1;
						continue loopback;
					}
				}
			}
			if(flag[job]==0)
			{
				starttime[job]=time;
				flag[job]=1;
			}
			copyserv[job]-=1;
			if(copyserv[job]==0)
			{
				fintime[job]=time+1;
				waittime[job]=fintime[job]-servtime[job]-arrtime[job];
				turntime[job]=waittime[job]+servtime[job];
				ratio[job]=(float)(turntime[job]/servtime[job]);
				k+=1;
			}
		}
	System.out.println("Process\tArrival\tService\tStart\tFinish\tWait\tTurn\tRatio");
	for(int i=0;i<no;i++)
	{
	System.out.println(proc[i]+"\t"+arrtime[i]+"\t"+servtime[i]+"\t"+starttime[i]+"\t"+fintime[i]+"\t"+waittime[i]+"\t"+turntime[i]+"\t"+ratio[i]);
	}
	}
}

