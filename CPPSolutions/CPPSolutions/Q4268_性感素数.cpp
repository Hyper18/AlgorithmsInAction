using namespace std;
#include <iostream>

bool isPrime(int x) {
	if (x <= 2) return false;
	for (int i = 2; i <= x / i; i++)
		if (x % i == 0) 
			return false;
	return true;
}

int main() {
	int n;
	cin >> n;
	if (isPrime(n - 6) && isPrime(n)) {
		cout << "Yes" << endl << n - 6;
		return 0;
	}
	if (isPrime(n) && isPrime(n + 6)) {
		cout << "Yes" << endl << n + 6;
		return 0;
	}

	for (int i = n + 1; ; i++) {
		if (isPrime(i) && (isPrime(i - 6) || isPrime(i + 6))) {
			cout << "No" << endl << i;
			return 0;
		}
	}
}