/*Scrivere un programma tale che:
1. Chiede in input un numero n > di 0
2. Generi in output tutte le possibili
sequenze numeriche fatte come nel seguente
esempio
Esempio: n=3 1) 9 2) 0-1 3) 0-1-2.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n,i=0,x=0;

	do
	{
		printf("Inserire un numero n > di 0: ");
		scanf("%d",&n);
	}while(n<0);

	while(i<n)
	{
		printf("\n%d\xF8\tSequenza =\t",i+1);
		
		while(x<n)
		{
			printf("%d-",x++);
		}

		i++;
	}
}