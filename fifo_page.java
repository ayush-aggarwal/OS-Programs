import java.io.*;
import java.util.*;
public class fifo_page
{
	public static int row;
	public static int check(int pt[],int no)
	{
		for(int i=0;i<row;i++)
		{
			if(pt[i]==no)
			{
				return 1;
			}
		}
		return 0;
	}
	public static void display(int pt[])
	{
		System.out.println("Stack Status:- ");
		for(int i=0;i<row;i++)
		{
			System.out.print(pt[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String args[]) throws IOException
	{
		int no,fault=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the number of rows in page table:- ");
		row=sc.nextInt();
		int pt[]=new int[row];
		System.out.println("Please enter the total number of pages:- ");
		no=sc.nextInt();
		int pgarr[]=new int[no];
		System.out.println("Please enter the page information:-");
		for(int i=0;i<no;i++)
		{
			pgarr[i]=sc.nextInt();
		}
		int k=0,z,j=0;
		while(k<row)
		{
			z=check(pt,pgarr[j]);
			if(z==0)
			{
				pt[k]=pgarr[j];
				k=k+1;
				display(pt);
			}
			j=j+1;
		}
		fault=fault+1;
		for(int i=j;i<no;i++)
		{
			z=check(pt,pgarr[i]);
			if(z==0)
			{
				pt[0]=pgarr[i];
				display(pt);
				fault=fault+1;
			}
		}
		System.out.println("Total Page Faults:- "+fault);		
	}
}

		
			
