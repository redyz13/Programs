#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int numeroCompreso(int x, int y) {
  int n;
  do {
    printf("Inserire un numero compreso tra %d e %d: ", x, y);
    scanf("%d", &n);
  }while(n <= x || n >= y);

  return n;
}

int sommaP(int x) {
  int s = 0;
  for(int i = 0; i <= x; i++) {
    if(i % 2 == 0)
      s += i;
  }

  return s;
}

int sommaD(int x) {
  int s = 0;
  for(int i = 0; i <= x; i++) {
    if(i % 2 != 0)
      s += i;
  }

  return s;
}

int main() {
  pid_t pidA, pidB;
  int x, y, s;
  int statusA, statusB;

  x = numeroCompreso(0, 20);
  y = numeroCompreso(0, 20);

  pidA = fork();

  if(pidA == 0) {
    s = sommaD(x);
    exit(s);
  }
  else {
    pidB = fork();

    if(pidB == 0) {
      s = sommaP(y);
      exit(s);
    }
    else {
      waitpid(pidA, &statusA, 0);
      waitpid(pidB, &statusB, 0);

      if(WIFEXITED(statusA))
        if(WIFEXITED(statusB)) {
          printf("\nRisultato 1: %d", WEXITSTATUS(statusA));
          printf("\nRisultato 2: %d\n", WEXITSTATUS(statusB));
          s = (WEXITSTATUS(statusA)) * (WEXITSTATUS(statusB));
          printf("\nRisultato complessivo: %d", s);
          putchar('\n');
        }
    }
  }

  return 0;
}
