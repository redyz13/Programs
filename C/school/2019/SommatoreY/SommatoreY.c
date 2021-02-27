/* Scrivere il diagramma di flusso per il calcolo di
y assumendo di acquisire k dall’esterno (dato di input)
controllando che k sia intero positivo */

#include <stdio.h>

int main() {
	int k, j, i;
	float y = 0, m;

	do {
		printf("Inserire un numero intero positivo: ");
		scanf("%d",&k);
	}while(k <= 0);

	for(i = 1; i <= k; i++) {
		m = 0;

		for(j = 1; j <= i; j++) {
			m = m + 1 / (i + j);
		}

		m = m * m;
		y = y + m;
	}

	printf("Risultato = %f",y);

	return 0;
}