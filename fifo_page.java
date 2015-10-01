import java.io.*;
import java.util.*;
public class fifo_page
{
	public static int row;
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
		int k;
		for(k=0;k<row;k++)
		{
			pt[k]=pgarr[k];
			display(pt);
		}
		fault=fault+1;
		for(int i=k;i<no;i++)
		{
			pt[0]=pgarr[i];
			display(pt);
			fault=fault+1;
		}
		System.out.println("Total Page Faults:- "+fault);		
	}
}

		
			
