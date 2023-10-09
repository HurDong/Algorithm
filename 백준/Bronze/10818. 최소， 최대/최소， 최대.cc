#include <iostream>
#define maxnum 1000000
using namespace std;

int x[maxnum] = { 0 };
int y[maxnum] = { 0 };
int compare1(int x, int y) {
	if (x > y) return x;
	else return y;
}
int compare2(int x, int y) {
	if (x < y) return x;
	else return y;
}
int main() {
	int n = 0;
	int a = 0, b = 0,c=0,d=0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x[i];
	}
	a = x[0];
	for (int j = 1; j < n; j++) {
		b = compare1(a, x[j]);
		a = b;
	}
	c = x[0];
	for (int j = 1; j < n; j++) {
		d = compare2(c, x[j]);
		c = d;
	}
	cout << c << " " << a;
	return 0;
}