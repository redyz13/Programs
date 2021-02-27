#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/*int numeroPositivo() {
  int x;

  do {
    printf("\nInserire un numero positivo: ");
    scanf("%d", &x);
  }while(x <= 0);

  return x;
}*/

int sommaCompresiPid() {
  int x = 0;

  for(int i = getppid(); i < getpid(); i++) {
    x += i;
  }

  return x;
}

int main() {
  pid_t pid, pid2;
  /*int a, b, c;

  a = numeroPositivo();
  b = numeroPositivo();
  c = numeroPositivo();*/

  pid = fork();

  if(pid > 0)
    pid2 = fork();

  if(pid == 0)
    printf("\nSomma dei numeri compresi tra pid del processo padre e figlio 1: %d\n", sommaCompresiPid());
  else if(pid2 == 0)
    printf("\nSomma dei numeri compresi tra pid del processo padre e figlio 2: %d\n", sommaCompresiPid());
  else
    printf("\nSomma dei numeri compresi tra pid del processo padre e figlio 3: %d\n", sommaCompresiPid());

  return 0;
}
