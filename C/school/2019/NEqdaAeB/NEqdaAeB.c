/*Scrivere un programma tale che:
1. Chiede in input un numero n maggiore di 0
2. Chiede in input due numeri, a e b, con b > di a
3. Chiede in input dei numeri c fino a che non ne
siano stati inseriti n compresi tra a e b
4. Restutisca il numero tra i numeri c inseriti
e compresi tra a e b maggiormente equidistante da
a e da b.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n,a,b,i=0,y=0,c,ne,ne1,ne2,nem;

	do
	{
		printf("Inserire un numero n > di 0: ");
		scanf("%d",&n);
	}while(n<0);

	do
	{
		printf("\nInserire due numeri a e b con b > di a (a;b): ");
		scanf("%d;%d",&a,&b);
	}while(a>b);

	printf("\n|| Inserire n numeri compresi tra a e b utilizzando un ordine crescente ||\n");

	while(i<n)
	{
		printf("\nInserire il %d\xF8 numero: ",++y);
		scanf("%d",&c);

		if(n%2!=0)
		{
			if(y==(n/2)+1)
			{
				ne=c;
			}			
		}
		else if(n%2==0)
		{
			ne=n/2;

			if(y==n/2)
			{
				ne1=c;
			}
			else if(y==n/2+1)
			{
				ne2=c;
			}
		}

		if(c<=b && c>=a)
		{
			i++;
		}
	}

	if(n%2!=0)
	{
		printf("\nIl numero maggiormente equidistante della sequenza \x8A %d",ne);
	}
	else
	{
		nem=(ne1+ne2)/2;
		printf("\nIl numero maggiormente equidistante della sequenza \x8A %d",nem);
	}
}