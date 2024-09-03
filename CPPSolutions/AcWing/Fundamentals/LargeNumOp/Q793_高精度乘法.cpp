#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/08/29
 * @file Q793_高精度乘法.cpp
 *
 * 这里的重点在于mul中循环的终止条件
 * i < A.size() || t
 * 即使i == A.size()，但此时存在t!=0的情况，是需要进位的
 */
vector<int> mul(vector<int> &A, int b) {
    vector<int> C;
    int t = 0;
    for (int i = 0; i < A.size() || t; i++) {
        if (i < A.size()) t += A[i] * b;
        C.push_back(t % 10);
        t /= 10;
    }
    while (C.size() > 1 && !C.back()) C.pop_back();

    return C;
}

int main() {
    string a;
    int b;
    vector<int> A;
    cin >> a >> b;
    for (int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    auto C = mul(A, b);
    for (int i = C.size() - 1; i >= 0; i--) cout << C[i];
    cout << endl;

    return 0;
}