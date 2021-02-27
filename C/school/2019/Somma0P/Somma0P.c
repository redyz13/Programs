#include <stdio.h>
#include <stdlib.h>

int InputN(int a) {
	int n;
	
	do {
		printf("Inserire un numero n positivo maggiore di 4: ");
		scanf("%d",&n);
	}while(n<a);
	
	return n;
}

int Somma0(int x) {
	int s=0;
	
	while(x>0) {
		s+=x;
		x--;
	}
	
	return s;
}

int main(int argc, char *argv[]) {
	int n,x,i,s,c=0;
	
	n=InputN(4);
	
	for(i=0;i<n;i++) {
		printf("\nInserire il %d numero della sequenza: ",++c);
		scanf("%d",&x);
		
		if(x>0) {
			s=Somma0(x);
			printf("\nSomma dei numeri tra 0 ed %d = %d\n",x,s);
		}
	}
	
	return 0;
}
