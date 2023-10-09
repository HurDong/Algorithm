/*첫째 줄에(A + B) % C, 둘째 줄에((A%C) + (B%C)) % C,
셋째 줄에(A×B) % C, 넷째 줄에((A%C) ×(B%C)) % C를 출력한다.*/
#include <iostream>

using namespace std;

int main() {
	int a, b, c;
	cin >> a;
	cin >> b;
	cin >> c;
	cout << (a + b) % c << endl << ((a%c) + (b%c)) % c << endl << (a*b) % c << endl << ((a%c)*(b%c)) % c;
	return 0;
}