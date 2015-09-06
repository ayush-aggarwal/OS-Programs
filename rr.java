import java.io.*;
import java.util.*;
public class rr
{
	static int Ar[];
	static int rear=-1;
	public static void main(String args[])
	{
		Ar=new int[5];
		int A[][]=new int[5][9];
		double ratio[]=new double[5];
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the quantum time:");
		int qt=Integer.parseInt(in.nextLine());
		System.out.println("Enter the arrival time and service time for 5 processes:-");
		for(int i=0;i<5;i++)
		{
			A[i][0]=i+1;
			String str[]=(in.nextLine()).split(" ");
			A[i][1]=Integer.parseInt(str[0]);
			A[i][2]=Integer.parseInt(str[1]);
			A[i][7]=A[i][2];
			A[i][8]=0;
		}
		int tym=0,pro,p=0,check=1;
		enq(0);
		loop:while(p<5)
		{
			pro=deq();
			/*if(pro==-1)
			{
				tym+=1;
				
				if(A[p][1]==tym)
				{
					enq(p);
				}
				continue loop;
			}*/
			if(A[pro][8]==0)
			{
				A[pro][8]=1;
				
				A[pro][3]=tym;
			}
			if(A[pro][7]>=qt)
			{
				A[pro][7]-=qt;
				tym=tym+qt;
			}
			else
			{
				tym=tym+A[pro][7];
				A[pro][7]=0;
			}
			while(check<5&&A[check][1]<=tym)
			{
				enq(check);
				check+=1;
			}
			if(A[pro][7]>0)
			{
				enq(pro);
			}
			else
			{
				p+=1;
				A[pro][4]=tym;
				A[pro][5]=A[pro][4]-A[pro][1]-A[pro][2];
				A[pro][6]=A[pro][2]+A[pro][5];
				ratio[pro]=(double)A[pro][6]/A[pro][2];
			}
		}
		System.out.println("Process\tArrival\tService\tStart\tFinish\tWait\tTurnaround Ratio");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(A[i][j]+"\t");
			}
			System.out.println("\t"+ratio[i]);
		}
	}
	static void enq(int p)
	{
		Ar[++rear]=p;
	}
	static int deq()
	{
		if(rear<=-1)
			return -1;
		else
		{
			int q=Ar[0];
			for(int i=0;i<rear;i++)
			{
				Ar[i]=Ar[i+1];	
			}
			rear-=1;
			return q;
		}
	}
}