#include <iostream>
#include <windows.h>
using namespace std;

int main() {
	string hello = "Hello Michele La Marca. Let's get programming in C++";
	int x = 0;

	while(hello[x] != '\0') {
		cout << hello[x];
		if (hello[x]!= ' ' && hello[x]!= '\n')
				Beep(550,100);
		x++;
	};
	
	printf("\n\nPress Enter to exit: ");
	getchar();
	return 0;
}