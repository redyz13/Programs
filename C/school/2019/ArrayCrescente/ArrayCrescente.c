/*Scrivere un programma tale che:
1. Carichi un array di n interi
2. Carichi un secondo array in modo che
contenga tutti i valori contenuti nel primo
array disposti in ordine crescente
3. Visualizzare in output il secondo array
*/

#include <stdio.h>
#include "\Scuola\Library\library.h"

void ArrayCrescente(int n, int b[]) {
	int i, j, tmp;

	for(i = 0; i < n; i ++)
		for(j = 0; j < n; j ++)
			if(b[j] > b[i]) {
				tmp = b[i];
				b[i] = b[j];
				b[j] = tmp;
			}
}

void StampaArray(int n, int b[]) {
	int i;

	for(i = 0; i < n; i++) {
		printf("\nNumero della cella (%d) = %d ",i, b[i]);
	}
}

int main() {
	int n, i;

	n = CompresoTra(1, 100);
	int a[n];
	int b[n];
	CaricaArray(n, a);

	for(i = 0; i < n; i++)
		b[i] = a[i];

	ArrayCrescente(n, b);
	StampaArray(n, b);

	return 0;
}