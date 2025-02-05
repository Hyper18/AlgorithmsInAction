#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/08/28
 * @file Q792_高精度减法.cpp
 *
 * 减法最后需要考虑最高位是否含有一或多个前导零
 */
bool cmp(vector<int> &A, vector<int> &B) {
    if (A.size() != B.size()) return A.size() > B.size();
    for (int i = A.size() - 1; i >= 0; i--)
        if (A[i] != B[i])
            return A[i] > B[i];

    return true;
}

vector<int> sub(vector<int> &A, vector<int> &B) {
    vector<int> C;
    int t = 0;
    for (int i = 0; i < A.size(); i++) {
        t = A[i] - t;
        if (i < B.size()) t -= B[i];
        C.push_back((t + 10) % 10);
        t = t < 0 ? 1 : 0;
    }
    while (C.size() > 1 && !C.back()) C.pop_back();

    return C;
}

int main() {
    string a, b;
    vector<int> A, B;
    cin >> a >> b;
    for (int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    for (int i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');
    vector<int> C;
    if (cmp(A, B)) C = sub(A, B);
    else {
        C = sub(B, A);
        cout << '-';
    }
    for (int i = C.size() - 1; i >= 0; i--) cout << C[i];
    cout << endl;

    return 0;
}