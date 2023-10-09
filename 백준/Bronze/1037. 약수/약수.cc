#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define N 1000000

int arr[N];
int n = 0;

void sort() {
	int index = arr[0];
	int i = 0;
	int j = 1;
	int k = 0;
	int temp;
	for (i = 0; i < n;i++) {
		index = arr[i];
		for (j = i + 1; j < n;j++) {
			k = i;
			if (index > arr[j]) {
				index = arr[j];
				k = j;
			}
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}
	}
	if (n <= 1) {
		printf("%d", arr[0] * arr[0]);
	}
	else printf("%d", arr[0] * arr[n - 1]);
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	sort();
	return 0;
}