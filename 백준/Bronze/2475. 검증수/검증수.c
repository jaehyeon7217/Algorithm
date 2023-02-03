#include <stdio.h>

int main() {
	int number, result = 0;

	for (int i = 0; i < 5; i++) {
		scanf("%d", &number);
		result = result + (number * number);
	}

	result = result % 10;
	
	printf("%d", result);

}