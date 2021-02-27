#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

// (3 + 2) * (5 - 2) * (8 - 3)

int main() {
  pid_t pid1, pid2, pid3;

    int statusA, statusB, statusC, res;

    pid1 = fork();

    if(pid1 == 0)
        exit(3 + 2);
    else {
        pid2 = fork();
        if(pid2 == 0)
            exit(5 - 2);
        else {
            pid3 = fork();
            if(pid3 == 0)
                exit(8 - 3);
            else {
                waitpid(pid1, &statusA, 0);
                waitpid(pid2, &statusB, 0);
                waitpid(pid3, &statusC, 0);

                res = (WEXITSTATUS(statusA) * WEXITSTATUS(statusB) * WEXITSTATUS(statusC));

                printf("Risultato: %d", res);
                putchar('\n');
            }
        }
    }

    return 0;
}
