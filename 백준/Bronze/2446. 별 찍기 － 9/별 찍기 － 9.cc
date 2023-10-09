#include <iostream>

using namespace std;

int main() {
	int N, k = -2;
	cin >> N;

	for (int i = 2 * N - 1; i <= 2 * N - 1; i += k) {
		for (int z = 1; z <= (2 * N - 1 - i) / 2; z++) cout << ' ';         // 공백 출력
		for (int j = 1; j <= i; j++) cout << '*';                           // 별 출력
		cout << endl;                                                       // 개행
		if (i == 1) k = 2;
        }
    return 0;
}