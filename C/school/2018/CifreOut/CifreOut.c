/*Dati in input le cifre che costituiscono
un numero decimale, calcolare e restituire
il valore del numero
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n[100],c,i=0;

	printf("\nDi quante cifre \x8A il numero? : ");
	scanf("%d",&c);

	while(i<c)
	{
		printf("\nInserire la %d\xF8 cifra: ",i+1);
		scanf("%d",&n[i]);

		i++;
	}

	printf("\nNumero = ");

	for (int j=0; j<i; j++)
	{
		printf("%d",n[j]);
	}
}