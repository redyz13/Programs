/*
* Convertitore da Binario a Decimale
*/

#include <stdio.h>

int main(int argc, char * argv[])
{
    int num,num_b,num_d=0,base=1,resto;

    //Inserzione numero binario

    printf("\nInserire un numero binario: ");
    scanf("%d",&num);

    num_b=num;

    //Conversione a Decimale

    while(num>0)
    {
        resto=num%10;
        num_d=num_d+resto*base;
        num=num/10;
        base=base*2;
    }

    //Output del numero convertito

    printf("\nIl suo equivalente in decimale \x82 : %d\n",num_d);

    return 0;
}