#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
  const int a = 4, b = 6;
  pid_t pid;

  printf("\nTavola pitagorica del %d:\n", a);
  for(int i = 1; i <= 10; i++)
    printf("\n%d * %d = %d",a, i, a * i);

  pid = fork();

  if(pid == 0) {
    printf("\n\nTavola pitagorica del %d:\n", b);
    for(int i = 1; i <= 10; i++)
      printf("\n%d * %d = %d",b, i, b * i);
  }

  printf("\n");
  return 0;
}
