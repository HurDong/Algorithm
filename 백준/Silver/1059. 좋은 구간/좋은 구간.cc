#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int length;
	int s[1000];
	int n;
	int big=1000, small=0;
	scanf("%d", &length);
	for (int i = 0; i < length; i++) {
		scanf("%d", &s[i]);
	}
	scanf("%d", &n);
	for (int i = 0; i < length; i++) {
		if (n < s[i]) {
			if (s[i] < big) {
				big = s[i];
			}
		}
		else if (n > s[i]) {
			if (s[i] > small) {
				small = s[i];
			}
		}
		else if (n == s[i]) {
			printf("%d", 0);
			return 0;
		}
	}
	printf("%d", ((n - small)*(big - n)) - 1);
	return 0;
}