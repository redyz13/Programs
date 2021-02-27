#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <pthread.h>

int nCoppie() {
  int n;

  do {
    printf("Inserire il numero di coppie da calcolare: ");
    scanf("%d",&n);
  }while(n < 2);

  return n;
}

void inserisciCoppie(int n, int *c) {
  int x, y;
  int counter = 0;

  for(int i = 0; i < n * 2; i++) {
    printf("\nPrimo numero coppia %d: ", ++counter);
    scanf("%d",&x);
    printf("\nSecondo numero coppia %d: ", counter);
    scanf("%d",&y);

    c[i] = x;
    c[i + 1] = y;
    i++;
  }
}

void *threadCode(void *arg) {
  int *c[4];

  for(int i = 0; i < 4; i++)
    c[i] = (int*) arg;

  for(int i = 0; i < 4; i++)
    printf("%d", c[i]);
}

int main() {
  int n;
  pthread_t ptid;

  n = nCoppie();
  int c[n];
  inserisciCoppie(n, c);

  pthread_create(&ptid, NULL, &threadCode, (void*) &c);
  pthread_join(ptid, NULL);

  return 0;
}
