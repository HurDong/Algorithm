#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int N, sum = 0,big=0;
	double  ans = 0;
	scanf("%d", &N);
	int score[1000];
	for (int i = 0; i < N; i++) {
		scanf("%d", &score[i]);
		if (big < score[i]) big = score[i];
		sum += score[i];
	}
	ans = double (sum *100)/ double (big * N);
	printf("%.2f", ans);
	return 0;


}