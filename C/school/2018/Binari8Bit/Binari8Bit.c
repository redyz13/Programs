/*Generare in output tutte le possibili
stringhe di codifica binaria di lunghezza
8 bit
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;

	for(int i=0; i<256; i++)
	{
		printf("\n\t%d\xF8\tStringa\t=\t%d%d%d%d%d%d%d%d",i+1,a,b,c,d,e,f,g,h);

		while(a<1)
		{
			h++;

			while(g<1)
			{
				h=0;
				g++;
				a++;
			}
		}
	}
}