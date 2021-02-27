/*Scrivere un programma tale che, dati in input
6 numeri calcoli e restituisca:
1. La media dei positivi
2. La media dei negativi
3. La media dei numeri pari
4. La media dei numeri dispari
N.B. I valori delle medie devono essere
numeri decimali con la virgola.
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h> //fmod

int main(int argc, const char * argv[])
{
	int i=0,cp=0,cn=0,cpa=0,cdi=0;
	float sp=0,sn=0,spa=0,sdi=0;
	float x,mp,mn,mpa,mdi;

	printf("\n");

	while(i<6)
	{
		printf("Inserire un numero: ");
		scanf("%f",&x);

		if(x>=0)
		{
			cp++;
			sp=sp+x;
		}
		else
		{
			cn++;
			sn=sn+x;
		}

		if(fmod(x,2)==0 && (float)((int)x)==x) //controllo che x sia pari e intero
		{
			cpa++;
			spa=spa+x;
		}
		else if((float)((int)x)==x)
		{
			cdi++;
			sdi=sdi+x;
		}
	
		i++;
	}

	if(cp>=1)
	{
		mp=sp/cp;
		
		printf("\nMedia Numeri Positivi = %f\n",mp);
	}

	if(cn>=1)
	{
		mn=sn/cn;

		printf("\nMedia Numeri Negativi = %f\n",mn);
	}

	if(cpa>=1)
	{
		mpa=spa/cpa;

		printf("\nMedia Numeri Pari = %f\n",mpa);
	}

	if(cdi>=1)
	{
		mdi=sdi/cdi;

		printf("\nMedia Numeri Dispari = %f\n",mdi);
	}

	return 0;
}