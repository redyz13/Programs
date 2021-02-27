/*
* Calcolatrice Semplice
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
  float x,y,z;
  char op;

  system("cls");
  
  printf("\n*Calcolatrice Semplice*\n");
  printf("\nInserire il primo operando: ");
  scanf("%f",&x);
  printf("Inserire il secondo operando: ");
  scanf("%f",&y); 

  printf("\n1. Addizzione (+)\n2. Sottrazione (-)");
  printf("\n3. Moltiplicazione (*)\n4. Divisione (/)\n");

  printf("\nSelezione l'operazione da eseguire: ");
  scanf(" %c",&op);

  switch(op)
  {
    case('+'):
    z=x+y;
    printf("\nSomma = %f\n",z);
    break;

    case('-'):
    z=x-y;
    printf("\nDifferenza = %f\n",z);
    break;

    case('*'):
    z=x*y;
    printf("\nProdotto = %f\n",z);
    break;

    case('/'):
    z=x/y;
    printf("\nDivisione = %f\n",z);
    break;

    default:
    printf("\nInserire un carattere valido!\n");
    break;
  }

  printf("\n");
  system("pause");
}