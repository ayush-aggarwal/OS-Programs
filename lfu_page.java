import java.io.*;
import java.util.*;
public class lfu_page
{
	public static int row,mapvar=0;
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
	public static void mapadd(int map[][],int no)
	{
		for(int j=0;j<mapvar;j++)
		{
			if(map[j][0]==no)
			{
				map[j][1]=map[j][1]+1;
			}
		}
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
	public static int findlfupos(int pt[],int map[][])
	{
		int s=map[0][1],no1=map[0][0],z,pos=0;
		for(int i=0;i<mapvar;i++)
		{
			z=check(pt,map[i][0]);
			if(z==1)
			{
				if(map[i][1]<s && map[i][1]!=0)
				{
					s=map[i][1];
					no1=map[i][0];
				}
			}
		}
		for(int j=0;j<row;j++)
		{
			if(pt[j]==no1)
			{
				pos=j;
				break;
			}
		}
		return pos;
	}
	public static void main(String args[]) throws IOException
	{
		int no,fault=0,t,flg=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the number of rows in page table:- ");
		row=sc.nextInt();
		int pt[]=new int[row];
		System.out.println("Please enter the total number of pages:- ");
		no=sc.nextInt();
		int pgarr[]=new int[no];
		int map[][]=new int[5][2];
		System.out.println("Please enter the page information:-");
		for(int i=0;i<no;i++)
		{
			t=sc.nextInt();
			pgarr[i]=t;
			flg=0;
			for(int j=0;j<mapvar;j++)
			{
				if(map[j][0]==t)
				{
					flg=1;
					break;
				}
			}
			if(flg==0)
			{
				map[mapvar][0]=t;
				mapvar=mapvar+1;
			}
		}
		int k=0,j=0,pos,z;
		while(k<row)
		{
			z=check(pt,pgarr[j]);
			mapadd(map,pgarr[j]);
			if(z==0)
			{
				pt[k]=pgarr[j];
				k=k+1;
				display(pt);
			}
			j=j+1;
		}
		for(int i=j;i<no;i++)
		{
			z=check(pt,pgarr[i]);
			if(z==1)
				mapadd(map,pgarr[i]);
			else if(z==0)
			{
				pos=findlfupos(pt,map);
				mapadd(map,pgarr[i]);
				pt[pos]=pgarr[i];
				display(pt);
				fault=fault+1;
			}
		}
		System.out.println("Total Page Faults:- "+fault);
	}
}
