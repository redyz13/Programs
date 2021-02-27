/*Scrivere un programma tale che:
1. Chiede in input un numero a ed un numero b maggiore di a.
2. Chiede in input un numero n positivo.
3. Chiede in input una sequenza di numeri fino a che non contenga
n numeri compresi tra a e b
4. Calcoli e restituisca la media di tutti i numeri della sequenza
inserita al passo 3, che risultano esterni all'intervallo a-b.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int a,b,n,i=0,ns,s=0,c=1,m,cnc=0;
	
	printf("Inserire il numero a: ");
	scanf("%d",&a);
	printf("Inserire il numero b: ");
	scanf("%d",&b);
	printf("Inserire un numero n positivo: ");
	scanf("%d",&n);

	while(a>b)
	{
		printf("Il numero a deve essere < di b, reinserisci a: ");
		scanf("%d",&a);
	}
	while(n<0)
	{
		printf("Il numero n deve essere > 0, reinserisci n: ");
		scanf("%d",&n);	
	}
	
	printf("\n");
	printf("Inserire una sequenza fino a quando non contenga n numeri compresi tra a e b:\n");
	printf("\n");

	while(i<n)
	{
		printf("%d. = ",c);
		scanf("%d",&ns);

		if(ns<=b && ns>=a)
		{
			i++;
		}
		else
		{
			s+=ns;
			cnc++;
		}

		c++;
	
	}

	m=s/cnc;

	printf("\nMedia numeri inseriti non compresi tra a e b = %d",m);

	return 0;
}