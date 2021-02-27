/*Scrivere un programma tale che:
1. Chieda in input un numero n maggiore di 0
2. Chieda in input una sequenza di numeri fino a che,
tale sequenza non contenga n numeri positivi
3. Calcoli e restituisca la media dei numeri negativi
appartenenti alla sequenza al passo 2.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int n,x,mn,sn=0,i=0,cn=0,c=1;

	printf("\nQuanti numeri vuoi inserire? (n) : ");
	scanf("%d",&n);

	while(n<0)
	{
		printf("\nIl numero deve essere > 0 : ");
		scanf("%d",&n);	
	}

	printf("\n\nInserire una sequenza di numeri finch\x82"
	" non contiene n numeri positivi:\n\n");

	while(i<n)
	{
		printf("%d\xF8 Numero\t=\t",c);
		scanf("%d",&x);

		if(x>=0)
		{
			i++;
		}
		else
		{
			cn++;
			sn=sn+x;
		}

		c++;
	}

	if(cn>1)
	{
		mn=sn/cn;
		
		printf("\nMedia Numeri Negativi =\t%d\n",mn);
	}



	return 0;
}