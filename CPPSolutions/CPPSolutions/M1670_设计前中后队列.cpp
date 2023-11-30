#include <bits\stdc++.h>

using namespace std;

class FrontMiddleBackQueue {
public:
    deque<int> front, back;

    void adjust() {
        if (front.size() > back.size()) {
            back.push_front(front.back());
            front.pop_back();
        }
        else if (front.size() + 1 < back.size()) {
            front.push_back(back.front());
            back.pop_front();
        }
    }

    void pushFront(int val) {
        front.push_front(val);
        adjust();
    }

    void pushMiddle(int val) {
        if (front.size() >= back.size()) back.push_front(val);
        else front.push_back(val);
    }

    void pushBack(int val) {
        back.push_back(val);
        adjust();
    }

    int popFront() {
        if (back.empty()) return -1;
        int val;
        if (front.empty()) {
            val = back.front();
            back.pop_front();
        }
        else {
            val = front.front();
            front.pop_front();
        }
        adjust();

        return val;
    }

    int popMiddle() {
        if (back.empty()) return -1;
        int val;
        if (front.size() == back.size()) {
            val = front.back();
            front.pop_back();
        }
        else {
            val = back.front();
            back.pop_front();
        }

        return val;
    }

    int popBack() {
        if (back.empty()) return -1;
        int val = back.back();
        back.pop_back();
        adjust();

        return val;
    }
};

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue* obj = new FrontMiddleBackQueue();
 * obj->pushFront(val);
 * obj->pushMiddle(val);
 * obj->pushBack(val);
 * int param_4 = obj->popFront();
 * int param_5 = obj->popMiddle();
 * int param_6 = obj->popBack();
 */