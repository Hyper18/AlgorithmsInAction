#include <iostream>

using namespace std;

const int N = 100010;

int e[N], l[N], r[N];
int idx;

void init() {
    l[0] = 0, r[0] = 1, idx = 2;
}

void addFirst(int val) {
    e[idx] = val;
    l[idx] = 0;
    r[idx] = r[0];
    l[r[0]] = idx;
    r[0] = idx++;
}

void addLast(int val) {
    e[idx] = val;
    l[idx] = l[1];
    r[idx] = 1;
    r[l[1]] = idx;
    l[1] = idx++;
}

void remove(int k) {
    r[l[k]] = r[k];
    l[r[k]] = l[k];
}

void insert(int k, int val) {
    e[idx] = val;
    l[idx] = k;
    r[idx] = r[k];
    l[r[k]] = idx;
    r[k] = idx++;
}

int main() {
    int m;
    cin >> m;
    init();
    while (m--) {
        string op;
        cin >> op;
        int k, val;
        if (op == "L") {
            cin >> val;
            addFirst(val);
        } else if (op == "R") {
            cin >> val;
            addLast(val);
        } else if (op == "D") {
            cin >> k;
            remove(k + 1);
        } else if (op == "IL") {
            cin >> k >> val;
            insert(l[k + 1], val);
        } else if (op == "IR") {
            cin >> k >> val;
            insert(k + 1, val);
        }
    }

    for (int i = r[0]; i != 1; i = r[i])
        cout << e[i] << " ";
}