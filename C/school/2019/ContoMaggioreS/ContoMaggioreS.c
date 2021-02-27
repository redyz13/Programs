/*Scrivere un algoritmo tale che:
1. Chieda in input un numero n positivo
2. Chieda in input una sequenza di N numeri
che devono essere necessariamente positivi
3. Calcoli e restituisca quante volte nella
sequenza succede che il precedente è maggiore
del successivo.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int n,p,x=0,cpm=0,i=0;

	do {
		printf("\nInserire un numero n positivo maggiore di 0: ");
		scanf("%d",&n);
	}while(n<=0);

	while(i<n) {
		p=x;
		printf("\nInserire il %d numero: ",++i);
		scanf("%d",&x);

		if(p>x&&i>1) {
			cpm++;
		}
	}

	printf("\nIl precedente \x8A stato maggiore del successivo %d volte/a",cpm);
}