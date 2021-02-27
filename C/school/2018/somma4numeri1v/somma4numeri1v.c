/*Scrivere un programma tale che dati in input 4
numeri, calcoli e restituisca la lora somma.
N.B. Usare una sola variabile di input.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int a,s=0;
	
	printf("Inserire il primo numero: ");
	scanf("%d",&a);

	s += a;

	printf("Inserire il secondo numero: ");
	scanf("%d",&a);

	s += a;

	printf("Inserire il terzo numero: ");
	scanf("%d",&a);

	s += a;

	printf("Inserire il quarto numero: ");
	scanf("%d",&a);

	s += a;

	printf("Somma totale = %d\n",s);
	
	return 0;
}