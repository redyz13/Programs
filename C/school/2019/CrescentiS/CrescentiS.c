/*Scrivere un algoritmo tale che:
Chiede in input una sequenza di numeri crescenti
fino a che la sequenza resti tale e, per ogni numero
inserito dal secondo in poi, calcoli e restituisca
la somma dei numeri compresi tra il precedente ed
il numero stesso.
*/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int SommaC(int x,int p) {
	int s = 0;
	
	while(x >= p) {
		s += x;
		x--;
	}

	return s;
}

int main(int argc, char *argv[]) {
	int p, c = 0, s;
	int x = INT_MIN;

	printf("| Inserire una sequenza di numeri crescenti |\n");

	do {
		p = x;
		printf("\nInserire il %d numero: ", ++c);
		scanf("%d", &x);
		if(c > 1 && x > p) {
			s = SommaC(x, p);
			printf("\nSomma numeri compresi tra %d e %d = %d\n",p, x, s);
		}
	}while(x >= p);

	return 0;
}