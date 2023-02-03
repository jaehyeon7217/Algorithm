#include <stdio.h>

int main() {

	int a, i;
	int b[42]={0};
	int sum = 0;

	for (i = 0; i < 10; i++) {

		scanf("%d", &a);
		b[a % 42]++;
		
	}

	for (i = 0; i < 42; i++) {
		if (b[i] == 0) sum++;
	}

	printf("%d", 42 - sum);


	return 0;
}