#include<stdio.h>
#include<stdlib.h>
int memory=30,min=1,max=30,nop,ctr=0,mapvar=0,loop=0,a;
char proc[15];
int size[15];
int flg[15];
int map[30];
struct node
{
	int no;
	struct node *next[29];
}*newptr,*ptr1;
struct node *create_new_node(int);
int call(int min,int max);
void display(struct node *,int);
void disp(int);
void display1();
int main()
{
	int z,y;
	int te=65;
	printf("\nPlease enter the number of files:- ");
	scanf("%d",&nop);
	for(z=0;z<nop;z++)
	{
		proc[z]=(char)te;
		te=te+1;
		printf("\nPlease Enter the file %d size in blocks:- ",z+1);
		scanf("%d",&size[z]);
		flg[z]=0;
	}
	for(y=0;y<nop;y++)
	{
		if(ctr+size[y]+1<=memory)
		{
		newptr=create_new_node(size[y]);
		flg[y]=1;
		disp(y);
		display(newptr,size[y]);
		newptr=NULL;
		}
		else
		{
			printf("\nFile %c cannot be allocated....Skipping...",proc[y]);
			continue;
		}
	}
	printf("\nTotal Memory Blocks Acquired:- %d\n",ctr);
	return 0;
}
struct node * create_new_node(int s)
{
	int i,temp;
	struct node * ptr;
	ptr=malloc(sizeof(struct node));
	ctr=ctr+1;
	temp=call(min,max);
	ptr->no=temp;
	map[mapvar]=ptr->no;
	mapvar=mapvar+1;
	for(i=0;i<s;i++)
	{
		ctr=ctr+1;
		ptr1=malloc(sizeof(struct node));
		temp=call(min,max);
		ptr1->no=temp;
		map[mapvar]=ptr1->no;
		mapvar=mapvar+1;
		ptr->next[i]=ptr1;
	}
	return ptr;
}	
int call(int min,int max)
{
	int f=0;
	a=rand() % (max-min+1) + min;
	for(loop=0;loop<mapvar;loop++)
	{
		if(map[loop]==a)
		{
			f=1;
			break;
		}
		else
		{
			f=0;
		}
	}
	if(f==1)
	{
		a=call(min,max);
	}
	else
	{
		return a;
	}
}
void disp(int i)
{
	printf("\nFile\tSize\tFlag\tIndex Locations\n");
	printf("%c\t%d\t%d\t",proc[i],size[i],flg[i]);
}
void display(struct node *p,int s)
{
	int i;
	for(i=0;i<s;i++)
	{
		printf("%d->%d,",p->no,p->next[i]->no);
	}
	printf("\n");
}
