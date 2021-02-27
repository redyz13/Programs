/*Scrivere un algoritmo tale che simuli il funzionamento
di un registratore di cassa per il calcolo di uno scontrino.
Per ogni articolo venduto, bisognerà inserire quantità, prezzo
unitario e % di sconto, e poi battere un tasto per dire che si
intende inserire un nuovo articolo, oppure un altro tasto per
dire che è finita la lista degli articoli. Terminata la lista
degli articoli il simulatore dovrà mostrare il totale calcolato,
chiedere l'importo versato e calcolare e mostrare il resto da dare
al cliente.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
  char r;
  int itemc,itemq,itemt,sale,p=NULL,prest;
  int c=1,s=0;

  system("cls");
  printf("*Registratore Cassa*\n");

  do
  {
    printf("\nVuoi aggiungere un %d\xF8 articolo alla cassa?\n",c);
    printf("\n1. Si(y)\n2. No(n)\n");
    printf("\nRisposta = ");scanf(" %c",&r);

    if(r=='y')
    {
      c++;
      printf("\nPrezzo articolo = EUR ");scanf("%d",&itemc);
      printf("Quantit\x85 articolo = ");scanf("%d",&itemq);
      printf("Sconto del prodotto = %%");scanf("%d",&sale);
      itemc=itemc*itemq;
      itemt=(itemc*sale)/100;itemt=itemc-itemt;
      s=s+itemt;
    }
  }while(r!='n');
  
  printf("\nLista articoli terminata!\n");
  printf("Totale Spesa = %d\n",s);
  
  if(s>0)
  {
    printf("\nEffettuare il pagamento: EUR ");scanf("%d",&p);
  }

  if(p>s)
  {
    prest=p-s;
    printf("Il suo resto \x8A di EUR %d\n",prest);
  }

  printf("\n");
  system("pause");
}