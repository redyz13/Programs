#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <limits.h>

int main() {
	int i, sum = 0, value = 1;
	int diceRoll;
	int edr = INT_MAX;

	srand(time(NULL));

	printf("\nD&D Stats Calculator");
	printf("\n--------------------\n");

	for(i=0; i<4; i++) {
		diceRoll = rand()%6 + 1;
		sum+=diceRoll;

		if(diceRoll<edr) {
			edr=diceRoll;
		}
		
		if(i==3) {
			sum-=edr;

			printf("%d\xF8 Value = %d\n",value,sum);

			value++;
			sum=0;
			edr=INT_MAX;

			if(value<=6)
				i=0;
		}
	}

	printf("\nType any character to exit: ");

	getchar();

	printf("\n");
}