/*Scrivere un programma tale che:
1. Chiede in input una sequenza di numeri fino
a che non si inserisce un numero che è il doppio
del suo precedente
2. Calcoli e restituisca quante volte nella
sequenza del passo 1 il numero inserito è 
di segno opposto rispetto al suo precedente
3. Calcoli e restituisca la somma dei numeri
positivi e dei numeri negativi inseriti al passo 1
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x=0,cs=0,sp=0,sn=0,i=0,p;

	printf("| La sequenza si interrompe all'inserimento di un numero doppio del precedente\n");

	do
	{
		p=x;
		printf("\n  Inserire il %d\xF8 numero: ",++i);
		scanf("%d",&x);

		if(x>0)
		{
			sp=sp+x;
		}
		else
		{
			sn=sn+x;
		}

		if(x>0&&p<0||x<0&&p>0)
		{
			cs++;
		}
	}while(x!=p*2);

	printf("\nNella sequenza sono stati inseriti segni opposti %d volte",cs);
	printf("\nSomma Positivi della sequenza = %d",sp);
	printf("\nSomma Nositivi della sequenza = %d",sn);
}