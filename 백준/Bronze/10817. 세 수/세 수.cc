#include <iostream>

using namespace std;

int compare(int a, int b, int c) {
	if (a > b)
	{
		if (a > c)
		{
			if (b > c) return b;				
			else return c;
		}
		if (a < c)  return a;				
		
	}
	if (a < b){
		if (a > c) return a;
		if (a < c)
		{
			if (b < c) return b;				
			else return c;
		}
	}	
}

int main() {
	int a, b, c;

	cin >> a >> b >> c;

	compare(a,b,c);

	cout<< compare(a,b,c);
	
	return 0;		
}