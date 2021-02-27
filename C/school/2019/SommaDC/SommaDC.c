/*Scrivere un algoritmo tale che:
1. Chiede in input un numero n positivo
2. Chiede in input una sequenza di n numeri
3. Per ogni numero positivo inserito al passo 2
calcoli e restituisca la somma dei numeri compresi
tra tale numero ed il suo doppio.*/

#include <stdio.h>
#include <stdlib.h>

int n,c = 0,x,sc = 0;

int InputN() {
	do {
		printf("Inserire un numero n positivo: ");
		scanf("%d",&n);
	}while(n<=0);
	
	return n;
}

int SommaCD() {
	int d;
	d = x*2;
		
	while(x<=d) {
		sc += x;
		x++;
	}
		
	return sc;
}

int main(int argc, char *argv[]) {
	int i;
	n = InputN();
	
	for(i = 0; i<n; i++) {
		printf("\nInserire il %d numero: ",++c);
		scanf("%d",&x);

		if(x > 0) {
			sc = SommaCD();
			printf("\nSomma numeri compresi tra x ed il suo doppio = %d\n",sc);
			sc = 0;
		}
	}
	
	return 0;
}