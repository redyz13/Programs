/* Scrivere un programma che riceva in ingresso
un numero positivo N e determini il massimo intero
k tale che la somma dei primi K interi sia minore o 
uguale a N. */

#include <stdio.h>

int main() {
	int n, k = 1, s = 0;

	do {
		printf("Inserire un numero positivo: ");
		scanf("%d",&n);
	}while(n <= 0);

	while(s <= n - k) {
		s += k;
		k ++;
	}

	printf("Risultato = %d",s);

	return 0;
}