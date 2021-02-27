int CompresoTra(int min, int max) {
	int x;
	
	do {
		printf("Inserire un numero compreso tra %d e %d: ",min, max);
		scanf("%d",&x);
	}while(x < min || x > max);
	
	return x;
}

void CaricaArray(int n, int a[]) {
	int i;
	
	for(i = 0; i < n; i ++) {
		printf("\nInserire il numero della cella (%d): ",i);
		scanf("%d",&a[i]);
	}
}

void InvertiArray(int n, int a[]) {
	int i = 0, j;
	
	for(j = n - 1; j >= i; j --)
		printf("\nNumero della cella (%d) = %d\n",j, a[j]);
}
