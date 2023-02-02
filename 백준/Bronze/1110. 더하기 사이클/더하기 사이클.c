#include <stdio.h>

int main() {
	int N;
	int cycle = 0;
	int ten, one, sum=0;
	int temp = 0;

	scanf("%d", &N);
	
	while (N < 0 || N>100) {
		printf("0<=N<100\n");
		scanf("%d", &N);
	}
	temp = N;
	do {
		ten = temp / 10;
		one = temp % 10;
		sum = (ten + one) % 10;
		temp = (one * 10) + sum;
		cycle++;
	} while (temp != N);
	
	printf("%d", cycle);
	

	return 0;
}