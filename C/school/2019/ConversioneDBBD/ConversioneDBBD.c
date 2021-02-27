#include <stdio.h>

int main() {
	int s, x, r, c = 1;
	int resto, base = 1, r2 = 0;

	do {
		printf("Inserire 0 per convertire un numero da decimale a binario");
		printf("\nInserire 1 per convertire un numero da binario a decimale\n");
		printf("\nRisposta: "); scanf("%d",&s);

		if(s == 0) {
			printf("\nNumero Decimale: ");
			scanf("%d",&x);

			while(x > 0) {
				r = x % 2;
				x /= 2;
				printf("\n%d\xF8 Cifra: %d",c ++, r);
			}
			printf("\n\nCifre dal bit meno significativo al piu' significativo");
		}

		if(s == 1) {
			printf("\nNumero Binario: ");
			scanf("%d",&x);

			while(x > 0) {
				resto = x % 10;
				r2 = r2 + resto * base;
				x = x / 10;
				base = base * 2;
			}

			printf("\nNumero Decimale convertito: %d",r2);
		}
	}while(s == 0 && s == 1);

	return 0;
}