#include <stdio.h>

int main() {
    int R1;

    scanf("%d", &R1);

    if (R1 >= 90 && R1 <= 100) printf("A");
    else if (R1 >= 80 && R1 < 90) printf("B");
    else if (R1 >= 70 && R1 < 80) printf("C");
    else if (R1 >= 60 && R1 < 70) printf("D");
    else printf("F");

    return 0;
}