#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int d[1001];

int dp(int x) {
	if (x == 1)return 1;
	if (x == 2)return 2;
	if (d[x] != 0)return d[x];
	return d[x] = (dp(x - 1) + dp(x - 2))%10007;
}

int main() {
	int N = 0;
	scanf("%d", &N);
	printf("%d",dp(N));
	
	return 0;
}