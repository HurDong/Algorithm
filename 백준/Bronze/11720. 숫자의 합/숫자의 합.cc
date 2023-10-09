#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	/*char a;
	printf("문자 : ");
	scanf("%c", &a);
	printf("아스키코드(10진수) : %d\n아스키코드(16진수) : %x\n",a,a);

	return 0;*/
	int N;
	char b[100];
	int sum = 0;
	scanf("%d", &N);
	scanf("%s", &b);
	for (int i = 0; i < N; i++) {
		sum += b[i] - '0';
	}
	printf("%d", sum);
	return 0;


}