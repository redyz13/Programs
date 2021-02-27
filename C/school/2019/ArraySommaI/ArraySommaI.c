/*Scrivere un programma tale che:
1. Carichi un array a di dimensione a assicurandosi che
contenga solo numeri positivi
2. Carichi un secondo array b in modo che la cella di
indice b[i] contenga la somma di tutti i numeri dall'indice
0 fino alle cella di i
3. Visualizzare gli array in output.
*/

#include <stdio.h>
#include <stdlib.h>

int getn(int min,int max) {
	int n;

	do {
		printf("\nInserire la dimensione dell'array (%d-%d): ",min,max);
		scanf("%d",&n);
	}while(n<=min||n>=max);

	return n;
}

void geta(int *a,int n) {
	int i;

	printf("\nRiempire le celle con soli numeri pari (Array a):\n");
	
	for(i=0; i<n; i++) {
		do {
			printf("\nCella %d = ",i);
			scanf("%d",&a[i]);
		}while(a[i]%2!=0);
	}
}

void inizializzavettore(int *b,int n,int k) {
	int i;

	for(i=0; i<n; i++) {
		b[i]=k;
	}
}

void getb(int *b,int n) {
	int i=0,j;

	for(j=0; j<n; j++) {
		while(b[j]<=i) {
			b[j]=b[j]+i;
			i++;
		}
	}
}

int main() {
	int n,i;
	int k=0;

	n = getn(0,101);
	int a[n];
	int b[n];
	geta(a,n);
	inizializzavettore(b,n,k);
	getb(b,n);

	for(i=0; i<n; i++) {
		printf("\nArray a; Cella %d = %d",i,a[i]);
		printf("\tArray b; Cella %d = %d",i,b[i]);
	}

	return 0;
}