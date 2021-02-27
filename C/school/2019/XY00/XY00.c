/*Scrivere un programma tale che:
1. Chieda in input una sequenza di coppie numeriche
(X;Y) fino a che l'utente non inserisca la coppia (0;0)
2. Per ogni coppia inserita al passo 1, calcoli la media
di tutti i numeri pari compresi tra il più piccolo e il
più grande tra X ed Y
3. Calcoli e restituisca la media di tutte le medie
calcolate al passo 2.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x,y,mc,mt,i=0,sc=0,cc=0,sm=0,cm=0;

	printf("Inserire delle coppie (X;Y) fino all'inserimento di (0;0)\n");

	do {
		printf("\n  Inserire la %d\xF8 coppia: ",++i);
		scanf("%d;%d",&x,&y);

	if(x>=y&&x!=0&&y!=0) {
		while(x>=y) {
			sc+=y;
			cc++;
			y++;
		}
	}
	else if(y>x) {
		while(y>=x) {
			sc+=x;
			cc++;
			x++;
		}
	}

	if(x!=0&&y!=0) {
		mc=sc/cc;
		sm+=mc;
		cm++;
		printf("\nMedia numeri compresi tra (X;Y) = %d\n",mc);
		sc=0;
		cc=0;
	}
	}while(x!=0||y!=0);

	mt=sm/cm;
	printf("\nMedia delle medie calcolate = %d",mt);
}