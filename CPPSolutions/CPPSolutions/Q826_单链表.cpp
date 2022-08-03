#include <iostream>

using namespace std;

const int N = 100010;

int e[N], ne[N];
int head, idx;

void init() {
	head = -1, idx = 0;
}

void add(int val) {
	e[idx] = val, ne[idx] = head, head = idx++;
}

void insert(int k, int val) {
	e[idx] = val, ne[idx] = ne[k], ne[k] = idx++;
}

void remove(int k) {
	ne[k] = ne[ne[k]];
}

int main() {
	int m;
	cin >> m;
	init();
	while (m--) {
		char c;
		int k;
		cin >> c >> k;
		switch (c) {
		case 'H': add(k); break;
		case 'I':
			int val;
			cin >> val;
			insert(k - 1, val);
			break;
		case 'D':
			if (k) remove(k - 1);
			else head = ne[head];
			break;
		}
	}

	for (int i = head; i != -1; i = ne[i])
		cout << e[i] << " ";
}