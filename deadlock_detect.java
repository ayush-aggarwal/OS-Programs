import java.io.*;
import java.util.*;
public class deadlock_detect
{
	public static void main(String args[])
	{
		int r,p,s=0,f=0,gflag=0,ctr=0;
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
		String status[]=new String[p];
		System.out.println("Please enter Required Matrix:- \n");
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
				req[i][j]=sc.nextInt();
		System.out.println("Please enter Allocation Matrix:- \n");
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
				alloc[i][j]=sc.nextInt();
		System.out.println("\nPlease enter Resource Matrix:- \n");
		for(int i=0;i<r;i++)
			resource[i]=sc.nextInt();
		System.out.println("Available Matrix:-");
		for(int j=0;j<r;j++)
		{
			for(int i=0;i<p;i++)
				s=s+alloc[i][j];
			available[j]=resource[j]-s;
			w[j]=resource[j]-s;
			System.out.print(available[j]+"\t");
			s=0;
		}
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
			{
				if(alloc[i][j]==0)
				{
					flg[i]=1;
					status[i]="Served";
				}
				else
				{
					flg[i]=0;
					status[i]="Not Served";
					break;
				}
			}
		System.out.println("\n\t\t\tInitial Table");
		System.out.println("Process\tFlag\tStatus");
		for(int l=0;l<p;l++)
			System.out.println((l+1)+"\t"+flg[l]+"\t"+status[l]);
		int i=0;
		while(gflag==0)
		{
			if(flg[i]==0)
			{
				for(int j=0;j<r;j++)
				{
					if(req[i][j]<=w[j])
						f=1;
					else
					{
						f=0;
						break;
					}
				}
				if(f==1)
				{
					for(int j=0;j<r;j++)
						w[j]=w[j]+alloc[i][j];
					flg[i]=1;
					status[i]="Served";
				}
			}
			if(i==3)
			{
				i=0;
				ctr=ctr+1;
			}
			else
			{
				i=i+1;
				ctr=ctr+1;
			}
			if(ctr<=p*p)
			{
				for(int k=0;k<p;k++)
				{
					if(flg[k]==1)
						gflag=1;
					else
					{
						gflag=0;
						break;
					}
				}
			}
			else
			{
				System.out.println("\n\n--------Caution:- Deadlock Occured----------");
				gflag=1;
			}
		}
		System.out.println("\t\t\tFinal Table");
		System.out.println("Process\tFlag\tStatus");
		for(int l=0;l<p;l++)
			System.out.println((l+1)+"\t"+flg[l]+"\t"+status[l]);
	}
}
		
