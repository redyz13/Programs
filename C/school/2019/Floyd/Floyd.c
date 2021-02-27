#include <stdio.h>

int main() {
	int n, r, c, x = 1;

	do {
		printf("Inserire un numero positivo: ");
		scanf("%d",&n);
	}while(n <= 0);

	for(r = 0; r < n; r++) {
		for(c = 0; c <= r; c++) {
			printf("%d ", x);
			x ++;
		}
		printf("\n");
	}

	return 0;
}