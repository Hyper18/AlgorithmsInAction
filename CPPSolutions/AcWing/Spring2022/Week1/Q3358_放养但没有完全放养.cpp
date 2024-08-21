using namespace std;
#include <algorithm>
#include <iostream>
#include <string>

int main() {
	int indexs[26];
	char c;
	for (int i = 0; i < 26; i++) {
		cin >> c;
		indexs[c - 'a'] = i;
	}
	
	string input;
	cin >> input;
	int n = input.size();
	int ans = 1;
	if (n == 1) {
		cout << ans;
		return 0;
	}
	for (int i = 1; i < n; i++) {
		if (indexs[input[i] - 'a'] - indexs[input[i - 1] - 'a'] <= 0) {
			ans++;
		}
	}
	cout << ans;
	
	return 0;
}