using namespace std;
#include <iostream>
#include <unordered_map>

const int N = 200010;

struct Query {
	int x;
	int y;
	int e;
}query[N];

int t, n, m;
int p[N];
unordered_map<int, int> idxMap;

void init() {
	n = 0;
	idxMap.clear();
}

int get(int x) {
	if (!idxMap.count(x)) idxMap[x] = ++n; // ¼ÇÂ¼
	return idxMap[x];
}

int find(int x) {
	if (x != p[x]) p[x] = find(p[x]);
	return p[x];
}

int main() {
	scanf("%d", &t);
	while (t--) {
		init();
		scanf("%d", &m);
		for (int i = 0; i < m; i++) {
			int x, y, e;
			scanf("%d%d%d", &x, &y, &e);
			query[i] = { get(x), get(y), e };
		}
		for (int i = 1; i <= n; i++) p[i] = i;

		for (int i = 0; i < m; i++) {
			if (query[i].e == 1) {
				int pa = find(query[i].x), pb = find(query[i].y);
				p[pa] = pb;
			}
		}
		bool checked = true;
		for (int i = 0; i < m; i++) {
			if (query[i].e == 0) {
				int pa = find(query[i].x), pb = find(query[i].y);
				if (pa == pb) {
					checked = false;
					break;
				}
			}
		}

		puts(checked ? "YES" : "NO");
	}
}