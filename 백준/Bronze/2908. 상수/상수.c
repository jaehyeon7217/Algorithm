#include <stdio.h>


int reverse(int a) {
	int tempx, tempy, tempz;

	tempx = a / 100;
	tempy = (a - (tempx * 100)) / 10;
	tempz = a % 10;

	return (tempz * 100) + (tempy * 10) + tempx;
}

int main() {
	int a, b;
	
	scanf("%d %d", &a, &b);

	a = reverse(a);
	b = reverse(b);

	printf("%d", a > b ? a : b);


	return 0;
}