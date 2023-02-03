#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char s[21];
    char p[161];
    int t=0, r=0;
    int i=0, j=0, k=0;

    scanf("%d", &t);

    for (i = 0; i < t; i++) {
        scanf("%d", &r);
        scanf("%s", s, sizeof(s));

        for (j = 0; j < strlen(s); j++) {
            for (k = 0; k < r; k++) {
                p[(j * r) + k] = s[j];
            }
        }

        p[strlen(s) * r] = '\0';
        printf("%s\n", p);
    }


    return 0;
}