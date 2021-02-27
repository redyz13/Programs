#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Variabili Globali
float c1,c2;
float ipot,perim;

void InsDati() {	// La funzione non ritorna nessun valore
	printf("Inserire il primo cateto: ");
	scanf("%f",&c1);
	printf("Inserire il secondo cateto: ");
	scanf("%f",&c2);	
}

void Stampa() {	// La funzione non ritorna nessun valore
	printf("\nPerimetro = %5.2f\n",perim);
}

float CalcolaPerim() {
	// La lunghezza dell'ipotenusa viene calcolata usando il teorema di Pitagora
	// sqrt è una funzione che calcola e restituisce la radice quadrata

	ipot = sqrt(c1*c1+c2*c2);
	return(c1+c2+ipot);
	// Il valore del perimetro viene restituito al main

}

int main(int argc, char *argv[]) {
	InsDati();
	perim = CalcolaPerim();
	// Il valore del perimetro restituito dalla funzione viene assegnato alla variabile
	Stampa();
	system("pause");
	return 0;
}