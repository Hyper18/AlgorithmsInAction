#include <iostream>
#include <vector>

using namespace std;

const int N = 1e6 + 10;

int main() {
	string a, b;
	vector<int> A, B;
	cin >> a >> b;
	for (auto i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
	for (auto i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');

}