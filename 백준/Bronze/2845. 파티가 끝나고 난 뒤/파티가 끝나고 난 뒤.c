#include <stdio.h>

int main() {
	int L, P;
	int article[5];
	int i;

	scanf("%d %d", &L, &P);
	for (i = 0; i < 5; i++) {
		scanf("%d", &article[i]);

	}

	for (i = 0; i < 5; i++) {

		printf("%d ", article[i] - (L*P));
	}
	
	return 0;
}
