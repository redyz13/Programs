#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

// (2 + x) * (3 + y) * (7 * z + 4) - 10

int input() {
  int x;
  printf("Inserire un numero intero: ");
  scanf("%d", &x);
  return x;
}

int main() {
  int x, y, z, statusA, statusB, statusC, res;
  pid_t pid1, pid2, pid3;

  x = input();
  y = input();
  z = input();

  pid1 = fork();

  if(pid1 == 0)
    exit(2 + x);
  else {
    pid2 = fork();
    if(pid2 == 0)
      exit(3 + y);
    else {
      pid3 = fork();
      if(pid3 == 0)
        exit(7 * z + 4);
      else {
        waitpid(pid1, &statusA, 0);
        waitpid(pid2, &statusB, 0);
        waitpid(pid3, &statusC, 0);
        res = (WEXITSTATUS(statusA) * WEXITSTATUS(statusB) * WEXITSTATUS(statusC)) - 10;

        printf("\nRisultato: %d", res);
        putchar('\n');
      }
    }
  }

    return 0;
}
