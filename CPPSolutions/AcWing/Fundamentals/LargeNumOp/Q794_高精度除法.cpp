#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/08/29
 * @file Q794_高精度除法.cpp
 *
 * 除法由于基底是从0开始，
 * 相当于最开始存入结果数组的是商的最低位
 * 因此需要在收集结果后reverse，再去除前导零
 */
vector<int> div(vector<int> &A, int b, int &r) {
    vector<int> C;
    r = 0;
    for (int i = A.size() - 1; i >= 0; i--) {
        r = r * 10 + A[i];
        C.push_back(r / b);
        r %= b;
    }
    reverse(C.begin(), C.end());
    while (C.size() > 1 && !C.back()) C.pop_back();

    return C;
}

int main() {
    string a;
    vector<int> A;
    int B;
    cin >> a >> B;
    for (int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    int r;
    auto C = div(A, B, r);
    for (int i = C.size() - 1; i >= 0; i--) cout << C[i];
    cout << endl << r << endl;

    return 0;
}