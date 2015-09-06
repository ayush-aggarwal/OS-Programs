import java.io.*;
import java.util.*;
public class priority
{
	public static void main(String args[]) throws IOException
	{
		char proc[]=new char[100];
		int arrtime[]=new int[100];
		int servtime[]=new int[100];
		int starttime[]=new int[100];
		int fintime[]=new int[100];
		int waittime[]=new int[100];
		int flag[]=new int[100];
		int priority[]=new int[100];
		int turntime[]=new int[100];
		float ratio[]=new float[100];
		int no;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of processes:- ");
		no=sc.nextInt();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter Process "+(i+1)+" information");
			proc[i]=(char)System.in.read();
			arrtime[i]=sc.nextInt();
			servtime[i]=sc.nextInt();
			priority[i]=sc.nextInt();
		}
		int temp=0,pos,small;
		for(int z=0;z<no;z++)
		{
			if(flag[z]==0)
			{
			if(z==0)
			{
				starttime[z]=0;
				fintime[z]=servtime[z];
				temp=fintime[z];
				flag[z]=1;
				waittime[z]=0;
				turntime[z]=servtime[z]+waittime[z];
				ratio[z]=(float)turntime[z]/servtime[z];
			}
			else
			{
				small=priority[z];
				pos=z;
				for(int j=0;j<no;j++)
				{
					if(flag[j]==0 && arrtime[j]<temp)
					{
						if(priority[j]<small)
						{
							small=priority[j];
							pos=j;
						}
					}
				}
				//System.out.println(pos+"sh"+temp);
				starttime[pos]=temp;
				fintime[pos]=servtime[pos]+starttime[pos];
				temp=fintime[pos];
				waittime[pos]=starttime[pos]-arrtime[pos];
				turntime[pos]=servtime[pos]+waittime[pos];
				ratio[pos]=(float)turntime[pos]/servtime[pos];
				flag[pos]=1;
			}
			}
		}
		for(int m=0;m<no;m++)
		{
			if(flag[m]==0)
			{
				starttime[m]=temp;
				fintime[m]=servtime[m]+starttime[m];
				temp=fintime[m];
				waittime[m]=starttime[m]-arrtime[m];
				turntime[m]=servtime[m]+waittime[m];
				ratio[m]=(float)(turntime[m]/servtime[m]);
				flag[m]=1;
			}
		}
		System.out.println("Process\tArrival\tService\tPriority\tStart\tFinish\tWait\tTurn\tRatio\t\tFlag");
		for(int l=0;l<no;l++)
		{
			System.out.println(proc[l]+"\t"+arrtime[l]+"\t"+servtime[l]+"\t"+priority[l]+"\t\t"+starttime[l]+"\t"+fintime[l]+"\t"+waittime[l]+"\t"+turntime[l]+"\t"+ratio[l]+"\t\t"+flag[l]);
		}
	}
}
