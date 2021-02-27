/*Scrivere un programma tale che chieda in input
n numeri assicurandosi che siano tutti positivi e
restituisca la somma dei numeri inseriti che risultano
maggiori dell'ultimo numero degli n inseriti.
*/

#include <stdio.h>
#include <stdlib.h>

int getn() {
	int n;

	do {
		printf("\nNumeri da inserire = ");
		scanf("%d",&n);	
	}while(n<=0);

	return n;
}

int main(int argc, char *argv[]) {
	int n,i,j,s=0;

	n = getn();

	int v[n];

	for(i=0; i<n; i++) {
		printf("\nInserire il numero della cella %d (Solo Positivi): ",i+1);
		scanf("%d",&v[i]);
		if(v[i]<=0)
			i--;
	}

	for(j=0; j<n; j++) {
		if(v[j]>v[i-1])
			s=s+v[j];
	}

	printf("\nSomma = %d",s);

	return 0;
}