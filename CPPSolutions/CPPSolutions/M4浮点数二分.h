#pragma once
bool check(double x) {}

double bsearch_3(double l, double r) {
    const double eps = 1e-6;   // ���ȣ�ȡ������Ŀ�Ծ��ȵ�Ҫ���磺����4λС�� -- 1e-6(һ��+2����)
    while (r - l > eps) {
        double mid = (l + r) / 2;
        if (check(mid)) {
            r = mid;
        }
        else {
            l = mid;
        }
    }

    return l;
}
