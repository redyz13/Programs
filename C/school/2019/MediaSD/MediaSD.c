/*Scrivere un programma tale che:
1. Chiede in input un numero n positivo
2. Chiede in input una sequenza numerica
assicurandosi che sia composta da n numeri
e che sia strettamente decrescente
3. Calcolare e restituire la media dei numeri
che compongono la sequenza.
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
	int x=0,i=0,s=0,c=0,n,y,m;
	
	do {
		printf("\nInserire un numero n positivo diverso da 0: ");
		scanf("%d",&n);
	}while(n<=0);
	
	printf("\n| Inserire una sequenza strettamente descrescente |\n");
	
	while(i<n) {
		y=x;
		printf("\n\tInserire il %d\xF8 numero: ",++c);
		scanf("%d",&x);
		
		if(x<y||c==1) {
			s+=x;
			i++;
		}
		else if(x>=y&&c>1) {
			do {
				printf("\n  Numero errato, reinserire il %d numero: ",c);
				scanf("%d",&x);
			}while(x>=y);
			
			s+=x;
			i++;
		}
	}
	
	m=s/i;
	
	printf("\nMedia = %d",m);
}
