using namespace std;
#include <iostream>

typedef long long LL;

const int N = 3e3 + 10;
int n, m;
LL f[N];

int main() {
	scanf("%d%d", &n, &m);
	
	f[0] = 1;
	for (int i = 0; i < n; i++) {
		int v;
		scanf("%d", &v);
		for (int j = v; j <= m; j++) {
			f[j] += f[j - v];
		}
	}
	printf("%lld", f[m]);
}