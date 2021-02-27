/*
* Convertitore da Decimale a Binario
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int arr[100],i=0,j;
	int n;

	printf("\nInserire un numero decimale: ");
	scanf("%d",&n);

	while(n>0)
	{
		arr[i]=n%2;
		i++;
		n=n/2;
	}

	printf("\nNumero Binario = ");

	for(j=i-1;j>=0;j--)
	{
		printf("%d",arr[j]);
	}

	printf("\n\n");

	system("pause");
}