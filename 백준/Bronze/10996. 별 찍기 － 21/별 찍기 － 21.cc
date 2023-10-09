#include <iostream>

using namespace std;

int main() {
	int i,n,m,k=1;
	cin >> n;
	m = n - n % 2;

	for (i = 1; i < 2 * n+1; i++) {
		if (i % 2 == 0) {
			while(k<n+1){
				if (k % 2 == 0) cout << "*";
				else cout << " ";
				k++;
			}
		}
		if (i % 2 == 1) {
			while(k < n+1) {
				if (k % 2 == 0) cout << " ";
				else cout << "*";
				k++;
			}
		}
		k = 1;
		if(i!=2*n) cout << "\n";
	}
	return 0;
}