/*Scrivere un programma tale che:
1. Chieda in input 10 coppie di numeri, x e y
2. Per ogni coppia inserita al passo 1 calcoli
e restituisca:
2.1 La somma dei numeri compresi tra x ed y se
x è <= di y
2.2 La somma dei numeri compresi tra y ed x se
y è <= di x
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int x,y,s1=0,s2=0,i=0,c=1;

	while(i<10)
	{
		printf("\nInserire la %d\xF8\tcoppia di numeri (X Y): ",c);
		scanf("%d %d",&x,&y);

		if(x<=y)
		{
			while(x<=y)
			{
				s1=s1+x;
				x++;
			}
		}
		else
		{
			while(y<=x)
			{
				s2=s2+y;
				y++;
			}	
		}	
		
		c++;
		i++;
	}

	printf("\nSomma numeri compresi fra X e Y = %d",s1);
	printf("\nSomma numeri compresi fra Y e X = %d\n",s2);

	return 0;
}