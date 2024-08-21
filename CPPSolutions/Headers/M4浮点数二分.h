#pragma once
bool check(double x) {}

double bsearch_3(double l, double r) {
    const double eps = 1e-6;   // 精度，取决于题目对精度的要求，如：保留4位小数 -- 1e-6(一般+2即可)
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
