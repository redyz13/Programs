/*
* Calcolatrice Semplice
*/

#include <stdio.h>
#include <stdlib.h>

float x,y;

float Addizzione() {
  float z;
  z=x+y;
  return z;
}

float Sottrazione() {
  float z;
  z=x-y;
  return z;
}

float Moltiplicazione() {
  float z;
  z=x*y;
  return z;
}

float Divisione() {
  float z;
  z=x/y;
  return z;
}

int main(int argc, char *argv[])
{
  float z;
  char op;
  
  printf("\n*Calcolatrice Semplice*\n");
  printf("\nInserire il primo operando: ");
  scanf("%f",&x);
  printf("Inserire il secondo operando: ");
  scanf("%f",&y); 

  printf("\n1. Addizzione (+)\n2. Sottrazione (-)");
  printf("\n3. Moltiplicazione (*)\n4. Divisione (/)\n");

  printf("\nSeleziona l'operazione da eseguire: ");
  scanf(" %c",&op);

  if(op=='+') {
    z = Addizzione();
    printf("\nRisultato Addizzione = %.2f",z);
  }

  if(op=='-') {
    z = Sottrazione();
    printf("\nRisultato Sottrazione = %.2f",z);
  }

  if(op=='*') {
    z = Moltiplicazione();
    printf("\nRisultato Moltiplicazione = %.2f",z);
  }

  if(op=='/') {
    z = Divisione();
    printf("\nRisultato Divisione+ = %.2f",z);
  }

  return 0;
}