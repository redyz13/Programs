/* Scrivere un algoritmo tale che:
Chieda in input una sequenza di numeri fino
a che le sottosequenze di numeri pari e dispari
inserite, risultino crescenti. Calcoli e restituisca
inoltre, la somma di tutte le differenze che si
ottengono sottraendo ad ogni numero della sequenza
il suo predecessore. */

#include <stdio.h>
#include <limits.h>

int main() {
	int x = INT_MIN, pp, pd = INT_MIN, i = 0;
	int s = 0;

	do {
		if(x % 2 == 0)
			pp = x;
		else
			pd = x;

		printf("\nInserire il %d\xA7 numero: ",++ i);
		scanf("%d",&x);

		if(x % 2 == 0)
			s = s + (x - pp);
		else
			s = s + (x - pd);
	}while(x >= pp && x >= pd);

	printf("\nSomma delle differenze dei numeri: %d",s);

	return 0;
}