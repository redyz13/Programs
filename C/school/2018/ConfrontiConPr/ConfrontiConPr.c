/*Scrivere un programma tale che, dati in input
una sequenza di 6 numeri, calcoli e restituisca
quante volte accade che un numero risulta maggiore
e minore del predecessore.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int x,xp,cmax=0,cmin=0,cq=1;
	const int low=-2147483648;

	printf("Inserire il %d numero: ",cq);
	scanf("%d",&x);

	cq++;

	if(x>low)
	{
		xp=x;
	}

	printf("Inserire il %d numero: ",cq);
	scanf("%d",&x);

	cq++;	

	if(x<xp)
	{
		cmin++;
	}
	else if(x>xp)
	{
		cmax++;
	}

	xp=x;

	printf("Inserire il %d numero: ",cq);
	scanf("%d",&x);

	cq++;

	if(x<xp)
	{
		cmin++;
	}
	else if(x>xp)
	{
		cmax++;
	}

	xp=x;

	printf("Inserire il %d numero: ",cq);
	scanf("%d",&x);

	cq++;

	if(x<xp)
	{
		cmin++;
	}
	else if(x>xp)
	{
		cmax++;
	}

	xp=x;

	printf("Inserire il %d numero: ",cq);
	scanf("%d",&x);

	cq++;

	if(x<xp)
	{
		cmin++;
	}
	else if(x>xp)
	{
		cmax++;
	}

	xp=x;

	printf("Inserire il %d numero: ",cq);
	scanf("%d",&x);

	cq++;	

	if(x<xp)
	{
		cmin++;
	}
	else if(x>xp)
	{
		cmax++;
	}

	printf("\nI numeri sono risultati minori del predecessore %d volte e maggiori %d volte\n",cmin,cmax);

	return 0;
}