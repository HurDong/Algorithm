#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	for (int k=1;k<n+1;k++) {
		for (int i = 0; i < k; i++) {
			cout << "*";

		}
		cout << "\n";
	}
	for (int t = n; 0<t; t--) {
		for (int x = 0; x < t-1; x++) {
			cout << "*";
		}
		cout << "\n";
	}
	return 0;
}