/*Scrivere un programma tale che:
Data in input una sequenza numerica formata
da n numeri, con n intero pari maggiore di 2,
si considerino le coppie di numeri successivi
appartenenti alla sequenza e per ognuna si calcoli
e restituisca la media dei numeri tra loro compresi.
*/

#include <stdio.h>
#include <stdlib.h>

int x,y;

int InputN() {
	int n;
	do {
		printf("Inserire un numero n intero pari maggiore di 2: ");
		scanf("%d",&n);
	}while(n<=1 || n%2!=0);

	return n;
}

int MediaCoppie() {
	int m,i=0,s=0;
	while(x<=y) {
		s+=x;
		i++;
		x++;
	}

	m=s/i;

	return m;
}

int main(int argc, char *argv[]) {
	int i,c=0,m,n;
	n = InputN();

	for(i=0; i<n; i++) {
		printf("\nInserire la %d coppia (x;y): ",++c);
		scanf("%d;%d",&x,&y);

		m = MediaCoppie();

		printf("\nMedia Numeri compresi = %d\n",m);
	}
	return 0;
}