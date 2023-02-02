#include <stdio.h>
#include <string.h>
#include <math.h>

char v[6];

// 숫자 '0' = 48

int isP(int t) {

	int i;
	int len=0;
	int temp = 0;
	int flag = 0;
	
	if (0 < t && t < 10) {
		printf("yes\n");
		return -1;
	}
	else if (9 < t && t < 100) len = 2;
	else if (99 < t && t < 1000) len = 3;
	else if (999 < t && t < 10000) len = 4;
	else if (9999 < t && t < 100000) len = 5;
	else {
		printf("no");
		return -1;
	}

	for (i = 0; i < len; i++) {
		temp = (t % (int)(pow(10.0, i+1)))/(int)(pow(10.0,i));
		v[i] = temp+48;
	}

	v[len] = '0';

	for (i = 0; i < len/2 ; i++) {
		if (v[i] != v[len - 1-i]) {
			printf("no\n");
			return -1;
		}
	}
	printf("yes\n");
	return 0;

}

int main() {

	int t;

	while (scanf("%d", &t) != EOF && t!=0) {

		isP(t);
	}

	return 0;

}
