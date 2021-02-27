#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int numeriPari(int n) {
  int x;
  for(int i = 0; i < n; i++) {
    if(i % 2 == 0)
      x++;
  }

  return x;
}

int numeriDispari(int n) {
  int x;
  for(int i = 0; i < n; i++) {
    if(i % 2 != 0)
      x++;
  }

  return x;
}

int numeriMultipli(int n) {
  int x;
  for(int i = 0; i < n; i++) {
    if(i % 10 == 0)
      x++;
  }

  return x;
}

int main() {
  pid_t pid, pid2;
  int n;

  do {
    printf("Inserire un numero maggiore di 100000: ");
    scanf("%d",&n);
  }while(n <= 100000);

  putchar('\n');
  pid = fork();

  if(pid > 0)
    pid2 = fork();

  if(pid == 0)
    printf("Numero di numero pari compresi tra 0 ed n: %d\n",numeriPari(n));
  else if(pid2 == 0)
    printf("Numero di numero dispari compresi tra 0 ed n: %d\n",numeriDispari(n));
  else
    printf("Numero di numeri multipli di 10 compresi tra 0 ed n: %d\n",numeriMultipli(n));

  /* int returnStatus;
  waitpid(pid, &returnStatus, 0); */

  return 0;
}
