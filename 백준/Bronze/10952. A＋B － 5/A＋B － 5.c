#include <stdio.h>

int main() {
    int H,M;
    
    do {
        scanf("%d %d", &H, &M);

        if((H + M) != 0)  printf("%d\n", H+ M);

    } while ((H + M) != 0);
    return 0;
}