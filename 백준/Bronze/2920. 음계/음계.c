#include <stdio.h>

int main() {
	int m[8];
	int i;
	int flag = 0;

	for (i = 0; i < 8; i++) {
		scanf("%d", &m[i]);

		if (m[i] == i + 1) {
			flag ++;
		}
		else if (m[i] == 8 - i) {
			flag --;
		}
	}

	switch (flag) {
	case 8 : printf("ascending\n"); return 0;
	case -8 : printf("descending\n"); return 0;
	default : printf("mixed\n");
	}
	



	return 0;
}