#include <iostream>

using namespace std;

int main() {
		int a=0, b=0,c=0,d=0,n=0,length=0;
		cin >> n; 
		b = n % 10;
		a = n - b;
		c = ((a / 10) + b) % 10;
		while (d !=n) {
			a = b;			
			b = c;			
			d = 10*a + b;
			c = ((a % 10) + b) % 10;
			++length;
		}
		if(n!=0)		
		cout << length;
		else cout << "1";
		return 0;
}