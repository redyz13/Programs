/*Scrivere un programma tale che:
1. Carichi un array di n interi
2. Carichi un secondo array in modo che
contenga tutti i valori contenuti nel primo
array disposti in ordine crescente
3. Visualizzare in output il secondo array
*/

#include <iostream>

int compresoTra(int min, int max) {
	int x;
	
	do {
		std::cout << "Inserire un numero compreso tra " << min << " e " << max << " : ";
		scanf("%d",&x);
	}while(x < min || x > max);
	
	return x;
}

void caricaArray(int n, int a[]) {
	int i;
	std::cout << "\n";

	for(i = 0; i < n; i ++) {
        std::cout << "\tInserire il numero della cella " << i << " : ";
		std::cin >> a[i];
	}
}

void visualizzaArray(int n, int a[]) {
    int i;

    for(i = 0; i < n; i++)
        std::cout << "\n\tValore cella " << i << " = " << a[i];
}

int main() {
    int ix;

    ix = compresoTra(0, 100);

    int a[ix], a1[ix], tmp;

    caricaArray(ix, a);

    for(int i = 0; i < ix; i++)
        a1[i] = a[i];

    for(int i = 0; i < ix; i++)
        for(int j = 0; j < ix; j++)
            if(a1[j] > a1[i]) {
                tmp = a1[i];
                a1[i] = a1[j];
                a1[j] = tmp;
            }

    visualizzaArray(ix, a1);

    return 0;
}