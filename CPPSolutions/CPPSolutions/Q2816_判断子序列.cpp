using namespace std;
#include <iostream>

const int N = 1e5 + 10;
int a[N], b[N];

int main() {
	int n, m;
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	for (int i = 0; i < m; i++) scanf("%d", &b[i]);

	int p1 = 0, p2 = 0;
	while (p1 < n && p2 < m) {
		if (a[p1] == b[p2])
			p1++;
		p2++;
	}

	printf("%s", p1 == n ? "Yes" : "No");
}