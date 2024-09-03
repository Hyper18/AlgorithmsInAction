#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/08/28
 * @file Q792_高精度加法.cpp
 *
 * 由于C++不像Java有专门处理大整数（BigInteger）或大浮点数（BigDecimal）的类
 * C++的高精度操作，本质上是先将每位依次存到数组中，执行二则运算后再重新拼接得到结果
 */
vector<int> add(vector<int> &A, vector<int> &B) {
    if (A.size() < B.size()) return add(B, A);
    vector<int> C;
    int t = 0;
    for (int i = 0; i < A.size(); i++) {
        t += A[i];
        if (i < B.size()) t += B[i];
        C.push_back(t % 10);
        t /= 10;
    }
    if (t) C.push_back(t);

    return C;
}

int main() {
    string a, b;
    vector<int> A, B;
    cin >> a >> b;
    for (int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    for (int i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');
    auto C = add(A, B);
    for (int i = C.size() - 1; i >= 0; i--) cout << C[i];
    cout << endl;

    return 0;
}