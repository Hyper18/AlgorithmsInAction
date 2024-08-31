using namespace std;

#include <iostream>
#include <unordered_set>

const int N = 1e5 + 10;

int main() {
    int n, m;
    cin >> n;
    unordered_set <string> set;
    string str;
    while (n--) {
        cin >> str;
        set.insert(str);
    }

    cin >> m;
    string a, b;
    int ans = 0;
    while (m--) {
        cin >> str;
        if (set.count(str)) {
            ans++;
            if (a.empty() || a.substr(6, 8) > str.substr(6, 8)) a = str;
        }
        if (b.empty() || b.substr(6, 8) > str.substr(6, 8)) b = str;
    }

    cout << ans << endl;
    if (ans) cout << a;
    else cout << b;
}