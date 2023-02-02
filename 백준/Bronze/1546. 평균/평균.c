#include <stdio.h>
#include <stdlib.h>

int* e;

int main() {

	int n;
	int i;
	double sum = 0;
	int max = -1;
	double a = 0.0;

	scanf("%d", &n);

	e = (int*)malloc(sizeof(int) * n);
	if (e == NULL) return -1;

	for (i = 0; i < n; i++) {
		scanf("%d", &e[i]);
		if (e[i] > max) {
			max = e[i];
		}
	}
	for (i = 0; i < n; i++) {
		sum = sum + (((double)e[i] / (double)max) * 100.0);
	}
	
	a = sum / n;

	printf("%.2lf", a);

	free(e);
	
	return 0;
}