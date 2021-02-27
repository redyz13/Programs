#include <stdio.h>

int main() {
	int x, y, max, min, mcm = 0, f = 0, c = 1;

	do {
		printf("\nInserire il primo numero intero positivo: ");
		scanf("%d",&x);
		printf("\nInserire il secondo numero intero positivo: ");
		scanf("%d",&y);
	}while(x <= 0 || y <= 0);

	if(x > y) {
		max = x;
		min = y;
	}
	else {
		max = y;
		min = x;
	}

	while(f == 0) {
		mcm = c * max;

		if(mcm % min == 0)
			f = 1;
		else
			c ++;
	}

	printf("\nMinimo comune multiplo tra %d e %d = %d",x, y, mcm);

	return 0;
}