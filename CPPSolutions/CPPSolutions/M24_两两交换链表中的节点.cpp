#include <bits\stdc++.h>
#include "ListNode.h"

using namespace std;

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode* dummy = head->next;
        head->next = swapPairs(dummy->next);
        dummy->next = head;

        return dummy;
    }

    ListNode* swapPairs2(ListNode* head) {
        ListNode* dummy = new ListNode(), *cur = dummy;
        if (head != nullptr && head->next == nullptr) return head;
        while (head != nullptr && head->next != nullptr) {
            cur->next = head->next;
            head->next = head->next->next;
            cur = cur->next;
            cur->next = head;
            head = head->next;
            cur = cur->next;
        }

        return dummy->next;
    }
};