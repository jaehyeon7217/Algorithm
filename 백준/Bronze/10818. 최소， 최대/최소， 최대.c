#include <stdio.h>

int main() {
	int t;
	int N;
	int i;
	int max = -1000000, min = 1000000;

	scanf("%d", &t);


	for (i = 0; i < t; i++) {
		scanf("%d", &N);

		if (N > max) max = N;
		if (N < min) min = N;
	}
	printf("%d %d\n", min, max);


	return 0;
}