#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int n;

	printf("\nQuanti numeri vuoi inserire?: ");
	scanf("%d",&n);
	int a[n];

	for(int i=0; i<n; i++) {
		printf("\nInserire il n.%d: ",i+1);
		scanf("%d",&a[i]);
	}

	for(int j=0; j<n; j++) {
		printf("\nn.%d = %d",j+1,a[j]);
	}

	return 0;
}