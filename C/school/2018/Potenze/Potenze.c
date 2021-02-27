/*Scrivere un algoritmo che dia in input le prime
10 potenze dei numeri che vanno da 1 a 9.
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, const char * argv[])
{
	int num=1,c=1,r;

  while(num<=9)
  {
    r=pow(num,c);
    printf("\t%d^%d\t=\t%d\n",num,c,r);
    c++;

    if(c==10)
    {
      c=1;
      num++;
    }
  }
  return 0;
}