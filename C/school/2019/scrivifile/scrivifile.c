#include <stdio.h>
#include <stdlib.h>

int main() {
	FILE *ptr_file;
	ptr_file = fopen("doc.txt","w");

	if(ptr_file) {
		fprintf(ptr_file,"Prova\n15");
		printf("\nScrittura completata");
	}
	else {
		printf("\nErrore!");
	}

	fclose(ptr_file);

	return 0;
}