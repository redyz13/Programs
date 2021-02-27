/*Scrivere un algoritmo tale che:
1. Chieda in input una sequenza numerica
che termina quando si inserisce di nuovo
il primo numero inserito
2. Calcoli e restituisca la somma dei
numeri il cui ordine di inserimento è dispari.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x,fn,i=1,c=0,sid=0;

	printf("| Inserire una sequenza numerica fino "
	"al reinserimento del primo numero:");

	do
	{
		printf("\n  %d\xF8 Numero = ",++c);
		scanf("%d",&x);

		if(i==1)
		{
			fn=x;
		}

		if(i%2!=0)
		{
			sid=sid+x;
		}

		i++;
	}while(x!=fn||i==2);

	printf("\nSomma numeri con ordine inserimento dispari = %d",sid);
}