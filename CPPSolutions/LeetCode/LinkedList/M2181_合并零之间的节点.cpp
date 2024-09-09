#include <bits/stdc++.h>
#include "../../Headers/LinkedList/ListNode.h"

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/09
 * @file M2181_合并零之间的节点.cpp
 */
class Solution {
public:
    ListNode *mergeNodes(ListNode *head) {
        ListNode *dummy = new ListNode();
        ListNode *cur = dummy;
        int sum = 0;
        while (head->next) {
            sum += head->val;
            head = head->next;
            if (head->val == 0 && sum != 0) {
                cur->next = new ListNode(sum);
                sum = 0;
                cur = cur->next;
            }
        }

        return dummy->next;
    }
};