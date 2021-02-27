#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void creaFiglio(int n, int x) {
  pid_t pid;

  pid = fork();

  if(pid == 0) {
    printf("\nSono il processo figlio che discende da %d processo/i; ho pid: %d\n",++x, getpid());
    printf("\nIl mio processo padre ha pid: %d\n", getppid());
    if(n > 0)
      creaFiglio(n - 1, x);
    else
      exit(0);
  }

  else
    printf("\nSono il processo padre con pid: %d\n",getpid());
}

int main() {
  int n;

  do {
    printf("\nInserire il numero di processi figli da creare: ");
    scanf("%d",&n);
  }while(n <= 0);

  creaFiglio(n, 0);

  return 0;
}
