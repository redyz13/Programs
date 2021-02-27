#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <pthread.h>

void *codice1(void *arg) {
  printf("DIN");
  putchar('\n');
  sleep(1);
}

void *codice2(void *arg) {
  printf("\nDON");
  putchar('\n');
  sleep(2);
}

void *codice3(void *arg) {
  printf("\nDAN");
  putchar('\n');
  sleep(3);
}

int main() {
  pthread_t ptid1, ptid2, ptid3;

  pthread_create(&ptid1, NULL, &codice1, NULL);
  pthread_create(&ptid2, NULL, &codice2, NULL);
  pthread_create(&ptid3, NULL, &codice3, NULL);

  sleep(4);
  return 0;
}
