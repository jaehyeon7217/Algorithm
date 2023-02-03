#include <stdio.h>

int main() {
    int H,M;
    int temp;
    scanf("%d %d", &H, &M);

    H = H * 60;
    temp = H + M;
    if (temp < 45) temp = temp + (24 * 60) - 45;
    else temp = temp - 45;
    H = temp / 60;
    M = temp % 60;

    printf("%d %d", H, M);

    return 0;
}