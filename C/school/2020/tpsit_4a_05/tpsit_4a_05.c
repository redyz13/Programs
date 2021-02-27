#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
  pid_t pid, pid1, pid2, pid3, pid4, pid5, status;

  pid1 = fork();

  if(pid1 == 0) {
    printf("(1) Sono il processo figlio con pid: %d\n", getpid());
    sleep(1);
    exit(1);
  }
  else {
    pid2 = fork();
    if(pid2 == 0) {
      printf("(2) Sono il processo figlio con pid: %d\n", getpid());
      sleep(2);
      exit(2);
    }
    else {
      pid3 = fork();
      if(pid3 == 0) {
        printf("(3) Sono il processo figlio con pid: %d\n", getpid());
        sleep(3);
        exit(3);
      }
      else {
        pid4 = fork();
        if(pid4 == 0) {
          printf("(4) Sono il processo figlio con pid: %d\n", getpid());
          sleep(4);
          exit(4);
        }
        else
        pid5 = fork();
        if(pid5 == 0) {
          printf("(5) Sono il processo figlio con pid: %d\n", getpid());
          sleep(5);
          exit(5);
        }
        else {
          printf("(6)\tSono il processo padre con pid: %d (In attesa del figlio più veloce)\n", getpid());
          pid = waitpid(pid1, &status, 0);
          printf("(7)\tTermina il figlio con pid: %d\n", pid);
        }
      }
    }
  }

  return 0;
}
