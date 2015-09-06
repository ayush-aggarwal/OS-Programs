import java.io.*;
import java.util.*;
public class rrb2
{
	static char queue[]=new char[100];
	static int qsize=0;
	static void enqueue(char a)
	{
		queue[qsize]=a;
		qsize=qsize+1;
	}
	static char dequeue()
	{
		char a=queue[0];
		for(int i=0;i<qsize;i++)
		{
			queue[i]=queue[i+1];
		}
		qsize=qsize-1;
		return a;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		char proc[]=new char[100];
		int arrtime[]=new int[100];
		int servtime[]=new int[100];
		int copyserv[]=new int[100];
		int starttime[]=new int[100];
		int fintime[]=new int[100];
		int waittime[]=new int[100];
		int turntime[]=new int[100];
		int flag[]=new int[100];
		float ratio[]=new float[100];
		int no,quant;
		System.out.println("Please Enter the number of processes:- ");
		no=sc.nextInt();
		System.out.println("Please Enter quantum time:- ");
		quant=sc.nextInt();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter process "+(i+1)+" information:- ");
			proc[i]=(char)System.in.read();
			arrtime[i]=sc.nextInt();
			servtime[i]=sc.nextInt();
			copyserv[i]=servtime[i];
		}
		enqueue(proc[0]);
		int c=1,job=0,time=0,p=0;
		char pr;
		while(p<no)
		{
			pr=dequeue();
			for(int z=0;z<no;z++)
			{
				if(proc[z]==pr)
				{
					job=z;
					break;
				}
			}
			if(flag[job]==0)
			{
				flag[job]=1;
				starttime[job]=time;
			}
			if(copyserv[job]>=quant)
			{
				copyserv[job]-=quant;
				time=time+quant;
			}
			else
			{
				time=time+copyserv[job];
				copyserv[job]=0;
			}
			while(c<no && arrtime[c]<=time)
			{
				enqueue(proc[c]);
				c=c+1;
			}
			if(copyserv[job]>0)
			{
				enqueue(proc[job]);
			}
			else
			{
				p+=1;
				fintime[job]=time;
				waittime[job]=fintime[job]-arrtime[job]-servtime[job];
				turntime[job]=servtime[job]+waittime[job];
				ratio[job]=(float)turntime[job]/servtime[job];
			}
		}
		System.out.println("Process\tArrival\tService\tStart\tFinish\tWait\tTurn\tRatio");
		for(int z=0;z<no;z++)
		{
			System.out.println(proc[z]+"\t"+arrtime[z]+"\t"+servtime[z]+"\t"+starttime[z]+"\t"+fintime[z]+"\t"+waittime[z]+"\t"+turntime[z]+"\t"+ratio[z]);
		}
	}
}
			
		
		
			
