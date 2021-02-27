// Sum of 2 numbers

#include <stdio.h>
#include "summer.c"

int main() {
	int a,b;

	printf("Insert the first number: ");
	scanf("%d",&a);
	printf("Insert the second number: ");
	scanf("%d",&b);

	printf("\nResult: %d",summer(a,b));
}