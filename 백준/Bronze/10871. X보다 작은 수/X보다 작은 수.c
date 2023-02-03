#include <stdio.h>

int main() {
    int n;
    int a, b;
    scanf("%d %d", &n, &a);

    for (int i = 0; i < n; i++) {
        scanf("%d", &b);
        if (b < a) printf("%d ", b);
    }

    return 0;
}