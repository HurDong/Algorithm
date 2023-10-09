#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	cout << std::setprecision(16) << endl;
	double a, b;
	cin >> a;
	cin >> b;
	cout << a / b;

	return 0;
}