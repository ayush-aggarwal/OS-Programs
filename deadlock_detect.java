import java.io.*;
import java.util.*;
public class deadlock_detect
{
	public static void main(String args[])
	{
		int r,p,s=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the number of Processes:- ");
		p=sc.nextInt();
		System.out.println("Please enter the number of resources:- ");
		r=sc.nextInt();
		int req[][]=new int[p][r];
		int alloc[][]=new int[p][r];
		int resource[]=new int[r];
		int available[]=new int[r];
		int w[]=new int[r];
		int flg[]=new int[p];
		System.out.println("Please enter Required Matrix:- \n");
		for(int i=0;i<p;i++)
		{
			for(int j=0;j<r;j++)
			{
				req[i][j]=sc.nextInt();
			}
		}
		System.out.println("Please enter Allocation Matrix:- \n");
		for(int i=0;i<p;i++)
		{
			for(int j=0;j<r;j++)
			{
				alloc[i][j]=sc.nextInt();
			}
		}
		System.out.println("\nPlease enter Resorce Matrix:- \n");
		for(int i=0;i<r;i++)
		{
			resource[i]=sc.nextInt();
		}
		System.out.println("Available Matrix:- \n");
		for(int j=0;j<r;j++)
		{
			for(int i=0;i<p;i++)
			{
				s=s+alloc[i][j];
			}
			available[j]=resource[j]-s;
			w[j]=resource[j]-s;
			System.out.println(available[j]+"\n");
			s=0;
		}
		for(int i=0;i<p;i++)
		{
			for(int j=0;j<r;j++)
			{
				if(alloc[i][j]==0)
				{
					flg[i]=1;
				}
				else
				{
					flg[i]=0;
					break;
				}
			}
			System.out.println(flg[i]);
		}
		
		
			
	}
}
		
