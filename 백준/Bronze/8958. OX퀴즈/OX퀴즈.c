#include <stdio.h>
#include <string.h>

int main() {
	int t; // 테스트 케이스
	char s[81]; // 정답 문자열
	int ing=0; // 연속 o횟수
	int i, j, sum = 0; // 합계
	

	scanf("%d", &t);

	for (i = 0; i < t; i++) {
		scanf("%s", s, sizeof(s));
		
		for (j = 0; j < strlen(s); j++) {
			if (*(s + j) == 'O') {
				++ing;
				sum += ing;
			}

			else {
				ing = 0;
			}
		}
		printf("%d\n", sum);
		sum = 0;
		ing = 0;
	}

	
	return 0;
}