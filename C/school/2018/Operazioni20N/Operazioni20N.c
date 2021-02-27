/*Scrivere un programma tale che:
1. Chiede in input 20 numeri
2. Calcoli e restituisca la somma dei
numeri negativi inseriti al passo 1
3. Calcoli e restituisca il prodotto
dei numeri positivi inseriti al passo 1
4. Calcoli e restituisca il più piccolo
dei numeri inseriti al passo 1
5. Calcoli e restituisca il più grande
dei numeri inseriti al passo 1
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int x,i,sn=0,pp=1,min,max;
	int c1=0;

	printf("\nInserire il numero %d: ",c1);
	scanf("%d",&x);

	c1++;
	min=x;
	max=x;

	for(i=0; i<19; i++)
	{
		printf("\nInserire il numero %d: ",c1);
		scanf("%d",&x);

		c1++;
	
		if(x<0)
		{
			sn=sn+x;
		}
		else
		{
			pp=pp*x;
		}

		if(x<min)
		{
			min=x;
		}
		else if(x>max)
		{
			max=x;
		}
	}

	printf("\nLa somma dei numeri negativi \x82: %d",sn);
	printf("\nIl prodotto dei numeri positivi \202: %d",pp);
	printf("\nIl numero minore \x82: %d",min);
	printf("\nIl numero maggiore \x82: %d\n",max);

	return 0;
}