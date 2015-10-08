import java.io.*;
import java.util.*;
public class fcfs
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int no;
		System.out.println("Please enter the number of processes:- ");
		no=sc.nextInt();
		char proc[]=new char[no];
		int arr[]=new int[no];
		int serv[]=new int[no];
		int start[]=new int[no];
		int finish[]=new int[no];
		int wait[]=new int[no];
		int turn[]=new int[no];
		float ratio[]=new float[no];
		for(int i=0;i<no;i++)
		{
			System.out.println("Please Enter Process "+(i+1)+" information:- ");
			proc[i]=(char)System.in.read();
			arr[i]=sc.nextInt();
			serv[i]=sc.nextInt();
		}
		System.out.println("Process\tArrival\tService\tStart\tFinish\tWait\tTurn\tRatio");
		for(int i=0;i<no;i++)
		{
			if(i==0)
				start[i]=0;
			else
				start[i]=finish[i-1];
			finish[i]=start[i]+serv[i];
			wait[i]=start[i]-arr[i];
			turn[i]=wait[i]+serv[i];
			ratio[i]=(float)turn[i]/(float)serv[i];
			System.out.println(proc[i]+"\t"+arr[i]+"\t"+serv[i]+"\t"+start[i]+"\t"+finish[i]+"\t"+wait[i]+"\t"+turn[i]+"\t"+ratio[i]);
		}
	}
}	
