import java.io.*;
import java.util.*;
import java.lang.*;
public class sdf
{
	public static void main(String args[]) throws IOException
	{
		char proc[]=new char[100];
		int arrtime[]=new int[100];
		int servtime[]=new int[100];
		int flag[]=new int[100];
		int starttime[]=new int[100];
		int fintime[]=new int[100];
		int waittime[]=new int[100];
		int turntime[]=new int[100];
		float ratio[]=new float[100];
		int no,temp=0,pos,small;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Processes:- ");
		no=sc.nextInt();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter Process "+i+" Information");
			proc[i]=(char)System.in.read();
			arrtime[i]=sc.nextInt();
			servtime[i]=sc.nextInt();
			flag[i]=0;
		}
		for(int k=0;k<no;k++)
		{
			if(flag[k]==0)
			{
				if(k==0)
				{
					starttime[k]=arrtime[k];
					waittime[k]=0;
					fintime[k]=arrtime[k]+servtime[k];
					flag[k]=1;
					temp=fintime[k];
					turntime[k]=waittime[k]+servtime[k];
					ratio[k]=(float)(turntime[k]/servtime[k]);
				}
				else
				{
					small=servtime[k];
					pos=k;
					for(int h=0;h<no;h++)
					{
						if(flag[h]==0 && arrtime[h]<temp)
						{
							if(servtime[h]<small)
							{
								small=servtime[h];
								pos=h;
								//System.out.println(small);
							}
						}
					}
					//System.out.println(pos);
					starttime[pos]=temp;
					fintime[pos]=servtime[pos]+starttime[pos];
					temp=fintime[pos];
					waittime[pos]=starttime[pos]-arrtime[pos];
					turntime[pos]=servtime[pos]+waittime[pos];
					ratio[pos]=(float)(turntime[pos]/servtime[pos]);
					flag[pos]=1;
				}
			}
		}
		//System.out.println(temp);
		for(int l=0;l<no;l++){
		if(flag[l]==0)
		{
		starttime[l]=temp;
		fintime[l]=servtime[l]+starttime[l];
		temp=fintime[l];
		waittime[l]=starttime[l]-arrtime[l];
		turntime[l]=servtime[l]+waittime[l];
		ratio[l]=(float)(turntime[l]/servtime[l]);
		flag[l]=1;
		}
		}
		System.out.println("Process\tArrival\tService\tStart\tFinish\tWait\tTurn\tRatio\tFlag");
		for(int j=0;j<no;j++)
		{
			System.out.println(proc[j]+"\t"+arrtime[j]+"\t"+servtime[j]+"\t"+starttime[j]+"\t"+fintime[j]+"\t"+waittime[j]+"\t"+turntime[j]+"\t"+ratio[j]+"\t"+flag[j]);
		}	
	}
}
