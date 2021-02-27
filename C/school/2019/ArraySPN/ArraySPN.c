/*Scrivere un programma tale che:
1. Carichi un array a di dimensione n assicurandosi
che contenga solo numeri negativi
2. Carichi un array b di dimensione n assicurandosi
che contenga solo numeri positivi
3. Carichi un terzo array c in modo tale che ogni cella
di c contenga la somma dei numeri compresi tra il valore
contenuto nella rispettiva cella di a e quello contenuto
nella rispettiva cella di b.
4. Visualizzi in output i tre array.
*/

#include <stdio.h>
#include <stdlib.h>

int getn(int min,int max) {
	int n;

	do {
		printf("\nInserire la dimensione degli array: ");
		scanf("%d",&n);
	}while(n<=min||n>=max);

	return n;
}

void getan(int *a,int n) {
	int i;

	printf("\nCaricare l'array a con soli numeri negativi:\n");

	for(i=0; i<n; i++) {
		do {
			printf("\nInserire il numero della cella %d dell'array a: ",i);
			scanf("%d",&a[i]);
		}while(a[i]>=0);
	}
}

void getbp(int *a,int n) {
	int i;

	printf("\nCaricare l'array b con soli numeri positivi:\n");

	for(i=0; i<n; i++) {
		do {
			printf("\nInserire il numero della cella %d dell'array b: ",i);
			scanf("%d",&a[i]);
		}while(a[i]<=0);
	}
}

void getcs(int *c,int *a,int *b,int n) {
	int i,s,m;

	for (i=0; i<n; i++) {
		s=0;
		m=a[i];

		while(a[i]<=b[i]) {
			s+=a[i];
			a[i]++;
		}
		a[i]=m;
		c[i]=s;
	}
}

int main() {
	int n,i;

	n = getn(0,101);
	int a[n],b[n],c[n];
	getan(a,n);
	getbp(b,n);
	getcs(c,a,b,n);

	for(i=0; i<n; i++) {
		printf("\nArray a; Cella %d = %d",i,a[i]);
		printf("\tArray b; Cella %d = %d",i,b[i]);
		printf("\tArray c; Cella %d = %d",i,c[i]);
	}

	return 0;
}