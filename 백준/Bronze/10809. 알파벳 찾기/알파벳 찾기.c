#include <stdio.h>
#include <string.h>


int count[26] = {0.};
char s[100];

int main() {
	int size = sizeof(s);
	int i, len;


	scanf("%s", s, size);

	len = strlen(s);

	for (i = 0; i < 26; i++) {
		count[i]--;
	}

	for (i = 0; i < len; i++) {
		if(count[s[i] - 97] == -1) count[s[i] - 97] = i;
	}

	for (i = 0; i < 26; i++) {
		printf("%d ", count[i]);
	}

	
	return 0;
}