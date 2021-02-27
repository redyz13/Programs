/*Scrivere un programma che chieda una sequenza di n numeri
con n intero positivo e la restituisca all'utente in ordine
inverso.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int n,i,j,c=0;

	printf("Lunghezza Sequenza = ");
	scanf("%d",&n);
	int v[n];

	for (i=0; i<n; i++) {
		printf("\n%d\xF8 Numero = ",++c);
		scanf("%d",&v[i]);
	}

	printf("\nNumeri Invertiti:\n");

	for (j=i-1; j>=0; j--) {
		printf("\n%d\xF8 Numero = %d\n",c--,v[j]);
	}

	return 0;
}