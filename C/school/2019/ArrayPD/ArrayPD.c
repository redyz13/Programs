/*Scrivere un programma tale che:
1. Carichi un array a che obblighi l'utente ad
inserire nelle celle di indice pari un numero pari
e nelle celle di indice dispari un numero dispari.
2. Carichi un array b con gli stessi criteri indicati
nel punto 1.
3. Carichi un terzo array c in modo tale che la generica
cella c[i] contenga la somma dei numeri compresi tra il
valore minimo tra a[i] e b[i] ed il valore massimo tra
a[i] e b[i]
4. Visualizzare gli array in output (uno affianco all'altro).
*/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int getn(int min,int max) {
	int n;

	do {
		printf("\nInserire la dimensione degli array: ");
		scanf("%d",&n);
	}while(n<=min||n>=max);

	return n;
}

void getarraypd(int *a,int n) {
	int i=1;
	int max=INT_MIN,min=INT_MAX;

	printf("\nInserire nelle cellule pari, numeri pari");
	printf(" e nelle cellule dispari, numeri dispari:\n");

	for(i=1; i<=n; i++) {
		do {
			printf("\n  Inserire il numero nella cella %d: ",i);
			scanf("%d",&a[i]);
		}while(a[i]%2==0);

	if(a[i]>max) {
		max=a[i];
	}
	if(a[i]<min) {
		min=a[i];
	}

	i++;

		do {
			printf("\n  Inserire il numero nella cella %d: ",i);
			scanf("%d",&a[i]);
		}while(a[i]%2==1);
	}

	if(a[i]>max) {
		max=a[i];
	}
	if(a[i]<min) {
		min=a[i];
	}

	printf("\nMassimo = %d",max);
	printf("\nMinimo = %d\n",min);
}

int main() {
	int n;

	n = getn(0,101);
	int a[n],b[n],c[n];

	getarraypd(a,n);
	getarraypd(b,n);
}