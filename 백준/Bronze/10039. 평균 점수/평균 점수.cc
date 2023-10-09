#include <iostream>

using namespace std;
int cut(int x) {
	if (x < 40)
		x = 40;
	return x;
}
int main() {
	int a, b, c, d, e;
	int avg = 0;
	cin >> a >> b >> c >> d >> e ;
	cut(a);
	cut(b);
	cut(c);
	cut(d);
	cut(e);
	avg = (cut(a) + cut(b) + cut(c) + cut(d) + cut(e))/5;
	cout << avg;
	return 0;
}