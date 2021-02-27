#include <stdio.h>
#include <math.h>

int main()
{
	
	#define LIMIT 16385
	int x=2,c=1;

	printf("\nPotenze di 2 fino a 2^14:\n\n");

	while(x<LIMIT)
	{
		printf("\t2^%d\t=\t%d\n",c,x);

		x=x*2;
		c++;
	}
}