#include <iostream>

using namespace std;

int main()
{
	int t;
	cin>>t;
	for (int i = 1;i<t+1; i++)
	{
		for (int k = 0; k < i; k++) {
			cout << "*";
		}
		cout << endl;
	}
	return 0;
}