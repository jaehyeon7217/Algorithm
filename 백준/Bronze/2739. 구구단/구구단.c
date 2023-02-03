#include <stdio.h>

int main() {
    int R1;

    scanf("%d", &R1);

    for (int i = 1; i <= 9; i++) {
        printf("%d * %d = %d\n", R1, i, R1 * i);
    }

    return 0;
}