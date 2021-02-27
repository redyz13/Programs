/*Scrivere un programma tale che:
1. Chiede in input un numero positivo np
2. Chiede in input un numero negativo nn
3. Chiede in input una sequenza numerica fino
a che la sequenza non contenga almeno np numeri
positivi ed almeno nn numeri negativi.
4. Calcoli e restituisca le medie dei numeri
positivi e negativi inseriti.
N.B. Calcolare medie esatte.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int np,nn,c=0,sep=0,sen=0;
	float x,sp=0,sn=0,mp,mn,cp=0,cn=0;

	do
	{
		printf("\nInserire un numero positivo (np): ");
		scanf("%d",&np);
	}
	while(np<=0);

	do
	{
		printf("\nInserire un numero negativo (nn): ");
		scanf("%d",&nn);
	}
	while(nn>=0);

	printf("\nInserire una sequenza fino a che la sequenza\n"
	"non contenga almeno np numeri positivi ed\n"
	"almeno nn numeri negativi\n\n");

	while(sep<np || sen>nn)//hello hello hello how low
	{
		printf("%d\xF8\t=\t",++c);
		scanf("%f",&x);

		if(x>0)
		{
			cp++;
			sep++;
			sp+=x;
		}
		else if(x<0)
		{
			cn++;
			sen--;
			sn+=x;
		}
	
	}

	mp=sp/cp;
	mn=sn/cn;

	printf("\n\nMedia Positivi = %f",mp);
	printf("\nMedia Negativi = %f\n\n",mn);

	return 0;
}