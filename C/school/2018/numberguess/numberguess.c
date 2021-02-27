#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	#define attempts 4
	#define range 50
	int random_n;
	int n,i = 1;

	srand(time(NULL));

	random_n=rand()%range;

	system("cls");
	
	printf("Guess the Number!\n\n");
	printf("Indovina il numero generato tra 0 e %d:\n", range - 1);

	while(i <= attempts) {
		printf("\n%d\xF8 Tentativo =\t", i);
		scanf("%d", &n);

		if(n > random_n && i < attempts) {
			printf("\nProva un numero minore!\n");
		}
		else if(n < random_n && i < attempts) {
			printf("\nProva un numero maggiore!\n");
		}
		else if(n == random_n) {
			printf("\nHai vinto in %d tentativi!\n", i);
			system("color 0a");
			system("ping 127.0.0.1 -n 3 > nul");
			system("color 0f");
			break;
		}

		i++;
	}
	
	if (i > attempts) {
		printf("\nHai Perso :C il numero era %d!\n", random_n);
		system("color 0c");
		system("ping 127.0.0.1 -n 3 > nul");
		system("color 0f");
	}

	printf("\n");
	system("pause");
	return 0;
}