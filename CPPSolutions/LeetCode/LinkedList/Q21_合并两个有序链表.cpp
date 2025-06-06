#include <bits/stdc++.h>
#include "../../Headers/LinkedList/ListNode.h"

using namespace std;

class Solution {
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
        ListNode *l = new ListNode(), *cur = l;
        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val <= list2->val) {
                cur->next = list1;
                list1 = list1->next;
            } else {
                cur->next = list2;
                list2 = list2->next;
            }
            cur = cur->next;
        }
        if (list1 != nullptr) cur->next = list1;
        if (list2 != nullptr) cur->next = list2;

        return l->next;
    }
};