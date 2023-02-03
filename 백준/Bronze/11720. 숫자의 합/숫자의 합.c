#include <stdio.h>
#include <stdlib.h>

int main() {

	int n,i;
	char* a;
	int sum=0;

	scanf("%d", &n);

	
	a = (char*)malloc(sizeof(char) * n);

		scanf("%s", a, sizeof(a)+1);

	for (i = 0; i < n; i++) {
		sum = sum + (int)a[i] - 48;
	}

	printf("%d\n", sum);


	free(a);

	return 0;
}