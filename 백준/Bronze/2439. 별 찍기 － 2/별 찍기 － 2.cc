#include <iostream>

using namespace std;

int main()
{
	int n;
	cin >> n;
	int a,b,c;
	for (a = 0; a < n; a++) {
		for (b = 0; b<n-a-1; b++) {
			cout << " ";
		}
		for (c = 0;c<a+1;c++) {
			cout << "*";
		}
		cout << "\n";
	}

	return 0;
}