#include <iostream>
using namespace std;

int main() {
	int h, m;
	cin >> h;
	cin >> m;
	if (m >= 45)
		cout << h <<" "<<(m - 45);
	else {
		if (h == 0){
			h = 23;
			m = 60 + m - 45;
			cout << h << " " << m;
		}
		else {
			h = h - 1;
			m = 60 + m - 45;
			cout << h << " " << m;
		}

	}
	return 0;
}