import java.io.*;
import java.util.*;
public class rrb
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		char proc[]=new char[100];
		int arrtime[]=new int[100];
		int servtime[]=new int[100];
		int starttime[]=new int[100];
		int fintime[]=new int[100];
		int waittime[]=new int[100];
		int turntime[]=new int[100];
		float ratio[]=new float[100];
		int check[]=new int[100];
		int no,q;
		System.out.println("Enter the no of processes:- ");
		no=sc.nextInt();
		System.out.println("Enter Quantum Time:- ");
		q=sc.nextInt();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter Process "+(i+1)+" Information:- ");
			proc[i]=(char)System.in.read();
			arrtime[i]=sc.nextInt();
			servtime[i]=sc.nextInt();
		}
		char queue[]=new char[100];
		int size=0,flag=0;
		for(int j=0;j<no;j++)
		{
			if(j==0)
			{
			starttime[j]=0;
			waittime[j]=0;
			fintime[j]=0;
			int k=1;
				while(k<=q)
				{
					if(fintime[j]<servtime[j])
					{
						fintime[j]=fintime[j]+1;
						k++;
						flag=1;
					}
					else
					{
						flag=2;
						break;
					}
				}
				if(flag==1)
				{
					queue[size]=proc[j];
					size=size+1;
				}
				if(flag==2)
				{
					waittime[j]=starttime[j]-arrtime[j];
					turntime[j]=waittime[j]+servtime[j];
					ratio[j]=(float)(turntime[j]/servtime[j]);
					check[j]=1;
				}				
			}
		}
	}
}
