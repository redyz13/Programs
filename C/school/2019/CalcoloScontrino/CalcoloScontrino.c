#include <stdio.h>
#include <stdlib.h>

float CalcoloSconto(float pp, int qp, int s) {
	float pt;

	pp = pp * qp;
	pt = (pp * s) / 100;
	pt = pp - pt;

	return pt;
}

int main() {
	float pp, pt, st = 0; //pp = Prezzo Prodotto pt = Prezzo Totale st = Somma Totale
	int qp, s, c = 1; //qp = Quantità Prodotti s = sconto
	char r;

	printf("*Generazione Scontrino*\n");

	do {
		printf("\nVuoi aggiungere un %d\xF8 articolo alla cassa?\n", c);
		printf("\n1. Si(y)\n2. No(n)\n");
		printf("\nRisposta = ");scanf(" %c",&r);

		if(r == 'y') {
			c ++;
			printf("\nPrezzo articolo = EUR ");scanf("%f",&pp);
			
			do {
				printf("Quantit\x85 articolo = ");scanf("%d",&qp);
			}while(qp <= 0);

			printf("Sconto del prodotto = %%");scanf("%d",&s);

			pt = CalcoloSconto(pp, qp, s);
			st += pt;
		}
	}while(r != 'n');

	printf("\nLista articoli terminata!\n");
	printf("Totale Spesa = %.2f\n",st);

	if(st > 0) {
		printf("\nDispone di una fidelity card?\n1. Si(y)\n2. No(n)\n");
		printf("\nRisposta = ");scanf(" %c",&r);

		if(r == 'y' && st < 100) {
			st = CalcoloSconto(st, 1, 5);
			printf("\nPrezzo Finale = %.2f",st);
		}
		else if(r == 'y' && st >=100) {
			st = CalcoloSconto(st, 1, 10);
			printf("\nPrezzo Finale = %.2f",st);
		}
	}

	return 0;
}