import java.util.*;
import java.io.*;
public class lru_page
{
	public static int row;
	public static int findlrupos(int p,int pt[],int pgarr[])
	{
		int po,s=0;
		int temp[]=new int[row];
		for(int i=0;i<row;i++)
		{
			for(int j=p;j>0;j--)
			{
				if(pt[i]==pgarr[j])
				{
					temp[i]=j;
					break;
				}
			}
		}
		s=temp[0];
		po=0;
		for(int k=0;k<row;k++)
		{
			if(temp[k]<s)
			{
				s=temp[k];
				po=k;
			}
		}
		//System.out.println(s);
		return po;
	}
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
		int k=0,j=0,pos,z;
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
				pos=findlrupos(i,pt,pgarr);
				pt[pos]=pgarr[i];
				display(pt);
				//System.out.println(pos);
				fault=fault+1;
			}
		}
		System.out.println("Total Page Faults:- "+fault);	
	}
}
