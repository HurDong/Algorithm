#include <iostream>
//첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0)
//다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)
//점 (x, y)의 사분면 번호(1, 2, 3, 4 중 하나)를 출력한다.
using namespace std;

int main() {
	float a, b;
	cin >> a;
	cin >> b;
	if (a > 0)
	{
		if (b > 0)
			cout << "1";
		else cout << "4";
	}
	else {
		if (b > 0)
			cout << "2";
		else cout << "3";
	}

	return 0;

}