/*Scrivere un programma tale che:
1. Chieda in input una sequenza di numeri sino
a che la somma dei numeri pari della sequenza
non risulti negativa
2. Per ogni coppia di numeri X,Y inserita al
passo 1 dove X è il precedente di Y, calcoli
e restituisca la somma dei numeri compresi tra
X ed Y.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int x,y=0,i=0,sp=0,sc=0;

	printf("\n| Inserire numeri fino a quando la somma"
	" dei numeri pari non risulti negativa |");

	do {
		x=y;
		printf("\n  Inserire il %d numero: ",++i);
		scanf("%d",&y);

		if(x<=y&&i>1) {
			while(x<=y) {
				sc+=x;
				x++;				
			}

			printf("\nSomma numeri compresi tra X ed Y = %d\n",sc);
			sc=0;			
		}

		if(y%2==0) {
			sp+=y;
		}
	}while(sp>=0);

	printf("\nSomma numeri positivi = %d\n",sp);
}