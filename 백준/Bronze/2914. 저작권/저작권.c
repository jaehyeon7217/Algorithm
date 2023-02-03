
#include <stdio.h>

int main() {
	int A, I;

	scanf("%d %d", &A, &I);
	if (A == 1) printf("%d", A * I);
	else {
		printf("%d", A * (I - 1) + 1);
	}
	
	return 0;
}