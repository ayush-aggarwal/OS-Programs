#include<stdio.h>
#include<math.h>
#include<stdlib.h>
int ctr=0,nop,mapvar=0,loop,mem=30;
char proc[15];
int size[15];
int begin[15];
int end[15];
int flg[15];
int map[30];
struct Node
{
	int no;
	struct Node *next;
}*start,*newptr,*ptr,*rear;
struct Node* create_new_node(int n);
int insert(struct Node*);
int disp(int z);
int display(struct Node*);
int call(int min,int max);
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
	start=rear=NULL;
	int a,j,random,f=0;
	int min=1,max=30;
	for(y=0;y<nop;y++)
	{
	for(j=0;j<size[y];j++)
	{
		if(ctr<mem)
		{
		random=call(min,max);
		for(loop=0;loop<mapvar;loop++)
		{
			if(random==map[loop])
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
			j=j-1;
			continue;
		}
		else
		{
			map[mapvar]=random;
			mapvar=mapvar+1;
		}
		newptr=create_new_node(random);
		insert(newptr);
		}
		else
		{
			printf("\nCaution: Memory Full\n");
			exit(0);
		}
	}
	flg[y]=1;
	begin[y]=start->no;
	end[y]=rear->no;
	disp(y);
	display(start);
	start=rear=NULL;
	}
	printf("Memory Nodes Number:- %d\n",ctr);
	return 0;
}
int call(int min,int max)
{
	int a,f=0;
	a=rand() % (max-min+1) + min;
	return a;
}
struct Node* create_new_node(int n)
{
	ptr=malloc(sizeof(struct Node));
	ctr=ctr+1;
	ptr->no=n;
	ptr->next=NULL;
	return ptr;
}
int insert(struct Node* np)
{
	if(start==NULL)
	{
		start=rear=np;
	}
	else
	{
		rear->next=np;
		rear=np;
	}
	return 0;
}
int disp(int z)
{
	printf("\nFile\tSize\tStart\tEnd\tFlag\n");
	printf("%c\t%d\t%d\t%d\t%d\n",proc[z],size[z],begin[z],end[z],flg[z]);
	return 0;
}
int display(struct Node* np)
{
	while(np!=NULL)
	{
		printf("%d->",np->no);
		np=np->next;
	}
	printf("NULL\n");
	return 0;
}
