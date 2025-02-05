#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/30
 * @file M1845_座位预约管理系统.cpp
 */
class SeatManager {
public:
    priority_queue<int, vector<int>, greater<>> seats;

    SeatManager(int n) {
        for (int i = 1; i <= n; i++) seats.push(i);
    }

    int reserve() {
        int t = seats.top();
        seats.pop();
        return t;
    }

    void unreserve(int seatNumber) {
        seats.push(seatNumber);
    }
};

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager* obj = new SeatManager(n);
 * int param_1 = obj->reserve();
 * obj->unreserve(seatNumber);
 */