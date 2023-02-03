#include <stdio.h>
#include <stdlib.h>
#include <math.h>

char buffer[10];
int count[10] = { 0 };

int main() {
	int a, b, c;
	int temp, i;

	scanf("%d %d %d", &a, &b, &c);

	temp = a * b * c;
	

		
	if (temp >= 1000000 && temp < 10000000) {
		for (i = 0; i < 7; i++) {
			buffer[i] = (temp % (int)(pow(10.0, i + 1)))/(int)pow(10.0,i) + '0';
		}
		buffer[7] = '\0';
	}
	else if (temp >= 10000000 && temp < 100000000) {
		for (i = 0; i < 8; i++) {
			buffer[i] = (temp % (int)(pow(10.0, i + 1))) / (int)pow(10.0, i) + '0';
		}
		buffer[8] = '\0';
	}
	else if (temp >= 100000000 && temp < 1000000000) {
		for (i = 0; i < 9; i++) {
			buffer[i] = (temp % (int)(pow(10.0, i + 1))) / (int)pow(10.0, i) + '0';
		}
		buffer[9] = '\0';
	}

	for (i = 0; i < 10; i++) {
		count[(buffer[i] - '0')]++;

	}

	for (i = 0; i < 10; i++) {
		printf("%d\n", count[i]);

	}



	return 0;
}