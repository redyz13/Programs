/*Scrivere un programma tale che, data in input
una sequenza di 50 numeri, calcoli e restituisca
la lunghezza della maggiore sottosequenza strettamente
crescente presente nella sequenza stessa.
*/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int main(int argc, const char * argv[])
{
	const int LS=10;
	int x,c=1,i=0,nms=0,y=INT_MIN,nc=INT_MIN;

	printf("\nInserire una sequenza di %d numeri:\n\n",LS);

	while(i<LS)
	{
		printf("%d\xF8 Numero\t=\t",c),scanf("%d",&x);

		if(x>y)
		{
			nms++;
			y=x;

			if(nms>nc)
			{
				nc=nms;
			}
			
		}
		else if(x<=y)
		{
			nms=0;
			nms++;
			y=x;
		}
	
		c++;
		i++;
	}
	
	printf("\nLa lunghezza della sottosequenza maggiore \x82 %d\n\n",nc);
	
	system("pause");
	return 0;
}