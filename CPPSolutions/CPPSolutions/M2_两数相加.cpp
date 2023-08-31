#include <bits/stdc++.h>
#include "ListNode.h"

using namespace std;

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* h = new ListNode();
        ListNode* cur = h;
        int c = 0;
        while (l1 != nullptr || l2 != nullptr) {
            int v1 = l1 == nullptr ? 0 : l1->val;
            int v2 = l2 == nullptr ? 0 : l2->val;
            int sum = v1 + v2 + c;
            cur->next = new ListNode(sum % 10);
            c = sum / 10;
            cur = cur->next;
            if (l1 != nullptr) l1 = l1->next;
            if (l2 != nullptr) l2 = l2->next;
        }
        if (c) cur->next = new ListNode(c);

        return h->next;
    }
};