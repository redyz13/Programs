/*Scrivere un programma tale che:
1. Chieda in input 100 numeri
2. Conti e restituisca quante volte succede che
vengono inseriti due numeri uguali consecutivamente
3. Conti e restituisca quante volte succede che
vengono inseriti due numeri positivi consecutivamente
4. Conti e restituisca quante volte succede che
vengono inseriti due numeri negativi consecutivamente
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	const int NI=10;
	int x,np,i=0,c=1;
	int cu=0,cp=0,cn=0;

	printf("\nInserire %d numeri:\n\n",NI);

	while(i<NI)
	{
		printf("%d\xF8\tNumero\t=\t",c),scanf("%d",&x);

		if(i==0)
		{
			np=x;
		}

		if(x==np && i>0)
		{
			cu++;
		}

		if(x>=0)
		{
			cp++;
		}
		else if(x<0 && np<=0)
		{
			cn++;
		}
	
		np=x;
		i++;
		c++;
	}

	printf("\nNumeri uguali consecutivi = %d\n",cu);
	printf("\nNumeri positivi consecutivi = %d\n",cp);
	printf("\nNumeri negativi consecutivi = %d\n",cn);

	return 0;
}