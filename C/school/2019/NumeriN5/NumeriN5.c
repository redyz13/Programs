#include <stdio.h>

int main() {
	int n, k = 11111, c = 1;

	printf("Inserire un numero positivo: ");
	scanf("%d",&n);

	while(k < k * n) {
		printf("\n%d Numero = %d",c,k);
		c++;

		if(k / 10000 == n) {
			k += 100;
		}
		else {
			k++;
		}
	}
}