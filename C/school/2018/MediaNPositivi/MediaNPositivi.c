#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int x,i=0,n,s=0,m,cp=0;
	
	printf("Di quanti numeri vuoi calcolare la media? = ");
	scanf("%d",&n);
	
	while(i<n)
	{
		printf("Inserire il numero %d\n",i);
		scanf("%d",&x);
		
		if(x>0)
		{
			s=s+x;
			cp++;			
		}
		
		i++;
	}

	m=s/cp;

	printf("Media numeri positivi = %d",m);

	return 0;
}