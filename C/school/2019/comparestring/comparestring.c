#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	char string1[100];
	char string2[100];

	printf("Inserire la prima stringa: "); gets(string1);
	printf("Inserire la seconda stringa: "); gets(string2);
	
	if(strcmp(string1,string2) == 0)
		printf("\nLe stringhe sono uguali\n");
	else
		printf("\nLe stringhe non sono uguali\n");

	printf("\nPress Enter to exit: ");
	getchar();
}