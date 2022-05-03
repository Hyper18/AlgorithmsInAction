using namespace std;
#include <iostream>

const int N = 10e5 + 10;
int a[N], b[N];
int n, m, l, r, c;

void insert(int l, int r, int c) {
	b[l] += c;
	b[r + 1] -= c;
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &a[i]);
		insert(i, i, a[i]);
	}

	while (m--) {
		scanf("%d %d %d", &l, &r, &c);
		insert(l, r, c);
	}

	for (int i = 1; i <= n; i++) {
		b[i] += b[i - 1];
		printf("%d ", b[i]);
	}
}