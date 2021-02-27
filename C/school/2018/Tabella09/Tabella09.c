/*Scrivere un programma che generi in output
tutte le quaterne attribuibili facendo variare
ogni cifra della quaterna tra 0 e 9.
Mantenere l'output in forma tabellare e numerando
le quaterne.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	short c0=0,c1=0,c2=0,c3=0,c=0,i;

	for(i=0; i<10000; i++)
	{
		printf("\n\t%d\xF8\tQuaterna\t=\t%d%d%d%d",c,c3,c2,c1,c0);
		
		if(c0<9)
		{
			c0++;
		}
		else if(c0==9)
		{
			c0=0;
			c1++;
		}

		if(c1>9)
		{
			c0=0;
			c1=0;
			c2++;
		}

		if(c2>9)
		{
			c0=0;
			c1=0;
			c2=0;
			c3++;
		}

		c++;
	}
}