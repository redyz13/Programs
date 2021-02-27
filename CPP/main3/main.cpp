#include <iostream>
using namespace std;

int main() {
    const int N = 3;
    float a[N];
    int c = 0, s = 0, m;

    for(int i = 0; i < N; i++) {
        cout << "Inserire il " << i + 1 << "\xF8 numero: ";
        cin >> a[i];
        c++;
        s += a[i];
    }

    m = s / c;

    cout << "\nSomma = " << s;
    cout << "\nMedia = " << m;
}