#include <stdio.h>
#include <stdlib.h>

int main() {
	char text[50];

	FILE *ptr_file;
	ptr_file = fopen("doc.txt","r");

	if(ptr_file) {
		while(!feof(ptr_file)) {
			fgets(text,50,ptr_file);
			printf("%s",text);
		}

		printf("\nOperazione Completata");
	}
	else {
		printf("\nErrore!");
	}

	fclose(ptr_file);

	return 0;
}