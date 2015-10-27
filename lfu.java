import java.io.*;
import java.util.*;
public class lfu
{
	public static int frame;
	public static int pgarr[];
	public static int pt[];
	public static int findlfupos(int pgarr[],int pt[],int pos)
	{
		int temp[]=new int[frame];
		for(int i=0;i<frame;i++)
		{
			for(int j=pos;j>=0;j--)
			{
				if(pt[i]==pgarr[j])
				{
					temp[i]=temp[i]+1;
				}
			}
		}
		int s=temp[0],p=0;
		for(int k=0;k<frame;k++)
		{
			if(temp[k]<s)
			{
				s=temp[k];
				p=k;
			}
		}
		return p;
	}
	public static int check(int no,int pt[])
	{
		for(int i=0;i<frame;i++)
			if(pt[i]==no)
				return 1;
		return 0;
	}
	public static void display(int pt[])
	{
		System.out.println("Queue Status: -");
		for(int i=0;i<frame;i++)
		{
			System.out.print(pt[i]+"\t");
		}
		System.out.println();
	}			
	public static void main(String args[]) throws IOException
	{
		int no;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of page frames:- ");
		frame=sc.nextInt();
		pt=new int[frame];
		System.out.println("Please enter the number of page references:- ");
		no=sc.nextInt();
		pgarr=new int[no];
		System.out.println("Please enter the page references:- ");
		for(int i=0;i<no;i++)
		{
			pgarr[i]=sc.nextInt();
		}
		int k=0,j=0,z,pos,fault=0;
		while(k<frame)
		{
			z=check(pgarr[j],pt);
			if(z==0)
			{
				pt[k]=pgarr[j];
				display(pt);
				k=k+1;
			}
			j=j+1;
		}
		for(int i=j;i<no;i++)
		{
			z=check(pgarr[i],pt);
			if(z==0)
			{
				pos=findlfupos(pgarr,pt,i-1);
				pt[pos]=pgarr[i];
				fault=fault+1;
			}
			display(pt);
		}
		System.out.println("Total Page Faults:- "+fault);
	}
}
