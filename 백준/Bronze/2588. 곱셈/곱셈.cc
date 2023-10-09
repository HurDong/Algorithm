#include <iostream>

using namespace std;
int div1(int y,int x) {
	int a, b, c,d,e;
	e = x % 100;
	c = e % 10;
	b = e - c;
	a = x - (b + c);
	d = y * c;
	return d;
}
int div2(int y, int x) {
	int a, b, c, d, e;
	e = x % 100;
	c = e % 10;
	b = e - c;
	a = x - (b + c);
	d = y * b / 10;
	return d;
}
int div3(int y, int x) {
	int a, b, c, d, e;
	e = x % 100;
	c = e % 10;
	b = e - c;
	a = x - (b + c);
	d = y * a / 100;
	return d;
}
int main() {
	int a, b;

	cin >> a;
	cin >> b;

	cout << div1(a ,b) << endl;
	cout << div2(a, b) << endl;
	cout << div3(a, b) << endl;
	cout << div1(a, b) + div2(a, b) * 10 + div3(a, b) * 100;

	return 0;
}