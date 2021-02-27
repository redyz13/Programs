/*Scrivere un programma tale che:
1. Carichi un array a di interi di dimensione n
2. Carichi un array b di interi di dimensione n
in modo tale che: b[i]<a[i]
3. Carichi un terzo array c di dimensione n in modo
tale che: a[i]<c[i]<b[i]
4. Calcoli e restituisca la media dei numeri pari
dell'array c.
*/

#include <stdio.h>
#include <stdlib.h>

int getn(int min, int max) {
	int n;

	do {
		printf("\nInserire un numero compreso tra %d e %d: ",min,max);
		scanf("%d",&n);
	}while(n<=min || n>=max);

	return n;

}

void geta(int n,int *a) {
	int i;

	for(i=0; i<n; i++) {
		printf("\nInserire un numero nella cella %d dell'array a: ",i);
		scanf("%d",&a[i]);
	}
}

void getb(int n,int *b,int *a) {
	int i;

	for(i=0; i<n; i++) {
		do {
			printf("\nInserire un numero nella cella %d dell'array b (b[i]>a[i]): ",i);
			scanf("%d",&b[i]);
		}while(b[i]<=a[i]);
	}
}

void getcc(int n,int *a,int *b,int *c) {
	int i;

	for(i=0; i<n; i++) {
		do {
			printf("\nInserire un numero nella cella %d dell'array c (a[i]<c[i]<b[i]): ",i);
			scanf("%d",&c[i]);
		}while(c[i]<=b[i] || c[i]>=a[i]);
	}
}

int medvp(int n,int *c) {
	int i,cp=0,sp=0,mp;

	for(i=0; i<n; i++) {
		if(c[i]%2==0) {
			sp+=c[i];
			cp++;
		}
	}

	mp=sp/cp;

	return mp;
}

int main(int argc, char **argv) {
	int n,a[100],b[100],c[100],mcp;

	n = getn(0,100);
	geta(n,a);
	getb(n,a,b);
	getcc(n,a,b,c);
	mcp = medvp(n,c);

	printf("\nMedia numeri pari del'array c: %d",mcp);

	return 0;
}