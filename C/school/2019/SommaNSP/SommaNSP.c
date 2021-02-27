/*Fare una sequenza crescente di n numeri
calcolando la somma tra ogni numero (s) ed
il suo precedente (p), successivamente calcolare
la somma di tutte le somme.
*/

#include <stdio.h>
#include <stdlib.h>

int SC(int x,int y) {
	int s=0;

	while(y>x) {
		s+=y;
		y--;
	}

	return s;
}

int main(int argc, char *argv[]) {
	int n,s=0,st=0,i=0,x,y;

	printf("Inserire un numero n: ");
	scanf("%d",&n);

	printf("\nInserire una sequenza di numeri crescente:\n");

	do {
		printf("\nInserire il primo numero: ");
		scanf("%d",&x);
		printf("Inserire il secondo numero: ");
		scanf("%d",&y);
		i++;
		printf("\nSomma Compresi = %d\n",s=SC(x,y));
		st=st+s;
	}while(y>x&&i<n);

	printf("\nSomma Totale = %d",st);

	return 0;
}