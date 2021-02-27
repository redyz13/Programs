#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float area(float ab,float bc) {
	float a;	
	a = ab*bc/2;
	return a;
}

float ipot(float ab, float bc) {
	float ipot;
	ipot = sqrt(ab*ab+bc*bc);
	return ipot;
}

float altezza(float ab, float bc, float ip) {
	float altezza;
	altezza = ab*bc/ip;
	return altezza;
}

int main(int argc, char *argv[]) {
	float ab,bc;
	float a,ip,al;

	printf("Inserire il primo cateto del triangolo rettangolo: ");
	scanf("%f",&ab);
	printf("Inserire il secondo cateto del triangolo rettangolo: ");
	scanf("%f",&bc);

	a = area(ab,bc);
	printf("\nArea = %.2f cm^2",a);

	ip = ipot(ab,bc);
	printf("\nIpotenusa = %.2f cm",ip);

	al = altezza(ab,bc,ip);
	printf("\nAltezza = %.2f cm",al);

	return 0;
}