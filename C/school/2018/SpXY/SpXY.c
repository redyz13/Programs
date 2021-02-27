/*Scrivere un programma tale che:
1. Chiede in input un numero n positivo
2. Chiede in input n coppie di numeri x
ed y con y>x
3. Per ogni coppia inserita al passo 2
calcoli e restituisca la media dei numeri
pari compresi tra x ed y.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[])
{
	int n,x,y;
	int sp=0,i=0;

	do
	{
		printf("\nInserire un numero (n) positivo: ");
		scanf("%d",&n);
	}
	while(n<=0);

	while(i<n)
	{
		do
		{
			printf("\nInserire una coppia (x;y) con y>=x: ");
			scanf("%d;%d",&x,&y);	
		}
		while(y<x);

		while(x<=y)
		{
			if(x%2==0)
			{
				sp=sp+x;
			}

			x++;
		}
	
		i++;
	}

	printf("\nSomma numeri pari delle sequenze = %d\n",sp);

	return 0;
}