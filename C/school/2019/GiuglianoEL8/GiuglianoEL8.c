#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define range 90
#define quantity 20

int main()
{
	system("cls");
	
	int random_n,i=0;
	
	srand(time(NULL));
	
	while(i<quantity) {
		random_n=rand()%range+1;
		printf("\n%d\xF8\tNumero\t=\t%d",++i,random_n);
		
		if(i==quantity) {
			i=0;
			printf("\n--------------------------");
			system("ping 127.0.0.1 -n 300 > NUL");
		}
	}
}
