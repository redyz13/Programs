/*Scrivere un programma tale che:
1. Chieda in input un numero n maggiore di 0
2. Chieda in input una sequenza di numeri fino a che,
tale sequenza non contenga n numeri positivi
3. Calcoli e restituisca la media dei numeri negativi
appartenenti alla sequenza al passo 2.
*/

#include <iostream>

int main() {
    int n, a, mn;
    int cp = 0, sn = 0, cn = 0;

    do {
        std::cout << "Inserire un numero n maggiore di 0: ";
        std::cin >> n;
    }while(n <= 0);

    std::cout << "\n---> La sequenza si interrompe all'inserimento di n numeri positivi <---\n\n";

    do {
        std::cout << "Inserire il " << cp + 1 << " numero positivo: ";
        std::cin >> a;

        if(a < 0) {
            cn++;
            sn += a;
        }
        else if (a > 0)
            cp++;
    
    }while(cp != n);

    mn = sn / cn;

    std::cout << "\nMedia numeri negativi inseriti: " << mn;

    return 0;
}