/*Scrivere un programma tale che:
1. Chieda in input un numero n > 0
2. Chieda in input 3 numeri, a, b, c, in modo che
a > b e b < c
3. Chieda in input n coppie (x;y) in modo tale che
x sia compreso tra a e b ed y tra b e c
4. Per ogni coppia inserita (x;y) calcoli e restituisca
il prodotto dei numeri compresi tra x ed y, escludendo
eventuali 0.
*/

#include <stdio.h>
#include <stdlib.h>

int InputN() {
	int n;

	do {
		printf("\nInserire un numero n > 0: ");
		scanf("%d",&n);
	}while(n<=0);

	return n;
}

int CoppiaX(int a,int b,int c) {
	int x;

	do {
		printf("\nInserire x (deve essere compreso tra a e b): ");
		scanf("%d",&x);
	}while(x>=a || x<=b);

	return x;
}

int CoppiaY(int a,int b,int c) {
	int y;

	do {
		printf("\nInserire y (deve essere compreso tra b e c): ");
		scanf("%d",&y);
	}while(y<=b || y>=c);

	return y;
}

int Prodotto(int x,int y) {
	int p=1;

	while(x<y) {
		if(p!=0) {
			p*=y;
		}
		y--;
	}

	while(x>y) {
		if(p!=0) {
			p*=x;
		}
		x--;
	}

	return p;
}

int main(int argc, char *argv[]) {
	int n,a,b,c,x,y,i=0,p;

	n = InputN();

	printf("\nInserire 3 numeri a;b;c (a>b;b<c)\n");
	do {
		printf("\n  Inserire a: ");
		scanf("%d",&a);
		printf("\n  Inserire b: ");
		scanf("%d",&b);
		printf("\n  Inserire c: ");
		scanf("%d",&c);
	}while(a<=b || b>=c);

	while(i<n) {
		printf("\n%d\xF8\tCoppia:",++i);
		x = CoppiaX(a,b,c);
		y = CoppiaY(a,b,c);
		p = Prodotto(x,y);
		printf("\nProdotto numeri tra la coppia = %d\n",p);
	}

	return 0;
}
