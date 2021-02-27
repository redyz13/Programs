/* Scrivere un algoritmo tale che:
Chieda in input una sequenza di numeri strettamente
crescenti fino a che il prodotto di due numeri
consecutivi non risulti maggiore del numero successivo
ai due nella sequenza. Calcoli inoltre quanti numeri
inseriti nella sequenza risultano pari e quanti dispari.
*/

#include <stdio.h>
#include <limits.h>

int main() {
	int x = INT_MIN, np, npp = 1, i = 0, p = 1;
	int cp = 0, cd = 0;

	do {
		if(i % 2 == 0)
			np = x;
		else
			npp = x;

		printf("\nInserire il %d\xA7 numero: ",++ i);
		scanf("%d",&x);

		if(x % 2 == 0)
			cp ++;
		else
			cd ++;

		p = np * npp;
	}while(x >= np && (p <= x || i == 1));

	printf("\nNumeri pari inseriti: %d",cp);
	printf("\nNumeri dispari inseriti: %d",cd);

	return 0;
}