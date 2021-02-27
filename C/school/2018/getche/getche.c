#include <stdio.h>
#include <conio.h>

int main(int argc, const char * argv[])
{
	char c;

	printf("\nType any character: ");

	c = getche();

	printf("\nRecived %c, exiting the program...\n",c);

	return 0;
}