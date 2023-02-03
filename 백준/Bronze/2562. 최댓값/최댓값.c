#include <stdio.h>

int main() {
    int H;
    int tempx=0, tempy=0;

    for (int i = 0; i < 9; i++) {
        scanf("%d", &H);
        if (tempx < H) {
            tempx = H;
            tempy = i + 1;
        }
    }
    printf("%d\n%d", tempx, tempy);

    return 0;
}