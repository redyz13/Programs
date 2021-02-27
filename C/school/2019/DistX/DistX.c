/*Scrivere un programma tale che:
1. Chiede in input un numero n positivo
2. Chiede in input un numero x positivo
3. Chiede in input una sequenza di numeri
che contenga n numeri con le seguenti caratteristiche:
3.1 Ogni numero deve essere maggiore del precedente
3.2 Ogni numero deve distare dal suo precedente per
non più del valore x.
4. Somma la differenza tra ogni numero e il suo
precedente e restituire la somma data.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int n,x,p,a=0,i=1,sd=0;

	do {
		printf("\nInserire un numero n positivo: ");
		scanf("%d",&n);	
	}while(n<=0);

	do {
		printf("\nInserire un numero x positivo: ");
		scanf("%d",&x);	
	}while(x<=0);

	printf("\n| Inserire i numeri per la sequenza\n"
	"(ogni numero deve essere maggiore del precedente)\n"
	"(ogni numero deve distare dal suo precedente per non pi\x97 del valore x) |\n");

	while(i<=n) {
	p=a;
		
		do {
			printf("\n  Inserire il %d\xF8 numero (maggiore di %d"
			" e disante da esso non pi\x97 di %d): ",i,p,x);
			scanf("%d",&a);
		}while(a<=p||(a-p)>x);

		if(i>1) {
			sd=sd+(a-p);
		}
		
		i++;
	}

	printf("\nLa somma delle differenze di ogni numero ed il"
	" suo precedente \x8A di: %d",sd);
}