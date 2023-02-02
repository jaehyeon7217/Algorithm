#include <stdio.h>

int main() {
	int length;
	char input[51];
	char result[51];

	scanf("%d", &length);

	scanf("%s", input, sizeof(input));
	for (int i = 0; i < sizeof(input); i++) {
		if (input[i] == NULL) {
			result[i] = NULL;
			break;
		}
		result[i] = input[i];
	}

	for (int i = 0; i < length-1; i++) {
		scanf("%s", input, sizeof(input));
		for (int j = 0; j < sizeof(input); j++) {
			if (input[j] == NULL) {
				break;
			}

			else if (input[j] != result[j]) {
				result[j] = '?';
			}
		}

	}
	printf("%s", result);


	return 0;
}