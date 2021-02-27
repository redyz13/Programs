/*Scrivere un programma tale che:
1. Chieda un array a di interi
2. Chieda in input un numero x
3. Conti quante volte il numero x è presente
nell'array a.
*/

#include <stdio.h>
#include <stdlib.h>

int In() {
	int n;

	do {
		printf("\nInserire un numero compreso tra 0 e 100: ");
		scanf("%d",&n);
	}while(n<=0 || n>=100);

	return n;
}

void geta(int n,int *a) {
	int i;

	for(i=0; i<n; i++) {
		printf("\nInserire il numero della cella %d: ",i);
		scanf("%d",&a[i]);
	}
}

int CountArray(int n,int *a,int x) {
	int i,c=0;

	for(i=0; i<n; i++) {
		if(x==a[i]) {
			c++;
		}
	}

	return c;
}

int main(int argc, char *argv[]) {
	int n,a[100],x,c;

	n = In();

	geta(n,a);

	printf("\nInserire un numero intero x: ");
	scanf("%d",&x);

	c = CountArray(n,a,x);

	printf("\nNumero di volte che x era presente nell'array: %d",c);

	return 0;
}