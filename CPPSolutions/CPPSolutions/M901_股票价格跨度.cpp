#include <bits\stdc++.h>

using namespace std;

class StockSpanner {
private:
    stack<pair<int, int>> stk;
    int idx;

public:
    StockSpanner() {
        this->stk.emplace(-1, INT_MAX);
        this->idx = -1;
    }

    int next(int price) {
        idx++;
        while (price >= this->stk.top().second) this->stk.pop();
        int ans = idx - this->stk.top().first;
        this->stk.emplace(idx, price);

        return ans;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */