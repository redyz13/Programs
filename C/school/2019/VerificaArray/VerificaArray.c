#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

int CompresoTra();
void CaricaArray();
bool VerificaArray();

int main() {
	int n;
	bool f;
	
	n = CompresoTra(1, INT_MAX);
	
	int a[n];
	
	CaricaArray(n, a);
	f = VerificaArray(n, a);
	
	printf("\nRisultato: %d", f);
	
	return 0;
}

int CompresoTra(int min, int max) {
	int x;
	
	do {
		printf("\nInserire un numero intero positivo: ");
		scanf("%d",&x);
	}while(x < min || x > max);
	
	return x;
}

void CaricaArray(int n, int *a) {
	int i;
	
	for(i = 0; i < n; i ++) {
		printf("\nInserire il %d numero: ",i + 1);
		scanf("%d",&a[i]);
	}
}

bool VerificaArray(int n, int *a) {
	int j, i;
	bool f = 0;
	
	for(j = 0; j < n; j ++)
		for(i = j + 1; i < n; i ++) {
			if(a[j] == a[i])
				f = 1;
		}
	
	return f;
}
