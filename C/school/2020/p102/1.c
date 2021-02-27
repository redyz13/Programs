#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

// 5 * [(2 + 4) * (7 + 3)] - 10

int main() {
  pid_t pid1, pid2;

    int statusA, statusB, res;

    pid1 = fork();

    if(pid1 == 0)
        exit(2 + 4);
    else {
        pid2 = fork();
        if(pid2 == 0) {
            exit(7 + 3);
        }
        else {
            waitpid(pid1, &statusA, 0);
            waitpid(pid2, &statusB, 0);

            res = 5 * (WEXITSTATUS(statusA) * WEXITSTATUS(statusB)) - 10;
            printf("Risultato : %d", res);
            putchar('\n');
        }
    }

    return 0;
}
